package com.zl.pojo.business;
/**
 *账单表实体类
 */

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zl.pojo.client.Client;

public class Bill {
	private int id;						//主键id
	private String billNum;				//账单编号			bill_num
	private int creditCard;		//信用卡id,外键		bill_card_id
	private BigDecimal billMoney;		//账单金额			bill_money
	private BigDecimal hasPay;			//已还款金额		bill_hasPay
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date srepayDate;			//应还款时间		bill_srepay_date
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date repayDate;				//还款时间			bill_repay_date
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date billDate;				//账单生成时间		bill_creat_date
	private String billState;			//状态			bill_state
	private int client;				//用户id			bill_client_id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBillNum() {
		return billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	public BigDecimal getBillMoney() {
		return billMoney;
	}
	public void setBillMoney(BigDecimal billMoney) {
		this.billMoney = billMoney;
	}
	public BigDecimal getHasPay() {
		return hasPay;
	}
	public void setHasPay(BigDecimal hasPay) {
		this.hasPay = hasPay;
	}
	public Date getSrepayDate() {
		return srepayDate;
	}
	public void setSrepayDate(Date srepayDate) {
		this.srepayDate = srepayDate;
	}
	public Date getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getBillState() {
		return billState;
	}
	public void setBillState(String billState) {
		this.billState = billState;
	}
	public int getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", billNum=" + billNum + ", creditCard=" + creditCard + ", billMoney=" + billMoney
				+ ", hasPay=" + hasPay + ", srepayDate=" + srepayDate + ", repayDate=" + repayDate + ", billDate="
				+ billDate + ", billState=" + billState + ", client=" + client + "]";
	}
	
}
