package com.zl.pojo.client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 视图(用户表+账单表)
 * @author Administrator
 *
 */
public class ClientBill implements Serializable{
	private int id;		//客户表主键  	id
	private String clientId;	//客户编号		client_id
	private String clientName;	//客户名字		client_name
	private String clientIDcard;	//身份证号	client_idcard
	private String billNum;				//账单编号			bill_num
	private BigDecimal billMoney;		//账单金额	
	private BigDecimal hasPay;			//已还款金额		bill_hasPay
	private Date repayDate;				//还款时间			bill_repay_date
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientIDcard() {
		return clientIDcard;
	}
	public void setClientIDcard(String clientIDcard) {
		this.clientIDcard = clientIDcard;
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
	public Date getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}
	@Override
	public String toString() {
		return "clientBill [id=" + id + ", clientId=" + clientId + ", clientName=" + clientName + ", clientIDcard="
				+ clientIDcard + ", billNum=" + billNum + ", billMoney=" + billMoney + ", hasPay=" + hasPay
				+ ", repayDate=" + repayDate + "]";
	}
	
}
