package com.zl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.business.CreditCard;
import com.zl.pojo.business.Password;
import com.zl.pojo.business.ShowCard;
import com.zl.pojo.client.Client;
import com.zl.pojo.manger.CardType;
import com.zl.service.CreditCardService;

//修改交易密码与设置密码
@Controller
public class CreditCardController {
	@Autowired
	private CreditCardService ccs;

	//根据信用卡id查询信用卡
	@RequestMapping("/selectCreditCardById")
	@ResponseBody
	public Map<String, Object> selectCreditCardById(int id, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("根据id查询行用卡...................");
		Client client = (Client) session.getAttribute("client");
		System.out.println(client);
		CreditCard cc = ccs.selectCreditCardById(id);
		List<ShowCard> scs = new ArrayList<ShowCard>();
		List<CardType> lcts = ccs.selectAllCardType();
		for (CardType cardType : lcts) {
			if (cc.getCardType() == cardType.getId()) {
				ShowCard sc = new ShowCard();
				sc.setCardType(cardType.getCardName());
				sc.setCardNum(cc.getCardNum());
				sc.setId(cc.getId());
				sc.setCardState(cc.getCardState());
				scs.add(sc);
			}
		}
		System.out.println(cc);
		System.out.println(scs);
		map.put("name", client.getClientName());
		map.put("cc", cc);
		map.put("scs", scs);
		return map;
	}

	//根据用户id查询所有信用卡
	@RequestMapping("/selectAllCreditCard")
	@ResponseBody
	public Map<String, Object> selectAllCreditCard(HttpSession session) {
		System.out.println("查询所有信用卡........................");
		Map<String, Object> map = new HashMap<String, Object>();
		//从session中获取用户信息
		Client client = (Client) session.getAttribute("client");
		System.out.println(client);
		if(client!=null) {
			List<ShowCard> scs = new ArrayList<ShowCard>();
			List<CreditCard> lcs = ccs.selectAllCreditCard(client.getId());
			List<CardType> lcts = ccs.selectAllCardType();
			for (CreditCard creditCard : lcs) {
				for (CardType cardType : lcts) {
					if (creditCard.getCardType() == cardType.getId()) {
						ShowCard sc = new ShowCard();
						sc.setCardType(cardType.getCardName());
						sc.setCardNum(creditCard.getCardNum());
						sc.setId(creditCard.getId());
						sc.setCardState(creditCard.getCardState());
						scs.add(sc);
					}
				}
			}
			map.put("lcs", lcs);
			map.put("scs", scs);
			map.put("name", client.getClientName());
			System.out.println(lcs);
			System.out.println(scs);
		}
		return map;
	}


	//根据信用卡id修改交易密码
	@PostMapping("/updateCreditCardPassword")
	@ResponseBody
	public Map<String, Object> updateCreditCardPassword(@RequestBody Password pad) {
		System.out.println(pad);
		Map<String, Object> map = new HashMap<String, Object>();
		CreditCard cc = ccs.selectCreditCardById(pad.getId());
		System.out.println(cc);
		if (cc.getCarPassword().length() > 0) {
			System.out.println("修改交易密码........................" + pad.getId());
			if (!cc.getCarPassword().equals(pad.getOldCarPassword())) {
				System.out.println("原交易密码错误！........................");
				map.put("msg1", "*原交易密码错误！");
			} else if (cc.getCarPassword().equals(pad.getNewCarPassword())) {
				System.out.println("新交易密码与原交易密码相同！..................");
				map.put("msg2", "*新交易密码与原交易密码相同！");
			} else if (!pad.getNewCarPassword().equals(pad.getConfirmNewCarPassword())) {
				System.out.println("确定新交易密码与新交易密码不一致！................");
				map.put("msg3", "*确定新交易密码与新交易密码不一致！");
			} else if (cc.getCardPhone() != pad.getCardPhone()) {
				System.out.println("手机号码与预留手机号码不一致！...............");
				map.put("msg4", "*手机号码与预留手机号码不一致！");
			} else {
				cc.setCarPassword(pad.getNewCarPassword());
				ccs.updateCreditCardPassword(cc);
				System.out.println("交易密码修改成功！...................." + cc.getCarPassword());
				map.put("ok", 200);
			}
		} else {
			System.out.println("交易密码修改失败！该信用卡未设置密码！");
			map.put("no", 400);
		}
		return map;
	}

	//根据信用卡id设置交易密码
	@PostMapping("/setCreditCardPassword")
	@ResponseBody
	public Map<String, Object> setCreditCardPassword(@RequestBody Password pad) {
		System.out.println(pad);
		Map<String, Object> map = new HashMap<String, Object>();
		CreditCard cc = ccs.selectCreditCardById(pad.getId());
		System.out.println(cc);
		if (cc.getCarPassword().length() == 0) {
			System.out.println("修改交易密码........................" + pad.getId());
			if (!pad.getNewCarPassword().equals(pad.getConfirmNewCarPassword())) {
				System.out.println("确定新交易密码与新交易密码不一致！................");
				map.put("msg1", "*确定新交易密码与新交易密码不一致！");
			} else if (cc.getCardPhone() != pad.getCardPhone()) {
				System.out.println("手机号码与预留手机号码不一致！...............");
				map.put("msg2", "*手机号码与预留手机号码不一致！");
			} else {
				cc.setCarPassword(pad.getNewCarPassword());
				ccs.setCreditCardPassword(cc);
				System.out.println("交易密码设置成功！...................." + cc.getCarPassword());
				map.put("ok", 200);
			}
		} else {
			System.out.println("交易密码设置失败！该信用已有交易密码！");
			map.put("no", 400);
		}
		return map;
	}
}
