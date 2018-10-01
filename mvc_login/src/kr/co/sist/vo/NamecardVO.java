package kr.co.sist.vo;

public class NamecardVO {
	private String comImg, company, dept, manager,
		position, phone, fax, addr, email;

	
	
	public NamecardVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NamecardVO(String comImg, String company, String dept, String manager, String position, String phone,
			String fax, String addr, String email) {
		super();
		this.comImg = comImg;
		this.company = company;
		this.dept = dept;
		this.manager = manager;
		this.position = position;
		this.phone = phone;
		this.fax = fax;
		this.addr = addr;
		this.email = email;
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
	
}
