package day0410;

/**
 * ������ ����ϴ� Ŭ���� VO(Value Object) ���� �����ϴ� instance���� ����,���� �ִ� setter method, ����
 * ��� getter method�� �����ȴ�.
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
	//VO�� toString�� VO�� ������ �ִ� ���� �ս��� Ȯ���� �������� Override ��.
	@Override
	public String toString() {
		return "StudentVO [num=" + num + ", name=" + name + ", age=" + age + ", javaScore=" + javaScore + ", addr="
				+ addr + "]";
	}
	

	
}
