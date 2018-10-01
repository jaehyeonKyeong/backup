package kr.co.sist.vo;

public class NamecardAllVO {
	private int ncNum;
	private String comImg, company, dept, manager,
		position, phone, fax, addr, email, inputDate;

	public NamecardAllVO() {
	}

	public NamecardAllVO(int ncNum, String comImg, String company, String dept, String manager, String position,
			String phone, String fax, String addr, String email, String inputDate) {
		super();
		this.ncNum = ncNum;
		this.comImg = comImg;
		this.company = company;
		this.dept = dept;
		this.manager = manager;
		this.position = position;
		this.phone = phone;
		this.fax = fax;
		this.addr = addr;
		this.email = email;
		this.inputDate = inputDate;
	}

	public int getNcNum() {
		return ncNum;
	}

	public void setNcNum(int ncNum) {
		this.ncNum = ncNum;
	}

	public String getComImg() {
		return comImg;
	}

	public void setComImg(String comImg) {
		this.comImg = comImg;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

}
