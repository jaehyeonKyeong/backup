package day0731;

import java.util.Arrays;

public class BeanParamVO {
	/* HTML Form Control(<input name=OO">)과 VO의 Instance 변수명 이름이 반드시 일치해야한다.*/
	private String id, pass, name, phone1, phone2, phone3, zipcode1, zipcode2,
				addr, addr_detail, ssn1, ssn2, gender, birth_year, birth_month,
				birth_day, marriage, m_year, m_month, m_day, greeting;
	
	//기본생성자 없어도 됨
	
	
	
	private String[] hobby;

	public void setId(String id) {
		this.id = id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public void setZipcode1(String zipcode1) {
		this.zipcode1 = zipcode1;
	}

	public void setZipcode2(String zipcode2) {
		this.zipcode2 = zipcode2;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}

	public void setSsn1(String ssn1) {
		this.ssn1 = ssn1;
	}

	public void setSsn2(String ssn2) {
		this.ssn2 = ssn2;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public void setBirth_month(String birth_month) {
		this.birth_month = birth_month;
	}

	public void setBirth_day(String birth_day) {
		this.birth_day = birth_day;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public void setM_year(String m_year) {
		this.m_year = m_year;
	}

	public void setM_month(String m_month) {
		this.m_month = m_month;
	}

	public void setM_day(String m_day) {
		this.m_day = m_day;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getPhone1() {
		return phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public String getZipcode1() {
		return zipcode1;
	}

	public String getZipcode2() {
		return zipcode2;
	}

	public String getAddr() {
		return addr;
	}

	public String getAddr_detail() {
		return addr_detail;
	}

	public String getSsn1() {
		return ssn1;
	}

	public String getSsn2() {
		return ssn2;
	}

	public String getGender() {
		return gender;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public String getBirth_month() {
		return birth_month;
	}

	public String getBirth_day() {
		return birth_day;
	}

	public String getMarriage() {
		return marriage;
	}

	public String getM_year() {
		return m_year;
	}

	public String getM_month() {
		return m_month;
	}

	public String getM_day() {
		return m_day;
	}

	public String getGreeting() {
		return greeting;
	}

	public String[] getHobby() {
		return hobby;
	}

	
	@Override
	public String toString() {
		return "BeanParamVO [id=" + id + ", pass=" + pass + ", name=" + name + ", phone1=" + phone1 + ", phone2="
				+ phone2 + ", phone3=" + phone3 + ", zipcode1=" + zipcode1 + ", zipcode2=" + zipcode2 + ", addr=" + addr
				+ ", addr_detail=" + addr_detail + ", ssn1=" + ssn1 + ", ssn2=" + ssn2 + ", gender=" + gender
				+ ", birth_year=" + birth_year + ", birth_month=" + birth_month + ", birth_day=" + birth_day
				+ ", marriage=" + marriage + ", m_year=" + m_year + ", m_month=" + m_month + ", m_day=" + m_day
				+ ", greeting=" + greeting + ", hobby=" + Arrays.toString(hobby) + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}//class
