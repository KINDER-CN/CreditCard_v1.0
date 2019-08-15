package com.zl.action.front;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 客户服务控制层
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.client.Client;
import com.zl.service.front.ClientService;
import com.zl.util.HttpUtils;
import com.zl.util.MD5Util;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService cs;
	@RequestMapping("/clientLogin")
	@ResponseBody
	public Map<String,Object> login(Client client,HttpSession session){
		client.setClientName("张三");
		client.setPassword("123456");
		System.out.println(client);
		Map<String,Object> result=new HashMap<String,Object>();
		if(client!=null) {
			client.setPassword(MD5Util.MD5(client.getPassword()));
			System.out.println(client);
			client=cs.clientLogin(client);
			System.out.println(client);
			if(client!=null) {
				session.setAttribute("client", client);
				result.put("client", client);
				result.put("flag", true);
			}else {
				result.put("flag", false);
			}
		}
		return result;
	}
	
	/**
	 * 注册
	 */
	@RequestMapping("/register")
	@ResponseBody
	public Map<String,Object> register(Client client){
		client.setClientPhone(15521227282l);
		client.setPassword("123456");
		Map<String,Object> result=new HashMap<String,Object>();
		if(client!=null) {
			int line = cs.clientRegister(client);
			if(line>0) {
				result.put("flag", true);
				return result;
			}
		}
		result.put("flag", false);
		return result;
	}
	/**
	 * 调用图形验证码接口
	 */
	@RequestMapping("/pic")
	@ResponseBody
	public Map<String,Object> pic(HttpResponse response){
		Map<String,Object> result=new HashMap<String,Object>();
		 String host = "https://captcha.market.alicloudapi.com";
		    String path = "/create";
		    String method = "GET";
		    String appcode = "114ebcc944d14b46a379799052c7e08e";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    Map<String, String> querys = new HashMap<String, String>();
		    
		    try {
				response = HttpUtils.doGet(host, path, method, headers, querys);
				result.put("data", EntityUtils.toString(response.getEntity()));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		    return result;
	}
}
