package com.zl.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.ClientLinkmanDao;
import com.zl.pojo.client.ClientLinkman;
import com.zl.service.ClientLinkmanService;

@Service
public class ClientLinkmanServiceImpl implements ClientLinkmanService {
	@Autowired
	private ClientLinkmanDao cld;
	
	@Test
	public int insertClientLinkmanInfo(ClientLinkman cl) {
		return cld.insertClientLinkmanInfo(cl);
	}

}
