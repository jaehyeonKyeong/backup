package kr.co.sist.web.member.vo;

public class WebMemberVO {
	private String id,passwd,name,tel,zipcode,addr1,addr2,ssn,gender,birth,marriage,marr_date,greeting,ip;
	private String[] hobby;
	
	public WebMemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getZipcode() {
		return zipcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public String getSsn() {
		return ssn;
	}
	public String getGender() {
		return gender;
	}
	public String getBirth() {
		return birth;
	}
	public String getMarriage() {
		return marriage;
	}
	public String getMarr_date() {
		return marr_date;
	}
	public String getGreeting() {
		return greeting;
	}
	public String getIp() {
		return ip;
	}
	public String[] getHobby() {
		return hobby;
	}
	public WebMemberVO(String id, String passwd, String name, String tel, String zipcode, String addr1, String addr2,
			String ssn, String gender, String birth, String marriage, String marr_date, String greeting, String ip,
			String[] hobby) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.tel = tel;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.ssn = ssn;
		this.gender = gender;
		this.birth = birth;
		this.marriage = marriage;
		this.marr_date = marr_date;
		this.greeting = greeting;
		this.ip = ip;
		this.hobby = hobby;
	}
	
}
