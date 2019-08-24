package com.zl.service;

import java.util.List;

import com.zl.pojo.business.CreditCard;
import com.zl.pojo.manger.CardType;

public interface CreditCardService {
	/**
	 * 根据条件查询该用户所有的信用卡
	 */
	public List<CreditCard> selectAllCreditCard(int clientId);
	
	/**
	 * 根据id查询用户信用卡
	 */
	public CreditCard selectCreditCardById(int id);
	
	/**
	 * 修改信用卡的状态（激活，挂失，解挂）
	 */
	public int updateCreditCardState(CreditCard cc);
	
	/**
	 * 修改用户信用卡的交易密码
	 */
	public int updateCreditCardPassword(CreditCard cc);
	
	/**
	 * 设置用户信用卡的交易密码
	 */
	public int setCreditCardPassword(CreditCard cc);
	
	/**
	 * 查询所有卡种
	 */
	public List<CardType> selectAllCardType();
}
