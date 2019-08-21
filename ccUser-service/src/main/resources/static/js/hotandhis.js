var mouseOutDiv = true;
var guessLikeArrayItem = [];
$(function(){
    // 加载默认搜索词
    initeKeyword();
    handleContentDiv('hide');
  });
  function initeKeyword() {
    get(_prefix + 'defaultWord?source=pc', function(_data){
      if(_data.retCode === '100000') {
        if(!!window.ActiveXObject || "ActiveXObject" in window){
          // 兼容ie浏览器
          $(".input-area").val(_data.data.list[0])
        } else {
          $(".input-area").attr('placeholder', _data.data.list[0]);
        }
      } else {
      }
    });
  }
  // 输入框得到焦点： 展示虚拟框
  function inputFocus() {
    handleContentDiv('show');
    $('.input-area').bind('input propertychange', function(){
      inputChange();
    });
  }
  // 输入变化时：刷新展示内容
  function inputChange() {
    handleContentDiv('show');
  }
  // 输入框失去焦点： 隐藏虚拟框
  function inputBlur() {
    if($('.content-div').is("focus")) {
    } else {
      // setTimeout(function(){handleContentDiv('hide');}, 100);
      // handleContentDiv('hide');
    }
  }
  // type控制是否展示虚拟框
  function handleContentDiv(type) {
    document.onmousedown = function(e) {
      if(mouseOutDiv) {
        $('.content-div').css('display', 'none');
      }
    }
    if (type === 'show') {
      var inputWords = $('.input-area').val() || '';
      // 输入为空： 展示 热门搜索和历史搜索
      if (inputWords !== '') {
        showHotOrLinked('linked');
      // 输入不为空： 展示关联词
      } else if (inputWords === ''){
        showHotOrLinked('hotandhis');
      }
    } else if (type === 'hide') {
      $('.content-div').css('display', 'none');
    }
  }
  // type控制 展示热门搜索和历史搜索记录  or  关联词
  function showHotOrLinked(type) {
    if (type === 'linked') {
      $('.content-div').css('display', 'block');
      $('.show-linked').css('display', 'block');
      loadLinkedWords();
      $('.show-hot-and-his').css('display', 'none');
    } else if (type === 'hotandhis') {
      $('.content-div').css('display', 'block');
      $('.show-hot-and-his').css('display', 'block');
      loadHotWords();
      loadGuessWords();
      loadHisWords();
      $('.show-linked').css('display', 'none');
    }
  }
  // 加载关联词
  function loadLinkedWords() {
    var LinkedWords = [];
    // 请求接口:拿到linkedWords
    get(_prefix + 'suggestion?source=pc' + '&num=8&keyword=' + encodeURI(encodeURI($('.input-area').val())), function(_data){
      if(_data.retCode === '100000') {
        LinkedWords = _data.data.list || [];
        if(LinkedWords.length > 8) {
          LinkedWords = LinkedWords.slice(0,8);
        }
        $('.linked-div').empty();
        if (LinkedWords !== []) {
          var linkItemLeft = '';
          var linkItemRight = '';
          // 给linkedWordsList加a标签----放到接口里面去
          var inputVal = $('.input-area').val()
          var re = new RegExp(inputVal, 'g');
          for (var j = 0; j < LinkedWords.length; j++) {
            LinkedWords[j].keyword = LinkedWords[j].keyword.replace(re, '<a class="aa">' + inputVal + '</a>');
          };
          // 给linkedWordsList加a标签----
          LinkedWords.map(function(item) {
              if(LinkedWords.indexOf(item) !== LinkedWords.length - 1) {
                linkItemLeft = '<div class="li-border-bottom linked-item item">' + item.keyword;
                linkItemRight = '<a class="bb"></a></div>';
              } else {
                linkItemLeft = '<div class="linked-item item">' + item.keyword;
                linkItemRight = '<a class="bb"></a></div>';
              }
              $('.linked-div').append(linkItemLeft + linkItemRight)
            }) 
          // 每个关联词的 click事件回调  =》 调用查询方法
          $('.item').click(function() {
            var keyWord = $(this).text(); // 以去掉aa标签
            if(keyWord) {
              goSearch(this);
            }
          });
        }
        } else {
          $('.linked-div').empty();
      }
    });
  }
  // 加载热门搜索
  function loadHotWords() {
    // 请求接口: 拿到hotWords
    var hotWords = [];
    get(_prefix + 'hotWord?source=pc', function(_data){
      if(_data.retCode === '100000') {
        //请求成功
        hotWords = _data.data.list || [];
        if(hotWords.length > 8) {
          hotWords = hotWords.slice(0, 8);
        }
        $('.hot-div').empty();
        if (hotWords.length !== 0) {
          $('.hot-div').css('display', 'block');
          var hotTitle = '<div class="title hot-title title-padding-left">热门搜索</div>';
          var hotContent = '<div class="hot-content"></div>';
          $('.hot-div').append(hotTitle);
          if(hotWords.length % 2 === 1) {
            hotWords.push({keyword: ''});
          }
          hotWords.map(function(item) {
              var hotItemLeft = '';
              var hotItemRight = '';
              if (hotWords.indexOf(item) % 2 === 0) {
                if (hotWords.indexOf(item) !== hotWords.length - 2) {
                  hotItemLeft = '<a class="li-border-bottom li-margin-left hot-or-his-item item"><span class="li-border-right">' + item.keyword
                  hotItemRight = '</span></a>'
                } else {
                  hotItemLeft = '<a class="li-margin-left hot-or-his-item item"><span class="li-border-right">' + item.keyword
                  hotItemRight = '</span></a>'
                }
                $('.hot-div').append(hotItemLeft + hotItemRight)
              } else {
                if (hotWords.indexOf(item) !== hotWords.length - 1) {
                  hotItemLeft = '<a class="li-padding-left li-border-bottom hot-or-his-item item"><span>' + item.keyword
                  hotItemRight = '</span></a>'
                } else {
                  hotItemLeft = '<a class="li-padding-left hot-or-his-item item"><span>' + item.keyword
                  hotItemRight = '</span></a>'
                }
                $('.hot-div').append(hotItemLeft + hotItemRight)
              }
            });//
          // 每个关联词的 click事件回调  =》 调用查询方法
          $('.item').click(function() {
            var keyWord = $(this).text();
            if(keyWord) {
              goSearch(this);
            }
          });
        } else {
          $('.hot-div').empty();
          $('.hot-div').css('display', 'none');
        }
      } else {
      }
    });
    
  }
  // 拿cookie中的deviceId
  function getCookieId () {
    var getCookie = document.cookie;
    if (getCookie) {
        var cookieList = document.cookie.split(';');
        var getDeviceId = '';
        for (var i = 0; i < cookieList.length; i++) {
          var cookieName = cookieList[i].split('=')[0]
            if ($.trim(cookieName) === '63f6d7504710') {
                getDeviceId = cookieList[i].split('=')[1]
            }
        }
        return getDeviceId
    } else {
        return ''
    }
  }
  //加载猜你喜欢
  function loadGuessWords() {
    var deviceId = getCookieId();
    var guessWords = [];
    get(_prefix + 'guessLike?num=6&page=1&source=pc&deviceId=' + deviceId, function(_data){
      if(_data.retCode === '100000') {
        toPiwikGuess('0', _data);
        guessLikeArrayItem = _data
        //请求成功
        guessWords = _data.data || [];
        if(guessWords.length > 6) {
          guessWords = guessWords.slice(0, 6);
        }
        $('.guess-div').empty();
        if (guessWords.length !== 0) {
          $('.guess-div').css('display', 'block');
          var guessTitle = '<div class="title guess-title title-padding-left">猜你喜欢</div>';
          var guessContent = '<div class="guess-content"></div>';
          $('.guess-div').append(guessTitle);
          if(guessWords.length % 2 === 1) {
            guessWords.push({itemId: ''});
          }
          guessWords.map(function(item) {
              var guessItemLeft = '';
              var guessItemRight = '';
              if (guessWords.indexOf(item) % 2 === 0) {
                if (guessWords.indexOf(item) !== guessWords.length - 2) {
                  guessItemLeft = '<a class="li-border-bottom li-margin-left hot-or-his-item item guess"><span class="li-border-right">' + item.itemId.slice(0, 8)
                  guessItemRight = '</span></a>'
                } else {
                  guessItemLeft = '<a class="li-margin-left hot-or-his-item item guess"><span class="li-border-right">' + item.itemId.slice(0, 8)
                  guessItemRight = '</span></a>'
                }
                $('.guess-div').append(guessItemLeft + guessItemRight)
              } else {
                if (guessWords.indexOf(item) !== guessWords.length - 1) {
                  guessItemLeft = '<a class="li-padding-left li-border-bottom hot-or-his-item item guess"><span>' + item.itemId.slice(0, 8)
                  guessItemRight = '</span></a>'
                } else {
                  guessItemLeft = '<a class="li-padding-left hot-or-his-item item guess"><span>' + item.itemId.slice(0, 8)
                  guessItemRight = '</span></a>'
                }
                $('.guess-div').append(guessItemLeft + guessItemRight)
              }
            });//
          // 每个关联词的 click事件回调  =》 调用查询方法
          $('.item').click(function() {
            console.log(this, 'this');
            var keyWord = $(this).text();
            if(keyWord) {
              goSearch(this);
            }
          });
        } else {
          $('.guess-div').empty();
          $('.guess-div').css('display', 'none');
        }
      } else {
      }
    });
    
  }
  function toPiwikGuess(type, dataItem){
    if (window.inputEvent) {
        var _sendObj = {};
        if (type === '0') { // 请求guess接口时触发
            _sendObj.id = 'official_word_scan';
            _sendObj.value = 'traceId=' + dataItem.traceId + '|' + 'adCode=w-official-01|abtag=' + dataItem.abtag;
            window.inputEvent(_sendObj);
        } else if (type === '1') { // 点击猜你喜欢的词时触发
            _sendObj.id = 'official_word_click';
            _sendObj.value = 'traceId=' + dataItem.traceId + '|' + 'adCode=w-official-01|abtag=' + dataItem.abtag + '|order=' + dataItem.order + '|id=' + dataItem.itemId;
            window.inputEvent(_sendObj);
        }
    }
  }
  // 加载历史搜索
  function loadHisWords() {
    $('.his-div').empty();
    var hisWords = JSON.parse(localStorage.getItem('history')) || [];
    if(hisWords.length !== 0) {
      $('.his-div').css('display', 'block');
      var hisTitle = '<div class="title his-title title-padding-left"><span class="his-text">历史搜索</span><img src=\"../../assets/assets/delete.png\" class="his-del" onclick="delHistory()"></div>';
      $('.his-div').append(hisTitle);
      if(hisWords.length % 2 === 1) {
        hisWords.push('');
      }
      var hisItemLeft = '';
      var hisItemRight = '';
        hisWords.map(function(item) {
            if (hisWords.indexOf(item) % 2 === 0) {
              if (hisWords.indexOf(item) !== hisWords.length - 2) {
                hisItemLeft = '<a class="li-margin-left li-border-bottom  hot-or-his-item item"><span class="li-border-right">' + item.replace(/\s/g, '&nbsp;')
                hisItemRight = '</span></a>'
              } else {
                hisItemLeft = '<a class="li-margin-left hot-or-his-item item"><span class="li-border-right">' + item.replace(/\s/g, '&nbsp;')
                hisItemRight = '</span></a>'
              }
              $('.his-div').append(hisItemLeft + hisItemRight)
            } else {
              if (hisWords.indexOf(item) !== hisWords.length - 1) {
                hisItemLeft = '<a class="li-padding-left li-border-bottom hot-or-his-item item"><span>' + item.replace(/\s/g, '&nbsp;')
                hisItemRight = '</span></a>'
              } else {
                hisItemLeft = '<a class="li-padding-left hot-or-his-item item"><span>' + item.replace(/\s/g, '&nbsp;')
                hisItemRight = '</span></a>'
              }
              $('.his-div').append(hisItemLeft + hisItemRight)
            }
        })
      // 每个关联词的 click事件回调  =》 调用查询方法
      $('.item').click(function() {
        var keyWord = $(this).text();
        if(keyWord) {
          // goSearch(keyWord);
          goSearch(this);

        }
      });
    } else {
      $('.his-div').css('display', 'none');
    }
  }
  // 进行搜索====>要跳转页面
  function goSearch(item) {
    var keyWordSolid = $(item).text();
    if (item === -1) { // 直接点搜索按钮
      if ($.trim($('.input-area').val().replace(/\<|\>/g, ''))) { // 已输入搜索词
        keyWordSolid = $.trim($('.input-area').val().replace(/\<|\>/g, ''));
        $('.input-area').val(keyWordSolid);
      } else if ($(".input-area").attr('placeholder')) { // 使用默认搜索词
        keyWordSolid = $(".input-area").attr('placeholder');
      } else { // 无搜索词
        alert('请输入搜索词');
      }
    } else { // 点item进行搜索
      if ($(item).attr('class').indexOf('guess') > -1) {
        // 点击的是猜你喜欢的词语，调用用户行为分析
        var targetItem = {abtag: guessLikeArrayItem.abtag, traceId: guessLikeArrayItem.traceId}
        guessLikeArrayItem.data.map(function (guessitem) {
            if ($(item).text() === guessitem.itemId) {
                targetItem.itemId = guessitem.itemId
                targetItem.order = guessitem.order
            }
        })
        toPiwikGuess('1', targetItem)
      }
      keyWordSolid = $.trim($(item).text().replace(/\<|\>/g, ''));
      // 回填搜索词
      $('.input-area').val(keyWordSolid);
      $('.content-div').css('display', 'none');
    }
    if(keyWordSolid.replace(/\<|\>/g, '')) {
      // 将搜索记录保存为  历史搜索，并处理历史搜索记录
      var hisWordsListTemp = JSON.parse(localStorage.getItem('history')) || [];
      hisWordsListTemp.unshift(keyWordSolid.replace(/\<|\>/g, ''));
      localStorage.setItem('history', JSON.stringify(manageHisWords(hisWordsListTemp)));
      // 页面跳转
      window.location = _prefix + 'search?keyword=' + encodeURI(encodeURIComponent(keyWordSolid)) + '&type=pc';
    } else {
      alert('请输入搜索词');
    }
  }
  // 处理historyWords： 去重，排序，控制展示数量
  function manageHisWords(hisWordsListTemp) {
    // var s = new Set();
    // hisWordsListTemp.forEach(function(x) {s.add(x)});
    // list = Array.from(s);
    // if(list.length > 6) {
    //   list = list.slice(0, 6);
    // }
    // return list
    var tempArr = [hisWordsListTemp[0]];
    for (var k = 1; k < hisWordsListTemp.length; k++) {
      if (hisWordsListTemp[k] !== hisWordsListTemp[0]) {
        tempArr.push(hisWordsListTemp[k])
      }
    }
    if(tempArr.length > 6) {
      tempArr = tempArr.slice(0, 6);
    }
    return tempArr
  }
  function delHistory() {
    mouseOutDiv = true;
    handleContentDiv('show');
    localStorage.setItem('history', JSON.stringify([]));
    loadHisWords();
  }
  function mouseOver() {
    mouseOutDiv = false;
  }
  function mouseOut() {
    mouseOutDiv = true;
  }
  function mouseOverInput() {
    mouseOutDiv = false;
  }
  function mouseOutInput() {
    mouseOutDiv = true;
  }
  function keyDown(e) {
    var keyWord = $('.input-area').val().trim();
    if(e.keyCode === 13) {
      goSearch(-1);
    }
  }
    // 异步加载js
  function loadScript(_url, _callback) {
      // check the page has the srcipt 
      var urlTemp = _url;
      var scripts = document.getElementsByTagName("script");
      for(var i=0; i< scripts.length;i++){
          if(scripts[i].src == urlTemp ){
              if(_callback){
                  _callback();
              }
              return;
          }
      }
  
      // Adding the script tag to the head as suggested before
      var head = document.getElementsByTagName('head')[0];
      var script = document.createElement('script');
      script.type = 'text/javascript';
  
      // Then bind the event to the callback function.
      // There are several events for cross browser compatibility.
      if (_callback) {
          script.onload = script.onreadystatechange = function () {
              if (script.readyState && script.readyState !== 'loaded' && script.readyState !== 'complete') {
                  return;
              }
              script.onreadystatechange = script.onload = null;
              setTimeout(function () { 
                  _callback()
              }, 0);
          };
      }
      script.src = _url;
      // Fire the loading
      head.appendChild(script);
  }
  function loadPageState(stateNum) {
      if (stateNum === undefined) { // 最初的首页
          $(".main").css('display', 'block');
          $(".search-area").css('display', 'none');
          $(".show-result").css('display', 'none');
          // $(".show-hot-his").css('display', 'none');
          $(".confirm-back").css('display', 'none');
          t4.refresh();
      } else if (stateNum === '1') {
          $(".main").css('display', 'none');
          $(".search-area").css('display', 'block');
          $(".show-hot-his").css('display', 'block');
          $(".show-result").css('display', 'none');
          $(".show-result-single").css('display', 'none');
          loadHotWords();
          loadGuessWords();
          loadHistoryWords();
      } else if (stateNum === '2') {
          $(".main").css('display', 'none');
          $(".search-area").css('display', 'block');
          $(".show-result").css('display', 'inline-block');
          $(".show-result-single").css('display', 'none');
      } else if (stateNum === '3') {
          $(".main").css('display', 'none');
          $(".search-area").css('display', 'block');
          $(".show-result").css('display', 'inline-block');
          $(".show-result-single").css('display', 'none');
      }
  }