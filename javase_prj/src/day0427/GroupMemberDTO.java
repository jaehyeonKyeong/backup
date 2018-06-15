package day0427;

import java.io.Serializable;

/**
 * DTO(Data Transfer Object) : 값을 전달하기 위해 사용하는 객체 - 값변경 가능 (VO와 차이 : 전달될때 값이 변경이 되는지 차이)
 * @author owner
 */
@SuppressWarnings("serial")
public class GroupMemberDTO implements Serializable{
	private String name;
	private int age;
	
	public GroupMemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GroupMemberDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
}
