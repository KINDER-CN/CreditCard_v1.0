package com.zl.pojo.manger;
/**
 *卡类型表
 */
public class Ctype {
	private int id;
	private String ctype; //卡类型：普通，金，白金
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	@Override
	public String toString() {
		return "Ctype [id=" + id + ", ctype=" + ctype + "]";
	}
	
}
