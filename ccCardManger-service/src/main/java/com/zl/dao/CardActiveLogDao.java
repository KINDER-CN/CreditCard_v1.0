package com.zl.dao;

import com.zl.pojo.business.CardActiveLog;

public interface CardActiveLogDao {
	/**
	 * 用来发送信用卡激活申请(激活记录表)
	 */
	public int activateCreditCard(CardActiveLog cal);
}
