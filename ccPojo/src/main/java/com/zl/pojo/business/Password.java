package com.zl.pojo.business;

//用来设置密码和修改密码
public class Password {
	private int id;
	private String oldCarPassword;//原密码
	private String newCarPassword;//新密码
	private String confirmNewCarPassword;//确定新密码
	private Long cardPhone;//手机号码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOldCarPassword() {
		return oldCarPassword;
	}
	public void setOldCarPassword(String oldCarPassword) {
		this.oldCarPassword = oldCarPassword;
	}
	public String getNewCarPassword() {
		return newCarPassword;
	}
	public void setNewCarPassword(String newCarPassword) {
		this.newCarPassword = newCarPassword;
	}
	public String getConfirmNewCarPassword() {
		return confirmNewCarPassword;
	}
	public void setConfirmNewCarPassword(String confirmNewCarPassword) {
		this.confirmNewCarPassword = confirmNewCarPassword;
	}
	public Long getCardPhone() {
		return cardPhone;
	}
	public void setCardPhone(Long cardPhone) {
		this.cardPhone = cardPhone;
	}
	@Override
	public String toString() {
		return "Password [id=" + id + ", oldCarPassword=" + oldCarPassword + ", newCarPassword=" + newCarPassword
				+ ", confirmNewCarPassword=" + confirmNewCarPassword + ", cardPhone=" + cardPhone + "]";
	}
	
}
