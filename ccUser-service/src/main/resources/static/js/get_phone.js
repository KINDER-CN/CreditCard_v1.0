$(document).ready(function(){
	var url = "returnphone.do?&timestamp"+new Date().getTime();
	var response = ajaxRequest(url,"GET");
	if(response == null || response == "") {
		
	} 
	else{
		response = JSON.parse(response);
		var code = response.resultCode;
		var msg = response.resultDesc;
		if(code == "0000000"){
			$("#phone").val(msg);
			$("#phone").attr("style","color:rgb(84,84,84)");
			$("#pwd").val("");
		}
	}
})

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
			}
		};
		if(jsonData) {
			handler.dataType = jsonData;
			handler.type = "POST";
		}
		var result = $.ajax(handler).responseText;
	}catch(e){
		
	}
	return result;
}
