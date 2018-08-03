package kr.co.sist.licensee.vo;

public class MenuVO {
	private String menuName;
	private int menuPrice;
	public MenuVO() {
		
	}
	public MenuVO(String menuName, int menuPrice) {
		super();
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	public String getMenuName() {
		return menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}
	
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}



	
	
}//class
