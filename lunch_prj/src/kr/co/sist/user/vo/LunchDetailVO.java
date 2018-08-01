package kr.co.sist.user.vo;

public class LunchDetailVO {
	private String lunch_code, prdName, prdInfo, img;
	private int price;
	
	public LunchDetailVO() {
	}

	public LunchDetailVO(String lunch_code, String prdName, String prdInfo, String img, int price) {
		this.lunch_code = lunch_code;
		this.prdName = prdName;
		this.prdInfo = prdInfo;
		this.img = img;
		this.price = price;
	}

	public String getLunch_code() {
		return lunch_code;
	}

	public void setLunch_code(String lunch_code) {
		this.lunch_code = lunch_code;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public String getPrdInfo() {
		return prdInfo;
	}

	public void setPrdInfo(String prdInfo) {
		this.prdInfo = prdInfo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
