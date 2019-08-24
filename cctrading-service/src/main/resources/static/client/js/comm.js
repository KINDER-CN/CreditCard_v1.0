jQuery(document).ready(function() {
    var $ = jQuery;
	
	$('.nav-ul > li').find(".nav-s").parents(".nav-ul li").addClass( 'nav-icon');
	
	 //切换
  $(".otop li").click(function () {
	  var thisli = $(this).parents(".otop").find("li");
	  var thisarc = $(this).parents(".cutover").find(".otopmain");
	  for(var i = 0; i<thisli.length; i++){
		  var num = $(this).index();
		  thisli[i].className = "";
		  thisarc[i].style.display="none";
		  thisli[num].className = "active";
		  thisarc[num].style.display="block";
	  }

  });
  
  $(".backtop").click(function(){
    $('body,html').animate({scrollTop:0},"speed");
    return false;
  });
  
	
});

$(document).ready(function(){
	$footer_link = $(".footer_link li a");
	$footer_link.hover(function(){
		$(this).siblings('.code_pop').show();
	},function(){
		$(this).siblings('.code_pop').hide();
	});
});

$(document).ready(function(){
	$actnav_link = $(".act_nav li p.act_nav_img");
	$actnav_link.hover(function(){
		$(this).siblings('.act_nav_tu').show();
	},function(){
		$(this).siblings('.act_nav_tu').hide();
	});
});
