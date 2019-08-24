package com.zl.service.backstage;

import java.util.List;

import com.zl.pojo.Query;
import com.zl.pojo.business.Overdue;

/**
 * 逾期模块Service层
 */
public interface OverdueService {
	/**
	 * 1.查询所有用户逾期信息
	 */
	public List<Overdue> queryAllOverdue();
	
	/**
	 * 2.根据id查询用户逾期信息
	 */
	public Overdue queryOverdueById(int id);
	
	/**
	 * 3.修改用户逾期信息
	 */
	public int updateOverdue(Overdue overdue);
	
	/**
	 * 4.添加用户逾期信息
	 */
	public int addOverdue(Overdue overdue);
	
	/**
	 * 5.根据条件查询用户逾期信息
	 */
	public Overdue queryOverdueByLike(Query query);
}
