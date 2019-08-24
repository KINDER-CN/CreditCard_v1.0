package com.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.ClientDao;
import com.zl.pojo.client.Client;
import com.zl.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao cd;
	
	@Override
	public Client selectClientById(int id) {
		return cd.selectClientById(id);
	}

	
	@Override
	public int updateClientInfo(Client client) {
		return cd.updateClientInfo(client);
	}

}
