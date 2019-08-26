package com.zl.dao;

import java.util.List;

import com.zl.pojo.business.ApplyCard;
import com.zl.pojo.business.ApplyCardPlan;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.client.Client;
import com.zl.pojo.client.ClientCompany;
import com.zl.pojo.client.ClientLinkman;
import com.zl.pojo.mklFenYe.FenYeClientApplyCard;
import com.zl.pojo.mklFenYe.PagingCreditCard;
import com.zl.pojo.mklFenYe.QueryClientApplyCard;
import com.zl.pojo.mklFenYe.QueryCreditCard;

/**
 * 信用卡接口
 *
 */
public interface MklCreditCardDao {

	/**
	 * 1.根据id查看个人资料
	 */
	public Client queryClientById(int id);

	/**
	 * 2.根据id查看个人单位表
	 */
	public ClientCompany queryClientCompanyById(int id);

	/** 3.根据id查看个人联系人表 */
	public ClientLinkman queryClientLinkmanById(int id);

	/** 4.根据id修改用户资料表 */
	public int updateClientById(Client client);

	/** 5.根据id修改用户单位表 */
	public int updateClientCompanyById(ClientCompany clientCompany);

	/** 6.根据id修改用户联系人表 */
	public int updateClientLinkmanById(ClientLinkman clientLinkman);

	/** 7.根据条件进行查询申请详情表符合要求记录总数 */
	public int queryCountApplyCard(QueryClientApplyCard queryClientApplyCard);

	/** 8.根据条件进行分页查询申请详情表 */
	public List<ApplyCard> queryApplyCardByFenYe(FenYeClientApplyCard fenYeClientApplyCard);

	/** 9.根据条件进行查询信用卡符合要求记录总数 */
	public int queryCountClientCard(QueryCreditCard queryCreditCard);

	/** 10. 查看所有信用卡用户（条件查询) */
	public List<CreditCard> queryAllClientCardByFenYe(PagingCreditCard pagingCreditCard);

	/** 11.根据id修改详情表 */
	public int updateApplyCardById(ApplyCard applyCard);

	/** 12.根据id修改进度表 */
	public int updateApplyCardPlanByIdCard(ApplyCardPlan applyCardPlan);

	/** 13.添加信用卡 */
	public int addCreditCardById(CreditCard creditCard);

	/** 14.根据原密码进行修改密码 */
	public int updateCreditCardRepairById(CreditCard creditCard);

	/* 15.根据身份证进行修改密码 */
	public int updateCreditCardByClientIdcard(CreditCard creditCard);

	/* 16.根据id查看信用卡 */
	public CreditCard queryCreditCardById(Long id);

	/** 17.根据客户id进行修改修改信用卡状态激活，销卡，冻结，挂失 */
	public int updateCreditCardByClientId(CreditCard creditCard);

	/** 18.根据客户id查看详情表 */
	public ApplyCard queryClientApplyCardById(int id);
	
	/**19.根据客户卡号修改信用卡额度*/
	public int udpateCreditCardLimit(CreditCard creditCard);

}
