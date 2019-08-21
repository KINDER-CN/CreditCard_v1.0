package com.zl.service.front;

import com.zl.pojo.business.CreditCard;
import com.zl.pojo.business.CreditCardModel;

public interface CreditCardService {
	/**
	 * 修改信用卡绑定系统的状态
	 */
	public int updateCreditCardOnBinding(CreditCard creditCard);
	
	/**
	 * 增加绑定的信用卡
	 */
	public int addCreditCard(CreditCardModel creditCardModel);
	
	/**
	 * 判断信用卡是不是本行信用卡
	 */
	public CreditCardModel queryBankCardByNum(CreditCard creditCard);
	
	/**
	 * 校验手机号
	 */
	public CreditCard queryCardPhone(CreditCard creditCard);
	/**
	 * 查找用户信用卡byId
	 */
	public CreditCard queryCardByid(int id);
}
