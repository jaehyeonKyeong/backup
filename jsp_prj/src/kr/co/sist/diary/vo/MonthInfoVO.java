package kr.co.sist.diary.vo;

public class MonthInfoVO {
	private String year,month;

	public MonthInfoVO() {
	}

	public MonthInfoVO(String year, String month) {
		super();
		this.year = year;
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
}
