package com.zl.pojo.business;
/**
 *分期利率表
 */
public class AgingRate {
	private int id;				//主键id
	private double agingRate;	//分期利率		aging_rate
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAgingRate() {
		return agingRate;
	}
	public void setAgingRate(double agingRate) {
		this.agingRate = agingRate;
	}
	@Override
	public String toString() {
		return "AgingRate [id=" + id + ", agingRate=" + agingRate + "]";
	}
	
}
