package com.zl.dao.gu;

import java.util.List;

import com.zl.pojo.business.BillDetails;
import com.zl.pojo.client.ClientBill;
import com.zl.pojo.client.ClientBillDetails;
import com.zl.pojo.htfenye.FenYe;
/**
 * 交易记录模块
 */
public interface jiaoyilishiDao {
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
	public List<ClientBill> queryBillDetailsByLike(String clientIDcard);
	/**
	 * 分页
	 */
	public List<ClientBill> fenYeClientBill(FenYe fenYe);
	/**
	 * 分页总数
	 */
	public int fenYeAllClientBill(FenYe fenYe);
}
