package com.zl.action.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.business.ApplyCardPlan;
import com.zl.service.front.ApplyCardService;

@Controller
@RequestMapping("/creditCard")
public class CardMangerController {
	@Autowired
	private ApplyCardService acs;
	
	@RequestMapping("/queryPlan")
	@ResponseBody
	public Map<String,Object> findPlan(String IDcard){
		Map<String,Object> result=new HashMap<String,Object>();
		List<ApplyCardPlan> plan =acs.queryCardPlanByIDCard(IDcard);
		result.put("plan", plan);
		return result;		
	}
}
