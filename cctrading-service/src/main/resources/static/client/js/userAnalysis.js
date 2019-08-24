$(function () {

    var 
        buttonEventList = {
        },

        inputEventList = {     
        },

        count = 0;

    function loadScript(_url, _callback) {
        var head = document.getElementsByTagName('head')[0];
        var script = document.createElement('script');
        script.type = 'text/javascript';

        if (_callback) {
            script.onload = script.onreadystatechange = function () {
                if (script.readyState && script.readyState != 'loaded' && script.readyState != 'complete') {
                    return;
                }
                script.onreadystatechange = script.onload = null;
                setTimeout(function () {
                  _callback();
                }, 0);
            }
            script.src = _url;
            head.appendChild(script);
        }
    }

    // 高级版本
    // function addEvent () {
    //   document.body.addEventListener('click', function (event) {   
    //     if (buttonEventList[event.target.getAttribute('id')] === 1 && event.target.id) {
    //       window.buttonEvent(event.target);
    //     }
    //   })
    //   document.body.addEventListener('input', function (event) {  
    //     if (inputEventList[event.target.getAttribute('id')] === 1 && event.target.id) {
    //       window.inputEvent(event.target);
    //     }
    //   })
    // }

    // 向下兼容处理
    var EventUtil = {
      addHandler: function (element, type, handler) {
        if (element.addEventListener) {
          element.addEventListener(type, handler, false);
        } else if (element.attachEvent) {
          element.attachEvent("on" + type, handler);
        } else {
          element["on" + type] = handler;
        }
      },
      removeHandler: function (element, type, handler) {
        if (element.removeEventListener) {
          element.addEventListener(type, handler, false);
        } else if (element.attachEvent) {
          element.detachEvent("on" + type, handler);
        } else {
          element["on" + type] = null;
        }
      },
      getEvent: function (event) {
        return event ? event : window.event;
      },
      getTarget: function (event) {
        return event.target || event.srcElement;
      }
    }

    function addEvent () {
      EventUtil.addHandler(document.body, 'click', function (event) {
        var eventTarget = EventUtil.getTarget(event);
        if (buttonEventList[eventTarget.getAttribute('id')] === 1 && eventTarget.id) {
          window.buttonEvent(eventTarget);
        }
      })
      EventUtil.addHandler(document.body, 'input', function (event) {
        var eventTarget = EventUtil.getTarget(event);
        if (inputEventList[eventTarget.getAttribute('id')] === 1 && eventTarget.id) {
          window.inputEvent(eventTarget);
        }
      })
    }

    var Analysiscontext = 'https://creditcard.ecitic.com';
    var currentUrl = window.location.href;
    if (currentUrl.indexOf('creditcard.ecitic.com') == -1) {
      Analysiscontext = window.location.protocol + '//e.test.bank.ecitic.com';
    } else {
      Analysiscontext = 'https://creditcard.ecitic.com';
    }
    var UserAnalysis_Tp = '/eshop/wtk/tp.js';
    var UserAnalysis_Trace = '/eshop/wtk/trackevent.js';

    var tp_api = Analysiscontext + UserAnalysis_Tp;
    var trace_api = Analysiscontext + UserAnalysis_Trace;

    loadScript(tp_api, function () {                        
      if (++count == 2) {
        addEvent();                                         
      }
    });
    loadScript(trace_api, function () {        
      if (++count == 2) {
        addEvent();                                        
      }
    });
});