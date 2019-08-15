package com.zl.dao.front;

import java.util.List;

import com.zl.pojo.business.ApplyCardPlan;

/**
 * 信用卡申请进度
 * @author KINDER
 *
 */
public interface ApplyCardPlanDao {
	public List<ApplyCardPlan> queryCardPlanByIDCard(String IDcard);
}
