package com.zl.dao.front;

import com.zl.pojo.client.Client;

/**
 * 客户表实体类DAO层
 * @author KINDER
 *
 */

public interface ClientDao {
	/**
	 * 客户登录
	 */
	public Client clientLogin(Client client);
	
	/**
	 * 客户注册
	 */
	public int clientRegister(Client client);
	
	
}
