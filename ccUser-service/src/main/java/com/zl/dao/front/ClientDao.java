package com.zl.dao.front;

import java.util.List;

import com.zl.pojo.business.Bill;
import com.zl.pojo.client.Client;
import com.zl.pojo.client.ShowClientCard;

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
	/**
	 * 查找用户卡片信息
	 */
	public List<ShowClientCard> queryClientCard(int clientId);
	/**
	 * 根据信用卡id查找账单
	 */
	public ShowClientCard queryBillByCardId(int cardId);
	/**
	 * 查找原密码是否正确
	 */
	public Client queryClientByPsdAndId(Client client);
	/**
	 * 修改密码
	 */
	public int updatePassword(Client client);
	/**
	 * 根据绑定的信用卡信息，修改用户信息
	 */
	public int updateClient(Client client);
}
