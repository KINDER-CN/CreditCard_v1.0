package com.zl.dao.gu;

import java.util.List;

import com.zl.pojo.client.ClientBill;
import com.zl.pojo.htfenye.FenYe;
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
	 * 模糊查询所有卡种
	 */
	public List<CardType> queryCardTypeByLike(String cardName);
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
	/**
	 * 分页
	 */
	public List<CardType> fenYeCardType(FenYe fenYe);
	/**
	 * 分页总数
	 */
	public int fenYeAllCardType(FenYe fenYe);
}
