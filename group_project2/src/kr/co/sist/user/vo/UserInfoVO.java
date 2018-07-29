package kr.co.sist.user.vo;

public class UserInfoVO {

	private String id;
	private int point;

	public UserInfoVO() {	}
	public UserInfoVO(String id, int point) {
		this.id = id;
		this.point = point;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}
