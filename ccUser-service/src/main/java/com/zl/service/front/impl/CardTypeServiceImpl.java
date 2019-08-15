package com.zl.service.front.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zl.dao.front.CardTypeDao;
import com.zl.pojo.manger.CardType;
import com.zl.service.front.CardTypeService;
@Service
public class CardTypeServiceImpl implements CardTypeService {
	@Autowired
	private CardTypeDao ctd;
	@Autowired
	private StringRedisTemplate rt;
	@Override
	public List<CardType> queryAllProduce() {
		
		List<CardType> product= null;
		product=ctd.queryAllProduce();
		/*//json主要类，它提供一些功能将转换成Java对象匹配JSON结构,反之亦然。
		ObjectMapper om=new ObjectMapper();
		String json=rt.opsForValue().get("products");
		if(json!=null && !"".equals(json)) {
			//缓存中有数据
			try {
				product=(List<CardType>)om.readValue(json, List.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			//从数据库获取数据
			product=ctd.queryAllProduce();
			try {
				json=om.writeValueAsString(product);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			rt.opsForValue().set("products",json,1,TimeUnit.MINUTES);
		}*/
		return product;
	}

}
