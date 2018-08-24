package kr.co.sist.diary.vo;

public class DiaryVO {
	private int num;
	private String subject, writer, content, input_date, ip_address;
	public DiaryVO() {
	}//DiaryVO
	public DiaryVO(int num, String subject, String writer, String content, String input_date, String ip_address) {
		super();
		this.num = num;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
		this.input_date = input_date;
		this.ip_address = ip_address;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
	}//class
