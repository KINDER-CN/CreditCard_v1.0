package com.zl.service;

import com.zl.pojo.client.ClientLinkman;

public interface ClientLinkmanService {
	/**
	 * 添加用户联系人信息到用户联系人表
	 */
	public int insertClientLinkmanInfo(ClientLinkman cl);
}
