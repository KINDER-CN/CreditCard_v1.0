package com.zl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.CreditCardDao;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.manger.CardType;
import com.zl.service.CreditCardService;

@Service
public class CreditCardServiceImpl implements CreditCardService {
	@Autowired
	private CreditCardDao ccd;

	@Override
	public int updateCreditCardState(CreditCard cc) {
		return ccd.updateCreditCardState(cc);
	}

	@Override
	public CreditCard selectCreditCardById(int id) {
		return ccd.selectCreditCardById(id);
	}

	@Override
	public List<CreditCard> selectAllCreditCard(int clientId) {
		return ccd.selectAllCreditCard(clientId);
	}

	@Override
	public int updateCreditCardPassword(CreditCard cc) {
		return ccd.updateCreditCardPassword(cc);
	}

	@Override
	public int setCreditCardPassword(CreditCard cc) {
		return ccd.setCreditCardPassword(cc);
	}

	@Override
	public List<CardType> selectAllCardType() {
		return ccd.selectAllCardType();
	}
	
}
