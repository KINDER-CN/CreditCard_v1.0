package com.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.ReportLossCreditCardDao;
import com.zl.pojo.business.CreditCard;
import com.zl.service.ReportLossCreditCardService;

@Service
public class ReportLossCreditCardServiceImpl implements ReportLossCreditCardService {
	@Autowired
	private ReportLossCreditCardDao rccd;
	
	@Override
	public int reportLossCreditCard(CreditCard creditCard) {
		return rccd.reportLossCreditCard(creditCard);
	}

	@Override
	public int creditCardLossUnregister(CreditCard creditCard) {
		return rccd.creditCardLossUnregister(creditCard);
	}

}
