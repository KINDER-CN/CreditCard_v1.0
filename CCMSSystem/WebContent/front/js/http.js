// var _prefix = 'http://e.test.bank.ecitic.com/citiccard/go/';
// var _pwikTp = 'http://e.test.bank.ecitic.com/eshop/wtk/tp.js';
// var _pwikEvent = 'http://e.test.bank.ecitic.com/eshop/wtk/trackevent.js';

var _prefix = 'https://creditcard.ecitic.com/go/';
var _pwikTp = 'https://creditcard.ecitic.com/eshop/wtk/tp.js';
var _pwikEvent = 'https://creditcard.ecitic.com/eshop/wtk/trackevent.js';
// 定义请求方式
function get(url, callback) {
  baseRequest({
    url: url,
    callback: callback,
    type: 'POST'
  })
}
function post(url, params, callback) {
  baseRequest({
    url: url,
    callback: callback,
    data: params,
    type: 'POST'
  })
}
var baseRequest = function (opt) {
    var cachedData;
    if (opt.cache) {
      cachedData = storage.sessionData('ZX_CACHED_DATA') || {};
      if (opt.data) {
        var data = {};
        if (typeof opt.data === 'string') {
          try {
            data = JSON.parse(opt.data)
          } catch (e) {
            data = {};
          }
        } else {
          data = opt.data;
        }
        data = $.param(data);
        opt.url = opt.url + '?' + data;
      }
      if (cachedData[opt.url]) {
        opt.callback && opt.callback(cachedData[opt.url]);
      }
    }
    var options = {
      url: opt.url,
      // contentType: 'application/json; charset=utf-8',
      dataType: 'json',
      headers: {
        'X-Requested-With': 'XMLHttpRequest'
      },
      success: function (_data) {
//        if (_data.responseCode === Constant.COMMON_ERROR) {
	  if (_data.responseCode === '7100001') {
          instance.$ui.toast.show('网络有误,请稍后再试')
        } else {
          // no common error, transform string to object
          var _response = typeof _data === 'object' ? _data : JSON.parse(_data)
          if (_response.key && /ucwap/.test(_response.key)) {
            // if contains ucwap value, redirect to login config
            Account.userLogin();
          } else {
            // handle request
            if (opt.cache) {
              // if enabled cache, set the data in session storage
              if (JSON.stringify(cachedData[opt.url]) !== JSON.stringify(_data)) {
                if ($.isEmptyObject(storage.sessionData('ZX_CACHED_DATA'))) {
                  cachedData[opt.url] = _data;
                } else {
                  cachedData = storage.sessionData('ZX_CACHED_DATA');
                  cachedData[opt.url] = _data;
                }
                storage.sessionData('ZX_CACHED_DATA', cachedData);
                opt.callback && opt.callback(cachedData[opt.url]);
              }
            } else {
              // if not, callback directly
              opt.callback && opt.callback(_response)
            }
          }
        }
      },
      error: function (){
      }
    }
    $.ajax($.extend(options, opt));
  }