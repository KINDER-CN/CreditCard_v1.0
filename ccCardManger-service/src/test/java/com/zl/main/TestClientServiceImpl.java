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

import com.zl.pojo.client.Client;
import com.zl.service.ClientService;
import com.zl.service.impl.ClientServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ClientServiceImpl.class)
@ContextConfiguration(locations = {"classpath:mapper/*.xml"})
@EnableAutoConfiguration
@ComponentScan("com.zl")
@MapperScan("com.zl.dao")
public class TestClientServiceImpl {
	@Autowired
	private ClientService clientService;

	@Test
	public void testSelectClientById() {
	}

	@Test
	public void testUpdateClientInfo() {
		Client c=clientService.selectClientById(3);
		c.setClientName("赵六");
		clientService.updateClientInfo(c);
	}

}
