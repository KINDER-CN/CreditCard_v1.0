package com.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.clientdao.RepayClientDao;
import com.zl.pojo.business.BankCard;
import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.business.RepayCard;
import com.zl.pojo.client.Client;
import com.zl.pojo.manger.CardType;
import com.zl.service.RepayClientService;
/**
 * 还款模块实现类
 * @author aaron
 *
 */
@Service
public class RepayClientServiceImpl implements RepayClientService{
	
    @Autowired
    private RepayClientDao rcd;
	@Override
	public int addRepayCard(RepayCard repayCard) {
     System.out.println("daoda/........"+repayCard);
		return rcd.addRepayCard(repayCard);
	}

	@Override
	public List<CreditCard> queryCreditCardByClient(int client) {

		return rcd.queryCreditCardByClient(client);
	}

	@Override
	public int updateBankBalance(BankCard bankCard) {

		return rcd.updateBankBalance(bankCard);
	}

	@Override
	public int updateCardBalance(CreditCard creditCard) {

		return rcd.updateCardBalance(creditCard);
	}

	@Override
	public int addRepayToBillDetails(BillDetails billDetails) {

		return rcd.addRepayToBillDetails(billDetails);
	}

	@Override
	public int updateCreditPoint(Client client) {

		return rcd.updateCreditPoint(client);
	}

	@Override
	public  BankCard queryBankCard(long cardId) {
		// TODO Auto-generated method stub
		return rcd.queryBankCard(cardId);
	}

	@Override
	public CreditCard queryCreditCardById(long cardId) {
		// TODO Auto-generated method stub
		return rcd.queryCreditCardById(cardId);
	}

	@Override
	public List<RepayCard> queryRepayCardbyclient(String client) {
		// TODO Auto-generated method stub
		return rcd.queryRepayCardbyclient(client);
	}

	@Override
	public int updateHasMoney(Bill bl) {
		// TODO Auto-generated method stub
		return rcd.updateHasMoney(bl);
	}

	@Override
	public List<CardType> queryCardType() {
		// TODO Auto-generated method stub
		return rcd.queryCardType();
	}

}
