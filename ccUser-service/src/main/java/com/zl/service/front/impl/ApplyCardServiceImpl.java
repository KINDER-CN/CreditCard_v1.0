package com.zl.service.front.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.front.ApplyCardPlanDao;
import com.zl.pojo.business.ApplyCardPlan;
@Service
public class ApplyCardServiceImpl implements com.zl.service.front.ApplyCardService {
	@Autowired
	private ApplyCardPlanDao acpd;
	@Override
	public List<ApplyCardPlan> queryCardPlanByIDCard(String IDcard) {
		return acpd.queryCardPlanByIDCard(IDcard);
	}
}
