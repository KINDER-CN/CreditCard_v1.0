package com.zl.pojo.client;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ClientBillDetails {
	private String clientName;	//客户名字		client_name
	private int transactionType;				//交易类型				transaction_type
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date transactionTime;				//交易时间				transaction_time
	private BigDecimal transactionMoney;		//交易金额				transaction_monry
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date payTime;						//还款时间				transaction_pay_time
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	public BigDecimal getTransactionMoney() {
		return transactionMoney;
	}
	public void setTransactionMoney(BigDecimal transactionMoney) {
		this.transactionMoney = transactionMoney;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	@Override
	public String toString() {
		return "ClientBillDetails [clientName=" + clientName + ", transactionType=" + transactionType
				+ ", transactionTime=" + transactionTime + ", transactionMoney=" + transactionMoney + ", payTime="
				+ payTime + "]";
	}
	
}
