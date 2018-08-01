package kr.co.sist.user.view;

public class LunchDetailVO {
	private String lunchCode, prdName,prdInfo, img; 
	private int price;
	
	
	public LunchDetailVO() {
		super();
	}


	public LunchDetailVO(String lunchCode, String prdName, String prdInfo, String img, int price) {
		super();
		this.lunchCode = lunchCode;
		this.prdName = prdName;
		this.prdInfo = prdInfo;
		this.img = img;
		this.price = price;
	}


	public String getLunchCode() {
		return lunchCode;
	}


	public void setLunchCode(String lunchCode) {
		this.lunchCode = lunchCode;
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
	
	
	
}//class
