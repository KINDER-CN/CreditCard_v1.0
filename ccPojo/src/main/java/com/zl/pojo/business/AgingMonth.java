package com.zl.pojo.business;

import java.math.BigDecimal;
import java.util.Date;

/**
 *分期账单详情表
 */
public class AgingMonth {
	private int id;//主键id
	private BigDecimal monthMoney;				//每月分期金额					month_money
	private BigDecimal monthInterest;			//本月利息						month_interest
	private BigDecimal notReturnMoney;			//本月未还分期金额				month_not_return_money
	private AgingRate agingRate;				//分期利率表，外键关联分期利率表		aging_rate_id
	private String agingRefund;					//分期还款状态，已还完，未还完		month_aging_refund
	private BigDecimal returnMoney;				//本月以还分期金额				month_return_money
	private Aging aging;						//分期概况表id，外键，此处以对象的形式	aging_id
	private int monthNper;						//当前期数						month_nper
	private BigDecimal agingPoundage;			//分期手续费					month_aging_poundage
	private String installments;				//分期方式：按月分期				month_installments
	private String agingType;					//分期类型：账单分期				aging_type
	private Date agingTime;						//申请时间						aging_time
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getMonthMoney() {
		return monthMoney;
	}
	public void setMonthMoney(BigDecimal monthMoney) {
		this.monthMoney = monthMoney;
	}
	public BigDecimal getMonthInterest() {
		return monthInterest;
	}
	public void setMonthInterest(BigDecimal monthInterest) {
		this.monthInterest = monthInterest;
	}
	public BigDecimal getNotReturnMoney() {
		return notReturnMoney;
	}
	public void setNotReturnMoney(BigDecimal notReturnMoney) {
		this.notReturnMoney = notReturnMoney;
	}
	public AgingRate getAgingRate() {
		return agingRate;
	}
	public void setAgingRate(AgingRate agingRate) {
		this.agingRate = agingRate;
	}
	public String getAgingRefund() {
		return agingRefund;
	}
	public void setAgingRefund(String agingRefund) {
		this.agingRefund = agingRefund;
	}
	public BigDecimal getReturnMoney() {
		return returnMoney;
	}
	public void setReturnMoney(BigDecimal returnMoney) {
		this.returnMoney = returnMoney;
	}
	public Aging getAging() {
		return aging;
	}
	public void setAging(Aging aging) {
		this.aging = aging;
	}
	public int getMonthNper() {
		return monthNper;
	}
	public void setMonthNper(int monthNper) {
		this.monthNper = monthNper;
	}
	public BigDecimal getAgingPoundage() {
		return agingPoundage;
	}
	public void setAgingPoundage(BigDecimal agingPoundage) {
		this.agingPoundage = agingPoundage;
	}
	public String getInstallments() {
		return installments;
	}
	public void setInstallments(String installments) {
		this.installments = installments;
	}
	public String getAgingType() {
		return agingType;
	}
	public void setAgingType(String agingType) {
		this.agingType = agingType;
	}
	public Date getAgingTime() {
		return agingTime;
	}
	public void setAgingTime(Date agingTime) {
		this.agingTime = agingTime;
	}
	@Override
	public String toString() {
		return "AgingMonth [id=" + id + ", monthMoney=" + monthMoney + ", monthInterest=" + monthInterest
				+ ", notReturnMoney=" + notReturnMoney + ", agingRate=" + agingRate + ", agingRefund=" + agingRefund
				+ ", returnMoney=" + returnMoney + ", aging=" + aging + ", monthNper=" + monthNper + ", agingPoundage="
				+ agingPoundage + ", installments=" + installments + ", agingType=" + agingType + ", agingTime="
				+ agingTime + "]";
	}
	
}
