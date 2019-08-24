package com.zl.service.backstage;

import java.util.List;

import com.zl.pojo.Query;
import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;

/**
 * 还款模块Service层
 */
public interface BillService {
	/**
	 * 一.账单概括
	 * 
	 * 1.查询所有用户账单信息
	 */
	public List<Bill> queryAllBill();
	
	/**
	 * 2.根据id查询用户账单信息
	 */
	public List<Bill> queryBillById(int id);
	
	/**
	 * 3.根据条件查询用户账单信息
	 */
	public List<Bill> queryBillByLike(Query query);
	
	
	/**
	 * 二.账单详情
	 * 
	 * 1.查询用户所有账单详情信息
	 */
	public List<BillDetails> queryBillDetails();
	
	/**
	 * 2.根据id查询用户账单详情信息
	 */
	public List<BillDetails> queryBillDetailsById(int id);
}
