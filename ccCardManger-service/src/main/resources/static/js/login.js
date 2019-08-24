var flag = 0;
ucNameSpace.register("login.qrcode"),
ucNameSpace.register("login.uclogin"),
window.reloadValidCode = function() {
    var e = '<img class="img-code" id="randImage" src="./newvalicode.do?time=' + (new Date).getTime() + '" width="72" height="35" alt="点击图片换一张"/>';
    $("#newValidCodeALink").html(e)
}
,
$(document).ready(function() {
    $("div.login_way>span").click(function() {
        $(this).index();
        $(this).addClass("click").siblings("span").removeClass("click")
    }),
    $("i.psd_login,.img_qrcode").click(function() {
        $("div.form_area").stop().animate({
            left: "0px"
        }, 500),
        $(".login_old_way").stop().show(),
        $(".img_psd").removeClass("none"),
        $(".img_qrcode").addClass("none"),
        clearTimeout(login.qrcode.constantPolling)
    }),
    $("i.qrcode_login,.img_psd").click(function() {
        $("div.form_area").stop().animate({
            left: "-300px"
        }, 500),
        $(".login_old_way").stop().hide(),
        $(".img_psd").addClass("none"),
        $(".img_qrcode").removeClass("none"),
        $(".qrcode_login_content .download").is(":hidden") && $(".scan_success").is(":hidden") ? login.qrcode.doRefresh() : login.qrcode.pollStatus()
    }),
    $(".qrcode_login_attr .download").click(function() {
        $(".qrcode_login_content").find(".download").removeClass("none").siblings(".login,.qrcode_reflesh").addClass("none"),
        $(".qrcode_login_qrcode .download").removeClass("none").siblings().addClass("none"),
        $(this).addClass("none").siblings(".scan").removeClass("none")
    }),
    $(".qrcode_login_attr .scan").click(function() {
        $(".qrcode_login_content").find(".login").removeClass("none").siblings(".download,.qrcode_reflesh").addClass("none"),
        $(".qrcode_login_qrcode .login").removeClass("none").siblings().addClass("none"),
        $(this).addClass("none").siblings(".download").removeClass("none")
    }),
    $(".scan_success a.return_scan").click(function() {
        clearTimeout(login.qrcode.constantPolling),
        $(".qrcode_login_content").removeClass("none").find(".login").removeClass("none").siblings(".download,.qrcode_reflesh").addClass("none"),
        $(".qrcode_login_qrcode").removeClass("none").find(".login").removeClass("none").siblings().addClass("none"),
        $(".qrcode_login_attr").removeClass("none").find(".download").removeClass("none").siblings().addClass("none"),
        $(this).parent().addClass("none"),
        $("div.scan_success").addClass("none"),
        $("div.scan_area").show(),
        login.qrcode.doRefresh()
    }),
    $(".reflesh").click(function() {
        login.qrcode.doRefresh()
    }),
    $("div.login_old_way").click(function() {}),
    $("span.forget_psd").bind("mousedown", function() {
        flag = 1,
        "block" != $("span.error_area").css("display") && "inline" != $("span.error_area").css("display") || $("span.error_area").css("display", "none")
    }),
    $("input[name='psd']").bind("keypress", function(e) {
        "13" == e.keyCode && $("div.submit").click()
    }),
    $("input").blur(function() {
        if (1 == flag)
            return !1;
        var e = $(this).attr("name")
          , n = $(this).val()
          , o = ($(this).attr("placeholder"),
        $(this).parent());
        $(this).parent().parent().children("li").eq(o.index() + 1);
        "phone" == e && ("" == n ? ($("span.error_area").stop().css("display", "block").html("<i></i>手机号码不能为空"),
        $(this).addClass("error")) : 11 != n.length || isNaN(n) ? ($("span.error_area").stop().css("display", "block").html("<i></i>手机号码需为11位数字"),
        $(this).addClass("error")) : isMobile($("input[name='phone']").val()) ? ($("span.error_area").stop().css("display", "none"),
        $(this).removeClass("error")) : ($("span.error_area").stop().css("display", "block").html("<i></i>手机号无效，请重新输入"),
        $(this).addClass("error")))
    }),
    $("div.submit").click(function() {
        if ($("span.error_area").css("display", "none"),
        "" == $("input[name='phone']").val())
            return $("span.error_area").css("display", "block").html("<i></i>手机号码不能为空"),
            !1;
        var e = $("input[name='psd']").val();
        if ("" == e)
            return $("span.error_area").css("display", "block").html("<i></i>密码不能为空"),
            !1;
        if (isNaN($("input[name='phone']").val()) || 11 != $("input[name='phone']").val().length)
            return $("span.error_area").css("display", "block").html("<i></i>手机号码需为11位数字"),
            !1;
        if (e.length < 6 || e.length > 15)
            return $("span.error_area").css("display", "block").html("<i></i>密码由6-15位数字和字母组成"),
            !1;
        if ("disabled" != $("div.submit").attr("disabled")) {
            $("div.submit").attr("disabled", "disabled");
            var n = $("input[name='phone']").val()
              , o = ""
              , s = $.trim($(".newvalidcode").val());
            o = $("input[name='psd']").val();
            var i = '{"loginType":"01","memCode":"' + (o = hex_md5($.trim(o))) + '","isBord":"' + !1 + '","phone":"' + n + '","source":"PC","page":"new","valiCode":"' + s + '"}'
              , a = (new Date).getTime();
            $.ajax({
                url: "login.do?date=" + a,
                type: "POST",
                dataType: "json",
                data: i,
                contentType: "application/json",
                processData: !1,
                success: function(e) {
                    if ("0000000" != e.rtnCode) {
                        var n = e.retMsg;
                        $("span.error_area").css("display", "block").html("<i></i>" + n),
                        "1" == e.needValidation && (reloadValidCode(),
                        $("#validcodeArea").attr("style", "display:block"),
                        $(".login_form_area").addClass("img-code-show"))
                    } else if (void 0 == e.needValiCode) {
                        cacheIdentity(e);
                        var o = e.ucseq
                          , s = !1;
                        "https:" == location.protocol && (s = !0),
                        $.cookie("ucseq", o, {
                            expires: 7,
                            path: "/",
                            domain: window.location.hostname,
                            secure: s
                        }),
                        login.uclogin.removeDisabled(),
                        location.href = e.redirectUrl
                    } else
                        "true" == e.needValiCode && (cacheIdentity(e),
                        a = (new Date).getTime(),
                        login.uclogin.removeDisabled(),
                        window.location.href = "sendSmsInit.do?date=" + a);
                    login.uclogin.removeDisabled()
                },
                error: function(e) {
                    $("span.error_area").css("display", "block").html("<i></i>处理数据失败，请稍后再试"),
                    login.uclogin.removeDisabled()
                }
            })
        }
    })
}),
window.goold = function() {
    var e = $.QueryString("r")
      , n = "";
    n = e ? "oldinit.do?r=" + e : "oldinit.do",
    window.location.href = n
}
;
var icsWnd = null;
window.fLogon = function() {
    screen.width,
    screen.height;
    for (var e = null, n = navigator.userAgent, o = ["Android", "iPhone", "SymbianOS", "Windows Phone", "iPad", "iPod"], s = !0, i = 0; i < o.length; i++)
        if (n.indexOf(o[i]) > 0) {
            s = !1;
            break
        }
    1 == s && (e = "https://im.bank.ecitic.com/credit/navigation.html?channel=712021"),
    0 == s && (e = "https://im.bank.ecitic.com/credit/navigation.html?channel=712021"),
    null == icsWnd || icsWnd.closed ? (icsWnd = window.open(e)).focus() : icsWnd.focus()
}
,
login.uclogin.removeDisabled = function() {
    $("div.submit").removeAttr("disabled")
}
,
login.qrcode.acquireQR = function() {
    var e = (new Date).getTime()
      , n = new Image;
    n.src = "qrcode/image.do?date=" + e,
    n.onload = function() {
        $(".qrcode_login_qrcode").html("<img src='./img/qrcode-download.jpg' alt='下载动卡空间' class='download none'><img src='" + n.src + "' class='login' alt='扫一扫'>"),
        login.qrcode.queryQRStatus()
    }
}
,
login.qrcode.scanSuccess = function() {
    $(".qrcode_login_content,.qrcode_login_qrcode,.qrcode_login_attr").addClass("none"),
    $(".scan_success").removeClass("none"),
    $(".qr_login_success").addClass("none"),
    $(".scanned_qrcode").removeClass("none"),
    $(".neterror").addClass("none")
}
,
login.qrcode.refreshQRCode = function() {
    $(".qrcode_login_content").removeClass("none").find(".qrcode_reflesh").removeClass("none"),
    $(".qrcode_login_content").find(".login,.download").addClass("none"),
    $(".qrcode_login_qrcode").removeClass("none").find(".login").removeClass("none").siblings().addClass("none"),
    $(".qrcode_login_attr").removeClass("none").find(".download").removeClass("none").siblings().addClass("none"),
    $(".scan_success").addClass("none")
}
,
login.qrcode.doRefresh = function() {
    login.qrcode.acquireQR(),
    $(".qrcode_login_content").find(".login").removeClass("none"),
    $(".qrcode_login_content").find(".qrcode_reflesh").addClass("none")
}
,
login.qrcode.qrLoginSuccess = function() {
    login.qrcode.scanSuccess(),
    $(".qr_login_success").removeClass("none"),
    $(".scanned_qrcode").addClass("none"),
    $(".neterror").addClass("none")
}
,
login.qrcode.queryQRStatus = function() {
    var e = (new Date).getTime();
    $.ajax({
        url: "qrcode/loginInfo.do?date=" + e,
        type: "GET",
        dataType: "json",
        contentType: "application/json",
        processData: !1,
        success: function(e) {
            e.success && ("WAIT_TO_SCAN" == e.value.status ? login.qrcode.pollStatus() : "SCAN_SUCCESS" == e.value.status ? (login.qrcode.scanSuccess(),
            login.qrcode.pollStatus()) : "LOGIN_SUCCESS" == e.value.status ? (login.qrcode.qrLoginSuccess(),
            window.location.href = e.value.rtnUrl) : login.qrcode.refreshQRCode())
        },
        error: function(e) {}
    })
}
,
login.qrcode.pollStatus = function() {
    login.qrcode.constantPolling = setTimeout(function() {
        login.qrcode.queryQRStatus()
    }, 1e3)
}
,
window.Encrypt = function(e, n) {
    e = escape(e),
    n = escape(n);
    for (var o = "", s = 0; s < n.length; s++)
        o += n.charCodeAt(s).toString();
    var i = Math.floor(o.length / 5)
      , a = parseInt(o.charAt(i) + o.charAt(2 * i) + o.charAt(3 * i) + o.charAt(4 * i) + o.charAt(5 * i))
      , r = Math.ceil(n.length / 2)
      , l = Math.pow(2, 31) - 1;
    if (a < 2)
        return alert("安全控件加载失败，请重新进入本页面."),
        null;
    var d = Math.round(1e9 * Math.random()) % 1e8;
    for (o += d; o.length > 10; )
        o = (parseInt(o.substring(0, 10)) + parseInt(o.substring(10, o.length))).toString();
    o = (a * o + r) % l;
    for (var t = "", c = "", s = 0; s < e.length; s++)
        c += (t = parseInt(e.charCodeAt(s) ^ Math.floor(o / l * 255))) < 16 ? "0" + t.toString(16) : t.toString(16),
        o = (a * o + r) % l;
    for (d = d.toString(16); d.length < 8; )
        d = "0" + d;
    return c += d
}
;
