package kr.co.sist.licensee.vo;

public class MenuUpdateVO {
	String menuName,menuIntro,menuImage,rNum;
	int menuPrice;

	public String getMenuName() {
		return menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public String getMenuIntro() {
		return menuIntro;
	}

	public String getMenuImage() {
		return menuImage;
	}

	public String getrNum() {
		return rNum;
	}

	public MenuUpdateVO(String menuName, int menuPrice, String menuIntro, String menuImage, String rNum) {
		super();
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuIntro = menuIntro;
		this.menuImage = menuImage;
		this.rNum = rNum;
	}

	public MenuUpdateVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
