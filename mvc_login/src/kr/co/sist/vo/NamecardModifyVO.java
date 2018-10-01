package kr.co.sist.vo;

public class NamecardModifyVO {
	private int ncNum;
	private String dept,manager,email,position;
	public NamecardModifyVO() {
		super();
	}
	public NamecardModifyVO(int ncNum, String dept, String manager, String email, String position) {
		super();
		this.ncNum = ncNum;
		this.dept = dept;
		this.manager = manager;
		this.email = email;
		this.position = position;
	}
	public int getNcNum() {
		return ncNum;
	}
	public void setNcNum(int ncNum) {
		this.ncNum = ncNum;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
