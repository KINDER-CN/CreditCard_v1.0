$(function(){
	var isIE = (document.all) ? true: false;
	var isIE6 = isIE && ([/MSIE (\d)\.0/i.exec(navigator.userAgent)][0][1] == 6);
	var $backToTopEle = $('<a class="online_service" id="online_service"  href="https://im.bank.ecitic.com/credit/navigation.html?channel=712021" target="_balnk"><span class="span_icon"></span><span class="span_txt">在线客服</span></a> ').appendTo($("body"));
	$backToTopEle.show();	
    var ol_se = document.getElementById('online_service');
    
    if (isIE6) {
		newbox_iestyle();
		window.attachEvent("onscroll",
		function() {
			newbox_iestyle();
		})
	}
	
});


