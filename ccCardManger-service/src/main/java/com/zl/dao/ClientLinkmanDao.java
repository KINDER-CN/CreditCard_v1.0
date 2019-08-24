package com.zl.dao;


import com.zl.pojo.client.ClientLinkman;

public interface ClientLinkmanDao {
	/**
	 * 添加用户联系人信息到用户联系人表
	 */
	public int insertClientLinkmanInfo(ClientLinkman cl);
	
}
