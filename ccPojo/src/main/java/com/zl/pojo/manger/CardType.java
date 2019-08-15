package com.zl.pojo.manger;
/**
 *卡种表
 */
public class CardType {
	private int id;								//主键id
	private int cardNum;						//卡种编号			card_num
	private int ctype;							//卡类型id			card_type
	private String cardPic;						//卡种图片			card_pic
	private String cardName;					//卡种名称			card_name
	private int cardannual;						//年费			card_annual
	private String anntationa1;					//注释1			card_anntation1
	private String anntationa2;					//注释2			card_anntation2
	private String anntationa3;					//注释3			card_anntation3
	private String anntationa4;					//注释4			card_anntation4
	private String activity1;					//活动1			card_activity1
	private String activity2;					//活动2			card_activity2
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCardNum() {
		return cardNum;
	}
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	
	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
	public String getCardPic() {
		return cardPic;
	}
	public void setCardPic(String cardPic) {
		this.cardPic = cardPic;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getCardannual() {
		return cardannual;
	}
	public void setCardannual(int cardannual) {
		this.cardannual = cardannual;
	}
	public String getAnntationa1() {
		return anntationa1;
	}
	public void setAnntationa1(String anntationa1) {
		this.anntationa1 = anntationa1;
	}
	public String getAnntationa2() {
		return anntationa2;
	}
	public void setAnntationa2(String anntationa2) {
		this.anntationa2 = anntationa2;
	}
	public String getAnntationa3() {
		return anntationa3;
	}
	public void setAnntationa3(String anntationa3) {
		this.anntationa3 = anntationa3;
	}
	public String getAnntationa4() {
		return anntationa4;
	}
	public void setAnntationa4(String anntationa4) {
		this.anntationa4 = anntationa4;
	}
	public String getActivity1() {
		return activity1;
	}
	public void setActivity1(String activity1) {
		this.activity1 = activity1;
	}
	public String getActivity2() {
		return activity2;
	}
	public void setActivity2(String activity2) {
		this.activity2 = activity2;
	}
	@Override
	public String toString() {
		return "CardType [id=" + id + ", cardNum=" + cardNum + ", ctype=" + ctype + ", cardPic=" + cardPic
				+ ", cardName=" + cardName + ", cardannual=" + cardannual + ", anntationa1=" + anntationa1
				+ ", anntationa2=" + anntationa2 + ", anntationa3=" + anntationa3 + ", anntationa4=" + anntationa4
				+ ", activity1=" + activity1 + ", activity2=" + activity2 + "]";
	}
	
}
