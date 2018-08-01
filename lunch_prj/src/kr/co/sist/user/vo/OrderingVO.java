package kr.co.sist.user.vo;

public class OrderingVO {
	private String lunchCode, name, phone, address, ipAdress;
	private int quantity;

	public OrderingVO() {
		super();
	}

	public OrderingVO(String lunchCode, String name, String phone, String address, String ipAdress, int quantity) {
		super();
		this.lunchCode = lunchCode;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.ipAdress = ipAdress;
		this.quantity = quantity;
	}
	

	public String getLunchCode() {
		return lunchCode;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getIpAdress() {
		return ipAdress;
	}

	public int getQuantity() {
		return quantity;
	}

	

	
}//class
