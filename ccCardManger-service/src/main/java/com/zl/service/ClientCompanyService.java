package com.zl.service;

import com.zl.pojo.client.ClientCompany;

public interface ClientCompanyService {
	/**
	 * 添加用户公司信息到用户公司表
	 */
	public int insertClientCompanyInfo(ClientCompany cc);
}
