package com.zl.service.backstage;

import java.util.List;

import com.zl.pojo.Query;
import com.zl.pojo.business.Aging;
import com.zl.pojo.business.AgingMonth;
import com.zl.pojo.business.AgingRate;

/**
 * 分期模块Service层
 */
public interface AgingService {
	/**
	 * 一.分期概括
	 * 
	 * 1.查询所有用户分期信息
	 */
	public List<Aging> queryAllAging();
	
	/**
	 * 2.根据id查询用户分期信息
	 */
	public Aging queryAgingById(int id);
	
	/**
	 * 3.修改用户分期信息状态
	 */
	public int updateAging(Aging aging);
	
	/**
	 * 4.根据条件查询用户分期信息
	 */
	
	
	/**
	 * 二.分期详情
	 * 
	 * 1.根据id查询本月用户分期详情信息
	 */
	public List<AgingMonth> queryAllAgingMonthById(int id);
	
	
	/**
	 * 2.修改本月用户分期详情信息
	 */
	public int updateAgingMonth(AgingMonth agingMonth);
	
	
	/**
	 * 三.分期利率
	 * 
	 * 1.根据id查询分期利率
	 */
	public AgingRate queryAgingRateById(int id);
}
