package com.zl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.business.ApplyCard;
import com.zl.pojo.business.ApplyCardPlan;
import com.zl.pojo.client.Client;
import com.zl.pojo.client.ClientCompany;
import com.zl.pojo.client.ClientLinkman;
import com.zl.pojo.mklFenYe.FenYeClientApplyCard;
import com.zl.service.impl.MKLCreditCardServiceImpl;

@Controller
@RequestMapping("/mo")
public class MoApplyCardControl {
	@Autowired
	private MKLCreditCardServiceImpl mccs;

	@RequestMapping(value = "/queryAllApplyCard", method = RequestMethod.GET)
	// 1.根据条件搜索申请详情表
	@ResponseBody
	public Map<String, Object> queryAllApplyCard(FenYeClientApplyCard fenYeClientApplyCard) {
		Map<String, Object> resut = new HashMap<String, Object>();
		System.out.println(fenYeClientApplyCard.getQueryClientApplyCard());
		List<ApplyCard> applyCard = mccs.queryApplyCardByFenYe(fenYeClientApplyCard);
		System.out.println("来到查询所有申请表分页");
		resut.put("applyCard", applyCard);
		resut.put("fenYeClientApplyCard", fenYeClientApplyCard);
		System.out.println(applyCard);
		return resut;
	}

	@RequestMapping("/queryClientCompanyLinkmanById")
	// 2. 根据id查询个人信息表，单位信息表，联系人表
	@ResponseBody
	public Map<String, Object> queryAllClient(String id) {
		Map<String, Object> resut = new HashMap<String, Object>();
		Client client = mccs.queryClientById(new Integer(id));
		ClientCompany company = mccs.queryClientCompanyById(new Integer(id));
		ClientLinkman linkman = mccs.queryClientLinkmanById(new Integer(id));
		System.out.println(client);
		System.out.println(company);
		System.out.println(linkman);

		// System.out.println(session.getAttribute("user"));
		System.out.println("来到根据id查询个人资料表");
		resut.put("client", client);
		resut.put("company", company);
		resut.put("linkman", linkman);
		return resut;
	}

	@RequestMapping("/updateCheckState")
	// 3.根据客户id修改核实状态
	@ResponseBody
	public Map<String, Object> updateCheckState(String id) {
		Map<String, Object> resut = new HashMap<String, Object>();
		ApplyCard applyCard = new ApplyCard();
		applyCard.setCheckState("核实");
		applyCard.setClient(new Integer(id));
		mccs.updateApplyCardById(applyCard);
		System.out.println("修改详情表核实状态为核实");
		resut.put("flag", "成功");
		return resut;
	}

	@RequestMapping("/updatePlanState")
	// 4.根据客户id修改进度表和详情表状态为审核中
	@ResponseBody
	public Map<String, Object> updatePlanState(String id) {
		Map<String, Object> resut = new HashMap<String, Object>();
		ApplyCard applyCard = new ApplyCard();
		applyCard.setApplyState("审核中");
		applyCard.setClient(new Integer(id));
		mccs.updateApplyCardById(applyCard);
		System.out.println("修改详情表进度为审核中");
		ApplyCardPlan applyCardPlan = new ApplyCardPlan();
		applyCardPlan.setPlanState("审核中");
		applyCardPlan.setClientId(new Integer(id));
		mccs.updateApplyCardPlanByIdCard(applyCardPlan);
		System.out.println("修改详进度表为审核中");
		resut.put("flag", "成功");
		return resut;
	}

	@RequestMapping("/updateClientCompanyLinkman")
	// 5.根据客户id修改个人信息表，用户单位表和用户联系人表
	@ResponseBody
	public Map<String, Object> updateClientCompanyMan(String id, Client client, ClientCompany clientCompany,
			ClientLinkman clientLinkman) {
		Map<String, Object> resut = new HashMap<String, Object>();
		client.setId(new Integer(id));
		mccs.updateClientById(client);
		clientCompany.setClient(new Integer(id));
		mccs.updateClientCompanyById(clientCompany);
		clientLinkman.setClient(new Integer(id));
		mccs.updateClientLinkmanById(clientLinkman);
		System.out.println("修改成功");
		resut.put("flag", "成功");
		return resut;
	}

	@RequestMapping("/updatePlanStaterefuse")
	// 6.根据客户id修改进度表和详情表状态为拒绝
	@ResponseBody
	public Map<String, Object> updatePlanStaterefuse(String id) {
		Map<String, Object> resut = new HashMap<String, Object>();
		ApplyCard applyCard = new ApplyCard();
		applyCard.setApplyState("拒绝");
		applyCard.setClient(new Integer(id));
		mccs.updateApplyCardById(applyCard);
		System.out.println("修改详情表进度为拒绝");
		ApplyCardPlan applyCardPlan = new ApplyCardPlan();
		applyCardPlan.setPlanState("拒绝");
		applyCardPlan.setClientId(new Integer(id));
		mccs.updateApplyCardPlanByIdCard(applyCardPlan);
		System.out.println("修改详进度表为拒绝");
		resut.put("flag", "成功");
		return resut;
	}

	@RequestMapping("/queryClientApplyCardById")
	// 7. 根据客户id查看详情表
	@ResponseBody
	public Map<String, Object> queryClientApplyCardById(String id) {	
		ApplyCard applyCard = mccs.queryClientApplyCardById(new Integer(id));
		Map<String, Object> resut = new HashMap<String, Object>();
		resut.put("applyCard", applyCard);
		System.out.println(id);
		Client client = new Client();
		client = mccs.queryClientById(new Integer(id));
		System.out.println(client);
		System.out.println("来到根据id查看详情表");
		System.out.println(client.getClientName());
		resut.put("clientName", client.getClientName());
		return resut;
	}

}
