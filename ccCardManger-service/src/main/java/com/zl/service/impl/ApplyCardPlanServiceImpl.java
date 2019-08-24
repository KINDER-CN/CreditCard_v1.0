package com.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.ApplyCardPlanDao;
import com.zl.pojo.business.ApplyCardPlan;
import com.zl.pojo.manger.CardType;
import com.zl.service.ApplyCardPlanService;

@Service
public class ApplyCardPlanServiceImpl implements ApplyCardPlanService {
	@Autowired
	private ApplyCardPlanDao acpd;

	public CardType selectCardTypeById(int id) {
		return acpd.selectCardTypeById(id);
	}

	public int handleCreditCard(ApplyCardPlan acp) {
		return acpd.handleCreditCard(acp);
	}

}
