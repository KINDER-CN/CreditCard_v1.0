package com.zl.service;

import java.util.List;

import com.zl.pojo.business.BankCard;
import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.business.RepayCard;
import com.zl.pojo.client.Client;
import com.zl.pojo.manger.CardType;

/**
 * 前台还款模块业务接口
 * @author aaron
 *
 */
public interface RepayClientService {
	/**
	 *  添加储蓄卡 
	 * @param repayCard
	 * @return
	 */
	public int addRepayCard(RepayCard repayCard);
	/**
	 * 根据客户ID查询信用卡表
	 * @param client
	 * @return
	 */
	public List<CreditCard> queryCreditCardByClient(int client);
	/**
	 * 修改还款余额（扣款）
	 * @param bankCard
	 * @return
	 */
	public int updateBankBalance(BankCard bankCard);
	/**
	 *  修改信用卡可用额度（还款）
	 * @param creditCard
	 * @return
	 */
	public int updateCardBalance(CreditCard creditCard);
	/**
	 * 添加还款记录到交易详情表
	 * @param billDetails
	 * @return
	 */
	public int addRepayToBillDetails(BillDetails billDetails);
	/**
	 * 更改客户信用分
	 * @param client
	 * @return
	 */
	public int updateCreditPoint(Client client);
	/**
	 * 查询还款卡
	 * @param cardId
	 * @return
	 */
	public BankCard queryBankCard(long cardId);
	public CreditCard queryCreditCardById(long cardId);
	public List<RepayCard> queryRepayCardbyclient(String id);
	public int updateHasMoney(Bill bl);
	public List<CardType> queryCardType();
	
}
