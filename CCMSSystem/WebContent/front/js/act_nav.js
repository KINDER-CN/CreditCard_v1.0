(function($){
    function SideNav(element,options){
        this.$element = $(element);                                //导航元素
        this.options = $.extend({},$.fn.sideNav.defaults,options); //合并参数
        this.$win = $(window);                                     //window对象
        this.wrapT = this.options.floatWrap.offset().top;          // 范围的上边
        this.wrapB = this.wrapT + this.options.floatWrap.height(); //范围的下边
        this.topIE6 = this.$element.position().top - this.$element.offsetParent().offset().top;                //相对定位减去父元素位置
        this.isIE6 = (typeof document.body.style.maxHeight === "undefined"); //是否为ie6
        this.index = 0;     //索引滚动到哪个楼层
        this.arrPositions = [];     //存锚点位置
        this.arrPositionsID = [];     //存锚点ID
        this.init();
    }
    SideNav.prototype = {
        //所有的锚点都是动画滑到目标
        goTarget : function(){
            var _this = this;
            $('a[href*=#],area[href*=#]').click(function() {
                  if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
                       var $target = $(this.hash);
                       $target = $target.length && $target || $('[name=' + this.hash.slice(1) + ']');
                       if ($target.length) {
                            var targetOffset = $target.offset().top;
                            $('html,body').animate({
                                 scrollTop: targetOffset
                            },_this.options.time);
                            return false;
                       }
                  }
            });
        },
        //窗口变化则判断窗口的宽是不是合要求
        onResize : function(){
            var w = this.$win.width();
            if(w < this.options.minWidth || this.$win.scrollTop() <= this.wrapT ){
                this.$element.css("visibility","hidden");
                this.options.visible = false;
            } else {
                this.$element.css("visibility","visible");
                this.options.visible = true;
            };
        },
        //滚动条滚动，判断上下边界
        onScroll : function(){
            var scrT = this.$element.offset().top+100;                   //导航元素的上边的位置
            var _wrapB = this.wrapB - this.$element.outerHeight();   //下边界
            if(scrT < this.wrapT) {                //根据导航元素来算是不是到了wrap的边界
                this.$element.css("visibility","hidden");
                this.options.visible = false;
            } else {
                if(!(this.options.visible)){                         //如果已经是显示的了就没有必要再去写一次dom
                    this.$element.css("visibility","visible");
                    this.options.visible = true;
                }
            };
            if(this.isIE6) {                                        //如果是ie6
                var top = this.$win.scrollTop();
                this.$element.css({top:(this.topIE6 + top)});
            }; 
        },
        //更新索引，到哪个楼层
        positionIndex : function(){                              
            var winHeight = this.$win.height();
            var sensitive = winHeight/2;
            var scroTop = this.$win.scrollTop()+winHeight;
            var t = this.arrPositions.length;
            for(var i in this.arrPositions){
                if((scroTop-this.arrPositions[t-i-1])>=sensitive) {this.index=t-parseInt(i)-1;break;} 
            } 
            $("a[href="+this.arrPositionsID[this.index]+"]").parent().addClass(this.options.activeClass).siblings().removeClass(this.options.activeClass);
        },
        init : function(){
            var _this = this;
            //记录下所有的锚点的top
            $("a[href*=#],area[href*=#]",this.$element).each(function(i){
                var href = $(this).attr("href");
                var top = ($(href).length>0)? $(href).offset().top : 0;
                if(top>120){_this.arrPositions.push(top);_this.arrPositionsID.push(href);}
            });
            if(!this.isIE6) { this.goTarget(); } // ie6下楼层间跳转就不要用动画了，有时候鼠标变成加载的样式
            this.$win.resize(function(){
                    _this.onResize();
            }).scroll(function(){
                    _this.onScroll();
                    if(_this.options.activeClass){ // 要是没有传激活的类名就不运行了
                        _this.positionIndex();
                    }
            });
            this.onResize();
            if(_this.options.activeClass){
                _this.positionIndex();
            }
        }
    
    };
    $.fn.sideNav = function (options) {
        if (this.length){
            return this.each(function(){
                (new SideNav(this,options));
            });
        }
    };
    $.fn.sideNav.defaults = {
        visible :false,             //导航元素现在是不是显示状态,为了在滚动的时候不总去修改DOM
        minWidth : 1200,            //最小宽度，小于这个就不显示了
        floatWrap :$("body"),       //设置出现的边栏范围的容器
        time : 800,                //设置不同锚点间跳转花的时间
        activeClass : 'null'        //激活索引时加的类名，添加到li上
    };
 })(jQuery);

$(document).ready(function(){
    $(".act_nav").sideNav({
        minWidth : 1200,
        floatWrap : $(".act_wrapper")
    });
});
/*  |xGv00|949ce084d96068755cbb58b3292082e9 */