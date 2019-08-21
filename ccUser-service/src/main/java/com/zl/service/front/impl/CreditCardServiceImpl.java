package com.zl.service.front.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.front.CreditCardDao;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.business.CreditCardModel;
import com.zl.service.front.CreditCardService;
@Service
public class CreditCardServiceImpl implements CreditCardService {
	@Autowired
	private CreditCardDao ccd;
	@Override
	public int updateCreditCardOnBinding(CreditCard creditCard) {
		return ccd.updateCreditCardOnBinding(creditCard);
	}
	
	@Override
	public int addCreditCard(CreditCardModel creditCard) {
		return ccd.addCreditCard(creditCard);
	}

	@Override
	public CreditCardModel queryBankCardByNum(CreditCard creditCard) {
		
		return ccd.queryBankCardByNum(creditCard);
	}

	@Override
	public CreditCard queryCardPhone(CreditCard creditCard) {
		
		return ccd.quertCardPhone(creditCard);
	}

	@Override
	public CreditCard queryCardByid(int id) {
		return ccd.queryCardByid(id);
	}

}
