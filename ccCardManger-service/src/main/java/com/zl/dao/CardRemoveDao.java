package com.zl.dao;

import com.zl.pojo.business.CardRemove;

public interface CardRemoveDao {
	/**
	 * 用来发送注销信用卡申请(销卡记录表)
	 */
	public int cancelCreditCard(CardRemove cr);
}
