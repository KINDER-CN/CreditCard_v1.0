package com.zl.dao.front;

import com.zl.pojo.business.CreditCard;
import com.zl.pojo.business.CreditCardModel;

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
	public int addCreditCard(CreditCardModel creditCardModel);
	
	/**
	 * 判断信用卡是不是本行信用卡
	 */
	public CreditCardModel queryBankCardByNum(CreditCard creditCard);
	
	/**
	 * 校验手机号是否正确
	 */
	public CreditCard quertCardPhone(CreditCard creditCard);
	/**
	 * 查找信用卡by信用卡id
	 */
	public CreditCard queryCardByid (int id);
}
