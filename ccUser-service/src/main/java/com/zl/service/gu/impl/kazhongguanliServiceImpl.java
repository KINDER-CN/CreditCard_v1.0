package com.zl.service.gu.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.gu.kazhongguanliDao;
import com.zl.pojo.manger.CardType;
import com.zl.service.gu.kazhongguanliService;
@Service
public class kazhongguanliServiceImpl implements kazhongguanliService {
	@Autowired
	public kazhongguanliDao kd;
	@Override
	public int updateCardType(CardType cardType) {
		int i=kd.updateCardType(cardType);
		return i;
	}

	@Override
	public int insertCardType(CardType cardType) {
		int i=kd.insertCardType(cardType);
		return i;
	}

	@Override
	public int deleteCardTypeById(int id) {
		int i=kd.deleteCardTypeById(id);
		return i;
	}
	@Override
	public CardType queryCardTypeById(int id) {
		return kd.queryCardTypeById(id);
	}

	@Override
	public List<CardType> queryAllCardType() {
		return kd.queryAllCardType();
	}

}
