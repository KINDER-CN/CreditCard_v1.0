package com.zl.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;


public class ShiroConfiguration {
	 /**
	  * 创建ShiroFilterFactoryBean
	  */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
		
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
		
		//添加shiro内置过滤器
		/**
		 * Shiro内置过滤器，可以实现权限相关的拦截
		 * 		常用的过滤器：
		 * 			anon:无需认证（登录）可以访问
		 * 			authc:必须认证才可以访问
		 * 			user:如果使用rememberMe的功能可以直接访问
		 * 			perms:该资源必须得到资源权限才可以访问
		 * 			role:该资源必须得到角色权限才可以访问
		 */
		Map<String,String>filterMap =new LinkedHashMap<String,String>();
		//filterMap.put("/login", "anon");
		//filterMap.put("/*", "authc");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		shiroFilterFactoryBean.setLoginUrl("/login.html");
		return shiroFilterFactoryBean;	
	}
	
	/**
	 * 创建DefaultWebSecurityManager
	 */
	@Bean(name="defaultWebSecurityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("realm") Realm Realm) {
		
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		/**
		 * 关联realm
		 */
		securityManager.setRealm(Realm);
		return securityManager;
	}
	
	/**
	 * 创建Realm对象
	 */
	@Bean(name="realm")
	public Realm getRealm() {
		
		return new Realm();
	}
}
