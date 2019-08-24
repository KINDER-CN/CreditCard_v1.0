
$(function () {

    $(window).scroll(function () {
        // 左侧悬浮菜单
        var pos = Math.max($("html").scrollTop(), $("body").scrollTop());
        if (pos > 500) {
            $(".u-fixed").show();
        } else {
            // $(".u-fixed").hide();
            $(".u-fixed").show();
            $(" .right-fixed li.returnTop").hide();

        }
        // 右侧悬浮菜单
        var pos = Math.max($("html").scrollTop(), $("body").scrollTop());
        if (pos > 100) {
            $(".right-fixed").show();
            $(" .right-fixed li.returnTop").show();
        } else {
            // $(".right-fixed").hide();
            $(".u-fixed").show();
            $(" .right-fixed li.returnTop").hide();
        }
    });
    // 右侧悬浮菜单
    $(".returnTop").click(function () {
        $("html").animate({
            scrollTop: 0
        }, 0); //火狐IE6789
        $("body").animate({
            scrollTop: 0
        }, 0); //谷歌
    });
});
/*全部商品 关闭 展开*/
$(function(){
    // 首页
    $('.pro-all').click(function(event){
        $(this).children('i').toggleClass('fa-sort-desc');
        $(this).siblings('ul').slideToggle('slow');
        event.stopPropagation();
    });

});
/*内容居中*/
function elementAuto(elememt,childElement){
    var childWid=$(childElement).width();
    var eleWid=$(elememt).width();
    $(childElement).css("margin-left",(eleWid - childWid)/2 + "px");
};
$(function(){
    elementAuto('#bannerIndex','#bannerIndex .hd');
    elementAuto('.lib-tab1','.lib-tab1 .hd');
    elementAuto('.copy','.copy-nav');
    elementAuto('.banner-quotes02','.banner-quotes02 .hd');
});
/*tab 选项卡*/
function setTabs(BoxTabs,LiTabs,ConTabs){
    $(BoxTabs).each(function(){
        $(LiTabs).click(function(){
            if(!!($(this).parent('.lib-menu').find('css3-container').length == 0)){
                var Index=$(this).index();
            }else{
                var Index=Math.floor($(this).index()/2);
            };
            $(this).addClass('hover');
            $(this).siblings('li').removeClass('hover');
            $(ConTabs).eq(Index).css({'display':'block'});
            $(ConTabs).eq(Index).siblings(ConTabs).css({'display':'none'});
        });
    });
};
$(function(){
    setTabs('.lib-tab1','.lib-tab1 .lib-menu li','.lib-tab1 .lib-content .child-content');
    setTabs('.lib-tab2','.lib-tab2 .lib-menu li','.lib-tab2 .lib-content .child-content');
    setTabs('.lib-tab3','.lib-tab3 .lib-menu li','.lib-tab3 .lib-content .child-content');
    setTabs('.lib-tab4','.lib-tab4 .lib-menu li','.lib-tab4 .lib-content .child-content');
    setTabs('.lib-tab5','.lib-tab5 .lib-menu li','.lib-tab5 .lib-content .child-content');
    setTabs('.lib-tab6','.lib-tab6 .lib-menu li','.lib-tab6 .lib-content .child-content');
});
/*搜索页 二级下拉菜单*/
$(function(){
    $('.menuPro-left dl dd .menuPro-first').each(function(){
        if($(this).hasClass("selected")){
            $(this).children('i').addClass('fa-minus-square');
            $(this).siblings('.menuPro-second').show(0);
        };
        $(this).click(function(){
            $(this).children('i').toggleClass('fa-minus-square');
            $(this).siblings('.menuPro-second').slideToggle();
            $(this).closest('dd').siblings('dd').find('.menuPro-second').slideUp();
            $(this).closest('dd').siblings('dd').find('i').removeClass('fa-minus-square');
        });
    });
    $('.member-left dl dd .menuPro-first').each(function(){
        if($(this).hasClass("selected")){
            $(this).children('i').addClass('fa-minus-square');
            $(this).siblings('.menuPro-second').show(0);
        };
        $(this).click(function(){
            $(this).children('i').toggleClass('fa-minus-square');
            $(this).siblings('.menuPro-second').slideToggle();
            $(this).closest('dd').siblings('dd').find('.menuPro-second').slideUp();
            $(this).closest('dd').siblings('dd').find('i').removeClass('fa-minus-square');
        });
    });
});
/*table 隔行变色*/
$(function(){
    $('.search-table table tr:even,.logistics-route tr:odd,.table-points tr:odd').css({
        background:"#e9f5ff"
    });
});
///*我的承运单*/
//$(function(){
//  /*筛选*/
//  $('.order-status a').click(function(){
//    $(this).toggleClass('selected');
//    $(this).siblings('a').removeClass('selected');
//  });
//  /*价格操作*/
//  $('.price-btn').click(function(){
//    $(this).closest('tr').find('.price-sub').show();
//    $(this).closest('tr').find('.price-input').show();
//    $(this).closest('tr').find('.price-txt').hide();
//  });
//  $('.price-sub').click(function(){
//    $(this).closest('tr').find('.price-sub').hide();
//    $(this).closest('tr').find('.price-input').hide();
//    $(this).closest('tr').find('.price-txt').show();
//  });
//  $('.price-input').keypress(function(e){
//    var k = e.keyCode || e.which;
//    if(k>=48&&k<=57||k==8){
//        return true;
//    };
//    return false;
//  });
//});
$(function(){
    $('.order-received').each(function(){
        $(this).find('table td table').each(function(){
            $(this).find('tr:last').css({
                border:'none'
            });
        });
    });
});
/*上传资源*/
// $(function(){
//   // 增加
//   $('.method-table .add').on('click',function(){
//     var tr = $(this).closest('.method-table').find('tr').eq(1).clone();
//     tr.find('input').val('');
//     tr.find('select').selectedIndex=1;
//     $(this).closest('.method-table').children('table').append(tr);
//   });
//   // 删除
//   $(document).on('click','.method-table .del',function(){
//        if($(this).closest('tbody').find('tr').length ==1){
//            alert("对不起，至少保留一行数据！")
//        }else{
//            $(this).closest('tr').remove();
//        }
//   });
// });
/*单击预览大图*/
$(function(){
    // 图片放大
    $('.preview-img').each(function(){
        $(this).click(function(){
            var ImgSrc = $(this).children('img').attr("src");
            $('.bigPic img').attr("src",ImgSrc);
            $('.mask').fadeIn(500);
        });
    });
    $('.pop-pay').each(function(){
        $(this).click(function(){
            var ImgSrc = $(this).attr("data-src");
            $('.bigPic img').attr("src",ImgSrc);
            $('.mask').fadeIn(500);
        });
    });
    $('.bigPic i').click(function(){
        $('.mask').fadeOut(500);
    });
});
///*承运管理 我的车辆*/
//$(function(){
//    // 修改信息
//    $('.car-revise').each(function(){
//        $(this).click(function(){
//            $('.mask-car').fadeIn(500);
//        });
//    });
//    $('.bigPic i,.bigPic .car-sub').click(function(){
//        $('.mask-car').fadeOut(500);
//    });
//});
/*弹出框*/
$(function () {
    // 显示
    $('.pop-btn').click(function () {
        $(this).closest('td').css('zIndex', '2');
        $(this).closest('td').find('.pop').fadeIn(200);
    });
    // 隐藏
    //  $('.pop-sub,.pop i').click(function(){
    //    $(this).closest('.pop').fadeOut(200);
    //  });
    $('.pop i').click(function () {
        $(this).closest('.pop').fadeOut(200);
        $(this).closest('td').removeAttr('style');
    });
});
/*弹出框*/
$(function(){
    // 供应商管理-修改价格
    $('.pop-sub').each(function(){
        $(this).click(function(){
            $('.mask01').fadeIn(500);
        });
    });
    $('.bigPic i,.bigPic .closed').click(function(){
        $('.mask01').fadeOut(500);
    });
});
/*输入框*/
function showtxt(element, txt) {
    var inputName = element;
    var inputTxt = txt;
    inputName.val(inputTxt);
    //点击时
    inputName.click(function() {
        if (inputName.val() == inputTxt) {
            inputName.val("");
        }
    });
    //失去焦点时
    inputName.blur(function() {
        if (inputName.val() == "") {
            inputName.val(inputTxt);
        }
    });
}
$(function(){
    showtxt($(".helpMe-input"), '写下您的真实需求，收到后我们会立即给您回电确认。');
});
// 文字选择 多选 单选
$(function(){
    $('.controls-radio').each(function(){
        $(this).find('i').click(function(){
            $(this).prev('input').click();
        });
    })
});
//2015 09 22 筛选
$(function () {
    $('.condition-select').each(function () {
        $(this).children('dd').find('a').click(function () {
            var conditionValue = $(this).html();
            $(this).closest('dd').prev('dt').html(conditionValue);
            $(this).closest('dd').prev('dt').attr('data-value', conditionValue);
        });
        var conditionValue = $(this).children('dd').find('a.selected').html();
        $(this).children('dd').find('a.selected').parent().siblings("dt").html(conditionValue);
    });
});
//首页 流行行情 2015 09 24
$(function(){
    //getdata();
    //setInterval('getdata()', 3000);
});
/*function getdata(){
    $.ajax({
        type:'GET',
        url:'dataNusms.php?data'+Math.random(),
        timeout:1000,
        success:function(data){
            show_num('#total-1',6706);
            show_num('#total-2',8706);
            show_num('#total-3',18706);
        },
        error:function(){
            show_num('#total-1',6666);
            show_num('#total-2',9999);
            show_num('#total-3',22229);
        }
    });
}*/
function show_num($Id,n){
    var it = $($Id).find(".num i");
    var len = String(n).length;
    for(var i=0;i<len;i++){
        if(it.length<=i){
            $($Id).find(".num").append("<i></i>");
        }
        var num=String(n).charAt(i);
        var y = -parseInt(num)*30;
        var obj = it.eq(i);
        obj.css({
            backgroundPosition:'0 '+String(y)+'px'
        });
    }
}