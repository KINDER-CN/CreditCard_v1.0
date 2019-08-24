package com.zl.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.business.CreditCard;
import com.zl.pojo.client.Client;
import com.zl.service.ClientService;
import com.zl.service.CreditCardService;
import com.zl.service.ReportLossCreditCardService;

//挂失
@Controller
public class ReportLossCreditCardController {
	@Autowired
	private ReportLossCreditCardService rlccs;
	@Autowired
	private CreditCardService ccs;
	@Autowired
	private ClientService cs;
	@GetMapping("/reportLossCreditCard")
	@ResponseBody
	public Map<String, Object> reportLossCreditCard(int id, String clientIDcard, 
			Long clientPhone) {
		System.out.println("挂失......................."+id);
		System.out.println(clientIDcard+"......."+clientPhone);
		Map<String, Object> map=new HashMap<String, Object>();
		CreditCard creditCard=ccs.selectCreditCardById(id);
		Client client=cs.selectClientById(creditCard.getClient());
		if(creditCard.getCardState().equals("激活")) {
			if(!client.getClientIDcard().equals(clientIDcard)) {
				System.out.println("身份证号码错误！..................");
				map.put("msg1", "*身份证号码错误！");
			}else if(creditCard.getCardPhone()!=clientPhone) {
				System.out.println("手机号码错误！..................");
				map.put("msg2", "*手机号码错误！");
			}else {
				creditCard.setCardState("挂失");
				System.out.println(creditCard);
				rlccs.reportLossCreditCard(creditCard);
				map.put("creditCard", creditCard);
				map.put("ok", 200);
			}
		}else {
			map.put("no", 400);
		}
		return map;
	}
	
	@GetMapping("/creditCardLossUnregister")
	@ResponseBody
	public Map<String, Object> creditCardLossUnregister(int id, String clientIDcard, 
			Long clientPhone) {
		System.out.println("解挂......................."+id);
		System.out.println(clientIDcard+"......."+clientPhone);
		Map<String, Object> map=new HashMap<String, Object>();
		CreditCard creditCard=ccs.selectCreditCardById(id);
		Client client=cs.selectClientById(creditCard.getClient());
		if(creditCard.getCardState().equals("挂失")) {
			if(!client.getClientIDcard().equals(clientIDcard)) {
				System.out.println("身份证号码错误！..................");
				map.put("msg1", "*身份证号码错误！");
			}else if(creditCard.getCardPhone()!=clientPhone) {
				System.out.println("手机号码错误！..................");
				map.put("msg2", "*手机号码错误！");
			}else {
				creditCard.setCardState("激活");
				System.out.println(creditCard);
				rlccs.creditCardLossUnregister(creditCard);
				System.out.println("解挂成功！......................");
				map.put("creditCard", creditCard);
				map.put("ok", 200);
			}
		}else {
			System.out.println("解挂失败！......................");
			map.put("no", 400);
		}
		return map;
	}
}
