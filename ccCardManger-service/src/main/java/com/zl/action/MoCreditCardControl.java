package com.zl.action;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zl.pojo.business.ApplyCard;
import com.zl.pojo.business.ApplyCardPlan;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.client.Client;
import com.zl.pojo.client.ClientCompany;
import com.zl.pojo.client.ClientLinkman;
import com.zl.pojo.mklFenYe.FenYeClientApplyCard;
import com.zl.pojo.mklFenYe.PagingCreditCard;
import com.zl.service.impl.MKLCreditCardServiceImpl;

@Controller
@RequestMapping("mo")
public class MoCreditCardControl {

	@Autowired
	private MKLCreditCardServiceImpl mccs;

	// 1.根据条件搜索查询所有信用卡用户
	@RequestMapping(value = "/queryAllCreditCard", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> queryAllCreditCard(Map<String, Object> map, HttpSession session,
			PagingCreditCard pagingCreditCard) {
		System.out.println(pagingCreditCard);
		List<CreditCard> creditCard = mccs.queryAllClientCardByFenYe(pagingCreditCard);
		Map<String, Object> resut = new HashMap<String, Object>();
		System.out.println(resut);
		System.out.println("来到控制台");
		resut.put("creditCard", creditCard);
		resut.put("pagingCreditCard", pagingCreditCard);
		System.out.println(creditCard);
		return resut;
	}

	// 2.添加信用卡
	@RequestMapping(value = "/addCreditCard", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCreditCard(CreditCard creditCard) {
		System.out.println("添加信用卡成功");
		Map<String, Object> addCard = new HashMap<String, Object>();
		ApplyCard applyCard = new ApplyCard();
		applyCard.setApplyState("发卡中");
		applyCard.setClient(new Integer(creditCard.getClient()));
		mccs.updateApplyCardById(applyCard);
		System.out.println("修改详情表进度为审核中");
		ApplyCardPlan applyCardPlan = new ApplyCardPlan();
		applyCardPlan.setPlanState("审核中");
		applyCardPlan.setClientId(new Integer(creditCard.getClient()));
		mccs.updateApplyCardPlanByIdCard(applyCardPlan);
		System.out.println("修改详进度表为发卡中");
		addCard.put("flag", "成功");
		int result = mccs.addCreditCardById(creditCard);
		System.out.println(result);
		addCard.put("flag", "成功");
		return addCard;
	}

	// 3.添加信用卡之前设定不变值
	@RequestMapping("/addCreditCardByApplyCard")
	@ResponseBody
	public Map<String, Object> addCreditCardByApplyCard(String id) {
		Map<String, Object> map = new HashMap<>();
		ApplyCard applyCard = mccs.queryClientApplyCardById(new Integer(id));
		Client client = mccs.queryClientById(new Integer(id));
		CreditCard creditCard = new CreditCard();
		creditCard.setCardPhone(client.getClientPhone());
		creditCard.setCardType(applyCard.getCardType());
		creditCard.setClient(applyCard.getClient());
		creditCard.setCardState("未激活");
		creditCard.setCardBinding(0);
		creditCard.setCardpoint(0);
		BigDecimal bigDecimal = new BigDecimal("0");
		creditCard.setCardBalance(bigDecimal);
		creditCard.setCardBillday("每月1号");
		creditCard.setCardRefundDay("隔月十号");
		/* 设置年费为480 */
		BigDecimal decimal = new BigDecimal("480");
		creditCard.setCardAnnual(decimal);
		/*
		 * System.out.println(creditCard); System.out.println("来到条件添加信用卡");
		 */
		map.put("creditCard", creditCard);
		return map;

	}

	// 4.激活事件
	@RequestMapping("/updateCreditCardJiHuoById")
	@ResponseBody
	public Map<String, Object> updateCreditCardById(String id) {
		Map<String, Object> map = new HashMap<>();
		long a = new Long(id).longValue();
		CreditCard creditCard = mccs.queryCreditCardById(a);
		System.out.println(creditCard);
		creditCard.setCardState("激活");
		creditCard.setClient(creditCard.getClient());
		int i = mccs.updateCreditCardByClientId(creditCard);
		if (i > 0) {
			map.put("flag", "激活成功");
		} else {
			map.put("flag", "激活失败");
		}
		return map;
	}

	// 5.冻结事件
	@RequestMapping("/updateCreditCardFreezeById")
	@ResponseBody
	public Map<String, Object> updateCreditCardFreezeById(String id) {
		Map<String, Object> map = new HashMap<>();
		long a = new Long(id).longValue();
		CreditCard creditCard = mccs.queryCreditCardById(a);
		creditCard.setCardState("冻结");
		creditCard.setClient(creditCard.getClient());
		int i = mccs.updateCreditCardByClientId(creditCard);
		if (i > 0) {
			map.put("flag", "冻结成功");
		} else {
			map.put("flag", "冻结失败");
		}
		return map;
	}

	// 6.解冻事件
	@RequestMapping("/updateCreditCardUnFreezeById")
	@ResponseBody
	public Map<String, Object> updateCreditCardUnFreezeById(String id) {
		Map<String, Object> map = new HashMap<>();
		long a = new Long(id).longValue();
		CreditCard creditCard = mccs.queryCreditCardById(a);
		creditCard.setCardState("激活");
		creditCard.setClient(creditCard.getClient());
		int i = mccs.updateCreditCardByClientId(creditCard);
		if (i > 0) {
			map.put("flag", "解冻成功");
		} else {
			map.put("flag", "解冻失败");
		}
		return map;
	}

	// 7.挂失事件
	@RequestMapping("/updateCreditCardLossById")
	@ResponseBody
	public Map<String, Object> updateCreditCardLossById(String id) {
		Map<String, Object> map = new HashMap<>();
		long a = new Long(id).longValue();
		CreditCard creditCard = mccs.queryCreditCardById(a);
		creditCard.setCardState("挂失");
		creditCard.setClient(creditCard.getClient());
		int i = mccs.updateCreditCardByClientId(creditCard);
		if (i > 0) {
			map.put("flag", "挂失成功");
		} else {
			map.put("flag", "挂失失败");
		}
		return map;
	}

	// 8.解挂事件
	@RequestMapping("/updateCreditCardUnLossById")
	@ResponseBody
	public Map<String, Object> updateCreditCardUnLossById(String id) {
		Map<String, Object> map = new HashMap<>();
		long a = new Long(id).longValue();
		System.out.println("激活成功");
		CreditCard creditCard = mccs.queryCreditCardById(a);
		creditCard.setCardState("激活");
		creditCard.setClient(creditCard.getClient());
		int i = mccs.updateCreditCardByClientId(creditCard);
		if (i > 0) {
			map.put("flag", "解挂成功");
		} else {
			map.put("flag", "解挂失败");
		}
		return map;
	}

	//9. 销卡事件
	@RequestMapping("/updateCreditCardPinCardById")
	@ResponseBody
	public Map<String, Object> updateCreditCardPinCardById(String id) {
		Map<String, Object> map = new HashMap<>();
		long a = new Long(id).longValue();
		CreditCard creditCard = mccs.queryCreditCardById(a);
		System.out.println(creditCard);
	     BigDecimal x = BigDecimal.valueOf(0.0); 
		BigDecimal y = creditCard.getCardBalance();
	/*	int i = creditCard.getClient();*/
		if (x.compareTo(y) == -1) {
			System.out.println("x小于y");
			map.put("flag", "销卡失败");
		}
		if (x.compareTo(y) == 0) {
			System.out.println("a等于b");
			creditCard.setCardState("销卡");
			map.put("flag", "销卡成功");
			creditCard.setClient(creditCard.getClient());
			mccs.updateCreditCardByClientId(creditCard);
		}
		if (x.compareTo(y) == 1) {
			System.out.println("a大于b");
			map.put("flag", "销卡失败");
		}
		System.out.println(map);
		return map;
	}

	@RequestMapping("/queryCreditCardById")
	//10. 根据卡号查看客户信息和信用卡信息
	@ResponseBody
	public Map<String, Object> queryCreditCardById(String id) {
		Map<String, Object> map = new HashMap<>();
		long a = new Long(id).longValue();
		System.out.println("来到根据id查看信用卡");
		CreditCard creditCard = mccs.queryCreditCardById(a);
		Client client = mccs.queryClientById(creditCard.getClient());
		map.put("creditCard", creditCard);
		map.put("client", client);
		System.out.println(creditCard+"---"+client);
		return map;
	}
	
	
	
	@RequestMapping("/updateCardByLimit")
	/**11.根据客户卡号修改信用卡额度*/
	@ResponseBody
	public Map<String, Object> updateCardByLimit(CreditCard creditCard) {
		Map<String, Object> map = new HashMap<>();
		System.out.println("来到根据卡号修改信用额度");
		int resut=mccs.udpateCreditCardLimit(creditCard);
		if(resut>0) {
			System.out.println("修改成功");
			map.put("flag", "修改成功");
		}else {
			System.out.println("修改失败");
			map.put("flag", "修改失败");
		}
		
		return map;
	}
	
	
	@RequestMapping("/updateCreditCardByClientIdcard")
	/**11.根据客户卡号修改支付密码*/
	@ResponseBody
	public Map<String, Object> updateCreditCardByClientIdcard(CreditCard creditCard) {
		Map<String, Object> map = new HashMap<>();
		System.out.println("来到根据身份证修改密码");	
		int resut=mccs.updateCreditCardByClientIdcard(creditCard);
		if(resut>0) {
			System.out.println("修改成功");
			map.put("flag", "修改成功");
		}else {
			System.out.println("修改失败");
			map.put("flag", "修改失败");
		}
		
		return map;
	}
}
