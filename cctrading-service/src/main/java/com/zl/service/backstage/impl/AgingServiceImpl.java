package com.zl.service.backstage.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.backstage.AgingDao;
import com.zl.pojo.Query;
import com.zl.pojo.business.Aging;
import com.zl.pojo.business.AgingMonth;
import com.zl.pojo.business.AgingRate;
import com.zl.service.backstage.AgingService;

@Service
public class AgingServiceImpl implements AgingService{
	@Autowired
	private AgingDao ad;
	
	@Override
	public List<Aging> queryAllAging() {
		/*//使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);*/
        // 获取
        //List<Aging> agingList = ad.queryAllAging();
		return ad.queryAllAging();
	}

	@Override
	public Aging queryAgingById(int id) {
		return ad.queryAgingById(id);
	}

	@Override
	public int updateAging(Aging aging) {
		AgingMonth am=new AgingMonth();
		if(am.getAgingRefund().equals("已还完")) {
			aging.setAgingState("已还完");
		}
		return ad.updateAging(aging);
	}


	@Override
	public List<AgingMonth> queryAllAgingMonthById(int id) {
		return ad.queryAllAgingMonthById(id);
	}

	@Override
	public int updateAgingMonth(AgingMonth agingMonth) {
		return ad.updateAgingMonth(agingMonth);
	}

	@Override
	public AgingRate queryAgingRateById(int id) {
		return ad.queryAgingRateById(id);
	}


	
}
