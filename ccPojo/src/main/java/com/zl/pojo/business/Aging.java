package com.zl.pojo.business;
/**
 *分期表 
 */

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zl.pojo.client.Client;

public class Aging {
	private int id; 					// 主键id
	private String agingNum; 			// 分期账单编号  					 aging_num
	private BigDecimal agingLines;		// 分期总额 					 aging_lines
	private int agingNper;				// 分期期数 					 aging_nper
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date agingTime;				// 分期账单生成时间 				 aging_time
	private int agingRate;		// 分期利率，外键关联分期利率表 		 aging_rate_id
	private String agingState; 			// 分期还款状态 					 aging_state
	private int creditCard; 		// 分期的信用卡，外键关联信用卡表 		 aging_card_id
	private int client; 				// 分期账单所属客户id，外键管理客户表	 aging_client_id
	private Date agingEndTime; 			// 账单结束时间					 aging_endtime
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAgingNum() {
		return agingNum;
	}
	public void setAgingNum(String agingNum) {
		this.agingNum = agingNum;
	}
	public BigDecimal getAgingLines() {
		return agingLines;
	}
	public void setAgingLines(BigDecimal agingLines) {
		this.agingLines = agingLines;
	}
	public int getAgingNper() {
		return agingNper;
	}
	public void setAgingNper(int agingNper) {
		this.agingNper = agingNper;
	}
	public Date getAgingTime() {
		return agingTime;
	}
	public void setAgingTime(Date agingTime) {
		this.agingTime = agingTime;
	}
	public String getAgingState() {
		return agingState;
	}
	public void setAgingState(String agingState) {
		this.agingState = agingState;
	}
	public Date getAgingEndTime() {
		return agingEndTime;
	}
	public void setAgingEndTime(Date agingEndTime) {
		this.agingEndTime = agingEndTime;
	}
	public int getAgingRate() {
		return agingRate;
	}
	public void setAgingRate(int agingRate) {
		this.agingRate = agingRate;
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
		return "Aging [id=" + id + ", agingNum=" + agingNum + ", agingLines=" + agingLines + ", agingNper=" + agingNper
				+ ", agingTime=" + agingTime + ", agingRate=" + agingRate + ", agingState=" + agingState
				+ ", creditCard=" + creditCard + ", client=" + client + ", agingEndTime=" + agingEndTime + "]";
	}
	
}
