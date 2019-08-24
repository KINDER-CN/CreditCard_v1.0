package com.zl.pojo.manger;

public class MangerRole {
	private int id;				//主键id
	private String mangerName;	//员工姓名			manger_name
	private String mPassword;	//登录密码			manger_password
	private long mPhone;			//联系电话			manger_phone
	private String role;//用户角色名称role
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMangerName() {
		return mangerName;
	}
	public void setMangerName(String mangerName) {
		this.mangerName = mangerName;
	}
	public String getmPassword() {
		return mPassword;
	}
	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}
	public long getmPhone() {
		return mPhone;
	}
	public void setmPhone(long mPhone) {
		this.mPhone = mPhone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "MangerRole [id=" + id + ", mangerName=" + mangerName + ", mPassword=" + mPassword + ", mPhone=" + mPhone
				+ ", role=" + role + "]";
	}
	
}
