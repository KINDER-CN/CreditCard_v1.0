package com.zl.service.gu;

import java.util.List;

import com.zl.pojo.client.Client;
/**
 * 账户管理模块
 */
public interface zhanghuguanlimokuaiService {
	/**
	 * 查询所有的用户
	 */
	public List<Client> queryAllClient();
	/**
	 * 模糊查询用户
	 */
	public List<Client> queryClientByLike(String clientIdcard);
	/**
	 * 查询该用户
	 */
	public Client queryClientById(int id);
}
