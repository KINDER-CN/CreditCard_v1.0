package com.zl.pojo.client;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class ShowClientCard {
	private int id;
	private String cardType;
	private String cardNum;
	private String billMoney;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date repayDay;
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getBillMoney() {
		return billMoney;
	}
	public void setBillMoney(String billMoney) {
		this.billMoney = billMoney;
	}
	public Date getRepayDay() {
		return repayDay;
	}
	public void setRepayDay(Date repayDay) {
		this.repayDay = repayDay;
	}
	@Override
	public String toString() {
		return "ShowClientCard [cardType=" + cardType + ", cardNum=" + cardNum + ", billMoney=" + billMoney
				+ ", repayDay=" + repayDay + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
