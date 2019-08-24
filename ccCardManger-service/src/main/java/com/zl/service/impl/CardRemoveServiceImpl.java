package com.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.CardRemoveDao;
import com.zl.pojo.business.CardRemove;
import com.zl.service.CardRemoveService;

@Service
public class CardRemoveServiceImpl implements CardRemoveService {
	@Autowired
	private CardRemoveDao crd;
	
	public int cancelCreditCard(CardRemove cr) {
		return crd.cancelCreditCard(cr);
	}

}
