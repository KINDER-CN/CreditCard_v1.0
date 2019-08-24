package com.zl.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.clientdao.BillClientDao;
import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;
import com.zl.service.BillClientService;
/**
 * 账单模块实现类
 * @author aaron
 *
 */
@Service
public class BillClientServiceImpl implements BillClientService {
    @Autowired
    private BillClientDao bcd;
    
	@Override
	public List<BillDetails> queryBillDetailsBybillId(BillDetails bs) {
		// TODO Auto-generated method stub
		return bcd.queryBillDetailsBybillId(bs);
	}

	@Override
	public Bill queryBillByCardIdAndDate(Bill bill) {
		
		return bcd.queryBillByCardIdAndDate(bill);
	}

	@Override
	public int addBillByBillDetails(Bill bill) {
		// TODO Auto-generated method stub
		return bcd.addBillByBillDetails(bill);
	}

}
