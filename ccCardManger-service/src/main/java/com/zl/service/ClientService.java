package com.zl.service;

import com.zl.pojo.client.Client;

public interface ClientService {
	/**
	 * 根据用户id查询用户
	 */
	public Client selectClientById(int id);
	/**
	 * 修改用户表里面的信息
	 */
	public int updateClientInfo(Client client);
}
