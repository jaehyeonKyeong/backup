package kr.co.sist.admin.vo;

public class LunchListVO {
	private String img, prdName,lunchCode,lunchInfo;
	private int price;
	
	
	
	public LunchListVO() {
		super();
	}
	
	public LunchListVO(String img, String prdName, String lunchCode, String lunchInfo, int price) {
		super();
		this.img = img;
		this.prdName = prdName;
		this.lunchCode = lunchCode;
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
	public String getLunchCode() {
		return lunchCode;
	}
	public void setLunchCode(String lunchCode) {
		this.lunchCode = lunchCode;
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
