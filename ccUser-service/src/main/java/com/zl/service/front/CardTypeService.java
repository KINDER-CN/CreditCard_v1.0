package com.zl.service.front;

import java.util.List;

import com.zl.pojo.manger.CardType;

public interface CardTypeService {
	/**
	 * 查找所有卡种
	 */
	public List<CardType> queryAllProduce();
}
