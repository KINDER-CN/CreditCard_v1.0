package com.zl.pojo.business;

public class ShowCard {
	private int id;
   private long cardNum;
   private String cardType;
   private String cardState;
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

public String getCardType() {
	return cardType;
}
public void setCardType(String cardType) {
	this.cardType = cardType;
}

public String getCardState() {
	return cardState;
}
public void setCardState(String cardState) {
	this.cardState = cardState;
}
@Override
public String toString() {
	return "ShowCard [id=" + id + ", cardNum=" + cardNum + ", cardType=" + cardType + ", cardState=" + cardState + "]";
}

   
}
