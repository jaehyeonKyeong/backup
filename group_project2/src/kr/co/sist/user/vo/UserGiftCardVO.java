package kr.co.sist.user.vo;

public class UserGiftCardVO {
	private String dateIssued,giftCardName,use;

	public UserGiftCardVO() {
		// TODO Auto-generated constructor stub
	}
	public UserGiftCardVO(String dateIssued, String giftCardName, String use) {
		super();
		this.dateIssued = dateIssued;
		this.giftCardName = giftCardName;
		this.use = use;
	}

	public String getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(String dateIssued) {
		this.dateIssued = dateIssued;
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
	
}
