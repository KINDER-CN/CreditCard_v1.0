package com.zl.service.front;
/**
 * 客户服务层，用于编写有关客户业务服务的所有接口
 * @author KINDER
 *
 */

import java.util.List;

import com.zl.pojo.client.Client;
import com.zl.pojo.client.ShowClientCard;

public interface ClientService {
	/**
	 * 客户登录服务
	 */
	public Client clientLogin(Client client);
	
	/**
	 * 客户注册服务接口
	 */
	public int clientRegister(Client client);
	
	/**
	 * 修改手机号
	 */
	public int updateClientPhone(Client client);
	
	/**
	 * 判断原手机号是否正确
	 */
	public Client queryClientPhone(Client client);
	/**
	 * 查找用户信用卡
	 */
	public List<ShowClientCard> queryClientCard(int clientId);
	/**
	 * 检验原密码是否正确
	 */
	public Client queryClientByPsdAndId(Client client);
	/**
	 * 修改密码
	 */
	public int updatePassword(Client client);
}
