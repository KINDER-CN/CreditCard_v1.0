package com.zl.pojo.manger;
/**
 *操作日志表
 */

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OperateLog {
	private int id;					//主键id
	private String operateNum;		//操作id		operate_num
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date operateTime;		//操作时间		operate_time
	private String operateUser;		//操作人		operate_user
	private String operateLog;		//操作详情		operate_log
	private String operateObj;		//操作对象		operate_object
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOperateNum() {
		return operateNum;
	}
	public void setOperateNum(String operateNum) {
		this.operateNum = operateNum;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public String getOperateUser() {
		return operateUser;
	}
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}
	public String getOperateLog() {
		return operateLog;
	}
	public void setOperateLog(String operateLog) {
		this.operateLog = operateLog;
	}
	public String getOperateObj() {
		return operateObj;
	}
	public void setOperateObj(String operateObj) {
		this.operateObj = operateObj;
	}
	@Override
	public String toString() {
		return "OperateLog [id=" + id + ", operateNum=" + operateNum + ", operateTime=" + operateTime + ", operateUser="
				+ operateUser + ", operateLog=" + operateLog + ", operateObj=" + operateObj + "]";
	}
	
}
