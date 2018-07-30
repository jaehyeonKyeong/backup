package kr.co.sist.licensee.vo;

public class RestaurantUpdateVO {
	private String rImg, mapImg, rName, bNumber, cName, rAddr, cPrice, rTel, rIntro;
	private int foodCategory;
	
	
	public RestaurantUpdateVO(String rImg, String mapImg, String rName, String bNumber, String cName, String rAddr,
			String cPrice, String rTel, String rIntro, int foodCategory) {
		super();
		this.rImg = rImg;
		this.mapImg = mapImg;
		this.rName = rName;
		this.bNumber = bNumber;
		this.cName = cName;
		this.rAddr = rAddr;
		this.cPrice = cPrice;
		this.rTel = rTel;
		this.rIntro = rIntro;
		this.foodCategory = foodCategory-1;
	}
	public String getrImg() {
		return rImg;
	}
	public String getMapImg() {
		return mapImg;
	}
	public String getrName() {
		return rName;
	}
	public String getbNumber() {
		return bNumber;
	}
	public String getcName() {
		return cName;
	}
	public String getrAddr() {
		return rAddr;
	}
	public String getcPrice() {
		return cPrice;
	}
	public String getrTel() {
		return rTel;
	}
	public String getrIntro() {
		return rIntro;
	}
	public int getFoodCategory() {
		return foodCategory;
	}
	
}
