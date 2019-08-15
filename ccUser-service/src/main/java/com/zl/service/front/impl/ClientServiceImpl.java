package com.zl.service.front.impl;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 客户服务层实现类，用于编写有关客户业务服务的所有接口的业务逻辑代码
 * @author KINDER
 *
 */
import org.springframework.stereotype.Service;

import com.zl.dao.front.ClientDao;
import com.zl.pojo.client.Client;
import com.zl.service.front.ClientService;
import com.zl.util.MD5Util;

@Service
public class ClientServiceImpl implements ClientService{
	@Autowired
	private ClientDao cd;
	/**
	 * 登录服务
	 */
	@Override
	public Client clientLogin(Client client) {
		return cd.clientLogin(client);
	}
	/**
	 * 注册服务
	 */
	@Override
	public int clientRegister(Client client) {
		if(client!=null) {
			client.setPassword(MD5Util.MD5(client.getPassword()));
		}
		return cd.clientRegister(client);
	}
	
	
	
}
