package kr.co.sist.user.vo;

public class ReviewContentVO {
	String review_number,review_contents, id, review_title, restaurant_number;
	int like_number,grade;
	public String getReview_number() {
		return review_number;
	}
	public String getReview_contents() {
		return review_contents;
	}
	public String getId() {
		return id;
	}
	public String getReview_title() {
		return review_title;
	}
	public String getRestaurant_number() {
		return restaurant_number;
	}
	public int getLike_number() {
		return like_number;
	}
	public int getGrade() {
		return grade;
	}
	public ReviewContentVO(String review_number, String review_contents, String id, String review_title,
			String restaurant_number, int like_number, int grade) {
		super();
		this.review_number = review_number;
		this.review_contents = review_contents;
		this.id = id;
		this.review_title = review_title;
		this.restaurant_number = restaurant_number;
		this.like_number = like_number;
		this.grade = grade;
	}
	
	
	
}
