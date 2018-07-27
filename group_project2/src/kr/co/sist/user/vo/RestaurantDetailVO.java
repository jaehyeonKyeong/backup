package kr.co.sist.user.vo;

import java.util.List;

public class RestaurantDetailVO {
	String rNum,rName,rInfo;
	List<MenuSearchVO> listMenu;
	public String getrNum() {
		return rNum;
	}
	public String getrName() {
		return rName;
	}
	public String getrInfo() {
		return rInfo;
	}
	public List<MenuSearchVO> getListMenu() {
		return listMenu;
	}
	public RestaurantDetailVO(String rNum, String rName, String rInfo) {
		super();
		this.rNum = rNum;
		this.rName = rName;
		this.rInfo = rInfo;
	}
	public void setListMenu(List<MenuSearchVO> listMenu) {
		this.listMenu = listMenu;
	}
	
	
}
