package com.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.ClientCompanyDao;
import com.zl.pojo.client.ClientCompany;
import com.zl.service.ClientCompanyService;

@Service
public class ClientCompanyServiceImpl implements ClientCompanyService {
	@Autowired
	private ClientCompanyDao ccd;
	
	public int insertClientCompanyInfo(ClientCompany cc) {
		return ccd.insertClientCompanyInfo(cc);
	}

}
