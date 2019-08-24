package com.zl.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zl.dao.clientdao.AgingClientDao;
import com.zl.pojo.business.Aging;
import com.zl.pojo.business.AgingMonth;
import com.zl.pojo.business.AgingRate;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.client.Client;
import com.zl.service.AgingClientService;
/**
 * 分期模块实现类
 * @author aaron
 *
 */
@Service
public class AgingClientServiceImpl implements AgingClientService {
	@Autowired
	private AgingClientDao acd;

	@Override
	public int addAging(Aging aging) {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date =new Date();
		//分期编号
		aging.setAgingNum(sdf.format(date));
		//分期日期
		aging.setAgingTime(date);
		//分期状态
		aging.setAgingState("未完结");
		//结束时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
	    calendar.add(Calendar.MONTH, aging.getAgingNper());
	    Date newTime=calendar.getTime();
		aging.setAgingEndTime(newTime);
		//添加
		System.out.println(aging+"aging对象。。。");
		int result= acd.addAging(aging);
		Aging ag=acd.queryAgingByNum(aging.getAgingNum());
		//同时生成分期详情表
		AgingMonth am=new AgingMonth();
		AgingRate rate= acd.queryAgingRate(aging.getAgingNper());
		for(int i=1;i<=aging.getAgingNper();i++) {
		//每期金额
		am.setMonthMoney(aging.getAgingLines().divide(new BigDecimal(aging.getAgingNper()),2,BigDecimal.ROUND_HALF_UP));
		//每期手续费
		am.setMonthInterest((aging.getAgingLines().multiply(new BigDecimal(rate.getAgingRate()))).divide(new BigDecimal(aging.getAgingNper()),2,BigDecimal.ROUND_HALF_UP));
		//当前期数
		am.setMonthNper(i);
		//分期还款状态
		am.setAgingRefund("未完结");
		//分期方式：按月分期
		am.setInstallments("按月分期");
		//分期类型
		am.setAgingType("账单分期");
		//概括表id
		am.setAging(ag.getId());
		//分期利率
		am.setAgingRate(rate.getAgingRate());
		acd.addAgingMonth(am);
		System.out.println(acd.queryAgingMonthByAging(ag.getId())+"循环"+rate.getAgingRate()+am);
		}
		System.out.println(acd.queryAgingMonthByAging(ag.getId())+"..............");
		return result;
	}

	@Override
	public List<Aging> queryAgingByClient(int client) {
		// TODO Auto-generated method stub
		return acd.queryAgingByClient(client);
	}

	@Override
	public List<AgingMonth> queryAgingMonthByAging(int Aging) {
		// TODO Auto-generated method stub
		return acd.queryAgingMonthByAging(Aging);
	}

	@Override
	public Client queryCreditPointByClientId(int clientId) {
		// TODO Auto-generated method stub
		return acd.queryCreditPointByClientId(clientId);
	}
/**
 * 添加分期详情
 */
	@Override
	public int addAgingMonth(AgingMonth am){
		return acd.addAgingMonth(am);
	}

@Override
public AgingRate queryAgingRate(int id) {
	// TODO Auto-generated method stub
	return acd.queryAgingRate(id);
}

@Override
public List<Client> queryClient() {
	// TODO Auto-generated method stub
	return acd.queryClient();
}

@Override
public List<CreditCard> queryCreditCard() {
	// TODO Auto-generated method stub
	return acd.queryCreditCard();
}



}
