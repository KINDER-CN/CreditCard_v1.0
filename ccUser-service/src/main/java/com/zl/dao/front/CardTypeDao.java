package com.zl.dao.front;

import java.util.List;

import com.zl.pojo.manger.CardType;

/**
 * 卡种表持久层接口
 * @author KINDER
 *
 */
public interface CardTypeDao {
/**
 * 查找所有的卡种
 */
	public List<CardType> queryAllProduce(int pageNum);
	/**
	 * 查询总条数
	 */
	public int queryCountProduce();
}
