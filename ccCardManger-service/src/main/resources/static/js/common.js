﻿/**
 * To register a namespace
 * @author liuql;
 */
var ucNameSpace =ucNameSpace||{};
(function(){
	var global = window;
	ucNameSpace.register = function(nsStr){
		roots = global;
		var parts = nsStr.split(".");
		for(var i=0;i<parts.length;i++){
			if(typeof roots[parts[i]] === "undefined"){
				roots[parts[i]] = {};
			}
			roots = roots[parts[i]];
		}
		return roots;
	};
})()
 
function init(){
    var wh = $(window).height(),headerH = $("div.header").height(),footerH = $("div.footer").height();
    var cH =$("div.content_bg>.wrap").height();
    if((cH+130) <(wh - headerH - footerH - 50 - 75)){
        $("div.content_bg").height(wh - headerH - footerH -50 - 75);
    }   
}

$(document).ready(function(){
    init();
    $(window).resize(function(){
        init();
    });
//    $("input[name='phone']").bind("keypress",function(e){//手机号码验证输入限制
//        var e = e || window.event;//window.event for IE // arguments.callee.caller.arguments[0] for firefox
//        var k = e.keyCode || e.which;
//        return (/[\d.]/.test(String.fromCharCode(k)));
//    });
    $("input").focus(function(){
    	if($(this).attr("type") != "button"){
    		$(this).css("color","#545454");
    	}
    });
    $("input").blur(function(){
    	if($(this).attr("type") != "button"){
    		if($(this).val() == $(this).attr("placeholder") || $(this).val() == ''){
    			$(this).css("color","#d8d8d8");
    		}
    	}
    });
});
//消除空格
function trim(str){
  return ltrim(rtrim(str));
}

function ltrim(str){
  var sRet="";
  regular = /\s*(\S*)/; 
  sRet=str.replace(regular, "$1");
  return sRet;
}

function rtrim(str){
  var sRet="";
  regular = /(\S*)\s*$/; 
  sRet=str.replace(regular, "$1");
  return sRet;
}

// 全部选中/不选中
function SetCheckBoxAllChecked(CheckBoxName, IsChecked)
{
    var item = document.getElementsByName(CheckBoxName);
    if (null == item)
        return;

    for (var i = 0; i < item.length; i++)
        item[i].checked = IsChecked;
}

// 获得选中的checkbox的value
function GetCheckBoxCheckedValue(CheckBoxName)
{
    var arrIndex = new Array();
    var item = document.getElementsByName(CheckBoxName);
    if (null == item)
        return arrIndex;

    for (var i = 0; i < item.length; i++)
    {
        if (item[i].checked)
        {
            arrIndex[arrIndex.length] = item[i].value + "&0";
        }
        else
        {
            arrIndex[arrIndex.length] = item[i].value + "&1";
        }
    }
    return arrIndex;
}

// 获得选中的值
function GetSelectedValue(SelectID) {
	var item = document.getElementById(SelectID);
	if ((null == item) || (item.selectedIndex < 0))
		return "";

	return item.options[item.selectedIndex].value.trim();
}

// 获得选中的内容
function GetSelectedText(SelectID) {
	var item = document.getElementById(SelectID);
	if ((null == item) || (item.selectedIndex < 0))
		return "";

	var Text = item.options[item.selectedIndex].text.trim();
	var Value = GetSelectedValue(SelectID) + "-";
	var Index = Text.indexOf(Value);

	return Text.substring(Index);
}

//格式化卡号
function formatCardno(cardno)
{
	var f_cardno = "";
	if(cardno.length>10)
	{
		f_cardno = cardno.substring(0,4) + "********" + cardno.substring(cardno.length-4);
	}
	return f_cardno;
}

//判断字符串是否为数字
function check_nan(str){
		
	var patrn=/^\d*$/; //JS中关于数字的正则
	var flag = patrn.test(str);
	return flag;		
}
	
//判断字符串是否为数字
function check_xiaoshu(str){
	str = str.replace(".","");
	var patrn=/^\d*$/; //JS中关于数字的正则
	var flag = patrn.test(str);
	return flag;		
}
	
//判断字符串长度
function charLength(str)
{
	var i,sum;
	sum=0;
    for(i=0;i<str.length;i++)
    {
         if ((str.charCodeAt(i)>=0) && (str.charCodeAt(i)<=255))
             sum=sum+1;
         else
             sum=sum+2;
    }
    return sum;
}

function repalceEnter(str)
{
    if(str==null || str==""){
       return "";
    }
    str = str.replace("&", " ");
	str = str.replace("<"," ");
	str = str.replace(">"," ");
	str = str.replace("\""," ");
	str = str.replace("\'"," ");
	return str;
}
	 
	 
//过滤特殊字符
function repalceTS(s)
{
    if(s==null || s==""){
       return "";
    }
    var re = new RegExp("(=|&|<|>|%|\'|\"|#|\")","g");     
    var r = s.replace(re, "");    
    return r;  
}

function select_curr(txt_obj, cls)
 {
   // hidMsg(arrdiv);
    txt_obj.className=cls;
 }

//取字符串字节长度（处理中文特殊情况）obj 为字符串
function lenX(obj){
    theLen = 0;
    for( i = 0; i < obj.length; i++)  {       
       if (obj.charCodeAt(i) > 255 ){  
          theLen=theLen + 2;
       }else{
          theLen=theLen + 1;
       }    
    }
    return theLen;	
}

//判断字符串字节长度是否超过定长（处理中文特殊情况）
//true 超过定长，false不超过定长
function overLength(obj,leng){    
   if(lenX(obj)> leng){
      return true	
   }
   return false;
}

/**
* 检查字符串是否为合法email地址
* @param {String} 字符串
* @return {bool} 是否为合法email地址
*/
function isEmail(aEmail) {
	var bValidate = RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(aEmail);
	if ( bValidate ){
		return true;
	}else{
		return false;
	}
}

//检查字符串是否为合法的用户名
function isHfUserNameOne(obj){
	//用户名必须以字母开头,由字母和数字组成
	var bValidate = RegExp(/^[a-zA-Z\u4E00-\u9FA5]{1}[0-9a-zA-Z\u4E00-\u9FA5]{1,}$/).test(obj);
	//字母、数字、或汉字
	//var bValidate = RegExp(/^[0-9a-zA-Z\u4E00-\u9FA5]*$/).test(obj);
	if(bValidate){
		return true;
	}
	else{
		return false;
	}
}

function checkCertNo(obj_text){
  	re=/^[\w|(|)|\-|_|\[|\]]*$/g;
	return re.test(obj_text);
}

function verifyCertNo(code){
	//return 0;
	if(code==null || code==""){
		//obj_text.select();
		//obj_text.focus();
		return -1;
	}
	if(code.length!=15 && code.length!=18){		
		//obj_text.select();
		//obj_text.focus();
		return -2;
	}
	
	if(code.length==15){
		rae=/^[0-9]*$/g;	
		if(!rae.test(code)){			   
			return -3;	
		}
		return 1;
	}	
	
	var sum=0;
	var temp = code.substring(0, 17);
	sum = parseInt(temp.substring(0, 1)) * 7;
	sum = sum + parseInt(temp.substring(1, 2)) * 9;
	sum = sum + parseInt(temp.substring(2, 3)) * 10;
	sum = sum + parseInt(temp.substring(3, 4)) * 5;
	sum = sum + parseInt(temp.substring(4, 5)) * 8;
	sum = sum + parseInt(temp.substring(5, 6)) * 4;
	sum = sum + parseInt(temp.substring(6, 7)) * 2;
	sum = sum + parseInt(temp.substring(7, 8)) * 1;
	sum = sum + parseInt(temp.substring(8, 9)) * 6;
	sum = sum + parseInt(temp.substring(9, 10)) * 3;
	sum = sum + parseInt(temp.substring(10, 11)) * 7;
	sum = sum + parseInt(temp.substring(11, 12)) * 9;
	sum = sum + parseInt(temp.substring(12, 13)) * 10;
	sum = sum + parseInt(temp.substring(13, 14)) * 5;
	sum = sum + parseInt(temp.substring(14, 15)) * 8;
	sum = sum + parseInt(temp.substring(15, 16)) * 4;
	sum = sum + parseInt(temp.substring(16, 17)) * 2;
	var checkvalue = 12 - sum % 11;
	var check_code;
	if (checkvalue==10)
		check_code = "X";
	else if (checkvalue==11)
		check_code = "0";
    	else if (checkvalue==12)
		check_code = "1";
	else 
		check_code=checkvalue;
	if (code.substring(17).toUpperCase()!=check_code){
		//obj_text.select();
		//obj_text.focus();
		return -3;
	}
	return 0;
}

//读秒后关闭
function show_time(id,s,path){
	//var bb = document.getElementById(id);
	if(s!=0){
		s=s-1; 
		//var time = "当前页面将在"+s+"秒后关闭";
		//bb.innerHTML = time;
		setTimeout('show_time("'+id+'","'+s+'","'+path+'")',1000);
	}
	else{
	   location.href=path;
	}
}

//加载图片验证码
function loadimageNew() {
	var time = new Date().getTime();	
	var imgd = "<img id='randImage' src='valicode.do?time="+time+"' width='72' height='30' border='1' align='absmiddle'>";
	var ddd = "<a href='javascript:loadimageNew();'><font size='1' >换一张</font></a>";
	document.getElementById("pic").innerHTML = imgd+ "&nbsp;" + ddd;
}

//加载图片验证码
function loadimageNew2() {
	var time = new Date().getTime();	
	var imgd = "<img id='randImage2' src='valicode.do?time="+time+"' width='72' height='30' border='1' align='absmiddle'>";
	var ddd = "<a href='javascript:loadimageNew2();'><font size='1' >换一张</font></a>";
	document.getElementById("pic2").innerHTML = imgd + "&nbsp;" + ddd;
}

/**
注册
找回密码
重置电话服务密码
绑定注册会员
*/
function loadimageNew3(type) {
	var time = new Date().getTime();
	var imgd = "<img id='randImage' style='vertical-align:middle;' src='valicode.do?time="+time+"&type="+type+"' width='72' height='30'>";
	//var src='jsp/valicode.jsp?time='+time;
	//document.getElementById("randImage").src =src;
	document.getElementById("pic").innerHTML = "&nbsp;" + imgd
}


//格式化手机号码
function formatMobileNo(mobileno){
	var f_mobileno = "";
	if(mobileno.length>10)
	{
		f_mobileno = mobileno.substring(0,3) + "*****" + mobileno.substring(mobileno.length-3,mobileno.length);
	}
	return f_mobileno;
}

//改变文本框值
function change_input(txt_obj) {
	txt_obj.className = 'input_01';
	txt_obj.value = '';
}

//提交弹出阻塞
function submitBlockUI(){
	$("#chuli").show();
	$.blockUI({
		message: '',
		overlayCSS:{
			backgroundColor: '#fff', 
        	opacity:'0.0'
		}
	});
}

//提交弹出阻塞
function submitBlockUIByBindZchy(chuliId){
	if(chuliId=="chuli0"){
		$("#chuli0").show();
	}
	else{
		$("#chuli1").show();
	}
	$.blockUI({
		message: '',
		overlayCSS:{
			backgroundColor: '#fff', 
        	opacity:'0.0'
		}
	});
}

//错误对话框
function errorBlockUI(title,msg_str){
	var div_str = "<div class='main_alert' id='errorAlert'>";
	div_str+= "<div class='point_div'>";
	div_str+= "<h2>"+ title +"</h2>";
	div_str+= "</div>";
	div_str+= "<div class='return_info2'>";
	div_str+= "<p class='p_err' style='width:400px;'>"+msg_str+"</p>";
	div_str+= "</div>";
	div_str+= "<div class='return_btn_div2'><a class='return_btn' href='javascript:void(0)' onclick='javascript:closeBlockUI();'>返回</a></div>";
	div_str+= "</div>";
	$.blockUI({
		message: div_str,
		css:{
			top:($(window).height() - 250)/2 + 'px',
			left:($(window).width() - 500)/2 + 'px',
			width:"501px"
		}
	});
}

//成功对话框
function successBlockUI(title,msg_str){
	var div_str = "<div class='main_alert' id='errorAlert'>";
	div_str+= "<div class='point_div'>";
	div_str+= "<h2>"+ title +"</h2>";
	div_str+= "</div>";
	div_str+= "<div class='return_info2'>";
	div_str+= "<p class='p_succ' style='width:200px;'>"+msg_str+"</p>";
	div_str+= "</div>";
	div_str+= "<div class='return_btn_div2'><a class='return_btn' href='javascript:void(0)' onclick='javascript:closeBlockUI();'>返回</a></div>";
	div_str+= "</div>";
	$.blockUI({
		message: div_str,
		css:{
			top:($(window).height() - 250)/2 + 'px',
			left:($(window).width() - 450)/2 + 'px',
			width:"451px"
		}
	});
}

function closeBlockUI(){
	$.unblockUI();
}

//验证手机号码
function isMobile(aMobile){
	var bValidate = RegExp(/^0?(1)[0-9]{10}$/).test(aMobile);
	if ( bValidate ){
		return true;
	}else{
		return false;
	}
}

//转换密码文字框
function changePhoneSecretcode(type,txId,pwdId,text){
	var tx_input = document.getElementById(txId);
    var pwd_input = document.getElementById(pwdId);
    
    if("tx_input"==type)
    {
    	tx_input.style.display = "none";
    	pwd_input.style.display = "";
        pwd_input.value = "";
        pwd_input.focus();
    }
    if("pwd_input"==type){
    	if(pwd_input.value != "") return;
    	pwd_input.style.display = "none";
    	tx_input.style.display = "";
       	tx_input.value = text;
    }
}

//转换用户名文字框
function changeCppaccountInput(type,txId,cppaccountId,text){
	var tx_input = document.getElementById(txId);
	var ca_input = document.getElementById(cppaccountId);
	
	if("0"==type){
		tx_input.style.display = "none";
    	ca_input.style.display = "";
        ca_input.value = "";
        ca_input.focus();
	}
	if("1"==type){
		if(ca_input.value != "") return;
    	ca_input.style.display = "none";
    	tx_input.style.display = "";
       	tx_input.value = text;
	}
}

function AccountKeyPress ( obj,len){
		key = event.keyCode;
		if ( key >= 0x30 && key <= 0x39 && obj.value.length < len ){
			return true;
		}
		else{
			event.keyCode = 0;
		}
}

//tab选项卡	
function selectTag(showContent,selfObj){
	var tag = document.getElementById("login_tab").getElementsByTagName("a");
	var taglength = tag.length;
	for(i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.className = "on";
	// 操作内容
	for(i=0; j=document.getElementById("a_c_con"+i); i++){
		j.style.display = "none";
	}
	document.getElementById(showContent).style.display = "block";	
}

/*tab菜单*/
function setTab(m,n){
 var tli=document.getElementById("menu"+m).getElementsByTagName("li");/*获取选项卡的LI对象*/
 var mli=document.getElementById("main"+m).getElementsByTagName("ul");/*获取主显示区域对象*/
 for(i=0;i<tli.length;i++){
  tli[i].className=i==n?"hover":""; /*更改选项卡的LI对象的样式，如果是选定的项则使用.hover样式*/
  mli[i].style.display=i==n?"block":"none";/*确定主区域显示哪一个对象*/
 }
}

function set_showdiv(did, type)
{
     if(type==1){
        document.getElementById(did).style.display="";
     }else{
        document.getElementById(did).style.display="none";
     }
}

//转换证件类型值
function changeIdTypeValue(value){
	var retValue = "1";
	if(value=="居民身份证"){
		retValue = "1";
	}else if(value=="护照"){
		retValue = "3";
	}else if(value=="军官证"){
		retValue = "4";
	}else if(value=="其它"){
		retValue = "5";
	}else if(value=="香港居民来往内地通行证"){
		retValue = "7";
	}else if(value=="澳门居民来往内地通行证"){
		retValue = "8";
	}else if(value=="台湾居民来往大陆通行证"){
		retValue = "9";
	}
	return retValue;
}

//转换Xml请求报文
function changeXml(data){
	var xml = "";
	if(window.ActiveXObject){
       //url = url+"&dom="+data.xml;
      // xml = data.xml;
      return data;
    }
    else{
       var osr = new XMLSerializer();
       //url = url+"&dom="+osr.serializeToString(data);
       xml = osr.serializeToString(data);
       return xml;
    }
}



/**
* 封装装载XML的方法，并返回XML文档的根元素节点
* @param flag true时参数xml表示xml文档的名称 false时参数xml是一个字符串，其内容是一个xml文档
* @param xml 根据flag参数的不同表示xml文档的名称或一个xml文档的字符串表示
*/
function loadXML(flag,xml){
	var xmlDoc;
	//针对IE浏览器
	if(window.ActiveXObject){
		var aVersions = ["MSXML2.DOMDOCUMENT","Microsoft.XmlDom"];
		for(var i=0;i<aVersions.length;i++){
			try{
				//建立xml对象
				xmlDoc = new ActiveXObject(aVersions[i]);
				break;
			}
			catch(oError)
			{
				
			}
		}
		
		if(xmlDoc!=null){
			//同步方式加载XML数据
			xmlDoc.async = false;
			if(flag==true){
				xmlDoc.load(xml);
			}
			else{
				//根据表示XML文档的字符串装载
				xmlDoc.loadXML(xml);
			}
			//返回XML文档的根元素节点
			return xmlDoc.documentElement;
		}
	}
	else {
		//针对非IE浏览器
		if(document.implementation && document.implementation.createDocument){
			//第一个参数表示XML文档使用的namespace的URL地址
			//第二个参数表示要被建立的XML文档的根节点名称
			//第三个参数是一个DOCTYPE类型对象，表示的是要建立的XML文档中DOCTYPE部分的定义，通常我们直接使用null
			//这里我们要装载一个已有的XML文档，所以首先建立一个空文档，因此使用下面的方式
			xmlDoc = document.implementation.createDocument("","",null);
			if(xmlDoc!=null){
				//根据XML文档名称装载
				if(flag==true){
					//同步方式加载XML数据
					xmlDoc.async = false;
					xmlDoc.load(xml);
				}
				else
				{
					//根据表示XML文档的字符串装载
					var oParser = new DOMParser();
					xmlDoc = oParser.parseFromString(xml,"text/xml");
				}
				//返回XML文档的根元素节点
				return xmlDoc.documentElement;
			}
		}
	}
	return null;
}

function getMsgXML(){
	var xmlDoc;
    if(window.ActiveXObject){
	    xmlDoc  = new ActiveXObject("MSXML2.DOMDOCUMENT");
	    xmlDoc.async = false;
	    xmlDoc.loadXML("<request></request>");
	}else{
	    var oParser = new DOMParser();
	    xmlDoc = oParser.parseFromString("<request></request>" , "text/xml");
	    xmlDoc.async = false;
	}
	return xmlDoc;	
}
function mmVerification(mm){
	if(!isNaN(mm) || mm.length > 15 
			|| mm.length < 6 
			|| mm.match(/[^A-Za-z0-9_]/ig) 
			|| !mm.match(/[A-Za-z]/) 
			|| !mm.match(/[0-9]/)){
		return false;
	}
	return true;
}

function mmLevel(mm){
	var lv = 0;
	var msg = "密码等级:";
	if(mm.length < 6){
		lv = 0;
	}
	else{
		if(mm.match(/[a-z]/)){
			lv = lv + 1;
		}
		if(mm.match(/[A-Z]/)){
			lv = lv + 1;
		}
		if(mm.match(/[0-9]/)){
			lv = lv + 1;
		}
		if(mm.length >= 8){
			lv = lv + 1;
		}
		if(!mmVerification(mm)){
			lv = 0;
		}
	}
	if(mm.match(/[^A-Za-z0-9]/ig)){
		lv = -1;
	}
	switch(lv){
	case 0:
		return "请输入6-15为英文和数字密码(含大小写)";
	case 1,2:
		return msg+"弱";
	case 3:
		return msg+"中";
	case 4:
		return msg+"强";
	case -1:
		return "<i></i>密码不能含有除英文或数字外的字符";
	default:
		return "请输入6-15为英文和数字密码(含大小写)";
	}
}

function timeOut(result){
	if(result.resultCode == "1111110"){
		alert("登录超时")
		location.replace("entry.do");
		return true;
	}
}

//在线客服
var icsWnd = null;
function fLogon() {
	var nWinLeft = (screen.width - 600) / 2;
	var nWinTop = (screen.height - 500) / 2;
	var onlineUrl = null;
	// 判断是否手机访问
	var userAgentInfo = navigator.userAgent;
	var Agents = [ "Android", "iPhone", "SymbianOS", "Windows Phone", "iPad",
			"iPod" ];
	var isPC = true;
	for (var v = 0; v < Agents.length; v++) {
		if (userAgentInfo.indexOf(Agents[v]) > 0) {
			isPC = false;
			break;
		}
	}
//	if (isPC == true) {
		//onlineUrl = 'https://im.bank.ecitic.com/cardsim/cardsim.do?entryId=36';
		onlineUrl = 'https://im.bank.ecitic.com/credit/navigation.html?channel=712021';
//	}
//	if (isPC == false) {
//		onlineUrl = 'https://im.bank.ecitic.com/cardsimHtml5/login.html?entryId=28';
//	}
	if (icsWnd != null && !icsWnd.closed) {
		icsWnd.focus();
	} else {
		icsWnd = window.open(onlineUrl);
		icsWnd.focus();
	}
}

function redirSetting(){
	$.get("toSetting.do",function(response){
 	 	var code = response.resultCode;
 	 	var desc = response.resultDesc;
 	 	if(code=="0000000"){
 	 		location.replace(desc);
 	 	}
 	 	else{
 	 		location.replace("entry.do");
 	 	}
 	 });
}
function cacheIdentity(data){
	var protocol = location.protocol;
	var secure = false;
	var d = window.location.hostname;
	var identity = data.identity;
	if(protocol == "https:")
		secure = true;
	if(window.localStorage){
		if(identity != "" && identity != undefined && identity != "undefined" )
			localStorage.setItem("ucweb_cached_identity",identity);
	}
	else{
		if(d.indexOf("creditcard.ecitic.com") != -1)
			d = ".creditcard.ecitic.com";
		if(identity != "" && identity != undefined && identity != "undefined" )
			$.cookie('ucweb_cached_identity',identity,{expires:365,path:"/",domain:d,secure:secure});
	}
}
