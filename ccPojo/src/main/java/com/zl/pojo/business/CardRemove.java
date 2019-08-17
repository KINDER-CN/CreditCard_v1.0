package com.zl.pojo.business;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 *信用卡销卡记录表实体类
 */
public class CardRemove {
	private int id;								//主键id
	private String removeApplyNum;				//申请编号			remove_apply_num
	private int removeCardId;					//销卡卡号			remove_card_id
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date removeApplyDate;				//申请时间			remove_apply_time
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date removeTime;					//销卡时间			remove_time
	private int clientId;						//用户id			remove_client_id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRemoveApplyNum() {
		return removeApplyNum;
	}
	public void setRemoveApplyNum(String removeApplyNum) {
		this.removeApplyNum = removeApplyNum;
	}
	public int getRemoveCardId() {
		return removeCardId;
	}
	public void setRemoveCardId(int removeCardId) {
		this.removeCardId = removeCardId;
	}
	public Date getRemoveApplyDate() {
		return removeApplyDate;
	}
	public void setRemoveApplyDate(Date removeApplyDate) {
		this.removeApplyDate = removeApplyDate;
	}
	public Date getRemoveTime() {
		return removeTime;
	}
	public void setRemoveTime(Date removeTime) {
		this.removeTime = removeTime;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "CardRemove [id=" + id + ", removeApplyNum=" + removeApplyNum + ", removeCardId=" + removeCardId
				+ ", removeApplyDate=" + removeApplyDate + ", removeTime=" + removeTime + ", clientId=" + clientId
				+ "]";
	}
	
}
