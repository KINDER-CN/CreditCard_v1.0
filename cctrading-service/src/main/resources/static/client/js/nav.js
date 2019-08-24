$(function () {
	/* 导航下拉 */
    $('#main_nav').shows_menu_list();

	
	/* 导航保持定位 */
	var dv = $('#main_nav'); 
	var st;
    //dv.css('display','none')
	var dvtop = dv.offset().top;
	//alert (dvtop)
	dv.attr('otop',dvtop); //存储原来的距离顶部的距离
	$(window).scroll(function () {
		st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
		if (st >= parseInt(dv.attr('otop'))) {
            if (dv.css('position') != 'fixed') dv.css({ 'position': 'fixed', top: 0 });
		} else if (dv.css('position') != 'relative') dv.css({ 'position': 'relative' });
	});
	
	
	
	//底部点击弹框
	$('.hide_nav').click(function(ev){
		var oEvent = ev || event;
		oEvent.stopPropagation();
		$('.hide_nav').removeClass('active');
		$('.foot_open_box').slideUp(100);
		$(this).addClass('active');
		$(this).next('.foot_open_box').slideDown(100);
	});
	$(document).click(function(){
		$('.hide_nav').removeClass('active');
		$('.foot_open_box').slideUp(100);
	})

	
});



//大分类下拉菜单
$.fn.shows_menu_list = function(){
	$item = $(this).find('li');
	$item.hover(function(){
		  $(this).find('.lab_a').addClass('focus_a')
				.siblings().show();
		},function(){
		  $(this).find('.lab_a').removeClass('focus_a')
			     .siblings().hide();
	    })
}


//在线客服
		var icsWnd = null;
		function fLogon(){
			var nWinLeft = (screen.width-600)/2;
			var nWinTop = (screen.height-500)/2;
			if ( icsWnd != null && !icsWnd.closed){
			        icsWnd.focus();
			 }else{
		    	icsWnd = window.open('https://im.bank.ecitic.com/cardsim/cardsim.do?entryId=1','citicwebim','width=689,height=461,status=no,resizable=no,left='+nWinLeft+',top='+nWinTop);
				icsWnd.focus();
			}
		}
/*底部弹出二维码框*/
$(document).ready(function(){
$footer_link = $(".footer_link li a");
$footer_link.hover(function(){
  $(this).siblings('.code_pop').show();
     },function(){
     $(this).siblings('.code_pop').hide();
   });
});