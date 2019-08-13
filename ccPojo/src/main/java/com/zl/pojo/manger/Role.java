package com.zl.pojo.manger;
/**
 *用户角色表
 */
public class Role {
	private int id;//主键id
	private String role;//用户角色名称role
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + "]";
	}
	
}
