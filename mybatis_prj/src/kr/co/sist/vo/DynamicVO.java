package kr.co.sist.vo;

public class DynamicVO {
	private String tableName;

	public DynamicVO() {
		
	}
	
	public DynamicVO(String tableName) {
		super();
		this.tableName = tableName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	
}
