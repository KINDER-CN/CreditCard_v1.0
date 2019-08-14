var lock = false;
var rtnUrl;
var response;
$(document).ready(function(){
	
	
	$("#cdialog_btn_confirm1").click(function(){
		$("#mask_bg1").hide();
		next();
		
	});
		
	$("#login").click(function(){
		login();
	});

	$("#cdialog_btn_cancel").click(function(){
		$(this).parent().parent().parent().hide();
		window.location.href = idRtnUrl;
	});
	$("#cdialog_btn_confirm").click(function(){
		if (idRtnUrl == "cancel") {
			$("#mask_bg").hide();
			cancel_confirm();
		}else{
			$("#cdialog_title").hide();
			$("#cdialog_content").addClass("scan");
			$("#cdialog_content").html("");
			$("#cdialog_text").show();
			$("#cdialog_text").html("请扫码下载动卡空间APP更新证件有效期，更可享受超多优惠福利");
			$("#btn-areas").hide();
			$("#cdialog_btn_confirm").hide();
			$("#cdialog_btn_cancel").hide();
			$("#cdialog-close").show();
		}
	});
	$("#cdialog-close").click(function(){
		$("#mask_bg").hide();
		if(idRtnUrl=="neverDo"){
			cancel_confirm();
			window.location.href = rtnUrl;
		}else{
			window.location.href = idRtnUrl;
		}
	});
	
});

function login(){
	//校验密码非空校验
	var o = $.trim($("#mm").val());
	if(chenkmm(o)){
		var msg = "密码不能为空且长度需大于等于6";
		showErrorMsg(msg);
		return;
	}		
	if(lock == true){
		return;
	}
	lock = true;
	hideErrorMsg();		
	var url = "newlogin.do?&timestamp"+new Date().getTime();
	var request = {mm:hex_md5(o)};
	response = ajaxRequest(url,"POST",request);
	if(response == null || response == "") {
		alert("系统繁忙，请稍后重试！");
		lock = false;
	}else{
		var resultCode = JSON.parse(response).resultCode;
	    var resultDesc = JSON.parse(response).resultDesc;
	    var needWinTips = JSON.parse(response).needWinTips;	    	    
	    rtnUrl = JSON.parse(response).rtnUrl;
	    if("0000000" == resultCode){
	    	if("true" == needWinTips){
	    		 $("#mask_bg1").show();
	    		 var winTipVal = JSON.parse(response).winTipVal;	 
	    		 $("#cdialog_text1").html(winTipVal);
	    	}else{
	    		next();
	    	}    		    	
	    }else{
	    	showErrorMsg(resultDesc);
	    	lock = false;
	    }
	   
	}				
}

function next(){
	var idCode =JSON.parse(response).idCode;
	if( idCode != null || idCode != undefined){
		// 弹出证件更新提示
		var idMsg = JSON.parse(response).idMsg;
		$("#cdialog_content").html(idMsg);					
		if(idCode=="9010003"){
			$("#cdialog_btn_cancel").hide();
			$("#btn-areas .confirm ").css("margin-left", "0%");
			$("#cdialog_btn_confirm").css("width", "80%").css("color", "white").css("border-radius","5px").css("border-right","1px").css("background","#E83C3D").html('立即更新');
			idRtnUrl = "neverDo";
		}else {
			if(idCode=="9010008"){
				idRtnUrl = "cancel";
				$("#cdialog_btn_cancel").hide();
				$("#btn-areas .confirm ").css("margin-left", "0%");
				$("#cdialog_btn_confirm").css("width", "80%").css("color", "white").css("border-radius","5px").css("border-right","1px").css("background","#E83C3D").html('确定');
			}else{
				idRtnUrl=rtnUrl;
			}	
		}
			$(".mask_bg").show();
			return;
	}
	location.href = rtnUrl;
}





function cancel_confirm() {
	$("#PwkGoOldLogin").removeClass("code_submit_disable").addClass("code_submit");
	$("#PwkGoOldLogin").bind("click", function() {
		submitBind();
	});
}

function mmfocus() {
	$("#mm_emsg").hide();
}
function mmblur() {
	if ($("#mm").val() != "") {
		pwdValidation1();
	}
}
function chenkmm(mm) {
	if (mm != "" && mm.length >=6) {
		return false;
	}
	return true;
}

function pwdValidation1(){
	var pwd = $("#mm").val();
	if(pwd.length < 6){
		showErrorMsg("登录密码至少包含6位字符");
		return false;
	}
	if(!mmVerification(pwd)){
		showErrorMsg("密码格式错误，登录密码需由6-15位数字和字母组成")
		return false;
	}
	return true;
	
}

function mmVerification(mm){
	if(!isNaN(mm) || mm.length > 15 
			|| mm.length < 6 
			|| mm.match(/[^A-Za-z0-9_]/ig) 
			|| !mm.match(/[A-Za-z]/) 
			|| !mm.match(/[0-9]/)){
		return false;
	}
	return true;
}

function showErrorMsg(error){
	$("#mm_emsg").show();
	$("#mm_emsg").html("<i></i>" + error);
}

function hideErrorMsg(){
	$("#mm_emsg").hide();
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

