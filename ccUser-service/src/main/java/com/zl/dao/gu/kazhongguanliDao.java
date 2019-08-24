package com.zl.dao.gu;

import java.util.List;

import com.zl.pojo.manger.CardType;

/**
 * 卡种管理模块
 */
public interface kazhongguanliDao {
	/**
	 * 查询所有卡种
	 */
	public List<CardType> queryAllCardType();
	/**
	 * 查询该卡种
	 */
	public CardType queryCardTypeById(int id);
	/**
	 * 修改卡种
	 */
	public int updateCardType(CardType cardType);
	/**
	 * 增加卡种
	 */
	public int insertCardType(CardType cardType);
	/**
	 * 删除卡种
	 */
	public int deleteCardTypeById(int id);
}
