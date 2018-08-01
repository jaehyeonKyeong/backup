package kr.co.sist.licensee.vo;

import java.util.List;

public class RestaurantSelectVO {
	private String rImg, mapImg, rName, bNumber, cName, rAddr, cPrice, rTel, rIntro;
	private int foodCategory;
	private List<MenuVO> menuList;
	
	
	public RestaurantSelectVO(String rImg, String mapImg, String rName, String bNumber, String cName, String rAddr,
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
	public int getFoodCategory() {
		return foodCategory;
	}
	public List<MenuVO> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<MenuVO> menuList) {
		this.menuList = menuList;
	}
	
}
