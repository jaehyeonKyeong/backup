package kr.co.sist.user.vo;

public class LoginVO {
	String id,password,tableName;
	public LoginVO() {}
	public LoginVO(String id, String password, String tableName) {
		super();
		this.id = id;
		this.password = password;
		this.tableName = tableName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	

}