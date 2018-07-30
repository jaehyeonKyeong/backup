package kr.co.sist.user.vo;

public class UserDetailReviewVO {
	private String review_image,review_contents;
	private int grade;
	
	public UserDetailReviewVO() {
		// TODO Auto-generated constructor stub
	}

	public UserDetailReviewVO(String review_image, String review_contents, int grade) {
		super();
		this.review_image = review_image;
		this.review_contents = review_contents;
		this.grade = grade;
	}

	public String getReview_image() {
		return review_image;
	}

	public void setReview_image(String review_image) {
		this.review_image = review_image;
	}

	public String getReview_contents() {
		return review_contents;
	}

	public void setReview_contents(String review_contents) {
		this.review_contents = review_contents;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
