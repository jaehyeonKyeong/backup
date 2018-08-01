package kr.co.sist.user.vo;

public class LunchVO {
	private String img,prdName,lunchCode, lunchInfo;

	
	public LunchVO() {
		super();
	}

	
	public LunchVO(String img, String prdName, String lunchCode, String lunchInfo) {
		super();
		this.img = img;
		this.prdName = prdName;
		this.lunchCode = lunchCode;
		this.lunchInfo = lunchInfo;
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

	

	 
}//class
