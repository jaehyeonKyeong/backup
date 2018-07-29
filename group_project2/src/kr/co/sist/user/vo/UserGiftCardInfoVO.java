package kr.co.sist.user.vo;

public class UserGiftCardInfoVO {

private String giftCardName,giftCardNum,dateIssued;
private boolean use; //사용여부

public UserGiftCardInfoVO() {
	// TODO Auto-generated constructor stub
}

public UserGiftCardInfoVO(String giftCardName, String giftCardNum, String dateIssued, boolean use) {
	this.giftCardName = giftCardName;
	this.giftCardNum = giftCardNum;
	this.dateIssued = dateIssued;
	this.use = use;
}

public String getGiftCardName() {
	return giftCardName;
}
public void setGiftCardName(String giftCardName) {
	this.giftCardName = giftCardName;
}
public String getGiftCardNum() {
	return giftCardNum;
}
public void setGiftCardNum(String giftCardNum) {
	this.giftCardNum = giftCardNum;
}
public String getDateIssued() {
	return dateIssued;
}
public void setDateIssued(String dateIssued) {
	this.dateIssued = dateIssued;
}
public boolean isUse() {
	return use;
}
public void setUse(boolean use) {
	this.use = use;
}

}
