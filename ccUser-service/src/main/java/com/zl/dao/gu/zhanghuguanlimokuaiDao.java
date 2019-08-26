package com.zl.dao.gu;

import java.util.List;

import com.zl.pojo.client.Client;
import com.zl.pojo.htfenye.FenYe;
import com.zl.pojo.manger.CardType;
/**
 * 账户管理模块
 */
public interface zhanghuguanlimokuaiDao {
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
	/**
	 * 分页
	 */
	public List<Client> fenYeClient(FenYe fenYe);
	/**
	 * 分页总数
	 */
	public int fenYeAllClient(FenYe fenYe);
}
