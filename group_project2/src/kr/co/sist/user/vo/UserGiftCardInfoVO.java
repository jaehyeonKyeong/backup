package kr.co.sist.user.vo;

public class UserGiftCardInfoVO {

private String giftCardNum,id,giftCardName,use,dateIssued;

	public UserGiftCardInfoVO() {
		// TODO Auto-generated constructor stub
	}

	
	public UserGiftCardInfoVO(String giftCardNum, String id, String giftCardName, String use, String dateIssued) {
		this.giftCardNum = giftCardNum;
		this.id = id;
		this.giftCardName = giftCardName;
		this.use = use;
		this.dateIssued = dateIssued;
	}


	public String getGiftCardNum() {
		return giftCardNum;
	}

	public void setGiftCardNum(String giftCardNum) {
		this.giftCardNum = giftCardNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGiftCardName() {
		return giftCardName;
	}

	public void setGiftCardName(String giftCardName) {
		this.giftCardName = giftCardName;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
	}


}
