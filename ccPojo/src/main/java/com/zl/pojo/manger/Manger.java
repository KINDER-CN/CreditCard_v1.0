package com.zl.pojo.manger;
/**
 *管理员表实体类
 */
public class Manger {
	private int id;				//主键id
	private String mangerId;	//员工编号			manger_id
	private String mangerName;	//员工姓名			manger_name
	private String mPassword;	//登录密码			manger_password
	private long mPhone;			//联系电话			manger_phone
	private int role;			//角色id，外键		manger_role_id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMangerId() {
		return mangerId;
	}
	public void setMangerId(String mangerId) {
		this.mangerId = mangerId;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Manger [id=" + id + ", mangerId=" + mangerId + ", mangerName=" + mangerName + ", mPassword=" + mPassword
				+ ", mPhone=" + mPhone + ", role=" + role + "]";
	}
	
}
