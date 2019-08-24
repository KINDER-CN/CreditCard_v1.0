package com.zl.service;

import java.util.List;

import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;

/**
 * 前台账单模块
 * @author aaron
 *
 */
public interface BillClientService {
	
/**
 * 根据账单概括id查询账单（已出/未出）	
 * @param billId
 * @return
 */
 public List<BillDetails> queryBillDetailsBybillId(BillDetails bs);
/**
 * 根据账单生成时间和卡号查询账单概况表	
 * @param bill
 * @return
 */
 public Bill queryBillByCardIdAndDate(Bill bill);
/**
 * 根据账单详情表生成账单概括表	
 * @param bill
 * @return
 */
 public int addBillByBillDetails(Bill bill);

}
