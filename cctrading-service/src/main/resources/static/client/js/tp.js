(function(){function b(k){return(typeof k=="string")&&k.constructor==String}function e(){var k={win:false,mac:false,xll:false};var l=navigator.platform;k.win=l.indexOf("Win")==0;k.mac=l.indexOf("Mac")==0;k.xll=l.indexOf("Xll")==0||l.indexOf("Linux")==0;if(k.win||k.mac||k.xll){return true}else{return false}}function i(){var k=navigator.userAgent.toLowerCase();return !!k.match(/DKKJ/ig)}function d(l,m,k){if(_paq&&l&&m&&k){if(JSON&&!b(k)){k=JSON.stringify(k)}if(b(k)){k=k.length<200?k:k.substring(0,190)}_paq.push(["setCustomVariable",l,m,k,"page"])}}function a(k){d(4,"dkkjDeviceInfo",k)}function j(n,m,k){var s=String(n);var r=String(m);if(s===r){return 0}var q=s.split(".");var l=r.split(".");var p=Math[k?"max":"min"](q.length,l.length);for(var o=0;o<p;o++){q[o]="undefined"===typeof q[o]?0:parseInt(q[o],10);l[o]="undefined"===typeof l[o]?0:parseInt(l[o],10);if(q[o]>l[o]){return 1}if(q[o]<l[o]){return -1}}return 0}function f(){var k=window.navigator.userAgent.match(/\[(.*?)\]/g);var l;if(k){for(var m=0;m<k.length;m++){if(k[m].indexOf("DKKJ_TOWER_")>-1){l=k[m].replace("[","").replace("]","").substr("11")}}}if(l&&j(l,"1.0",true)>0){return true}return false}function h(){var k=navigator.userAgent.toLowerCase();if(!!k.match(/iphone|ipod|ipad/ig)){return true}else{return false}}function g(){var k=navigator.userAgent.toLowerCase();if(k.match(/android/ig)=="android"){return true}else{return false}}function c(){if(e()){return"2f3b8a913df20ec4b4a81faeb58841bd"}if(i()){if(g()){return"f7ad22b27dc8261d55d5c498ea3e2741"}if(h()){return"630a8c68acc2f817ebf6857be730db72"}}return"1c0c06f067fc51fe0f52cdc6573c31b1"}return window.wtk=ret={getBfdAK:c,WTKIsApp:i,WTKIsHighVApp:f,WTKSetCustVDI:a}})();function isIos(){var a=navigator.userAgent.toLowerCase();if(!!a.match(/iphone|ipod|ipad/ig)){return true}else{return false}}function isAndroid(){var a=navigator.userAgent.toLowerCase();if(a.match(/android/ig)=="android"){return true}else{return false}}function isApp(){var a=navigator.userAgent.toLowerCase();return !!a.match(/DKKJ/ig)}function isPc(){var a={win:false,mac:false,xll:false};var b=navigator.platform;a.win=b.indexOf("Win")==0;a.mac=b.indexOf("Mac")==0;a.xll=b.indexOf("Xll")==0||b.indexOf("Linux")==0;if(a.win||a.mac||a.xll){return true}else{return false}}function isMicroMessenger(){var a=navigator.userAgent.toLowerCase();if(a.match(/MicroMessenger/i)=="micromessenger"){return true}else{return false}}function isWap(){var a=navigator.userAgent.toLowerCase();return !!a.match(/AppleWebKit.*Mobile.*/i)||!!a.match(/AppleWebKit/)}function getIdsite(){if(isApp()){return 2}if(isMicroMessenger()){return 6}if(isPc()){return 5}return 4}function getcookies(){var d={};var h=decodeURI(document.cookie);if(h===""){return d}var f=h.split("; ");for(var c=0;c<f.length;c++){var a=f[c];var g=a.indexOf("=");var b=a.substring(0,g);var e=a.substring(g+1);d[b]=e}return d}function getCookie(b){var a={};a=getcookies();return a[b]||null}function getChid(){var a=new RegExp("(^|&)sid=([^&]*)(&|$)");var b=window.location.search.substr(1).match(a);if(b!=null&&b.length>1){chid=unescape(b[2])}else{chid=getCookie("CHID")}return chid}function getWTKPid(){var a=new RegExp("(^|&)pid=([^&]*)(&|$)");var b=window.location.search.substr(1).match(a);if(b!=null&&b.length>1){chid=unescape(b[2])}else{chid=getCookie("cls")}return chid}function WTKsetcookie(b,d,a){var c=b+"="+encodeURIComponent(d);if(typeof a==="number"){c+="; max-age="+(a*60*60*24)}document.cookie=c}function WTKsearchUrlAndSaveCookie(a){var b=new RegExp("(^|&)"+a+"=([^&]*)(&|$)");var c=window.location.search.substr(1).match(b);if(c!=null&&c.length>1){str=unescape(c[2]);WTKsetcookie(a,str)}else{str=getCookie(a)}return str}function WTKSetCustomDimension(a,b){if(_paq&&a&&!isNaN(a)&&b&&WTKIsString(b)){_paq.push(["setCustomDimension",a,b])}}function WTKDeleteCustomDimension(a){if(_paq&&a&&!isNaN(a)){_paq.push(["deleteCustomDimension",a])}}function WTKIsString(a){return(typeof a=="string")&&a.constructor==String}function getCls(){var a=new RegExp("(^|&)cls=([^&]*)(&|$)");var b=window.location.search.substr(1).match(a);if(b!=null&&b.length>1){chid=unescape(b[2])}else{chid=getCookie("cls")}return chid}function isString(a){return(typeof a=="string")&&a.constructor==String}var _paq=_paq||[];var wtk_chid=getChid();if(wtk_chid){_paq.push(["setCustomVariable",1,"chid",wtk_chid,"page"])}var wtk_pid=getWTKPid();if(wtk_pid){_paq.push(["setCustomVariable",2,"pid",wtk_pid,"page"])}var wtk_cls=WTKsearchUrlAndSaveCookie("cls");if(wtk_cls){_paq.push(["setCustomVariable",3,"cls",wtk_cls,"page"])}if(window.wtk.WTKIsApp()&&window.wtk.WTKIsHighVApp()){confirm('{"funcName":"deviceInfoToPiwik","params":""}')}else{var deviceFm=getCookie("63f6d7504710");window.wtk.WTKSetCustVDI(deviceFm)}var wtk_ocrid=getCookie("ocrid");if(wtk_ocrid&&isString(wtk_ocrid)){_paq.push(["setUserId",wtk_ocrid])}_paq.push(["trackPageView"]);_paq.push(["enableLinkTracking"]);_paq.push(["trackAllContentImpressions"]);window.onhashchange=function(){var a=getTrackURl()+window.location.hash;sendUrl(a)};(function(){var b,a;b=function(d,e,c){if(d){if(d.attachEvent){d.attachEvent("on"+e,c)}else{d.addEventListener(e,c,false)}return true}else{return false}};a=function(){setTimeout(function(){var e="https://ebank.creditcard.ecitic.com/citiccard/wtk/";_paq.push(["setTrackerUrl",e+"cms"]);_paq.push(["setSiteId",getIdsite()]);var j=document,i=j.createElement("script"),f=j.getElementsByTagName("script")[0];i.type="text/javascript";i.async=true;i.defer=true;i.src=e+"pk.js";f.parentNode.insertBefore(i,f);var c=document.getElementsByTagName("HEAD").item(0);var h=document.createElement("script");h.type="text/javascript";h.src="https://cdn.citiccard.hunshitong.net/eshop/wtk/zxing.min.js";c.appendChild(h)},20)};b(window,"load",a)})();