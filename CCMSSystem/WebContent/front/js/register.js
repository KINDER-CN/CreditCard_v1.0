var timer = 0,counter = 120;
var flag = false;
var lock = false;
var isRegistering = false;
function count(){
    var textContent = $("i.get_code");
    if(counter == -1){
        clearInterval(timer);
        timer = 0;
        textContent.css("background-color","#5d5d5d");
        textContent.text("重新获取");
        counter = 120;
        flag = false;
        $("#getsms").attr("id","getsms");
    }else{
        textContent.text(counter+'s');
        counter--;
    }
};

$(document).ready(function(){
    $("#phoneNbr").focus(function(){
        $("#phone_emsg").hide();
    });
    
    $("#phoneNbr").blur(function(){
        phoneValidation();
    });
    
    $("#valicode").focus(function(){
        $("#sms_emsg").hide();
    });
    
    $("#valicode").blur(function(){
        smsValidation();
    });
    
    $('#i1').click(function() {
    	$('#phoneNbr').val('');
    });
});

//Get sms code
$(document).ready(function(){
	$("#getsms").click(function(){
		if(!phoneValidation()){
			return;
		}
		
		if (isNeedImgValid && !imgValidation()) {
			return;
		}
		
		if(flag == true){
			return;
		}
		flag = true;
		hidePhoneSmsErrors();
		
		var url = "getsms.do?&timestamp"+new Date().getTime();
		var nbr = $.trim($("#phoneNbr").val());
		var request = {phone:nbr};
		if (isNeedImgValid) {
			request['imgValidCode'] = $.trim($("#imgvalicode").val());
		}
		
		var response = ajaxRequest(url, "POST", request);
		if(response == null || response == "") {
			alert("系统繁忙，请稍后重试！");
			flag = false;
		} else {
			var result = response;
			var resultCode = result.resultCode;
			
			if (resultCode == "0000000") {
				$("#getsms").removeAttr("id");
				timer = setInterval('count()', 1000);
				$(this).css("background-color","#aeadad");
				return;
			}
			
			reloadImgValidCode();
			flag = false;
			
			if (resultCode == '0000001') {
				imgValidStatus(resultCode);
				renderImgError(result.resultDesc);
				return;
			}
			
			if (resultCode == "0000004") {
				$("#phone_emsg").show();
				return;
			}
			
			if (resultCode == "0000031") {
				// 临时
				renderSmsError("短信发送失败，请稍候重试");
				// renderSmsError(result.resultDesc);
				return;
			}
			renderSmsError("短信发送失败，请稍候重试");
		}
	});
});

//Verify sms code and registry status
$(document).ready(function(){
	$("#submit_phone_sms").click(function(){
		if((phoneValidation()&smsValidation())==false){
			return;
		}
		if(lock == true){
			return;
		}
		lock = true;
		hidePhoneSmsErrors();
		var url = "registrycheck.do?&timestamp"+new Date().getTime();
		var nbr = $.trim($("#phoneNbr").val());
		var validcode = $.trim($("#valicode").val());
		var request = {phone:nbr,smsCode:validcode};
		var response = ajaxRequest(url,"POST",request);
		
		if(response == null || response == "") {
			alert("系统繁忙，请稍后重试！");
		} else {
			lock = false;
			var result = response;
			var code = result.resultCode;
			if(code == "0000000" || code == "0000006"){
				location.href="toSetMm.do";
			}
			else if(code == "0000004"){
				renderPhoneError(result.resultDesc);
			}
			else if(code == "0000005"){
				$("#phone_registered").show();
			}
			else if(code == "0000003" || code == "0000032" || code == "0000033"){
				renderSmsError(result.resultDesc);
			}
			else{
				alert("系统出错，请稍后再试");
			}
		}
		
	})
})

//Register
$(document).ready(function(){
	var cashier;
	$("#register").click(function(){
		if (isRegistering == true) {
			return;
		}
		if ((pwdValidation1() & pwdValidation2()) == false) {
			return;
		}
		isRegistering = true;
		hidePwdErrors();
		var url = "register.do?&timestamp" + new Date().getTime();
		var password = hex_md5($.trim($("#mm").val()));
		var request = {mm : password};
		var response = ajaxRequest(url, "POST", request);
		if (response == null || response == "") {
			alert("系统繁忙，请稍后重试！");
		} else {
			var result = response;
			var code = result.resultCode;
			if (code == "0000000") {
				$(".register_suc_bg").show();
				var bindBackUrl = $.cookie('bind_back_url');
				var backUrl = $.cookie('back_url');
				setTimeout(function() {
					$(".register_suc_bg").hide();
					isRegistering = false;
					cashier = cashier || new Cashier();
					cashier.ucwebBindCard({
						'confirmUrl' : bindBackUrl,
						'cancelUrl' : backUrl
					});
				}, 2000);
			} else if (code == "0000031") {
				alert(result.resultDesc);
				isRegistering = false;
			} else if (code == "0000001") {
				renderSmsError(result.resultDesc);
				isRegistering = false;
			} else if (code == "0000005") {
				isRegistering = false;
				location.href = "entry.do";
			} else if (code == "1111110") {
				alert(result.resultDesc);
				isRegistering = false;
				location.href = "entry.do";
			} else {
				alert("系统出错，请稍后再试");
				isRegistering = false;
			}
		}
	})
});

function ajaxRequest(url, type, request, jsonData) {
	try {
		var handler = {
			header : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			url : url,
			type : type,
			async : false,
			dataType : "json",
			data : request,
			success : function(response) {
			},
			error : function(response) {
				alert("系统错误！");
			}
		};
		if (jsonData) {
			handler.dataType = jsonData;
			handler.type = "POST";
		}
		var result = $.ajax(handler).responseText;
		result = eval("(" + result + ")");
	} catch (e) {
		alert("ajax error:系统错误！");
	}
	return result;
}

function phoneValidation() {
	var phone = $.trim($("#phoneNbr").val());
	if (phone.length == 0) {
		renderPhoneError("手机号码不能为空")
		return false;
	}
	if (phone.length != 11 || isNaN(phone) == true) {
		renderPhoneError("手机号码需为11位数字")
		return false;
	}
	if (!isMobile(phone)) {
		renderPhoneError("手机号码无效，请重新输入")
		return false;
	}
	return true;
}

function smsValidation() {
	var valicode = $.trim($("#valicode").val());
	if (valicode.length == 0) {
		renderSmsError("短信验证码不能为空");
		return false;
	}
	if (valicode.length != 6 || isNaN(valicode) == true) {
		renderSmsError("短信验证码为6位数字");
		return false;
	}
	return true;
}

function pwdValidation1() {
	var pwd = $("#mm").val();
	if (pwd.length == 0) {
		renderPwdError1("密码不能为空");
		return false;
	}
	if (!mmVerification(pwd)) {
		renderPwdError1("登录密码由6-15位数字和字母组成")
		return false;
	}
	return true;
}

function pwdValidation2() {
	var pwd1 = $("#mm").val();
	var pwd2 = $("#remm").val();
	if (pwd2.length == 0) {
		renderPwdError2("确认密码不能为空");
		return false;
	}
	if (!mmVerification(pwd2)) {
		renderPwdError2("登录密码由6-15位数字和字母组成")
		return false;
	}
	if (pwd1 != pwd2) {
		renderPwdError2("两次密码输入不一致");
		return false;
	}
	return true;
}

function renderPhoneError(error) {
	$("#phone_emsg").show();
	$("#phone_emsg").html("<i></i>" + error);
}

function renderSmsError(error) {
	$("#sms_emsg").show();
	$("#sms_emsg").html("<i></i>" + error);
}

function renderPwdError1(error) {
	$("#mm_emsg").show();
	$("#mm_emsg").html("<i></i>" + error);
}

function renderPwdError2(error) {
	$("#remm_emsg").show();
	$("#remm_emsg").html("<i></i>" + error);
}

function hidePhoneSmsErrors() {
	$("#phone_emsg").hide();
	$("#img_emsg").hide();
	$("#sms_emsg").hide();
}
function hidePwdErrors() {
	$("#mm_emsg").hide();
	$("#remm_emsg").hide();
}
function mmfocus() {
	$("#mm_emsg").hide();
}
function mmblur() {
	if ($("#mm").val() != "") {
		pwdValidation1();
	}

}
function remmfocus() {
	$("#remm_emsg").hide();
}
function remmblur() {
	if ($("#remm").val() != "" || $("#mm").val() != "") {
		pwdValidation2();
	}
}