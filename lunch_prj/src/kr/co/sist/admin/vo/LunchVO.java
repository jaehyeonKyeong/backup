package kr.co.sist.admin.vo;

public class LunchVO {
	private String img, prdName, lunchInfo;
	private int price;
	
	
	public LunchVO() {
		super();
	}


	public LunchVO(String img, String prdName, String lunchInfo, int price) {
		super();
		this.img = img;
		this.prdName = prdName;
		this.lunchInfo = lunchInfo;
		this.price = price;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getPrdName() {
		return prdName;
	}


	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}


	public String getLunchInfo() {
		return lunchInfo;
	}


	public void setLunchInfo(String lunchInfo) {
		this.lunchInfo = lunchInfo;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
}//class
