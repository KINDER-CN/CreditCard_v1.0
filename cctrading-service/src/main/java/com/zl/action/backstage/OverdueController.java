package com.zl.action.backstage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.Query;
import com.zl.pojo.business.Aging;
import com.zl.pojo.business.AgingMonth;
import com.zl.pojo.business.AgingThree;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.business.Overdue;
import com.zl.pojo.client.Client;
import com.zl.service.AgingClientService;
import com.zl.service.backstage.AgingService;
import com.zl.service.backstage.BillService;
import com.zl.service.backstage.OverdueService;

@Controller
@Component
public class OverdueController {
	@Autowired
	private OverdueService os;
	@Autowired
	private AgingClientService acs;
	@Autowired
	private AgingService as;
	@Autowired
	private BillService bs;
	
	//1.查询所有用户逾期信息
	@RequestMapping("/queryAllOverdue")
	@ResponseBody
	public Map<String,Object> queryAllOverdue(){
		System.out.println("queryAllOverdue......................");
		Map<String,Object> map = new HashMap<String, Object>();
		List<Overdue> overdues = os.queryAllOverdue();
		List<Client> client = acs.queryClient();
		List<CreditCard> creditCards= acs.queryCreditCard();
		List<AgingThree> agingThree=new ArrayList<AgingThree>();
		for(int i=0;i<client.size();i++) {
			for(int y=0;y<creditCards.size();y++) {
				if(creditCards.get(y).getClient()==client.get(i).getId()) {
					for(int z=0;z<overdues.size();z++) {
						AgingThree at=new AgingThree();
						if(overdues.get(z).getCreditCard()==creditCards.get(y).getId()) {
							System.out.println(overdues.get(z));
							at.setId(overdues.get(z).getId());
							at.setClientName(client.get(i).getClientName());
							at.setClientIDcard(client.get(i).getClientIDcard());
							at.setCardNum(creditCards.get(y).getCardNum());
							at.setOverdueNum(overdues.get(z).getOverdueNum());
							at.setOverMoney(overdues.get(z).getOverMoney());
							at.setOverDate(overdues.get(z).getOverDate());
							at.setOverSPayDate(overdues.get(z).getOverSPayDate());
							at.setOverState(overdues.get(z).getOverState());
							at.setOverReturnDate(overdues.get(z).getOverReturnDate());
							at.setOverSPayMoney(overdues.get(z).getOverSPayMoney());
							agingThree.add(at);
						}
					}
				}
			}
		}
		System.out.println(agingThree);
		map.put("overdue", agingThree);
		return map;
	}
	
	//2.根据id查询用户逾期信息
	@RequestMapping("/queryOverdueById")
	@ResponseBody
	public Map<String,Object> queryOverdueById(int id) {
		System.out.println("queryOverdueById......................");
		Map<String,Object> map = new HashMap<String, Object>();
		Overdue overdueId=os.queryOverdueById(id);
		map.put("overdueId", overdueId);
		return map;
	}
	
	//3.修改用户逾期信息
	@RequestMapping("/updateOverdue")
	@ResponseBody
	public Map<String,Object> updateOverdue(Overdue overdue) {
		System.out.println("updateOverdue......................");
		Map<String,Object> map = new HashMap<String, Object>();
		int i = os.updateOverdue(overdue);
		if(i>0) {
			//说明修改成功
			map.put("code", "200");
			map.put("message", "用户逾期的信息修改成功");
			map.put("overdue", overdue);
		}else {
			//说明修改失败
			map.put("code", "400");
			map.put("message", "用户逾期的信息修改失败");
		}
		return map;
	}
	
	//4.添加用户逾期信息
	@RequestMapping("/addOverdue")
	@ResponseBody
	@Scheduled(cron="0 0 10 10 * ?")
	public Map<String,Object> addOverdue() {
		System.out.println("addOverdue......................");
		Map<String,Object> map = new HashMap<String, Object>();
		List<Aging> aging=as.queryAllAging();
		List<Client> Client= acs.queryClient();
		List<CreditCard> CreditCard=acs.queryCreditCard();
		
		Overdue overdue=new Overdue();
		for(Client c:Client) {
			for(CreditCard cc:CreditCard) {
				if(c.getId()==cc.getClient()) {
					for(Aging a:aging) {
						List<AgingMonth> agingMonth=as.queryAllAgingMonthById(a.getId());
						for(AgingMonth am:agingMonth) {
							if(a.getCreditCard()==cc.getId() && am.getAgingRefund().equals("未完结")) {
								overdue.setClientId(c.getId());
								//overdue.setClientId(1);
								overdue.setCreditCard(cc.getId());
								//overdue.setCreditCard(1);
								//逾期日期
								overdue.setOverDate(new Date());
								//逾期金额
								overdue.setOverMoney(am.getNotReturnMoney().multiply(new BigDecimal(0.0005).add(am.getNotReturnMoney())));
								//overdue.setOverMoney(new BigDecimal("1000.00"));
								
								//逾期编号
								overdue.setOverdueNum((int)Math.random()*10000);
								
								overdue.setOverReturnDate(new Date());
								//应还款日期
								overdue.setOverSPayDate(new Date());
								//应还款金额
								overdue.setOverSPayMoney(am.getMonthMoney());
								//overdue.setOverSPayMoney(new BigDecimal("5000.00"));
								
								//逾期状态
								overdue.setOverState("逾期");
								
							} 
						}
					}
				}
			}
		}
		os.addOverdue(overdue);
		System.out.println("overdue:"+overdue);
		map.put("overdue", overdue);
		return map;
	}
	
	//5.根据条件查询用户逾期信息
	@RequestMapping("/queryOverdueByLike")
	@ResponseBody
	public Map<String,Object> queryOverdueByLike(Query query) {
		System.out.println("queryOverdueByLike......................");
		Map<String,Object> map = new HashMap<String, Object>();
		Overdue overdueLike=os.queryOverdueByLike(query);
		map.put("overdueLike", overdueLike);
		return map;
	}
}
