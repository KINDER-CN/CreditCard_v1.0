package com.zl.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

import com.zl.pojo.business.Aging;
import com.zl.pojo.business.AgingMonth;
import com.zl.pojo.business.AgingRate;
import com.zl.pojo.business.Bill;
import com.zl.pojo.client.Client;
import com.zl.service.AgingClientService;
import com.zl.service.BillClientService;
import com.zl.service.RepayClientService;

@Controller
public class AgingClientController {
	@Autowired
	private AgingClientService acs;
	@Autowired
	private BillClientService bcs;
	@Autowired
	private RepayClientService rcs;
	/**
	 * 填写分期表单
	 * @param aging
	 * @return
	 */
	@RequestMapping("/addAging")
	@ResponseBody
	public Map<String,Object> addAging(@RequestBody Aging aging){
		Bill bl =new Bill();
		Map<String,Object> map =new HashMap<String, Object>();
		int result=acs.addAging(aging);
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMM");
		 bl.setBillNum(sdf.format(new Date()));
		 bl.setCreditCard(aging.getCreditCard());
		 bl=bcs.queryBillByCardIdAndDate(bl);
		 bl.setHasPay(bl.getHasPay().add(aging.getAgingLines()));
		 rcs.updateHasMoney(bl);
		map.put("结果", result);
		return map;
	}
	/**
	 * 展示分期概括
	 * @param aging
	 * @return
	 */
	@RequestMapping("/queryAgingByClient")
	@ResponseBody
	public Map<String,Object> queryAgingByClient(@RequestBody Aging aging){
		System.out.println("<<<<<到达控制层"+aging);
		Map<String,Object> map =new HashMap<String, Object>();
		int id=aging.getCreditCard();
		List <Aging> las=acs.queryAgingByClient(id);
		map.put("las", las);
		System.out.println(las);
		return map;
	}
	/**
	 * 展示分期详情
	 * @param aging
	 * @return
	 */
	@RequestMapping("/queryAgingMonth")
	@ResponseBody
	public Map<String,Object> queryAgingMonth(int id,HttpSession s){
		Client client= new Client();
		client=(Client) s.getAttribute("client");
		System.out.println("到达控制层"+id);
		Map<String,Object> map =new HashMap<String, Object>();
		List <AgingMonth> lams=acs.queryAgingMonthByAging(id);
		map.put("lams", lams);
		map.put("name", client.getClientName());
		System.out.println(lams);
		return map;
	}
	/**
	 * 查询可分期金额
	 * @param aging
	 * @return
	 */
	@RequestMapping("/queryAgingMoney")
	@ResponseBody
	public Map<String,Object> queryAgingMoney(@RequestBody Bill bill){
		System.out.println("到达控制层"+bill);
		Map<String,Object> map =new HashMap<String, Object>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		Date d=new Date();
		bill.setBillNum(sdf.format(d));
		bill=bcs.queryBillByCardIdAndDate(bill);
		if(bill!=null) {
			if(bill.getBillMoney().compareTo(bill.getHasPay())==-1) {
				 bill.setResidueRepay(new BigDecimal(0));
			 }else {
				 bill.setResidueRepay(bill.getBillMoney().subtract(bill.getHasPay()));

			 };
			System.out.println(">>>>>>>>"+bill);
		}else {
			Bill bill2=new Bill();
			map.put("bill2", bill2);
		}
		
		map.put("bill", bill);
		return map;
  } 
	@RequestMapping("/jisuanqi")
	@ResponseBody
	public Map<String,Object> jisuanqi(@RequestBody Aging ag){
		System.out.println("到达控制层"+ag);
		Map<String,Object> map =new HashMap<String, Object>();
		AgingRate ar =new AgingRate();
	    ar=acs.queryAgingRate(ag.getAgingNper());
        BigDecimal result=ag.getAgingLines().multiply(new BigDecimal(ar.getAgingRate()));
		map.put("result", result);
		return map;
  } 
}