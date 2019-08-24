package com.zl.dao;

import com.zl.pojo.client.ClientCompany;

public interface ClientCompanyDao {
	/**
	 * 添加用户公司信息到用户公司表
	 */
	public int insertClientCompanyInfo(ClientCompany cp);
	
}
