package com.zl.action.front;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 客户服务控制层
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.zl.pojo.client.Client;
import com.zl.pojo.client.ShowClientCard;
import com.zl.service.front.ClientService;
import com.zl.util.HttpUtils;
import com.zl.util.MD5Util;
import com.zl.util.api.UtilApi;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private ClientService cs;
	/**
	 * 用户登录
	 * @param client
	 * @param session
	 * @return
	 */
	@RequestMapping("/clientLogin")
	@ResponseBody
	public Map<String,Object> login(@RequestBody String clientPhone,HttpSession session){
		Map<String,Object> result=new HashMap<String,Object>();
		//1.获取subject
		clientPhone=clientPhone.substring(0, 11);
		System.out.println(clientPhone);
		Subject subject = SecurityUtils.getSubject();
		Client client=new Client();
		if(clientPhone!=null && !"".equals(clientPhone)) {
			client.setClientPhone(new Long(clientPhone));
		}
		client=cs.clientLogin(client);
		String pswd="";
		if(client!=null) {
			pswd=client.getPassword();
		}
		//2。封装用户数据
		UsernamePasswordToken token= new UsernamePasswordToken(clientPhone,pswd);
		//3.执行登录方法
		try {
			subject.login(token);
			result.put("flag", true);
			//登录成功
		} catch (UnknownAccountException u) {
			result.put("msg", "用户名不存在");
		}catch (IncorrectCredentialsException i) {
			result.put("msg", "密码错误");
		}
				
		/*if(client!=null) {
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
		}*/
		return result;
	}
	
	/**
	 * 注册
	 */
	@RequestMapping("/register")
	@ResponseBody
	public Map<String,Object> register(@RequestBody Client client){
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
	 *修改原手机号 
	 */
	@RequestMapping("/updateClientPhone")
	@ResponseBody
	public Map<String,Object> updatePhone(String oldPhone,String newPhone,HttpSession session){
		
		oldPhone=oldPhone.substring(0,11);
		newPhone=newPhone.substring(0,11);
		System.out.println(oldPhone+"1111111111122222"+newPhone);
		Map<String,Object> result=new HashMap<String,Object>();
		Client client=new Client();
		Client clients=(Client)(session.getAttribute("client"));
		client.setClientPhone(new Long(oldPhone));
		client.setId(clients.getId());
		Client newClient=new Client();
		newClient.setId(clients.getId());
		newClient.setClientPhone(new Long(newPhone));
		System.out.println(client);
		System.out.println(newClient);
		//client.setClientPhone(new Long(oldPhone));
		System.out.println("------------------------------------------------------");
		if(cs.queryClientPhone(client)!=null) {//验证原手机号是否正确
		int line=cs.updateClientPhone(newClient);
			if(line>0) {
				result.put("flag", true);
			}
		}else {
			result.put("flag", false);
			result.put("mess", "修改失败，请检查原手机号是否正确");
		}
		
		return result;
	}
	/**
	 * 查询用户信用卡
	 */
	@RequestMapping("/queryClientCard")
	@ResponseBody
	public  Map<String,Object> queryClientCard(HttpSession session){
		Map<String,Object> result=new HashMap<String,Object>();
			Client client= (Client) session.getAttribute("client");
			System.out.println(client);
			List<ShowClientCard> clientCards=cs.queryClientCard(client.getId());
			//把银行卡号隐藏
			if(clientCards!=null) {
				for(int i=0;i<clientCards.size();i++) {
					int hideLength = 8;
					int startIndex = clientCards.get(i).getCardNum().length()/2-hideLength/2;
					String replaceSymbol = "*";
					 StringBuilder stringBuilder = new StringBuilder();
					 for (int y = 0; y<clientCards.get(i).getCardNum().length();y++){
				            char number = clientCards.get(i).getCardNum().charAt(y);
				            if (y>=startIndex-1&&y<startIndex+hideLength){
				                stringBuilder.append(replaceSymbol);
				            }else {
				                stringBuilder.append(number);
				            }
				        }
					 clientCards.get(i).setCardNum(stringBuilder.toString());
			}
		}
			result.put("clientName", client.getClientName());
			result.put("cards", clientCards);
			result.put("flag", true);
			return result;
	}
	/**
	 * 修改密码
	 */
	@RequestMapping("/updatePsd")
	@ResponseBody
	public Map<String,Object> updatePsd(String oldpsd,String newpsd,HttpSession session){
		oldpsd = oldpsd.substring(0,oldpsd.length());
			newpsd = newpsd.substring(0,newpsd.length());
		Map<String,Object> result=new HashMap<String,Object>();
		//创建一个新对象
		System.out.println(oldpsd+""+newpsd);
		Client client=new Client();
		Client clients=(Client) session.getAttribute("client");
		client.setPassword(MD5Util.MD5(oldpsd));
		client.setId(clients.getId());
		if(cs.queryClientByPsdAndId(client)!=null) {//判断原密码是否正确
			client.setPassword(MD5Util.MD5(newpsd));
			if(cs.updatePassword(client)>=1) {
				result.put("flag", true);
			}else {
				result.put("flag", false);
				result.put("mess", "修改失败");
			}
		}else {
			result.put("flag", false);
			result.put("mess", "原密码错误");
		}
		return result;
		
	}
	/**
	 * 调用图形验证码接口
	 */
	@Autowired
	private UtilApi uapi;
	@RequestMapping("/pic")
	@ResponseBody
	public Map<String,Object> pic(HttpResponse response){
		Map<String,Object> result=new HashMap<String,Object>();
		JSONObject data=JSONObject.parseObject(uapi.pic());
		result.put("data", data);
		    return result;
	}
	/**
	 * 身份证验证控制器
	 * @param name
	 * @param IDcard
	 * @return
	 */
	@RequestMapping("/idcard")
	@ResponseBody
	public Map<String,Object> idcard( String name, String IDcard){
		System.out.println(name+IDcard);
		Map<String,Object> result=new HashMap<String,Object>();
		JSONObject data=JSONObject.parseObject(uapi.IDcard(name, IDcard));
		System.out.println(data);
		result.put("data", data);
		return result;
	}
	/**
	 * 短信验证
	 */
	@RequestMapping("/checkphone")
	@ResponseBody
	public Map<String,Object> checkphone(@RequestBody String clientPhone){
			clientPhone=clientPhone.substring(0, 11);
			System.out.println(clientPhone);
		Map<String,Object> result=new HashMap<String,Object>();
		  String host = "https://cdcxdxjk.market.alicloudapi.com";
		    String path = "/chuangxin/dxjk";
		    String method = "POST";
		    String appcode = "114ebcc944d14b46a379799052c7e08e";
		    Map<String, String> headers = new HashMap<String, String>();
		    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
		    headers.put("Authorization", "APPCODE " + appcode);
		    Map<String, String> querys = new HashMap<String, String>();
		    Random rm = new Random();
		    int strLength = 6;
		    double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
		    String fixLenthString = String.valueOf(pross);
		    String a=fixLenthString.substring(1, strLength + 1);
		    querys.put("content", "【创信】你的验证码是："+a+"，3分钟内有效！");
	            //测试可用短信模板：【创信】你的验证码是：#code#，3分钟内有效！，如需自定义短信内容或改动任意字符，请联系旺旺或QQ：726980650进行申请。
		    querys.put("mobile", clientPhone);
		    Map<String, String> bodys = new HashMap<String, String>();
		    System.out.println(a);
		    JSONObject data = null;
		    try {
		    	/**
		    	* 重要提示如下:
		    	* HttpUtils请从
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
		    	* 下载
		    	*
		    	* 相应的依赖请参照
		    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
		    	*/
		    	HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
		    	//System.out.println(EntityUtils.toString(response.getEntity()));
		    	data=JSONObject.parseObject(EntityUtils.toString(response.getEntity()));
		    	//获取response的body
		    	//System.out.println(EntityUtils.toString(response.getEntity()));
		    	result.put("flag", true);
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		    	result.put("scode", a);
		    	result.put("data", data);
		return result;
	}
}
