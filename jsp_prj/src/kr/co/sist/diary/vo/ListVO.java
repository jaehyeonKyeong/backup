package kr.co.sist.diary.vo;

public class ListVO {
	private String fieldName, keyword;
	private int startNum,endNum;
	public String getFieldName() {
		return fieldName;
	}
	public String getKeyword() {
		return keyword;
	}
	public int getStartNum() {
		return startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public ListVO(String fieldName, String keyword, int startNum, int endNum) {
		super();
		this.fieldName = fieldName;
		this.keyword = keyword;
		this.startNum = startNum;
		this.endNum = endNum;
	}
	public ListVO() {
		super();
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	

	
}
