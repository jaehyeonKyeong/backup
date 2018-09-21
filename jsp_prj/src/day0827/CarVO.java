package day0827;

public class CarVO {
	private String car_option,car_img,hiredate,price;
	private int cc;
	
	public CarVO() {
		
	}
	
	public CarVO(String car_option, String car_img, String hiredate, String price, int cc) {
		super();
		this.car_option = car_option;
		this.car_img = car_img;
		this.hiredate = hiredate;
		this.price = price;
		this.cc = cc;
	}

	public String getCar_option() {
		return car_option;
	}
	public void setCar_option(String car_option) {
		this.car_option = car_option;
	}
	public String getCar_img() {
		return car_img;
	}
	public void setCar_img(String car_img) {
		this.car_img = car_img;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	

}
