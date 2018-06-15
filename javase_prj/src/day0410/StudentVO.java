package day0410;

/**
 * 값으로 사용하는 클래스 VO(Value Object) 값을 저장하는 instance변수 선언,값을 넣는 setter method, 값을
 * 얻는 getter method로 구성된다.
 * 
 * @author owner
 */
public class StudentVO {
	private int num;
	private String name;
	private int age, javaScore;
	private String addr;
	public StudentVO() {
	}
	public StudentVO(int num, String name, int age, int javaScore, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.javaScore = javaScore;
		this.addr = addr;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJavaScore() {
		return javaScore;
	}
	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	//VO의 toString은 VO가 가지고 있는 값을 손쉽게 확인할 목적으로 Override 함.
	@Override
	public String toString() {
		return "StudentVO [num=" + num + ", name=" + name + ", age=" + age + ", javaScore=" + javaScore + ", addr="
				+ addr + "]";
	}
	

	
}
