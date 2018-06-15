package kr.co.sist.admin.vo;

public class OrderListVO {
	private String orderCode,prdName,lunchCode,name,phone,orderDate,status;
	private int quantity;
	public OrderListVO() {
	}
	public OrderListVO(String orderCode, String prdName, String lunchCode, String name, String phone, String orderDate,
			String status, int quantity) {
		this.orderCode = orderCode;
		this.prdName = prdName;
		this.lunchCode = lunchCode;
		this.name = name;
		this.phone = phone;
		this.orderDate = orderDate;
		this.status = status;
		this.quantity = quantity;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
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
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
