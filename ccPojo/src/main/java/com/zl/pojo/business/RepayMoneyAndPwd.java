package com.zl.pojo.business;

import java.math.BigDecimal;

public class RepayMoneyAndPwd {

	private BigDecimal money;
	private int pwd;
	private long cardNum;
	private long bankNum;
	
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	public long getBankNum() {
		return bankNum;
	}
	public void setBankNum(long bankNum) {
		this.bankNum = bankNum;
	}
	@Override
	public String toString() {
		return "RepayMoneyAndPwd [money=" + money + ", pwd=" + pwd + ", cardNum=" + cardNum + ", bankNum=" + bankNum
				+ "]";
	}
	
}
