package kr.co.sist.user.vo;

public class UserReviewVO {
	private String reviewTitle,restaurantNumber,reviewNumber;
	private int grades;

	public UserReviewVO() {
		// TODO Auto-generated constructor stub
	}

	public UserReviewVO(String reviewTitle, String restaurantNumber, String reviewNumber, int grades) {
		super();
		this.reviewTitle = reviewTitle;
		this.restaurantNumber = restaurantNumber;
		this.reviewNumber = reviewNumber;
		this.grades = grades;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getRestaurantNumber() {
		return restaurantNumber;
	}

	public void setRestaurantNumber(String restaurantNumber) {
		this.restaurantNumber = restaurantNumber;
	}

	public String getReviewNumber() {
		return reviewNumber;
	}

	public void setReviewNumber(String reviewNumber) {
		this.reviewNumber = reviewNumber;
	}

	public int getGrades() {
		return grades;
	}

	public void setGrades(int grades) {
		this.grades = grades;
	}



}
