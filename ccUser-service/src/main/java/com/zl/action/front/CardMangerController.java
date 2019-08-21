package com.zl.action.front;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.dao.front.ClientDao;
import com.zl.pojo.business.ApplyCardPlan;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.business.CreditCardModel;
import com.zl.pojo.client.Client;
import com.zl.service.front.ApplyCardService;
import com.zl.service.front.CreditCardService;
import com.zl.util.MD5Util;

@Controller
@RequestMapping("/creditCard")
public class CardMangerController {
	@Autowired
	private ApplyCardService acs;
	@Autowired
	private CreditCardService ccs;
	/**
	 * 查询申请信用卡进度控制器
	 * @param IDcard
	 * @return
	 */
	@RequestMapping("/queryPlan")
	@ResponseBody
	public Map<String,Object> findPlan(@RequestBody String IDcard){
		System.out.println(IDcard);
		IDcard=IDcard.substring(0,18);
		Map<String,Object> result=new HashMap<String,Object>();
		List<ApplyCardPlan> plan =acs.queryCardPlanByIDCard(IDcard);
		System.out.println(plan);
		result.put("plan", plan);
		return result;		
	}
	/**
	 * 修改签约状态
	 */
	@RequestMapping("/updateCardBinding")
	@ResponseBody
	public Map<String,Object> updateCardBinding(int id){
		Map<String,Object> result=new HashMap<String,Object>();
		CreditCard creditCard = ccs.queryCardByid(id);
		if(creditCard.getCardBinding()==0) {
			creditCard.setCardBinding(1);
		}else {
			creditCard.setCardBinding(0);
		}
		int line=ccs.updateCreditCardOnBinding(creditCard);
		if(line>0) {
			result.put("flag", true);
		}else {
			result.put("flag", false);
		}
		return result;
	}
	/**
	 * 绑定信用卡
	 */
	@Autowired 
 	private ClientDao cd;
	
	@RequestMapping("/addBindingCard")
	@ResponseBody
	public Map<String,Object> addBindingCard(@RequestBody CreditCard creditCard,HttpSession session){
		Map<String,Object> result=new HashMap<String,Object>();
		Client client = (Client) session.getAttribute("client");
		System.out.println(client);
		//绑定信用卡
		CreditCardModel newCreditCard=ccs.queryBankCardByNum(creditCard);
		newCreditCard.setCardBinding(1);
		newCreditCard.setClient(client.getId());
		//newCreditCard.setCardpoint(client.getCreditPoint());
		newCreditCard.setCarPassword(MD5Util.MD5(newCreditCard.getCarPassword()));
		//修改用户信息
		client.setClientName(newCreditCard.getUserName());
		client.setClientIDcard(newCreditCard.getIDcard());
		client.setCreditPoint(newCreditCard.getCardpoint());
		String s="CC00"+client.getId();
		client.setClientId(s);
		System.out.println(newCreditCard);
		if(newCreditCard!=null) {
			if(ccs.queryCardPhone(creditCard)!=null) {
				if(ccs.addCreditCard(newCreditCard)>=1) {
					result.put("flag", true);
					
					if(cd.updateClient(client)>=1) {
						session.setAttribute("client", client);
					}
				}else{
					result.put("flag", false);
					result.put("mess", "绑定失败");
				}	
			}else {
				result.put("flag", false);
				result.put("mess", "电话号码不正确");
			}
		}
		return result;
	}
	/**
	 * 查询信用卡
	 */
	@RequestMapping("/queryBankCard")
	@ResponseBody
	public Map<String,Object> queryBankCard (@RequestBody CreditCard creditCard){
		Map<String,Object> result=new HashMap<String,Object>();
		CreditCardModel newCreditCard=ccs.queryBankCardByNum(creditCard);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(newCreditCard!=null) {
			result.put("name", newCreditCard.getUserName());
			result.put("idcard", newCreditCard.getIDcard());
			result.put("day", sdf.format(newCreditCard.getCardValidity()));
			result.put("num", newCreditCard.getLastThree());
			result.put("bankCard", "CCMS银行信用卡");
		}else {
			result.put("bankCard", "此卡号非本行信用卡，请重新输入");
		}
		return result;
	}
}
