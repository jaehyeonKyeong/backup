package kr.co.sist.user.vo;

public class RestaurantSearchVO {
	String rNum,rImg,rName;
	int rCategory;

	public RestaurantSearchVO(String rNum, String rImg, String rName, int rCategory) {
		super();
		this.rNum = rNum;
		this.rImg = rImg;
		this.rName = rName;
		this.rCategory = rCategory;
	}

	public String getrNum() {
		return rNum;
	}

	public String getrImg() {
		return rImg;
	}

	public String getrName() {
		return rName;
	}

	public int getrCategory() {
		return rCategory;
	}
	
	
}
