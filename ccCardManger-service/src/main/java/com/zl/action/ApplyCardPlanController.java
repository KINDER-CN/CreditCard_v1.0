package com.zl.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.business.ApplyCardPlan;
import com.zl.pojo.client.Client;
import com.zl.pojo.client.ClientCompany;
import com.zl.pojo.client.ClientLinkman;
import com.zl.pojo.manger.CardType;
import com.zl.service.ApplyCardPlanService;
import com.zl.service.ClientCompanyService;
import com.zl.service.ClientLinkmanService;
import com.zl.service.ClientService;

//信用卡申请
@Controller
public class ApplyCardPlanController {
	@Autowired
	private ApplyCardPlanService acps;
	@Autowired
	private ClientService cs;
	@Autowired
	private ClientLinkmanService cls;
	@Autowired
	private ClientCompanyService ccs;
	
	@ResponseBody
	@RequestMapping("/selectCardTypeById")
	public Map<String, Object> selectCardTypeById(int id){
		System.out.println("根据id查询卡种...................");
		Map<String, Object> map = new HashMap<String, Object>();
		CardType ct= acps.selectCardTypeById(id);
		String src=ct.getCardPic().substring(16,ct.getCardPic().length());
		ct.setCardPic("http://10.1.12.66:8086/client/img/kapian/"+src);
		System.out.println(ct);
		map.put("ct", ct);
		return map;
	}

	@ResponseBody
	@RequestMapping("/handleCreditCard")
	public Map<String, Object> handleCreditCard(int id, ApplyCardPlan acp, ClientLinkman clientLinkman,
			ClientCompany clientCompany, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 从session中获取用户信息
		Client cl = (Client) session.getAttribute("client");
		System.out.println("进入办卡申请..........................."+id);
		System.out.println(acp);
		System.out.println(cl);
		System.out.println(clientLinkman);
		System.out.println(clientCompany);
		CardType ct = acps.selectCardTypeById(id);
		/*String src=ct.getCardPic().substring(7,ct.getCardPic().length());
		ct.setCardPic("http://10.1.12.66:8086/client/img/kapian/"+src);*/
		acp.setPlanIDcard(cl.getClientIDcard());
		acp.setApplyTime(new Date());
		acp.setPlanState("待审核");
		acp.setPlanIDcard(cl.getClientIDcard());
		acp.setClientId(cl.getId());
		int clientId = new Random().nextInt(99999);
		cl.setClientId("Cc" + clientId);
		clientLinkman.setClient(cl.getId());
		clientCompany.setClient(cl.getId());
		acps.handleCreditCard(acp);
		cs.updateClientInfo(cl);
		cls.insertClientLinkmanInfo(clientLinkman);
		ccs.insertClientCompanyInfo(clientCompany);
		System.out.println("办卡申请成功...........................");
		System.out.println(acp);
		System.out.println(cl);
		System.out.println(clientLinkman);
		System.out.println(clientCompany);
		map.put("ct", ct);
		return map;
	}
}
