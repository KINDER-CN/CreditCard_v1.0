package com.zl.service.gu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.gu.zhanghuguanlimokuaiDao;
import com.zl.pojo.client.Client;
import com.zl.pojo.htfenye.FenYe;
import com.zl.service.gu.zhanghuguanlimokuaiService;
@Service
public class zhanghuguanlimokuaiServiceImpl implements zhanghuguanlimokuaiService {
	@Autowired
	public zhanghuguanlimokuaiDao zd;
	@Override
	public List<Client> queryAllClient() {
		return zd.queryAllClient();
	}

	@Override
	public List<Client> queryClientByLike(String clientIdcard) {
		return zd.queryClientByLike(clientIdcard);
	}

	@Override
	public Client queryClientById(int id) {
		return zd.queryClientById(id);
	}

	@Override
	public List<Client> fenYeClient(FenYe fenYe) {
		return zd.fenYeClient(fenYe);
	}

	@Override
	public int fenYeAllClient(FenYe fenYe) {
		int i=zd.fenYeAllClient(fenYe);
		return i;
	}

}
