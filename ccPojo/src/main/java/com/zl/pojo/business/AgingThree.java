package com.zl.pojo.business;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AgingThree {
	private int id; 					// 主键id
	private String agingNum; 			// 分期账单编号  					 aging_num
	private BigDecimal agingLines;		// 分期总额 					 aging_lines
	private int agingNper;				// 分期期数 					 aging_nper
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date agingTime;				// 分期账单生成时间 				 aging_time
	private int agingRate;		// 分期利率，外键关联分期利率表 		 aging_rate_id
	private String agingState; 			// 分期还款状态 					 aging_state
	private int creditCard; 		// 分期的信用卡，外键关联信用卡表 		 aging_card_id
	private int client; 				// 分期账单所属客户id，外键管理客户表	 aging_client_id
	private Date agingEndTime; 			// 账单结束时间					 aging_endtime
	
	
	private String billNum;				//账单编号			bill_num
	private BigDecimal billMoney;		//账单金额			bill_money
	private BigDecimal hasPay;			//已还款金额		bill_hasPay
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date srepayDate;			//应还款时间		bill_srepay_date
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date repayDate;				//还款时间			bill_repay_date
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date billDate;				//账单生成时间		bill_creat_date
	private String billState;			//状态			bill_state
	
	
	private int overdueNum;				//逾期编号			overdue_num
	private BigDecimal overMoney;			//逾期金额			overdue_money
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date overDate;					//逾期日期应		overdue_date
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date overSPayDate;				//应还款日期		overdue_sreturn_date
	private String overState;				//逾期状态			overdue_state
	private Date overReturnDate;			//还款日期			overdue_return_date
	private BigDecimal overSPayMoney;		//应还款金额		overdue_sreturn_money
	private int clientId;					//用户id			overdue_client_id
	
	
	
	
	
	@Override
	public String toString() {
		return "AgingThree [id=" + id + ", agingNum=" + agingNum + ", agingLines=" + agingLines + ", agingNper="
				+ agingNper + ", agingTime=" + agingTime + ", agingRate=" + agingRate + ", agingState=" + agingState
				+ ", creditCard=" + creditCard + ", client=" + client + ", agingEndTime=" + agingEndTime + ", billNum="
				+ billNum + ", billMoney=" + billMoney + ", hasPay=" + hasPay + ", srepayDate=" + srepayDate
				+ ", repayDate=" + repayDate + ", billDate=" + billDate + ", billState=" + billState + ", overdueNum="
				+ overdueNum + ", overMoney=" + overMoney + ", overDate=" + overDate + ", overSPayDate=" + overSPayDate
				+ ", overState=" + overState + ", overReturnDate=" + overReturnDate + ", overSPayMoney=" + overSPayMoney
				+ ", clientId=" + clientId + ", transactionDes=" + transactionDes + ", transactionType="
				+ transactionType + ", transactionMoney=" + transactionMoney + ", transactionTime=" + transactionTime
				+ ", transactionCoin=" + transactionCoin + ", payTime=" + payTime + ", billId=" + billId + ", aging="
				+ aging + ", cardNum=" + cardNum + ", clientName=" + clientName + ", clientIDcard=" + clientIDcard
				+ ", getId()=" + getId() + ", getAgingNum()=" + getAgingNum() + ", getAgingLines()=" + getAgingLines()
				+ ", getAgingNper()=" + getAgingNper() + ", getAgingTime()=" + getAgingTime() + ", getAgingRate()="
				+ getAgingRate() + ", getAgingState()=" + getAgingState() + ", getCreditCard()=" + getCreditCard()
				+ ", getClient()=" + getClient() + ", getAgingEndTime()=" + getAgingEndTime() + ", getBillNum()="
				+ getBillNum() + ", getBillMoney()=" + getBillMoney() + ", getHasPay()=" + getHasPay()
				+ ", getSrepayDate()=" + getSrepayDate() + ", getRepayDate()=" + getRepayDate() + ", getBillDate()="
				+ getBillDate() + ", getBillState()=" + getBillState() + ", getOverdueNum()=" + getOverdueNum()
				+ ", getOverMoney()=" + getOverMoney() + ", getOverDate()=" + getOverDate() + ", getOverSPayDate()="
				+ getOverSPayDate() + ", getOverState()=" + getOverState() + ", getOverReturnDate()="
				+ getOverReturnDate() + ", getOverSPayMoney()=" + getOverSPayMoney() + ", getClientId()="
				+ getClientId() + ", getTransactionDes()=" + getTransactionDes() + ", getTransactionType()="
				+ getTransactionType() + ", getTransactionMoney()=" + getTransactionMoney() + ", getTransactionTime()="
				+ getTransactionTime() + ", getTransactionCoin()=" + getTransactionCoin() + ", getPayTime()="
				+ getPayTime() + ", getBillId()=" + getBillId() + ", getAging()=" + getAging() + ", getCardNum()="
				+ getCardNum() + ", getClientName()=" + getClientName() + ", getClientIDcard()=" + getClientIDcard()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAgingNum() {
		return agingNum;
	}
	public void setAgingNum(String agingNum) {
		this.agingNum = agingNum;
	}
	public BigDecimal getAgingLines() {
		return agingLines;
	}
	public void setAgingLines(BigDecimal agingLines) {
		this.agingLines = agingLines;
	}
	public int getAgingNper() {
		return agingNper;
	}
	public void setAgingNper(int agingNper) {
		this.agingNper = agingNper;
	}
	public Date getAgingTime() {
		return agingTime;
	}
	public void setAgingTime(Date agingTime) {
		this.agingTime = agingTime;
	}
	public int getAgingRate() {
		return agingRate;
	}
	public void setAgingRate(int agingRate) {
		this.agingRate = agingRate;
	}
	public String getAgingState() {
		return agingState;
	}
	public void setAgingState(String agingState) {
		this.agingState = agingState;
	}
	public int getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(int creditCard) {
		this.creditCard = creditCard;
	}
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}
	public Date getAgingEndTime() {
		return agingEndTime;
	}
	public void setAgingEndTime(Date agingEndTime) {
		this.agingEndTime = agingEndTime;
	}
	public String getBillNum() {
		return billNum;
	}
	public void setBillNum(String billNum) {
		this.billNum = billNum;
	}
	public BigDecimal getBillMoney() {
		return billMoney;
	}
	public void setBillMoney(BigDecimal billMoney) {
		this.billMoney = billMoney;
	}
	public BigDecimal getHasPay() {
		return hasPay;
	}
	public void setHasPay(BigDecimal hasPay) {
		this.hasPay = hasPay;
	}
	public Date getSrepayDate() {
		return srepayDate;
	}
	public void setSrepayDate(Date srepayDate) {
		this.srepayDate = srepayDate;
	}
	public Date getRepayDate() {
		return repayDate;
	}
	public void setRepayDate(Date repayDate) {
		this.repayDate = repayDate;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getBillState() {
		return billState;
	}
	public void setBillState(String billState) {
		this.billState = billState;
	}
	public int getOverdueNum() {
		return overdueNum;
	}
	public void setOverdueNum(int overdueNum) {
		this.overdueNum = overdueNum;
	}
	public BigDecimal getOverMoney() {
		return overMoney;
	}
	public void setOverMoney(BigDecimal overMoney) {
		this.overMoney = overMoney;
	}
	public Date getOverDate() {
		return overDate;
	}
	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}
	public Date getOverSPayDate() {
		return overSPayDate;
	}
	public void setOverSPayDate(Date overSPayDate) {
		this.overSPayDate = overSPayDate;
	}
	public String getOverState() {
		return overState;
	}
	public void setOverState(String overState) {
		this.overState = overState;
	}
	public Date getOverReturnDate() {
		return overReturnDate;
	}
	public void setOverReturnDate(Date overReturnDate) {
		this.overReturnDate = overReturnDate;
	}
	public BigDecimal getOverSPayMoney() {
		return overSPayMoney;
	}
	public void setOverSPayMoney(BigDecimal overSPayMoney) {
		this.overSPayMoney = overSPayMoney;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getTransactionDes() {
		return transactionDes;
	}
	public void setTransactionDes(String transactionDes) {
		this.transactionDes = transactionDes;
	}
	public int getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}
	public BigDecimal getTransactionMoney() {
		return transactionMoney;
	}
	public void setTransactionMoney(BigDecimal transactionMoney) {
		this.transactionMoney = transactionMoney;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getTransactionCoin() {
		return transactionCoin;
	}
	public void setTransactionCoin(String transactionCoin) {
		this.transactionCoin = transactionCoin;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	public int getBillId() {
		return billId;
	}
	public void setBillId(int billId) {
		this.billId = billId;
	}
	public int getAging() {
		return aging;
	}
	public void setAging(int aging) {
		this.aging = aging;
	}
	public long getCardNum() {
		return cardNum;
	}
	public void setCardNum(long cardNum) {
		this.cardNum = cardNum;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientIDcard() {
		return clientIDcard;
	}
	public void setClientIDcard(String clientIDcard) {
		this.clientIDcard = clientIDcard;
	}
	private String transactionDes;				//交易描述				transaction_des
	private int transactionType;				//交易类型				transaction_type
	private BigDecimal transactionMoney;		//交易金额				transaction_monry
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date transactionTime;				//交易时间				transaction_time
	private String transactionCoin;				//交易币种:默认人民币		transaction_coin
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date payTime;						//还款时间				transaction_pay_time
	private int billId;							//账单表id				bill_id
	private int aging;						//分期表id				aging_id
	
	private long cardNum; 							// 信用卡卡号								 card_num
	private String clientName;	//客户名字		client_name
	private String clientIDcard;	//身份证号	client_idcard

	
	
	
}
