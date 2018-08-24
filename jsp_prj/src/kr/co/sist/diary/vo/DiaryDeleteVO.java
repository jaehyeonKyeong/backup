package kr.co.sist.diary.vo;

public class DiaryDeleteVO {
	private int num;
	private String pwd;
	public DiaryDeleteVO() {
		super();
	}
	public DiaryDeleteVO(int num, String pwd) {
		super();
		this.num = num;
		this.pwd = pwd;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
