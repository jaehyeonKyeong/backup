package kr.co.sist.diary.vo;

public class DiaryUpdateVO {
	private int num;
	private String content, pwd, ip_address;
	public DiaryUpdateVO() {
		super();
	}
	public DiaryUpdateVO(int num, String content, String pwd, String ip_address) {
		super();
		this.num = num;
		this.content = content;
		this.pwd = pwd;
		this.ip_address = ip_address;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
}
