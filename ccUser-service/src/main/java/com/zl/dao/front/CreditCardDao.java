package com.zl.dao.front;

import com.zl.pojo.business.CreditCard;

/**
 * 信用卡Dao层
 * @author KINDER
 *
 */
public interface CreditCardDao {
	/**
	 * 修改信用卡绑定系统的状态
	 */
	public int updateCreditCardOnBinding(CreditCard creditCard);
	
	/**
	 * 增加绑定的信用卡
	 */
	public int addCreditCard(CreditCard creditCard);
	
	/**
	 * 判断信用卡是不是本行信用卡
	 */
	public CreditCardDao queryBankCardByNum(CreditCard creditCard);
	
}
