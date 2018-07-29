package kr.co.sist.licensee.vo;

public class MenuRegistrationVO {
	private String menuImg, menuName, menuPrice, menuIntro, rNum;

	public String getMenuImg() {
		return menuImg;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getMenuPrice() {
		return menuPrice;
	}

	public String getMenuIntro() {
		return menuIntro;
	}

	public String getrNum() {
		return rNum;
	}

	public MenuRegistrationVO(String menuImg, String menuName, String menuPrice, String menuIntro, String rNum) {
		super();
		this.menuImg = menuImg;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuIntro = menuIntro;
		this.rNum = rNum;
	}
	 
	
}//class
