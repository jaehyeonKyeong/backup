package kr.co.sist.licensee.vo;

public class MenuVO2 {
	private String menuName, price;

	public MenuVO2() {
		super();
	}

	public MenuVO2(String menuName, String price) {
		super();
		this.menuName = menuName;
		this.price = price;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
