package com.zl.service;


import com.zl.pojo.business.ApplyCardPlan;
import com.zl.pojo.manger.CardType;

public interface ApplyCardPlanService {
	/**
	 * 用来显示用户选择的信用卡模板（卡种详细信息，根据卡种id)
	 */
	public CardType selectCardTypeById(int id);
	
	/**
	 * 发送申请信用卡请求（卡片申请进度表记录）
	 */
	public int handleCreditCard(ApplyCardPlan acp);
}
