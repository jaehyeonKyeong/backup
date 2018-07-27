package kr.co.sist.user.vo;

public class MenuSearchVO {
	String menuName,price,intro;

	public MenuSearchVO(String menuName, String price, String intro) {
		super();
		this.menuName = menuName;
		this.price = price;
		this.intro = intro;
	}

	public String getMenuName() {
		return menuName;
	}

	public String getPrice() {
		return price;
	}

	public String getIntro() {
		return intro;
	}
	
}
