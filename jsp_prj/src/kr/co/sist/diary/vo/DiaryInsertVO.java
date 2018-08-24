package kr.co.sist.diary.vo;

public class DiaryInsertVO {
	private String subject, content,param_year,param_month,
		param_day, writer, pwd,ip_address;

	public DiaryInsertVO() {
	}

	public DiaryInsertVO(String subject, String content, String param_year, String param_month, String param_day,
			String writer, String pwd, String ip_address) {
		super();
		this.subject = subject;
		this.content = content;
		this.param_year = param_year;
		this.param_month = param_month;
		this.param_day = param_day;
		this.writer = writer;
		this.pwd = pwd;
		this.ip_address = ip_address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getParam_year() {
		return param_year;
	}

	public void setParam_year(String param_year) {
		this.param_year = param_year;
	}

	public String getParam_month() {
		return param_month;
	}

	public void setParam_month(String param_month) {
		this.param_month = param_month;
	}

	public String getParam_day() {
		return param_day;
	}

	public void setParam_day(String param_day) {
		this.param_day = param_day;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
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

	@Override
	public String toString() {
		return "DiaryInsertVO [subject=" + subject + ", content=" + content + ", param_year=" + param_year
				+ ", param_month=" + param_month + ", param_day=" + param_day + ", writer=" + writer + ", pwd=" + pwd
				+ ", ip_address=" + ip_address + "]";
	}
	
}
