package com.zl.pojo.business;
/**
 *账单详情表
 */

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class BillDetails {
	private int id;								//主键id
	private String transactionDes;				//交易描述				transaction_des
	private int transactionType;				//交易类型				transaction_type
	private BigDecimal transactionMoney;		//交易金额				transaction_monry
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date transactionTime;				//交易时间				transaction_time
	private String transactionCoin;				//交易币种:默认人民币		transaction_coin
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date payTime;						//还款时间				transaction_pay_time
	private int billId;							//账单表id				bill_id
	private CreditCard creditCard;				//信用卡id				card_id
	private Aging aging;						//分期表id				aging_id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTransactionDes() {
		return transactionDes;
	}
	public void setTransactionDes(String transactionDes) {
		this.transactionDes = transactionDes;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public BigDecimal getTransactionMoney() {
		return transactionMoney;
	}
	public void setTransactionMoney(BigDecimal transactionMoney) {
		this.transactionMoney = transactionMoney;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getTransactionCoin() {
		return transactionCoin;
	}
	public void setTransactionCoin(String transactionCoin) {
		this.transactionCoin = transactionCoin;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}
	public Aging getAging() {
		return aging;
	}
	public void setAging(Aging aging) {
		this.aging = aging;
	}
	@Override
	public String toString() {
		return "BillDetails [id=" + id + ", transactionDes=" + transactionDes + ", transactionType=" + transactionType
				+ ", transactionMoney=" + transactionMoney + ", transactionTime=" + transactionTime
				+ ", transactionCoin=" + transactionCoin + ", payTime=" + payTime + ", billId=" + billId
				+ ", creditCard=" + creditCard + ", aging=" + aging + "]";
	}
	
	
}
