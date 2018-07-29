package kr.co.sist.licensee.vo;

public class MenuVO {
	private String menuName;
	private int menuPrice;

	public String getMenuName() {
		return menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public MenuVO(String menuName, int menuPrice) {
		super();
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}


	
	
}//class
