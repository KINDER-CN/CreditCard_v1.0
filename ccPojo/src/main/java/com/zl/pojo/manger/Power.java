package com.zl.pojo.manger;
/**
 *权限表
 */
public class Power {
	private int id;				//主键id
	private int role;			//角色	idpower_role_id
	private String power;		//权限	power
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	@Override
	public String toString() {
		return "Power [id=" + id + ", role=" + role + ", power=" + power + "]";
	}
	
}
