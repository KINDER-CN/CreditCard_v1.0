package com.zl.main;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zl.dao.ClientLinkmanDao;
import com.zl.pojo.client.ClientLinkman;
import com.zl.service.impl.ClientLinkmanServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ClientLinkmanServiceImpl.class)
@ContextConfiguration(locations = {"classpath:mapper/*.xml"})
@EnableAutoConfiguration
@ComponentScan("com.zl")
@MapperScan("com.zl.dao")
public class TestClientLinkmanServiceImpl {
	@Autowired
	private ClientLinkmanDao clientLinkmanDao;
	
	@Test
	public void testInsertClientLinkmanInfo() {
		ClientLinkman cl=new ClientLinkman();
		cl.setLinkName("胡八一");
		cl.setLinkPhone(15073889981l);
		cl.setLinkAddress("广东省深圳市宝安区");
		cl.setLinkRelation("同事");
		cl.setClient(1001);
		cl.setBinding(1);
		
		clientLinkmanDao.insertClientLinkmanInfo(cl);
	}

}
