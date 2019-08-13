package com.zl.pojo.manger;
/**
 *权限表
 */
public class Power {
	private int id;				//主键id
	private Role role;			//角色	idpower_role_id
	private String power;		//权限	power
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
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
