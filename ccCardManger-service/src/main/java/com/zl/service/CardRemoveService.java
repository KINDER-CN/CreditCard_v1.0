package com.zl.service;

import com.zl.pojo.business.CardRemove;

public interface CardRemoveService {
	/**
	 * 用来发送注销信用卡申请(销卡记录表)
	 */
	public int cancelCreditCard(CardRemove cr);
}
