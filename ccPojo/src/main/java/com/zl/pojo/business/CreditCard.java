package com.zl.pojo.business;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 信用卡列表
 *
 */
public class CreditCard {
	private int id;
	private long cardNum; 							// 信用卡卡号								 card_num
	private int cardType; 							// 信用卡卡种id，外键，此处用对象					 card_type_id
	private String carPassword; 					// 信用卡支付密码 							 card_password
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date cardValidity; 						// 信用卡有效期								 card_validity
	private int cardSecurityCode; 					// 安全码									 card_security_code
	private BigDecimal cardLimit; 					// 信用卡额度								 card_limit
	private BigDecimal cardShortLimit; 				// 临时额度 								 card_short_limit
	private BigDecimal cardCashLimit; 				// 取现额度								 card_cash_limit
	private String cardState; 						// 信用卡状态:未激活，激活。挂失。冻结，销卡			 card_state
	private int cardBinding;						// 信用卡绑定状态：是否绑定在系统上					 card_binding
	private int repayCard; 							// 信用卡绑定的还款卡id。此处用对象，方便级联查询 		 card_bankcard_id
	private int client; 							// 信用卡所属客户id。此处使用对象，方便级联查询 		 card_client_id
	private BigDecimal cardAnnual; 					// 信用卡年费 								 card_annual
	private BigDecimal cardBalance; 				// 信用卡余额，还款时，金额大于需还款金额，则为余额 		 card_balance
	private String cardBillday; 					// 信用卡出账日. 							 card_bill_day
	private String cardRefundDay; 					// 信用卡还款日 								 card_refund_day
	private int cardpoint; 							// 信用卡积分								 card_point
	private long cardPhone;							// 信用卡电话								 card_phone

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCardNum() {
		return cardNum;
	}

	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}

	public String getCarPassword() {
		return carPassword;
	}

	public void setCarPassword(String carPassword) {
		this.carPassword = carPassword;
	}

	public Date getCardValidity() {
		return cardValidity;
	}

	public void setCardValidity(Date cardValidity) {
		this.cardValidity = cardValidity;
	}

	public int getCardSecurityCode() {
		return cardSecurityCode;
	}

	public void setCardSecurityCode(int cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}

	public BigDecimal getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(BigDecimal cardLimit) {
		this.cardLimit = cardLimit;
	}

	public BigDecimal getCardShortLimit() {
		return cardShortLimit;
	}

	public void setCardShortLimit(BigDecimal cardShortLimit) {
		this.cardShortLimit = cardShortLimit;
	}

	public BigDecimal getCardCashLimit() {
		return cardCashLimit;
	}

	public void setCardCashLimit(BigDecimal cardCashLimit) {
		this.cardCashLimit = cardCashLimit;
	}

	public String getCardState() {
		return cardState;
	}

	public void setCardState(String cardState) {
		this.cardState = cardState;
	}

	public int getCardBinding() {
		return cardBinding;
	}

	public void setCardBinding(int cardBinding) {
		this.cardBinding = cardBinding;
	}

	public BigDecimal getCardAnnual() {
		return cardAnnual;
	}

	public void setCardAnnual(BigDecimal cardAnnual) {
		this.cardAnnual = cardAnnual;
	}

	public BigDecimal getCardBalance() {
		return cardBalance;
	}

	public void setCardBalance(BigDecimal cardBalance) {
		this.cardBalance = cardBalance;
	}

	public String getCardBillday() {
		return cardBillday;
	}

	public void setCardBillday(String cardBillday) {
		this.cardBillday = cardBillday;
	}

	public String getCardRefundDay() {
		return cardRefundDay;
	}

	public void setCardRefundDay(String cardRefundDay) {
		this.cardRefundDay = cardRefundDay;
	}

	public int getCardpoint() {
		return cardpoint;
	}

	public void setCardpoint(int cardpoint) {
		this.cardpoint = cardpoint;
	}

	
	public long getCardPhone() {
		return cardPhone;
	}

	public void setCardPhone(long cardPhone) {
		this.cardPhone = cardPhone;
	}

	public int getCardType() {
		return cardType;
	}

	public void setCardType(int cardType) {
		this.cardType = cardType;
	}

	public int getRepayCard() {
		return repayCard;
	}

	public void setRepayCard(int repayCard) {
		this.repayCard = repayCard;
	}

	public int getClient() {
		return client;
	}

	public void setClient(int client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", cardNum=" + cardNum + ", cardType=" + cardType + ", carPassword="
				+ carPassword + ", cardValidity=" + cardValidity + ", cardSecurityCode=" + cardSecurityCode
				+ ", cardLimit=" + cardLimit + ", cardShortLimit=" + cardShortLimit + ", cardCashLimit=" + cardCashLimit
				+ ", cardState=" + cardState + ", cardBinding=" + cardBinding + ", repayCard=" + repayCard + ", client="
				+ client + ", cardAnnual=" + cardAnnual + ", cardBalance=" + cardBalance + ", cardBillday="
				+ cardBillday + ", cardRefundDay=" + cardRefundDay + ", cardpoint=" + cardpoint + ", cardPhone="
				+ cardPhone + "]";
	}

	
}
