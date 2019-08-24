package com.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.MklCreditCardDao;

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
import com.zl.service.MKLCreditCardService;

@Service
public class MKLCreditCardServiceImpl implements MKLCreditCardService {
	@Autowired
	private MklCreditCardDao mccd;

	@Override
	public Client queryClientById(int id) {
		Client client = mccd.queryClientById(id);
		return client;
	}

	@Override
	public ClientCompany queryClientCompanyById(int id) {
		ClientCompany clientCompany = mccd.queryClientCompanyById(id);
		return clientCompany;
	}

	@Override
	public ClientLinkman queryClientLinkmanById(int id) {
		ClientLinkman clientLinkman = mccd.queryClientLinkmanById(id);
		return clientLinkman;
	}

	@Override
	public int updateClientById(Client client) {
		int result = mccd.updateClientById(client);
		return result;
	}

	@Override
	public int updateClientCompanyById(ClientCompany clientCompany) {
		int updateclientCompany = mccd.updateClientCompanyById(clientCompany);
		return updateclientCompany;
	}

	@Override
	public int updateClientLinkmanById(ClientLinkman clientLinkman) {
		int updateClientLinkman = mccd.updateClientLinkmanById(clientLinkman);
		return updateClientLinkman;
	}

	@Override
	public int queryCountApplyCard(QueryClientApplyCard queryClientApplyCard) {
		int queryCountApplyCard = mccd.queryCountApplyCard(queryClientApplyCard);
		return queryCountApplyCard;
	}

	@Override
	public List<ApplyCard> queryApplyCardByFenYe(FenYeClientApplyCard fenYeClientApplyCard) {
		/* 设置符合要求的总条数 */
		fenYeClientApplyCard.setRowsCount(mccd.queryCountApplyCard(fenYeClientApplyCard.getQueryClientApplyCard()));
		if (fenYeClientApplyCard.getPage() == null || fenYeClientApplyCard.getPage() == 0
				|| fenYeClientApplyCard.getPage() < 0) {
			fenYeClientApplyCard.setPage(1);
		}
		System.out.println(fenYeClientApplyCard.getPage());
		// int pageInt = new Integer(pag.getPage());
		// if (pageInt < 1) {
		// pageInt = 1;
		// }
		if (fenYeClientApplyCard.getPage() > fenYeClientApplyCard.getPageCount() && fenYeClientApplyCard.getPage() > 0
				&& fenYeClientApplyCard.getPageCount() > 0) {
			fenYeClientApplyCard.setPage(fenYeClientApplyCard.getPageCount());
		}

		System.out.println("===================当前页号：" + fenYeClientApplyCard.getPage() + "=======");
		List<ApplyCard> applyCard = mccd.queryApplyCardByFenYe(fenYeClientApplyCard);
		return applyCard;
	}

	@Override
	public int queryCountClientCard(QueryCreditCard queryCreditCard) {
		int queryCountClientCard = mccd.queryCountClientCard(queryCreditCard);
		return queryCountClientCard;
	}

	@Override
	public List<CreditCard> queryAllClientCardByFenYe(PagingCreditCard pagingCreditCard) {
		/* 设置符合要求的总条数 */
		pagingCreditCard.setRowsCount(mccd.queryCountClientCard(pagingCreditCard.getQueryCreditCard()));
		if (pagingCreditCard.getPage() == null || pagingCreditCard.getPage() == 0 || pagingCreditCard.getPage() < 0) {
			pagingCreditCard.setPage(1);
		}
		System.out.println(pagingCreditCard.getPage());
		// int pageInt = new Integer(pag.getPage());
		// if (pageInt < 1) {
		// pageInt = 1;
		// }
		if (pagingCreditCard.getPage() > pagingCreditCard.getPageCount() && pagingCreditCard.getPage() > 0
				&& pagingCreditCard.getPageCount() > 0) {
			pagingCreditCard.setPage(pagingCreditCard.getPageCount());
		}

		System.out.println("===================当前页号：" + pagingCreditCard.getPage() + "=======");
		List<CreditCard> creditCard = mccd.queryAllClientCardByFenYe(pagingCreditCard);
		return creditCard;
	}

	@Override
	public int updateApplyCardById(ApplyCard applyCard) {
		int updateApplyCard = mccd.updateApplyCardById(applyCard);
		return updateApplyCard;
	}

	@Override
	public int updateApplyCardPlanByIdCard(ApplyCardPlan applyCardPlan) {
		int updateApplyCardPlanByCard = mccd.updateApplyCardPlanByIdCard(applyCardPlan);
		return updateApplyCardPlanByCard;
	}

	@Override
	public int addCreditCardById(CreditCard creditCard) {
		int addCrditCard = mccd.addCreditCardById(creditCard);
		return addCrditCard;
	}

	@Override
	public int updateCreditCardRepairById(CreditCard creditCard) {
		int updateCreditCardRepair = mccd.updateCreditCardRepairById(creditCard);
		return updateCreditCardRepair;
	}

	@Override
	public int updateCreditCardRepairByCardId(CreditCard creditCard) {
		int updateCreditCardRepairCardId = mccd.updateCreditCardRepairByCardId(creditCard);
		return updateCreditCardRepairCardId;
	}

	// @Override
	// public int updateCreditCardRepairByClientId(int id) {
	// int updateCreditCardRepairByClientId=mccd.updateCreditCardRepairByCardId(id);
	// return 0;
	// }

	@Override
	/** 16.根据信用卡对象进行修改修改信用卡状态 */
	public int updateCreditCardByClientId(CreditCard creditCard) {
		int i = mccd.updateCreditCardByClientId(creditCard);
		return i;
	}

	@Override
	public ApplyCard queryClientApplyCardById(int id) {
		ApplyCard applyCard = mccd.queryClientApplyCardById(id);
		return applyCard;
	}

	@Override
	public CreditCard queryCreditCardById(Long id) {
		CreditCard creditCard=mccd.queryCreditCardById(id);
		return creditCard;
	}

	/*@Override
	public int udpateCreditCardLimit(CreditCard creditCard) {
		int resut=mccd.udpateCreditCardLimit(creditCard);
		return resut;
	}*/

}
