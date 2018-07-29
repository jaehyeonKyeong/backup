package kr.co.sist.licensee.vo;

public class RestaurantRegistrationVO {
	private String rImg, mapImg, rName, bNumber, cName, rAddr, cPrice,rTel, rIntro,l_id;
	private int foodCategory;
	public RestaurantRegistrationVO(String rImg, String mapImg, String rName, String bNumber, String cName,
			String rAddr, String cPrice, String rTel, String rIntro, String l_id, int foodCategory) {
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
		this.l_id = l_id;
		this.foodCategory = foodCategory;
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
	public String getL_id() {
		return l_id;
	}
	public int getFoodCategory() {
		return foodCategory;
	}
	

	
	
	
}//class
