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
	
	/**
	 * 修改绑定的手机号码
	 */
	public int updateClientPhone(Client client);
	
	/**
	 * 判断原手机号是否正确
	 */
	public Client queryClientPhone(Client client);
}
