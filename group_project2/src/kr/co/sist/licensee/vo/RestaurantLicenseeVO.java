package kr.co.sist.licensee.vo;

public class RestaurantLicenseeVO {
	private String restaurantName,restaurantNumber;

	
	
	public RestaurantLicenseeVO() {
		super();
	}

	public RestaurantLicenseeVO(String restaurantName,String restaurantNumber ) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantNumber = restaurantNumber;
	}

	
	public String getRestaurantName() {
		return restaurantName;
	}

	public String getRestaurantNumber() {
		return restaurantNumber;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public void setRestaurantNumber(String restaurantNumber) {
		this.restaurantNumber = restaurantNumber;
	}
	
	
	
}
