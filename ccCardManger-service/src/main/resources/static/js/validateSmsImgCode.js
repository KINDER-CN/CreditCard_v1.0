// 前端图形验证码输入校验
function imgValidation(){
	var imgvalicode = $.trim($("#imgvalicode").val());
	if (imgvalicode.length == 0) {
		renderImgError("图形验证码不能为空");
		return false;
	}
	if (imgvalicode.length != 4) {
		renderImgError("图形验证码为4位");
		return false;
	}
	return true;
}

// 生成图形验证码
function reloadImgValidCode(){
	var time = new Date().getTime();
	var imgd = '<img class="img-code" id="randImage" src="./newvalicode.do?time='+time+'" width="72" height="28" alt="点击图片换一张"/>';
	$("#newImgValidCodeALink").html(imgd);
}

function renderImgError(error){
	$("#img_emsg").show();
	$("#img_emsg").html("<i></i>"+error);
}

// 是否需要图形验证码标志
var isNeedImgValid = false;
$(function() {
	$("#imgvalicode").focus(function(){
        $("#img_emsg").hide();
    });
    
    $("#imgvalicode").blur(function(){
        imgValidation();
    });
	
	$.get('smsImgValid.do?type=register&refresh='+new Date().getTime(), {
	}, function(data) {
		imgValidStatus(data.resultCode);
	}, 'json');
});

function imgValidStatus(code) {
	if (code != '0000000') {
		$('#img_code').show();
		$('#img_code_emsg').show();
		isNeedImgValid = true;
	} else {
		$('#img_code').hide();
		$('#img_code_emsg').hide();
		isNeedImgValid = false;
	}
}