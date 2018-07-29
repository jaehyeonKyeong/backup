package kr.co.sist.user.vo;

public class UserShopVO {

	private String giftCardImage,name,giftCardNum;
	private int price;
	public UserShopVO() {
	}
	public UserShopVO(String giftCardImage, String name, String giftCardNum, int price) {
		this.giftCardImage = giftCardImage;
		this.name = name;
		this.giftCardNum = giftCardNum;
		this.price = price;
	}
	public String getGiftCardImage() {
		return giftCardImage;
	}
	public void setGiftCardImage(String giftCardImage) {
		this.giftCardImage = giftCardImage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGiftCardNum() {
		return giftCardNum;
	}
	public void setGiftCardNum(String giftCardNum) {
		this.giftCardNum = giftCardNum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
