package com.zl.service.backstage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.backstage.BillDao;
import com.zl.pojo.Query;
import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;
import com.zl.service.backstage.BillService;

@Service
public class BillServiceImpl implements BillService{
	@Autowired
	private BillDao bd;
	
	@Override
	public List<Bill> queryAllBill() {
		return bd.queryAllBill();
	}

	@Override
	public List<Bill> queryBillById(int id) {
		return bd.queryBillById(id);
	}

	@Override
	public List<Bill> queryBillByLike(Query query) {
		return bd.queryBillByLike(query);
	}

	@Override
	public List<BillDetails> queryBillDetails() {
		return bd.queryBillDetails();
	}

	@Override
	public List<BillDetails> queryBillDetailsById(int id) {
		return bd.queryBillDetailsById(id);
	}

}
