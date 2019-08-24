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

import com.zl.pojo.client.ClientCompany;
import com.zl.service.ClientCompanyService;
import com.zl.service.impl.ClientCompanyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ClientCompanyServiceImpl.class)
@ContextConfiguration(locations = {"classpath:mapper/*.xml"})
@EnableAutoConfiguration
@ComponentScan("com.zl")
@MapperScan("com.zl.dao")
public class TestClientCompanyServiceImpl {
	@Autowired
	private ClientCompanyService clientCompanyService;
	
	@Test
	public void testInsertClientCompanyInfo() {
		ClientCompany cc=new ClientCompany();
		cc.setCompanyName("CCMS科级有限公司");
		cc.setCompanyNature("企业");
		cc.setCompanyPhone(4008896666L);
		cc.setCompanyIndustry("计算机服务和软件业");
		cc.setCompanyAddress("广东省深圳市宝安区");
		cc.setCompanyJob("职员");
		cc.setAnnualIncome("处级职称");
		cc.setCompanyPostalcode(518000);
		System.out.println(clientCompanyService.insertClientCompanyInfo(cc)); 
	}

}
