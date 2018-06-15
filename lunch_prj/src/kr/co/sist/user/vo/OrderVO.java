package kr.co.sist.user.vo;

public class OrderVO {
	private String lunchCode,name,phone,address,ipAddress;
	private int quantity;

	public OrderVO() {
		
	}

	public OrderVO(String lunchCode, String name, String phone, String address, String ipAddress, int quantity) {
		
		this.lunchCode = lunchCode;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.ipAddress = ipAddress;
		this.quantity = quantity;
	}

	public String getLunchCode() {
		return lunchCode;
	}

	public void setLunchCode(String lunchCode) {
		this.lunchCode = lunchCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
