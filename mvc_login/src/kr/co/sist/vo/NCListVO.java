package kr.co.sist.vo;

public class NCListVO {
	private int ncNum;
	private String company,manager,dept,inputDate;
	public NCListVO() {
	}
	public NCListVO(int ncNum, String company, String manager, String dept, String inputDate) {
		super();
		this.ncNum = ncNum;
		this.company = company;
		this.manager = manager;
		this.dept = dept;
		this.inputDate = inputDate;
	}
	public int getNcNum() {
		return ncNum;
	}
	public void setNcNum(int ncNum) {
		this.ncNum = ncNum;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	
}
