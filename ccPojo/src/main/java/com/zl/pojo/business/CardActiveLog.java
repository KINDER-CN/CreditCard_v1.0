package com.zl.pojo.business;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *卡片激活记录表
 */
public class CardActiveLog {
	private int id;//主键id
	private String activNum;		//申请编号		activ_num
	private Long activCardNum;		//激活卡号		activ_card_num
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date activeTime;		//激活时间		activ_time
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date activApplyTime;	//申请时间		activ_apply_time
	private int clientId;			//用户id		activ_client_id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActivNum() {
		return activNum;
	}
	public void setActivNum(String activNum) {
		this.activNum = activNum;
	}
	public Long getActivCardNum() {
		return activCardNum;
	}
	public void setActivCardNum(Long activCardNum) {
		this.activCardNum = activCardNum;
	}
	public Date getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(Date activeTime) {
		this.activeTime = activeTime;
	}
	public Date getActivApplyTime() {
		return activApplyTime;
	}
	public void setActivApplyTime(Date activApplyTime) {
		this.activApplyTime = activApplyTime;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "CardActiveLog [id=" + id + ", activNum=" + activNum + ", activCardNum=" + activCardNum + ", activeTime="
				+ activeTime + ", activApplyTime=" + activApplyTime + ", clientId=" + clientId + "]";
	}
	
}
