package com.zl.action;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.business.CardRemove;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.client.Client;
import com.zl.service.CardRemoveService;
import com.zl.service.ClientService;
import com.zl.service.CreditCardService;

//销卡申请
@Controller
public class CardRemoveController {
	@Autowired
	private CardRemoveService crs;
	@Autowired
	private CreditCardService ccs;
	@Autowired
	private ClientService cs;
	
	@GetMapping("/cancelCreditCard")
	@ResponseBody
	public Map<String, Object> cancelCreditCard(CardRemove cr, String clientIDcard,
			Long clientPhone) {
		System.out.println("销卡............................"+cr.getId());
		Map<String, Object> map=new HashMap<String, Object>();
		CreditCard cc=ccs.selectCreditCardById(cr.getId());
		Client client=cs.selectClientById(cc.getClient());
		System.out.println(cc);
		if(!client.getClientIDcard().equals(clientIDcard)) {
			System.out.println("身份证号码错误！...........................");
			map.put("msg1", "身份证号码错误！");
		}else if(cc.getCardPhone()!=clientPhone) {
			System.out.println("手机号码错误！...........................");
			map.put("msg2", "手机号码错误！");
		}else if(cc.getCardBalance().equals(BigDecimal.ZERO)) {
			System.out.println("卡上还有余额，不能销卡！...........");
			map.put("no", 400);
		}else if(cc.getCardpoint()!=0) {
			System.out.println("卡上还有欠款，不能销卡！...........");
			map.put("no", "401");
		}else {
			int removeApplyNum=new Random().nextInt(99999);
			cr.setRemoveApplyNum("A"+removeApplyNum);
			cr.setRemoveTime(new Date());
			cr.setClientId(cc.getClient());
			cc.setCardState("销卡");
			ccs.updateCreditCardState(cc);
			crs.cancelCreditCard(cr);
			System.out.println(cr);
			map.put("cc", cc);
			map.put("client", client);
			map.put("ok", 200);
			System.out.println("销卡成功........................");
		}
		return map;
	}
}
