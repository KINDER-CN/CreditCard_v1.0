package com.zl.pojo.business;
/**
 *逾期表实体类
 */

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Overdue {
	private int id;							//主键id
	private String overdueNum;				//逾期编号			overdue_num
	private BigDecimal overMoney;			//逾期金额			overdue_money
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date overDate;					//逾期日期应		overdue_date
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date overSPayDate;				//应还款日期		overdue_sreturn_date
	private String overState;				//逾期状态			overdue_state
	private Date overReturnDate;			//还款日期			overdue_return_date
	private BigDecimal overSPayMoney;		//应还款金额		overdue_sreturn_money
	private int clientId;					//用户id			overdue_client_id
	private int creditCard;					//信用卡id			overdue_card_id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOverdueNum() {
		return overdueNum;
	}
	public void setOverdueNum(String overdueNum) {
		this.overdueNum = overdueNum;
	}
	public BigDecimal getOverMoney() {
		return overMoney;
	}
	public void setOverMoney(BigDecimal overMoney) {
		this.overMoney = overMoney;
	}
	public Date getOverDate() {
		return overDate;
	}
	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}
	public Date getOverSPayDate() {
		return overSPayDate;
	}
	public void setOverSPayDate(Date overSPayDate) {
		this.overSPayDate = overSPayDate;
	}
	public String getOverState() {
		return overState;
	}
	public void setOverState(String overState) {
		this.overState = overState;
	}
	public Date getOverReturnDate() {
		return overReturnDate;
	}
	public void setOverReturnDate(Date overReturnDate) {
		this.overReturnDate = overReturnDate;
	}
	public BigDecimal getOverSPayMoney() {
		return overSPayMoney;
	}
	public void setOverSPayMoney(BigDecimal overSPayMoney) {
		this.overSPayMoney = overSPayMoney;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}
	@Override
	public String toString() {
		return "Overdue [id=" + id + ", overdueNum=" + overdueNum + ", overMoney=" + overMoney + ", overDate="
				+ overDate + ", overSPayDate=" + overSPayDate + ", overState=" + overState + ", overReturnDate="
				+ overReturnDate + ", overSPayMoney=" + overSPayMoney + ", clientId=" + clientId + ", creditCard="
				+ creditCard + "]";
	}
	
}
