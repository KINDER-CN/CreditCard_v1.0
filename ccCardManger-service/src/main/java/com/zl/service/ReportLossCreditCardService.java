package com.zl.service;

import com.zl.pojo.business.CreditCard;

public interface ReportLossCreditCardService {
	/**
	 * 信用卡挂失
	 * */
	public int reportLossCreditCard(CreditCard creditCard);
	
	/**
	 * 信用卡解挂
	 * */
	public int creditCardLossUnregister(CreditCard creditCard);
}
