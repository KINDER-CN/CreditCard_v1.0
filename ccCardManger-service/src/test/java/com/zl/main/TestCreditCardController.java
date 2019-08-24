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

import com.zl.action.CreditCardController;
import com.zl.pojo.business.CreditCard;
import com.zl.service.CreditCardService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CreditCardController.class)
@ContextConfiguration(locations = {"classpath:mapper/*.xml"})
@EnableAutoConfiguration
@ComponentScan("com.zl")
@MapperScan("com.zl.dao")
public class TestCreditCardController {
	@Autowired
	private CreditCardService ccs;
	
	/*@Test
	public void testUpdateCreditCardPassword() {
		CreditCard creditCard=ccs.selectCreditCardById(4);
		creditCard.setCarPassword("666888");
		ccs.updateCreditCardPassword(creditCard);
	}
*/
	@Test
	public void testUpdateCreditCardState() {
		CreditCard creditCard=ccs.selectCreditCardById(4);
		creditCard.setCarPassword("激活");
		ccs.updateCreditCardState(creditCard);
	}
}
