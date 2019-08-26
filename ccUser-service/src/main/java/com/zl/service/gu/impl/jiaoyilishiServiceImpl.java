package com.zl.service.gu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.gu.jiaoyilishiDao;
import com.zl.pojo.business.BillDetails;
import com.zl.pojo.client.ClientBill;
import com.zl.pojo.client.ClientBillDetails;
import com.zl.pojo.htfenye.FenYe;
import com.zl.service.gu.jiaoyilishiService;
@Service
public class jiaoyilishiServiceImpl implements jiaoyilishiService {
	@Autowired
	public jiaoyilishiDao jd;
	@Override
	public List<BillDetails> queryAllBillDetails() {
		return jd.queryAllBillDetails();
	}

	@Override
	public ClientBillDetails queryBillDetailsById(String clientName) {
		return jd.queryBillDetailsById(clientName);
	}

	@Override
	public List<ClientBill> queryBillDetailsByLike(String clientIdcard) {
		return jd.queryBillDetailsByLike(clientIdcard);
	}

	@Override
	public List<ClientBill> fenYeClientBill(FenYe fenYe) {
		return jd.fenYeClientBill(fenYe);
	}

	@Override
	public int fenYeAllClientBill(FenYe fenYe) {
		int i=jd.fenYeAllClientBill(fenYe);
		return i;
	}

}
