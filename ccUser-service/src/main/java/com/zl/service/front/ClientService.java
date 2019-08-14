package com.zl.service.front;
/**
 * 客户服务层，用于编写有关客户业务服务的所有接口
 * @author KINDER
 *
 */

import com.zl.pojo.client.Client;

public interface ClientService {
	/**
	 * 客户登录服务
	 */
	public Client clientLogin(Client client);
	
	/**
	 * 客户注册服务接口
	 */
	public int clientRegister(Client client);
}
