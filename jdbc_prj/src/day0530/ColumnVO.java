package day0530;

public class ColumnVO {
	private String columnName,dataType,constraintName;
	int dataLength;
	
	public ColumnVO() {
	}
	
	public ColumnVO(String columnName, String dataType, String constraintName, int dataLength) {
		this.columnName = columnName;
		this.dataType = dataType;
		this.constraintName = constraintName;
		this.dataLength = dataLength;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public String getConstraintName() {
		return constraintName;
	}
	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
	}
	public int getDataLength() {
		return dataLength;
	}
	public void setDataLength(int dataLength) {
		this.dataLength = dataLength;
	}
	
}
