package com.zl.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.business.CardActiveLog;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.client.Client;
import com.zl.service.CardActiveLogService;
import com.zl.service.ClientService;
import com.zl.service.CreditCardService;

//开卡申请
@Controller
public class CardActiveLogController {
	@Autowired
	private CardActiveLogService cals;
	@Autowired
	private CreditCardService ccs;
	@Autowired
	private ClientService cs;

	@RequestMapping("/activateCreditCard")
	@ResponseBody
	public Map<String, Object> activateCreditCard(CardActiveLog cal, String clientIDcard,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date cardValidity,
			Long clientPhone, int cardSecurityCode) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> map = new HashMap<String, Object>();
		CreditCard cc = ccs.selectCreditCardById(cal.getId());
		Client client = cs.selectClientById(cc.getClient());
		String strDate1 = sdf.format(cardValidity);
		Date date = cc.getCardValidity();
		String strDate2 = sdf.format(date);
		System.out.println(strDate1+".................."+strDate2);
		System.out.println(cc);
		System.out.println(client);
		try {
			Date cardValidity1 = sdf.parse(strDate1);
			Date cardValidity2 = sdf.parse(strDate2);
			if (cc.getCardState().equals("未激活")) {
				System.out.println("激活信用卡.........................." + cal.getId());
				if (!client.getClientIDcard().equals(clientIDcard)) {
					System.out.println("身份证号码错误！...........................");
					map.put("msg1", "*身份证号码错误！");
				} else if (cardValidity1.getTime() != cardValidity2.getTime()) {
					System.out.println("有效期错误！...........................");
					map.put("msg2", "*有效期错误！");
				} else if (cc.getCardSecurityCode() != cardSecurityCode) {
					System.out.println("安全码错误！...........................");
					map.put("msg3", "*安全码错误！");
				} else if (cc.getCardPhone() != clientPhone) {
					System.out.println("手机号码错误！...........................");
					map.put("msg4", "*手机号码错误！");
				} else {
					int activNum = new Random().nextInt(99999);
					cal.setActivNum("A" + activNum);
					cal.setActivApplyTime(new Date());
					cal.setClientId(cc.getClient());
					cc.setCardState("激活");
					ccs.updateCreditCardState(cc);
					cals.activateCreditCard(cal);
					map.put("cc", cc);
					map.put("ok", "200");
					System.out.println(cc);
					System.out.println(cal);
					System.out.println("信用卡激活成功..............................");
				}
			} else {
				map.put("no", "400");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return map;
	}
}
