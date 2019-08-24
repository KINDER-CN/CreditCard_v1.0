package com.zl.action.backstage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.Query;
import com.zl.pojo.business.AgingThree;
import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;
import com.zl.pojo.business.CreditCard;
import com.zl.pojo.client.Client;
import com.zl.service.AgingClientService;
import com.zl.service.backstage.BillService;

@Controller
public class BillController {
	@Autowired
	private BillService bs;
	@Autowired
	private AgingClientService acs;
	
	//1.查询所有用户账单信息
	@RequestMapping("/queryAllBill")
	@ResponseBody
	public Map<String,Object> queryAllBill() {
		System.out.println("queryAllBill......................");
		Map<String,Object> map = new HashMap<String, Object>();
		List<Bill> bills=bs.queryAllBill();
		System.out.println(bills+"bills");
		
		List<Client> client = acs.queryClient();
		List<CreditCard> creditCards= acs.queryCreditCard();
		System.out.println(client+"client");
		System.out.println(creditCards+"creditCards");
		List<AgingThree> agingThree=new ArrayList<AgingThree>();
		System.out.println(agingThree+"agingThree");
		for(int i=0;i<client.size();i++) {
			for(int y=0;y<creditCards.size();y++) {
				if(creditCards.get(y).getClient()==client.get(i).getId()) {
					for(int z=0;z<bills.size();z++) {
						AgingThree at=new AgingThree();
						if(bills.get(z).getCreditCard()==creditCards.get(y).getId()) {
							at.setId(bills.get(z).getId());
							at.setClientName(client.get(i).getClientName());
							at.setClientIDcard(client.get(i).getClientIDcard());
							at.setCardNum(creditCards.get(y).getCardNum());
							at.setBillNum(bills.get(z).getBillNum());
							at.setBillMoney(bills.get(z).getBillMoney());
							at.setHasPay(bills.get(z).getHasPay());
							at.setSrepayDate(bills.get(z).getSrepayDate());
							at.setRepayDate(bills.get(z).getRepayDate());
							at.setBillDate(bills.get(z).getBillDate());
							at.setBillState(bills.get(z).getBillState());
							agingThree.add(at);
						}
					}
				}
			}
		}
		System.out.println(agingThree);
		map.put("agingThree", agingThree);
		return map;
	}
	
	//2.根据id查询用户账单信息
	@RequestMapping("/queryBillById")
	@ResponseBody
	public Map<String,Object> queryBillById(int id){
		System.out.println("queryBillById......................");
		Map<String,Object> map = new HashMap<String, Object>();
		List<Bill> billId=bs.queryBillById(id);
		System.out.println(billId);
		System.out.println(id);
		map.put("billId", billId);
		return map;
	}
	
	
	//3.根据条件查询用户账单信息
	@RequestMapping("/queryBillByLike")
	@ResponseBody
	public Map<String,Object> queryBillByLike(Query query){
		System.out.println("queryBillByLike......................");
		Map<String,Object> map = new HashMap<String, Object>();
		List<Bill> billsLike=bs.queryBillByLike(query);
		map.put("billsLike", billsLike);
		return map;
	}
	
	
	// 二.账单详情
	//1.查询用户所有账单详情信息
	@RequestMapping("/queryBillDetails")
	@ResponseBody
	public Map<String,Object> queryBillDetails(){
		System.out.println("queryBillDetails......................");
		Map<String,Object> map = new HashMap<String, Object>();
		
		List<BillDetails> billDetails=bs.queryBillDetails();
		List<Client> client = acs.queryClient();
		List<CreditCard> creditCards= acs.queryCreditCard();
		List<AgingThree> agingThree=new ArrayList<AgingThree>();
		System.out.println(billDetails);
		for(int i=0;i<client.size();i++) {
			for(int y=0;y<creditCards.size();y++) {
				if(creditCards.get(y).getClient()==client.get(i).getId()) {
					System.out.println(1111);
					for(int z=0;z<billDetails.size();z++) {
						AgingThree at=new AgingThree();
						System.out.println(billDetails.get(z).getCreditCard()+""+creditCards.get(y).getId());
						if(billDetails.get(z).getCreditCard()==creditCards.get(y).getId()) {
							at.setId(billDetails.get(z).getId());
							at.setClientName(client.get(i).getClientName());
							at.setClientIDcard(client.get(i).getClientIDcard());
							at.setCardNum(creditCards.get(y).getCardNum());
							at.setTransactionDes(billDetails.get(z).getTransactionDes());
							at.setTransactionType(billDetails.get(z).getTransactionType());
							at.setTransactionMoney(billDetails.get(z).getTransactionMoney());
							at.setTransactionTime(billDetails.get(z).getTransactionTime());
							at.setTransactionCoin(billDetails.get(z).getTransactionCoin());
							at.setPayTime(billDetails.get(z).getPayTime());
							at.setBillId(billDetails.get(z).getBillId());
							agingThree.add(at);
							System.out.println(at+""+i);
						}
					}
				}
			}
		}
		System.out.println(agingThree);
		map.put("agingThree", agingThree);
		return map;
	}
	
	//2.根据id查询用户账单详情信息
	@RequestMapping("/queryBillDetailsById")
	@ResponseBody
	public Map<String,Object> queryBillDetailsById(int id){
		System.out.println("queryBillDetailsById......................");
		Map<String,Object> map = new HashMap<String, Object>();
		List<BillDetails> billDetailsId=bs.queryBillDetailsById(id);
		map.put("billDetailsId", billDetailsId);
		System.out.println(billDetailsId);
		System.out.println(id);
		return map;
	}
}
