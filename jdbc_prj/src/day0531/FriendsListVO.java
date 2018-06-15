package day0531;

public class FriendsListVO {
	private String name,phone_num;
	private int age;
	public FriendsListVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FriendsListVO(String name, String phone_num, int age) {
		super();
		this.name = name;
		this.phone_num = phone_num;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(String phone_num) {
		this.phone_num = phone_num;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
