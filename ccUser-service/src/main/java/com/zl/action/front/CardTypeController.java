package com.zl.action.front;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.dao.front.CardTypeDao;
import com.zl.pojo.manger.CardType;
import com.zl.service.front.CardTypeService;

@Controller
@RequestMapping("/product")
public class CardTypeController {
	@Autowired
	private CardTypeService cts;
	@Autowired
	private CardTypeDao ctd;
	/**
	 * 查看所有卡种产品控制器
	 */
	@RequestMapping("/product")
	@ResponseBody
	public Map<String,Object> queryProduct(int pageNum){
		Map<String,Object> result=new HashMap<String,Object>();
		List<CardType> product=cts.queryAllProduce(pageNum);
		int num=0;
		if(pageNum==1) {
			num=ctd.queryCountProduce();
			result.put("num", num);
		}
		for(int i=0;i<product.size();i++) {
			if(product.get(i).getCardPic()!=null) {
				product.get(i).setCardPic(product.get(i).getCardPic().substring(4,product.get(i).getCardPic().length()));
			}
		}
		//System.out.println(product);
		result.put("product", product);
		return result;
	}
}
