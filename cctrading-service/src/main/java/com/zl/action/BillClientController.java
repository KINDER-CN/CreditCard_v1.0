package com.zl.action;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.business.Bill;
import com.zl.pojo.business.BillDetails;
import com.zl.service.BillClientService;

@Controller
public class BillClientController {
	@Autowired
	private BillClientService bcs;
	@ResponseBody
	@RequestMapping("/queryBillDetailsBybillId")
	public Map<String,Object> queryBillDetailsBybillId(@RequestBody Bill bl,BillDetails bs){
	 Map<String,Object> map=new HashMap<String, Object>();
	 if(bl.getBillNum()==null||"".equals(bl.getBillNum())) {
		 SimpleDateFormat sdf =new SimpleDateFormat("yyyyMM");
		 bl.setBillNum(sdf.format(new Date()));
		 System.out.println(">>!!!!>>>>>"+bl);
	 }
	 System.out.println(">>???>>>>>"+bl);
	 bl=bcs.queryBillByCardIdAndDate(bl);
	 if(bl!=null) {
		 System.out.println(">>???>>>>>"+bl);
		 bs.setBillId(bl.getId());
		 bs.setCreditCard(bl.getCreditCard());
		 List<BillDetails> lbds=bcs.queryBillDetailsBybillId(bs);
		 System.out.println(lbds);
		 map.put("lbds", lbds);
	 }else {
		 map.put("result",1);
	 }
	 
	 return map;
		
	}
	@ResponseBody
	@RequestMapping("/queryBillByDate")
	public Map<String,Object> queryBillByDate(@RequestBody Bill bill){
	 System.out.println("前台传值>>>>>>>>>>>>"+bill);
	 Map<String,Object> map=new HashMap<String, Object>();
	 if(bill.getBillNum()==null||"".equals(bill.getBillNum())) {
		 SimpleDateFormat sdf =new SimpleDateFormat("yyyyMM");
		 bill.setBillNum(sdf.format(new Date()));
		 System.out.println("赋值>>!!!!>>>>>"+bill);
	 }
	     bill=bcs.queryBillByCardIdAndDate(bill);
       if(bill!=null) {
    	   System.out.println("终值>>>>>>>>>>"+bill+"对象");
  		 //最低还款
  		 bill.setMinRepay(bill.getBillMoney().multiply(new BigDecimal("0.05")));
       
		
		 
		 //剩余还款
		 if(bill.getBillMoney().compareTo(bill.getHasPay())==-1) {
			 bill.setResidueRepay(new BigDecimal(0));
			 bill.setMinRepay(new BigDecimal(0));
		 }else {
			 bill.setResidueRepay(bill.getBillMoney().subtract(bill.getHasPay()));

		 }
       }else {
    	   Bill billq=new Bill();
    	   map.put("billq", billq);
    	   map.put("result",1);
       }
		 System.out.println(bill+"......");
		 map.put("bill", bill);
	 
	
	 
	 return map;
		
	}
	@ResponseBody
	@RequestMapping("/queryBillDetailsBybillId2")
	public Map<String,Object> queryBillDetailsBybillId2(@RequestBody BillDetails bs){
	System.out.println(bs);
	Map<String,Object> map=new HashMap<String, Object>();
	bs.setBillId(0);
	 List<BillDetails> lbds=bcs.queryBillDetailsBybillId(bs);
	 System.out.println(lbds);
	 map.put("lbds", lbds);
	 return map;
	}
}
