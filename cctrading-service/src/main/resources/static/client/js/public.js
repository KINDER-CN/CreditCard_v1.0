
 
//sid透传
  function GetQueryString(name)
  {	//获取url参数
	   var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	   var r = window.location.search.substr(1).match(reg);
	   if(r!=null)return  unescape(r[2]); return null;
  };
  var sid=GetQueryString("sid");
  var netId=GetQueryString("netId");
$(function(){
		//继承参数
		if(sid!=null){
				$("a").each(function(){         //遍历所有超链接标签			
                    var ohref= $(this).attr("href"); 
					if(ohref!=undefined){     
					if(ohref.indexOf("javascript")<0){//排除含javascript的href
					  var lhref=ohref.replace(/sid=\w*&|[\?&]sid=\w*$/g,"");//暂存原来的href值且去掉带sid的参数
					  var para=window.location.search.substr(1);//获取地址栏中?后面的参数
					  if(lhref.indexOf("?") >=0 ){            //如果原来的href中已经存在参数，则使用&操作符增加一个参数
						  $(this).attr("href",lhref+"&"+para)
					  }else{                                 //若原来的href中不存在参数，则使用?操作符给连接增加一个参数
						  $(this).attr("href",lhref+"?"+para)
					  }
					}
					}
                });
		}else{
			$("a").each(function(){         
                    var ohref = $(this).attr("href");      //暂存原来的href值
					if(ohref!=undefined){
					if(ohref.indexOf("javascript")<0){
					  if(ohref.indexOf("?") >=0 ){            //如果原来的href中已经存在参数，则使用&操作符增加一个参数
					  	  var para=window.location.search.substr(1);
						  $(this).attr("href",ohref+"&"+para)
					  }else{                                 //若原来的href中不存在参数，则使用?操作符给连接增加一个参数
						  var para=window.location.search.substr(0);
						  $(this).attr("href",ohref+para)
					  }
					}
					}
                });
			}
		
});

$(function(){
		//继承参数
		if(sid!=null){
				$("area").each(function(){         //遍历所有超链接标签			
                    var ohref= $(this).attr("href"); 
					if(ohref!=undefined){     
					if(ohref.indexOf("javascript")<0){//排除含javascript的href
					  var lhref=ohref.replace(/sid=\w*&|[\?&]sid=\w*$/g,"");//暂存原来的href值且去掉带sid的参数
					  var para=window.location.search.substr(1);//获取地址栏中?后面的参数
					  if(lhref.indexOf("?") >=0 ){            //如果原来的href中已经存在参数，则使用&操作符增加一个参数
						  $(this).attr("href",lhref+"&"+para)
					  }else{                                 //若原来的href中不存在参数，则使用?操作符给连接增加一个参数
						  $(this).attr("href",lhref+"?"+para)
					  }
					}
					}
                });
		}else{
			$("area").each(function(){         
                    var ohref = $(this).attr("href");      //暂存原来的href值
					if(ohref!=undefined){
					if(ohref.indexOf("javascript")<0){
					  if(ohref.indexOf("?") >=0 ){            //如果原来的href中已经存在参数，则使用&操作符增加一个参数
					  	  var para=window.location.search.substr(1);
						  $(this).attr("href",ohref+"&"+para)
					  }else{                                 //若原来的href中不存在参数，则使用?操作符给连接增加一个参数
						  var para=window.location.search.substr(0);
						  $(this).attr("href",ohref+para)
					  }
					}
					}
                });
			}
		
});


