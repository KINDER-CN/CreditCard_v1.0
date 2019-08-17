package com.zl.pojo.client;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 客户信息表
 *
 */
public class Client implements Serializable{
	private int id;		//客户表主键  	id
	private String clientId;	//客户编号		client_id
	private String clientName;	//客户名字		client_name
	private String clientSex;	//客户性别		client_sex
	private String clientNational;	//民族	client_national
	private String clientIDcard;	//身份证号	client_idcard
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date clientBirthday;		//出生年月如	client_birthday
	private String clientMarriage;		//婚姻状况：已婚（有子女），已婚（无子女），未婚，其他	client_marriage
	private String clientEdu;	//学历：小学，初中，高中，中专，大专，本科，硕士，博士，博士后	client_edu
	private double creditPoint;	//客户信用分：人工评定之后输入	client_bank_creditPoint
	private String password;	//客户登录密码	client_password
	private int questionId;	//安全问题序号，外键关联安全问题表	client_question_id
	private String clientAnswer;	//安全问题答案	client_answer
	private	String clientHousing;	//客户住宅情况:与父母同住，有贷房，全款房，租房		client_housing 
	private String clientAddress;	//客户地址		client_address
	private int postalcode;		//邮编		client_postalcode
	private String clientEmail;		//客户邮箱地址		client_email
	private long clientPhone;		//客户联系电话	client_phone
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
	public String getClientSex() {
		return clientSex;
	}
	public void setClientSex(String clientSex) {
		this.clientSex = clientSex;
	}
	public String getClientNational() {
		return clientNational;
	}
	public void setClientNational(String clientNational) {
		this.clientNational = clientNational;
	}
	public String getClientIDcard() {
		return clientIDcard;
	}
	public void setClientIDcard(String clientIDcard) {
		this.clientIDcard = clientIDcard;
	}
	public Date getClientBirthday() {
		return clientBirthday;
	}
	public void setClientBirthday(Date clientBirthday) {
		this.clientBirthday = clientBirthday;
	}
	public String getClientMarriage() {
		return clientMarriage;
	}
	public void setClientMarriage(String clientMarriage) {
		this.clientMarriage = clientMarriage;
	}
	public String getClientEdu() {
		return clientEdu;
	}
	public void setClientEdu(String clientEdu) {
		this.clientEdu = clientEdu;
	}
	public double getCreditPoint() {
		return creditPoint;
	}
	public void setCreditPoint(double creditPoint) {
		this.creditPoint = creditPoint;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getClientAnswer() {
		return clientAnswer;
	}
	public void setClientAnswer(String clientAnswer) {
		this.clientAnswer = clientAnswer;
	}
	public String getClientHousing() {
		return clientHousing;
	}
	public void setClientHousing(String clientHousing) {
		this.clientHousing = clientHousing;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public int getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(int postalcode) {
		this.postalcode = postalcode;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public long getClientPhone() {
		return clientPhone;
	}
	public void setClientPhone(long clientPhone) {
		this.clientPhone = clientPhone;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", clientId=" + clientId + ", clientName=" + clientName + ", clientSex=" + clientSex
				+ ", clientNational=" + clientNational + ", clientIDcard=" + clientIDcard + ", clientBirthday="
				+ clientBirthday + ", clientMarriage=" + clientMarriage + ", clientEdu=" + clientEdu + ", creditPoint="
				+ creditPoint + ", password=" + password + ", questionId=" + questionId + ", clientAnswer="
				+ clientAnswer + ", clientHousing=" + clientHousing + ", clientAddress=" + clientAddress
				+ ", postalcode=" + postalcode + ", clientEmail=" + clientEmail + ", clientPhone=" + clientPhone + "]";
	}
	
}
