package com.zl.service.gu;

import java.util.List;

import com.zl.pojo.business.BillDetails;
import com.zl.pojo.client.ClientBill;
import com.zl.pojo.client.ClientBillDetails;
/**
 * 交易记录模块
 */
public interface jiaoyilishiService {
	/**
	 * 查询账单表
	 */
	public List<BillDetails> queryAllBillDetails();
	/**
	 * 查询账单记录表
	 */
	public ClientBillDetails queryBillDetailsById(String clientName);
	/**
	 * 模糊查询账单表
	 */
	public List<ClientBill> queryBillDetailsByLike(String clientIdcard);
}
