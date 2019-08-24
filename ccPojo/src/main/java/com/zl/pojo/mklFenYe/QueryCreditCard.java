package com.zl.pojo.mklFenYe;

import org.springframework.stereotype.Component;

@Component
public class QueryCreditCard {

	/** 根据客户姓名精确查询用户表 */
	private String clientName;

	/** 根据客户身份证精确查询用户表 */
	private String clientIdcard;

	/* 根据客户卡号精确查询信用卡表clientName */
	private String cardNum;

	public String getClientName() {
		return clientName;
	}

	public String getClientIdcard() {
		return clientIdcard;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void setClientIdcard(String clientIdcard) {
		this.clientIdcard = clientIdcard;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	



	

	

}
