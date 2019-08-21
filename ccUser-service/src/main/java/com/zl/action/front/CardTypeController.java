package com.zl.action.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.pojo.manger.CardType;
import com.zl.service.front.CardTypeService;

@Controller
@RequestMapping("/product")
public class CardTypeController {
	@Autowired
	private CardTypeService cts;
	
	/**
	 * 查看所有卡种产品控制器
	 */
	@RequestMapping("/product")
	@ResponseBody
	public Map<String,Object> queryProduct(){
		Map<String,Object> result=new HashMap<String,Object>();
		List<CardType> product=cts.queryAllProduce();
		System.out.println(product);
		result.put("product", product);
		return result;
	}
}
