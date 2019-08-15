package com.zl.service.front;

import java.util.List;

import com.zl.pojo.business.ApplyCardPlan;

/**
 * 卡片申请服务
 * @author KINDER
 *
 */
public interface ApplyCardService {
	/**
	 * 申请信用卡进度查询
	 */
	public List<ApplyCardPlan> queryCardPlanByIDCard(String IDcard);
}
