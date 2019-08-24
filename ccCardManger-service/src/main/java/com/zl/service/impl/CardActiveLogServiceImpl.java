package com.zl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.CardActiveLogDao;
import com.zl.pojo.business.CardActiveLog;
import com.zl.service.CardActiveLogService;

@Service
public class CardActiveLogServiceImpl implements CardActiveLogService {
	@Autowired
	private CardActiveLogDao cald;
	
	public int activateCreditCard(CardActiveLog cal) {
		return cald.activateCreditCard(cal);
	}

}
