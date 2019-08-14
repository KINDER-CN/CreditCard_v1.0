function load_cards(){setTimeout("$('#cards_list0').show()",1000)};
$(function() {	

    //页面两列等高
    //two_col();

    //比较箱展开收缩
	var show_btn = $('.show_btn');
	show_btn.click( function(){
		$(this).toggleClass('show_btn_on');
		$('.com_cards').toggle();
		});	
    
	var join_btn = $('.card_act .com_a');
	join_btn.click( function(){
		$('.show_btn').addClass('show_btn_on');
		$('.com_cards').show();
		});	
    
	//初始化卡片加载
	start();		
	$('.card_basic').shows_pic();
	
});	



//卡片预加载进度效果
var i = 0;
function start() {
	ba = setInterval("begin()", 1); //setInterval 返回的是一个全局变量，一个间隔数值.这个数值是表示调用setInterval的次数
}
function begin() {
		clearInterval(ba);
		document.getElementById("cards_loading").style.display = "none";
		document.getElementById("loading_after").style.display = "block";
	
}





//卡分类选项卡	
function cards_nav(showContent,selfObj){
	var tag = document.getElementById("cards_nav").getElementsByTagName("li");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.className = "on";
	// 操作内容
	for(i=0; j=document.getElementById("cards_list"+i); i++){
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";	
}


//卡片大小图片展示
$.fn.shows_pic = function(){
	$item = $(this).find('.s_pic_ul li');
	$item.click(function(){ 
	      var big_pic = $(this).parent().parent().siblings('.b_card_pic').find('img');
          var imgSrc = $(this).find('img').attr("src");
		  $(this).addClass('on').siblings().removeClass('on');
		  big_pic.attr({"src":imgSrc });
	})
}

<!--鼠标悬停弹出提示-->
	$(function(){
		$(".tag_text1").hide();
	$(".tag_msg1").mouseover(function(){
		$(this).next(".tag_text1").show();
		$(".tag_msg1").mouseout(function(){
			$(".tag_text1").hide();
		});
	});
});
$(function(){
	$(".tag_text2").hide();
	$(".tag_msg2").mouseover(function(){
		$(this).next(".tag_text2").show();
		$(".tag_msg2").mouseout(function(){
			$(".tag_text2").hide();
		});
	});
});
$(function(){
	$(".tag_text3").hide();
	$(".tag_msg3").mouseover(function(){
		$(this).next(".tag_text3").show();
		$(".tag_msg3").mouseout(function(){
			$(".tag_text3").hide();
		});
	});
});
$(function(){
       $(".card_pic").hover(function(){
           $(this).find(".card_layer1").animate({top:"-124px"},10);
       },function(){
           $(this).find(".card_layer1").animate({top:"0px"},10);
       })
    });
$(function(){
   $(".card_pic").hover(function(){
	   $(this).find(".card_layer2").animate({top:"-107px"},10);
   },function(){
	   $(this).find(".card_layer2").animate({top:"0px"},10);
   })
});


$(function(){
	$(".tag_btn").click(function(){
		$(".tag_btn").removeClass("on");
		$(this).addClass("on");
	})
	$(".tag_all").click(function(){
		$(".cards_con ul li").css("display","block");
	})
	$(".tag_txk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_txk)").css("display","none");
	})
	$(".tag_ylshk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_ylshk)").css("display","none");
	})
	$(".tag_yxk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_yxk)").css("display","none");
	})
	$(".tag_jrk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_jrk)").css("display","none");
	})
	$(".tag_nrk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_nrk)").css("display","none");
	})
	$(".tag_lcbxk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_lcbxk)").css("display","none");
	})
	$(".tag_qtk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_qtk)").css("display","none");
	})
	$(".tag_ghk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_ghk)").css("display","none");
	})
	$(".tag_dhhhk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_dhhhk)").css("display","none");
	})
	$(".tag_nhshk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_nhshk)").css("display","none");
	})
	$(".tag_qthkk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_qthkk)").css("display","none");
	})
	$(".tag_lyjdk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_lyjdk)").css("display","none");
	})
	$(".tag_uberk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_uberk)").css("display","none");
	})
	$(".tag_bzbjk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_bzbjk)").css("display","none");
	})
	$(".tag_qtbjk").click(function(){
		$(".cards_con ul li").css("display","block");
		$(".cards_con ul li:not(.ss_card_qtbjk)").css("display","none");
	})
	
});  