package com.zl.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.zl.pojo.client.Client;
import com.zl.service.front.ClientService;
import com.zl.util.MD5Util;

public class Realm extends AuthorizingRealm{
	/**
	 * 执行授权的逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 执行认证的逻辑
	 */
	@Autowired
	private ClientService cs;
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		//编写shiro判断逻辑，判断用户名和密码
		//1.判断用户名
		UsernamePasswordToken token=(UsernamePasswordToken) arg0;
		Client client=new Client();
		client.setClientPhone(new Long( token.getUsername()));
		client= cs.clientLogin(client);
		
		if(client==null) {
			return null;
		}
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("client", client);
		return new SimpleAuthenticationInfo("", client.getPassword(), "");
	}

}
