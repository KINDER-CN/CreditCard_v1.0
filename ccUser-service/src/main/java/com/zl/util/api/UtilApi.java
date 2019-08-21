package com.zl.util.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.JSONObject;
import com.zl.util.HttpUtils;

@Service
public class UtilApi {
	/**
	 * 图形验证码
	 */
	public String pic() {
		 String host = "https://captcha.market.alicloudapi.com";
		    String path = "/create";
		    String method = "GET";
		    String appcode = "114ebcc944d14b46a379799052c7e08e";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    Map<String, String> querys = new HashMap<String, String>();
		    HttpResponse response ;
		    String src=null;
		    try {
		    	response = HttpUtils.doGet(host, path, method, headers, querys);
				//JSONObject data=JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
		    	src=EntityUtils.toString(response.getEntity());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return src;
		
	}
	/**
	 * 身份证验证
	 */
	public String IDcard(String name,String IDcard) {
		 HttpResponse response ;
		 String src=null;
		 String host = "https://checkid.market.alicloudapi.com";
		    String path = "/IDCard";
		    String method = "GET";
		    String appcode = "114ebcc944d14b46a379799052c7e08e";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    Map<String, String> querys = new HashMap<String, String>();
		    querys.put("idCard", IDcard);
		    querys.put("name", name);
		    try {
				response = HttpUtils.doGet(host, path, method, headers, querys);
				src=EntityUtils.toString(response.getEntity());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return src;
	}
}
