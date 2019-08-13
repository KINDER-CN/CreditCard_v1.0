package com.zl.pojo.client;
/**
 *客户联系人 
 *
 */
public class ClientLinkman {
	private int id;		//主键id
	private String linkName;	//联系人姓名	client_link_name
	private int linkPhone;		//联系人电话	client_link_phone
	private String linkAddress;	//联系人地址	client_link_address
	private String linkRelation;	//与联系人关系：父子，母子，同学，同事	client_link_relation
	private int client;	//外键客户id	clinent_link_client_id,此处为方便级联，写成外键对象
	private int binding;	//联系人与客户的绑定状态，0为未绑定，1为绑定状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public int getLinkPhone() {
		return linkPhone;
	}
	public void setLinkPhone(int linkPhone) {
		this.linkPhone = linkPhone;
	}
	public String getLinkAddress() {
		return linkAddress;
	}
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	public String getLinkRelation() {
		return linkRelation;
	}
	public void setLinkRelation(String linkRelation) {
		this.linkRelation = linkRelation;
	}
	
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}
	public int getBinding() {
		return binding;
	}
	public void setBinding(int binding) {
		this.binding = binding;
	}
	@Override
	public String toString() {
		return "ClientLinkman [id=" + id + ", linkName=" + linkName + ", linkPhone=" + linkPhone + ", linkAddress="
				+ linkAddress + ", linkRelation=" + linkRelation + ", client=" + client + ", binding=" + binding + "]";
	}
	
}
