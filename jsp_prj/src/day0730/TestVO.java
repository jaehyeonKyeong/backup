package day0730;

/**
 * <jsp:useBean>���� ����� VO
 * @author owner
 */
public class TestVO {
	private String name, thesisSubject;
	private int age;
	
	public TestVO() {
		System.out.println("�⺻������");
	}
	
	public TestVO(String name, String thesisSubject, int age) {
		System.out.println("�����ִ� ������");
		this.name = name;
		this.thesisSubject = thesisSubject;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setThesisSubject(String thesisSubject) {
		this.thesisSubject = thesisSubject;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getThesisSubject() {
		return thesisSubject;
	}

	public int getAge() {
		return age;
	}
	
	
	
}//class
