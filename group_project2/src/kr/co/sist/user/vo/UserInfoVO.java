package kr.co.sist.user.vo;

public class UserInfoVO {

	private String id,name;
	private int point;

	public UserInfoVO() {	}

	public UserInfoVO(String id, String name, int point) {
		this.id = id;
		this.name = name;
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}
