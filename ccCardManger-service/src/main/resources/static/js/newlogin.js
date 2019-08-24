var timer = 0,counter = 120;
var flag = false;
var lock = false;
var isNeedImgValid = false;

function countReg(){
    var textContent = $("i.get_code_registerlogin");
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
	
	//注册一体化图形验证码
	$(function() {
		$("#imgvalicode").focus(function(){
	        $("#reg_phone_error").hide();
	    });
	    
	    $("#imgvalicode").blur(function(){
	        newImgValidation();
	    });
		
		$.get('smsImgValid.do?type=register&refresh='+new Date().getTime(), {
		}, function(data) {
			imgValidStatus(data.resultCode);
		}, 'json');
	});
	
	// 获取短信验证码
	$("#getsms").click(function(){
		if(!phoneValidation()){
			return;
		}
		
		if (isNeedImgValid && !newImgValidation()) {
			return;
		}
		
		if(flag == true){
			return;
		}
		flag = true;
		hideErrors();
		
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
			var resultCode = JSON.parse(response).resultCode;
			var resultDesc = JSON.parse(response).resultDesc;
			if (resultCode == "0000000") {
				$("#getsms").removeAttr("id");
				timer = setInterval(countReg, 1000);
				$(this).css("background-color","#aeadad");
				return;
			}
			
			reloadImgValidCode();
			flag = false;
			
			if (resultCode == '0000001') {
				imgValidStatus(resultCode);
				renderError(resultDesc);
				return;
			}
			
			if (resultCode == "0000004") {
				$("#phone_emsg").show();
				return;
			}
			
			if (resultCode == "0000031") {
				// 临时
				renderError(resultDesc);
				return;
			}
			renderError("短信发送失败，请稍候重试");
		}
	});
	
	// 点击下一步
	$("#checkcode").click(function() {
		
		//手机号，短信验证码非空校验
		if((phoneValidation()&smsValidation())==false){
			return;
		}
		
		if(lock == true){
			return;
		}
		lock = true;
		//隐藏错误码
		hideErrors();
		var url = "registrycheck.do?&timestamp"+new Date().getTime();
		var smsValidCode = $.trim($("#valicode").val());
		var nbr = $.trim($("#phoneNbr").val());
		var request = {phone:nbr,smsCode:smsValidCode};
		var response = ajaxRequest(url,"POST",request);		
		if(response == null || response == "") {
			alert("系统繁忙，请稍后重试！");
		}else{
			lock = false;
			var resultCode = JSON.parse(response).resultCode;
			var resultDesc = JSON.parse(response).resultDesc;
			//2： 未注册  -- 跳转设置登录密码界面
			if(resultCode == "0000000" || resultCode == "0000006"){
				location.href="toSetMm.do";
				return;
			}			
			//1： 已注册  -- 跳转 输入登录密码界面
			if(resultCode == "0000005"){
				location.href="tologin.do";
				return;
			}			
			//3：已经注册，但未设置登录密码 --跳转实名找回界面	
			if(resultCode == "0000007"){
				location.href="torealnamepage.do";
				return;
			}else{
				renderError(resultDesc);
			}			      			
		}		
	})
	
});

//生成图形验证码
function reloadImgValidCode(){
	var time = new Date().getTime();
	var imgd = '<img class="img-code" id="randImage" src="./newvalicode.do?time='+time+'" width="72" height="28" alt="点击图片换一张"/>';
	$("#newImgValidCodeALink").html(imgd);
}

function phoneValidation() {
	var phone = $.trim($("#phoneNbr").val());
	if (phone.length == 0) {
		renderError("手机号码不能为空")
		return false;
	}
	if (phone.length != 11 || isNaN(phone) == true) {
		renderError("手机号码需为11位数字")
		return false;
	}
	if (!isMobile(phone)) {
		renderError("手机号码无效，请重新输入")
		return false;
	}
	return true;
}

function smsValidation(){
	var valicode = $.trim($("#valicode").val());
	if(valicode == ""){
		renderError("验证码不能为空");
		return false;
	}
	if(valicode == "" || valicode.length != 6 || isNaN(valicode) == true){
		renderError("验证码为6位数字");
		return false;
	}
	return true;
}

function renderError(error) {
	$("#reg_phone_error").show();
	$("#reg_phone_error").html("<i></i>" + error);
}

function hideErrors() {
	$("#reg_phone_error").hide();

}


function imgValidStatus(code) {
	if (code != '0000000') {
		$('#img_code').show();
		$('#reg_phone_error').show();
		isNeedImgValid = true;
	} else {
		$('#img_code').hide();
		$('#reg_phone_error').hide();
		isNeedImgValid = false;
	}
}

function newImgValidation(){
	var imgvalicode = $.trim($("#imgvalicode").val());
	if (imgvalicode.length == 0) {
		renderError("图形验证码不能为空");
		return false;
	}
	if (imgvalicode.length != 4) {
		renderError("图形验证码为4位");
		return false;
	}
	return true;
}

function ajaxRequest(url,type,request,jsonData) {
	try {
		var handler = {
			header:{
				'Accept':'application/json',
				'Content-Type':'application/json'
			},
			url : url,
			type : type,
			async : false,
			dataType : "json",
			data:request,
			success : function(response){
				
			},
			error:function(response){
				alert("系统错误！");
			}
		};
		if(jsonData) {
			handler.dataType = jsonData;
			handler.type = "POST";
		}
		var result = $.ajax(handler).responseText;
	}catch(e){
		alert("ajax error:系统错误！");
	}
	return result;
}
