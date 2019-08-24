package com.zl.pojo.business;
/**
 *银行卡表 
 *
 */

import java.math.BigDecimal;

public class BankCard {
	private int id; 				// 主键id
	private long bankCard; 			// 银行卡卡号 bank_card
	private String bankClientName;	// 银行卡卡主姓名 bank_client_name
	private String bankIDcard; 		// 银行卡卡主身份证号码 bank_idcard
	private long bankPhone; 			// 预留电话 bank_client_phone
	private String bankName; 		// 所属行 bank_name
	private BigDecimal bankBalance; // 卡余额 bank_balance
	private int cardPwd;           //卡密码 card_pwd
	public int getCardPwd() {
		return cardPwd;
	}
	public void setCardPwd(int cardPwd) {
		this.cardPwd = cardPwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getBankCard() {
		return bankCard;
	}
	public void setBankCard(long bankCard) {
		this.bankCard = bankCard;
	}
	public String getBankClientName() {
		return bankClientName;
	}
	public void setBankClientName(String bankClientName) {
		this.bankClientName = bankClientName;
	}
	public String getBankIDcard() {
		return bankIDcard;
	}
	public void setBankIDcard(String bankIDcard) {
		this.bankIDcard = bankIDcard;
	}
	public long getBankPhone() {
		return bankPhone;
	}
	public void setBankPhone(long bankPhone) {
		this.bankPhone = bankPhone;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public BigDecimal getBankBalance() {
		return bankBalance;
	}
	public void setBankBalance(BigDecimal bankBalance) {
		this.bankBalance = bankBalance;
	}
	@Override
	public String toString() {
		return "BankCard [id=" + id + ", bankCard=" + bankCard + ", bankClientName=" + bankClientName + ", bankIDcard="
				+ bankIDcard + ", bankPhone=" + bankPhone + ", bankName=" + bankName + ", bankBalance=" + bankBalance
				+ ", cardPwd=" + cardPwd + "]";
	}
	
	
}
