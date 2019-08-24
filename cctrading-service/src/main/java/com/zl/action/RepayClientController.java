package com.zl.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.business.BankCard;
import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.business.RepayCard;
import com.zl.pojo.business.RepayMoneyAndPwd;
import com.zl.pojo.business.ShowCard;
import com.zl.pojo.client.Client;
import com.zl.pojo.manger.CardType;
import com.zl.service.AgingClientService;
import com.zl.service.BillClientService;
import com.zl.service.RepayClientService;

@Controller

public class RepayClientController {
	@Autowired
	private RepayClientService rcs;
	@Autowired
	private AgingClientService acs;
	@Autowired
	private BillClientService bcs;

	@RequestMapping("/queryCreditCardByClient")
	@ResponseBody
	// 根据客户id展示信用卡
	public Map<String, Object> queryCreditCardByClient(HttpSession s) {
		// 得到客户id
		Client client=new Client();
		client =(Client) s.getAttribute("client");
		int id=client.getId();
		Map<String, Object> map = new HashMap<String, Object>();
		List<ShowCard> scs = new ArrayList<ShowCard>();
		List<CreditCard> lcs = rcs.queryCreditCardByClient(id);
		List<CardType> lcts = rcs.queryCardType();
		for (CreditCard creditCard : lcs) {
			for (CardType cardType : lcts) {
				ShowCard sc = new ShowCard();
				if (creditCard.getCardType() == cardType.getId()) {
					sc.setCardType(cardType.getCardName());
					sc.setCardNum(creditCard.getCardNum());
					sc.setId(creditCard.getId());
					sc.setCardState(creditCard.getCardState());
					scs.add(sc);
					System.out.println("><><><><?><>" + sc);
				}
			}
		}
		map.put("name", client.getClientName());
		map.put("scs", scs);
		System.out.println(scs);
		return map;

	}

	@RequestMapping("/addRepayCard")
	@ResponseBody
	// 添加还款卡
	public Map<String, Object> addRepayCard(@RequestBody RepayCard rc) {
		Map<String, Object> map = new HashMap<String, Object>();
		rc.setRepayBank("ccms银行");
		rcs.addRepayCard(rc);
		System.out.println("还款卡" + rc);
		return map;

	}

	@RequestMapping("/queryrepayCard")
	@ResponseBody
	public Map<String, Object> queryrepayCard(HttpSession s) {
		// 客户id查身份证 通过身份证查还款卡
		Client client=new Client();
		client =(Client) s.getAttribute("client");
		int id=client.getId();
		Client ct = acs.queryCreditPointByClientId(id);
		Map<String, Object> map = new HashMap<String, Object>();
		List<RepayCard> lbcs = rcs.queryRepayCardbyclient(ct.getClientIDcard());
		map.put("lbcs", lbcs);
		System.out.println(">>>>>"+lbcs);
		return map;

	}

	@RequestMapping("/repay")
	@ResponseBody
	// 还款方法
	public Map<String, Object> repay(@RequestBody RepayMoneyAndPwd rmp, BankCard bc, BillDetails bds) {
		Map<String, Object> map = new HashMap<String, Object>();
		Bill bl = new Bill();
		CreditCard cc = rcs.queryCreditCardById((int) rmp.getCardNum());
		System.out.println(rmp + ">>>>>>>>>>>>>>>>>>>>>.");
		// 添加到交易记录
		bds.setTransactionMoney(rmp.getMoney().multiply(new BigDecimal("-1")));
		bds.setPayTime(new Date());
		bds.setTransactionTime(new Date());
		bds.setTransactionCoin("人民币");
		bds.setTransactionType(2);
		bds.setTransactionDes("还款");
		bds.setCreditCard(cc.getId());
		bc.setCardPwd(rmp.getPwd());
		BankCard bc1 = rcs.queryBankCard((int) rmp.getBankNum());
		System.out.println(bc1 + "bc1" + bds.getTransactionTime());
		Client ct = acs.queryCreditPointByClientId(3);
		// 更改信用分
		ct.setClientId("1");
		ct.setCreditPoint(ct.getCreditPoint() + 10);
		System.out.println(ct);
		// 更改已还金额
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		bl.setBillNum(sdf.format(new Date()));
		bl.setCreditCard(1);
		bl = bcs.queryBillByCardIdAndDate(bl);
		System.out.println("账单》》》》》" + bl);
		bl.setHasPay(bl.getHasPay().subtract(rmp.getMoney()));
		rcs.updateHasMoney(bl);
		int i = rmp.getMoney().compareTo(bc1.getBankBalance());
		System.out.println("比较大小》》》" + i + "<>>>>" + rmp.getMoney() + ">>>>" + bc1.getBankBalance());
		if (!(bc1.getCardPwd() == bc.getCardPwd())) {
			map.put("result", 0);
			
		} else {
			
			if (!((rmp.getMoney().compareTo(bc1.getBankBalance())) == 1)) {
				// 还款运算
				System.out.println(">>>>>>>>>>>>>>>" + ct);
				bc1.setBankBalance(bc1.getBankBalance().subtract(rmp.getMoney()));
				// 扣款运算
				System.out.println(
						cc.getCardBalance() + "cc.getCardBalance()" + bds.getTransactionMoney() + "rmp.getMoney()");
				cc.setCardBalance(cc.getCardBalance().add(rmp.getMoney()));
				rcs.addRepayToBillDetails(bds);
				int resultBank = rcs.updateBankBalance(bc1);
				int resultCard = rcs.updateCardBalance(cc);
				int resultpoint = rcs.updateCreditPoint(ct);
				map.put("result", 1);
				map.put("resultBank", resultBank);
				map.put("resultCard", resultCard);
				System.out.println(resultBank + "resultBank" + "resultCard" + resultCard);
			} else {
				map.put("resultbalance", 2);
			};
		};
		return map;
	}
}
