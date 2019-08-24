package com.zl.action.backstage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.Query;
import com.zl.pojo.business.Aging;
import com.zl.pojo.business.AgingMonth;
import com.zl.pojo.business.AgingRate;
import com.zl.pojo.business.AgingThree;
import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.client.Client;
import com.zl.service.AgingClientService;
import com.zl.service.backstage.AgingService;
import com.zl.service.backstage.BillService;

import feign.Param;

/**
 * 分期模块控制层
 */

@Controller
@ResponseBody
public class AgingController {
	@Autowired
	private AgingService as;
	@Autowired
	private AgingClientService acs;
	@Autowired
	private BillService bs;
	
	
	//每隔2秒执行一次
    @Scheduled(cron="0 0 1 10 * ?")
	public Map<String,Object> aa(){
    	Map<String,Object> map = new HashMap<String, Object>();
		System.out.println("打死你！！！！");
		return map;
	}
    
    @Scheduled(cron="0 0 1 10 * ?")
   	public Map<String,Object> bb(){
       	Map<String,Object> map = new HashMap<String, Object>();
   		System.out.println("111111111111");
   		return map;
   	}
	
	//	一.分期概括
	//1.查询所有用户分期信息
	@RequestMapping(value="/queryAllAging")
	@ResponseBody
	public Map<String,Object> queryAllAging() {
		System.out.println("queryAllAging......................");
		Map<String,Object> map = new HashMap<String, Object>();
        List<Aging> agings=as.queryAllAging();
        
//        PageInfo<Aging> pageInfo = new PageInfo<Aging>(agings);
//        System.out.println("总记录数：" + pageInfo.getTotal());
//        System.out.println("当前页数：" + pageInfo.getPageNum());
//        System.out.println("每页数：" + pageInfo.getPageSize());
//        System.out.println("总页数：" + pageInfo.getPages());
//        System.out.println("结果集：" + pageInfo.getList());
//        System.out.println("123：" + pageInfo.getNextPage());
        
		List<Client> client = acs.queryClient();
		List<CreditCard> creditCards= acs.queryCreditCard();
		List<AgingThree> agingThree=new ArrayList<AgingThree>();
		for(int i=0;i<client.size();i++) {
			for(int y=0;y<creditCards.size();y++) {
				if(creditCards.get(y).getClient()==client.get(i).getId()) {
					for(int z=0;z<agings.size();z++) {
						AgingThree at=new AgingThree();
						if(agings.get(z).getCreditCard()==creditCards.get(y).getId()) {
							//System.out.println(agings.get(z));
							at.setId(client.get(i).getId());
							at.setClientName(client.get(i).getClientName());
							at.setClientIDcard(client.get(i).getClientIDcard());
							at.setCardNum(creditCards.get(y).getCardNum());
							at.setAgingNum(agings.get(z).getAgingNum());
							at.setAgingLines(agings.get(z).getAgingLines());
							at.setAgingNper(agings.get(z).getAgingNper());
							at.setAgingTime(agings.get(z).getAgingTime());
							at.setAgingRate(agings.get(z).getAgingRate());
							at.setAgingState(agings.get(z).getAgingState());
							at.setAgingEndTime(agings.get(z).getAgingEndTime());
							at.setCreditCard(agings.get(z).getCreditCard());
							at.setClient(agings.get(z).getClient());
							agingThree.add(at);
						}
					}
				}
			}
		}
		//System.out.println(agingThree);
		//map.put("pageInfo", pageInfo);
		map.put("agingThree", agingThree);
		return map;
	}
	
	//2.根据id查询用户分期信息
	@RequestMapping("/queryAgingById")
	@ResponseBody
	public Map<String,Object> queryAgingById(Aging aging,int id){
		System.out.println("queryAgingById......................");
		Map<String,Object> map = new HashMap<String, Object>();
		aging=as.queryAgingById(id);
		map.put("agingsId", aging);
		return map;
	}
	
	//3.修改用户分期信息状态
	@RequestMapping("/updateAging")
	@ResponseBody
	public Map<String,Object> updateAging(Aging aging,int id){
		System.out.println("updateAging......................");
		Map<String,Object> map = new HashMap<String, Object>();
		int i = as.updateAging(aging);
		if(i>0) {
			//说明修改成功
			map.put("code", "200");
			map.put("message", "用户分期的信息修改成功");
			map.put("aging", aging);
		}else {
			//说明修改失败
			map.put("code", "400");
			map.put("message", "用户分期的信息修改失败");
		}
		return map;
	}
	
	//4.根据条件查询用户分期信息
	@RequestMapping("/queryAgingByLike")
	@ResponseBody
	public Map<String,Object> queryAgingByLike(Query query,
			@RequestParam(required=true,value="pageNum",defaultValue="1") Integer pageNum,
			@RequestParam(required=true,value="pageSize",defaultValue="15") Integer pageSize){
		System.out.println("queryAgingByLike......................");
		Map<String,Object> map = new HashMap<String, Object>();
		
	        
			List<Client> client = acs.queryClient();
			List<CreditCard> creditCards= acs.queryCreditCard();
			List<AgingThree> agingThree=new ArrayList<AgingThree>();
			/*for(int i=0;i<client.size();i++) {
				for(int y=0;y<creditCards.size();y++) {
					if(creditCards.get(y).getClient()==client.get(i).getId()) {
						for(int z=0;z<agings.size();z++) {
							AgingThree at=new AgingThree();
							if(agings.get(z).getCreditCard()==creditCards.get(y).getId()) {
								System.out.println(agings.get(z));
								at.setId(client.get(y).getId());
								at.setClientName(client.get(i).getClientName());
								at.setClientIDcard(client.get(i).getClientIDcard());
								at.setCardNum(creditCards.get(y).getCardNum());
								at.setAgingNum(agings.get(z).getAgingNum());
								at.setAgingLines(agings.get(z).getAgingLines());
								at.setAgingNper(agings.get(z).getAgingNper());
								at.setAgingTime(agings.get(z).getAgingTime());
								at.setAgingRate(agings.get(z).getAgingRate());
								at.setAgingState(agings.get(z).getAgingState());
								at.setAgingEndTime(agings.get(z).getAgingEndTime());
								at.setCreditCard(agings.get(z).getCreditCard());
								at.setClient(agings.get(z).getClient());
								agingThree.add(at);
							}
						}
					}
				}
			}*/
		
		return map;
	}
	
	
	//	二.分期详情
	//1.根据id查询本月用户分期详情信息
	@RequestMapping("/queryAllAgingMonthById")
	@ResponseBody
	public Map<String,Object> queryAllAgingMonthById(int id) {
		System.out.println("queryAllAgingMonthById......................");
		Map<String,Object> map = new HashMap<String, Object>();
		List<AgingMonth> agingMonths = as.queryAllAgingMonthById(id);
		map.put("agingMonths", agingMonths);
		System.out.println(agingMonths);
		System.out.println(id);
		return map;
	}
	
	//2.修改本月用户分期详情信息
	@RequestMapping("/updateAgingMonth")
	@ResponseBody
	public Map<String,Object> updateAgingMonth(AgingMonth agingMonth){
		System.out.println("updateAgingMonth......................");
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<BillDetails> billDetails=bs.queryBillDetails();
		List<Aging> aging =as.queryAllAging();
		for(int i=0;i<billDetails.size();i++) {
			for(int y=0;y<aging.size();y++) {
				if(aging.get(y).getId()==billDetails.get(i).getAging() && aging.get(y).getId()==agingMonth.getAging()) {
					if(billDetails.get(i).getTransactionMoney().compareTo(agingMonth.getMonthMoney())==1 || billDetails.get(i).getTransactionMoney().compareTo(agingMonth.getMonthMoney())==0) {
						agingMonth.setAgingRefund("已还完");
						agingMonth.setAging(aging.get(y).getId());
					}else {
						agingMonth.setAgingRefund("未还");
						agingMonth.setAging(aging.get(y).getId());
						//未还分期金额
						agingMonth.setNotReturnMoney(agingMonth.getMonthMoney().multiply(agingMonth.getMonthInterest()).add(agingMonth.getMonthMoney()).subtract(agingMonth.getReturnMoney()));
					}
				}
			}
		}
		int i = as.updateAgingMonth(agingMonth);
		if(i>0) {
			//说明修改成功
			map.put("code", "200");
			map.put("message", "本月用户分期的详情信息修改成功");
			map.put("agingMonth", agingMonth);
		}else {
			//说明修改失败
			map.put("code", "400");
			map.put("message", "本月用户分期的详情信息修改失败");
		}
		return map;
	}
	
	//	三.分期利率
	//1.根据id查询分期利率
	@RequestMapping("/queryAgingRateById")
	@ResponseBody
	public Map<String,Object> queryAgingRateById(int id) {
		System.out.println("queryAgingRateById......................");
		Map<String,Object> map = new HashMap<String, Object>();
		AgingRate agingRate=as.queryAgingRateById(id);
		map.put("agingRate", agingRate);
		return map;
	}
}
