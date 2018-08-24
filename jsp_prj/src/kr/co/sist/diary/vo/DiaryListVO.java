package kr.co.sist.diary.vo;

public class DiaryListVO {
	private int num,cnt;
	private String subject,writer,input_date,e_year,e_month,
						e_day, ip_address;
	public DiaryListVO() {
		super();
	}
	public DiaryListVO(int num, int cnt, String subject, String writer, String input_date, String e_year,
			String e_month, String e_day, String ip_address) {
		super();
		this.num = num;
		this.cnt = cnt;
		this.subject = subject;
		this.writer = writer;
		this.input_date = input_date;
		this.e_year = e_year;
		this.e_month = e_month;
		this.e_day = e_day;
		this.ip_address = ip_address;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
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
	public String getInput_date() {
		return input_date;
	}
	public void setInput_date(String input_date) {
		this.input_date = input_date;
	}
	public String getE_year() {
		return e_year;
	}
	public void setE_year(String e_year) {
		this.e_year = e_year;
	}
	public String getE_month() {
		return e_month;
	}
	public void setE_month(String e_month) {
		this.e_month = e_month;
	}
	public String getE_day() {
		return e_day;
	}
	public void setE_day(String e_day) {
		this.e_day = e_day;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	
}//class
