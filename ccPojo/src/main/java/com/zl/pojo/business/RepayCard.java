package com.zl.pojo.business;

/**
 * 信用卡绑定的还款卡表
 *
 */
public class RepayCard {
	private int id; 				// 主键id
	private int repayCardNum;		// 还款卡号 repay_card
	private String repayName; 		// 还款卡卡主姓名 repay_name
	private String repayIDcard;		// 还款卡卡主身份证号码 repaay_idcar
	private int repayPhone; 		// 还款卡电话 repay_phone
	private String repayBank; 		// 还款卡银行 repay_bank
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRepayCardNum() {
		return repayCardNum;
	}
	public void setRepayCardNum(int repayCardNum) {
		this.repayCardNum = repayCardNum;
	}
	public String getRepayName() {
		return repayName;
	}
	public void setRepayName(String repayName) {
		this.repayName = repayName;
	}
	public String getRepayIDcard() {
		return repayIDcard;
	}
	public void setRepayIDcard(String repayIDcard) {
		this.repayIDcard = repayIDcard;
	}
	public int getRepayPhone() {
		return repayPhone;
	}
	public void setRepayPhone(int repayPhone) {
		this.repayPhone = repayPhone;
	}
	public String getRepayBank() {
		return repayBank;
	}
	public void setRepayBank(String repayBank) {
		this.repayBank = repayBank;
	}
	@Override
	public String toString() {
		return "RepayCard [id=" + id + ", repayCardNum=" + repayCardNum + ", repayName=" + repayName + ", repayIDcard="
				+ repayIDcard + ", repayPhone=" + repayPhone + ", repayBank=" + repayBank + "]";
	}
	
}
