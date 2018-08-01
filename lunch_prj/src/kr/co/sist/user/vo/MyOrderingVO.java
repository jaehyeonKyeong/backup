package kr.co.sist.user.vo;

public class MyOrderingVO {
	private String img,prdName;
	private int quantity, price;
	
	
	public MyOrderingVO() {
		super();
	}


	public MyOrderingVO(String img, String prdName, int quantity, int price) {
		super();
		this.img = img;
		this.prdName = prdName;
		this.quantity = quantity;
		this.price = price;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getPrdName() {
		return prdName;
	}


	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
}
