package day0330;

/**
 *	����� ������� ����� Ŭ���� <br>
 *	������� Ư¡ - ��, ��, ��, �̸� <br>
 *	������ Ư¡ - �Դ� �� <br>
 *	����) Person ��ü�� = new Person(); �� �������� ��üȭ�Ͽ� ����Ѵ� <br>
 *
 * @author owner
 */
public class Person {
	private int eye,nose,mouse;	// ��,��,��
	private String name; //�̸� 
	
	/**
	 * Person�� �⺻������ : ����� �¾ �� ����Ѵ�. <br>
	 * ����� �¾�� �⺻������ �� 2��, �� 1��, �� 1���� ���� �ϴ� �� <br>
	 */
	public Person() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouse=1;
	}//Person
	
	/**
	 * �� 2��, ��1��, �� 1���� �ƴ� ��� ��ü�� ������ �� ����ϴ� ������
	 * @param eye �� ����
	 * @param nose �� ����
	 * @param mouse �� ����
	 */
	public Person(int eye, int nose, int mouse) {
		this.eye=eye;
		this.nose=nose;
		this.mouse=mouse;
	}//Person
	
	/**
	 * ������ ��� ��ü�� ���� ������ �ҷ����� ��
	 * @return ���� ����
	 */
	public int getEye() {
		return eye;
	}
	
	/**
	 * ������ ��� ��ü�� ���� ������ �Է��ϴ� ��
	 * @param eye ���� ����
	 */
	public void setEye(int eye) {
		this.eye = eye;
	}
	
	/**
	 * ������ ��� ��ü�� ���� ������ �ҷ����� ��
	 * @return ���� ����
	 */
	public int getNose() {
		return nose;
	}
	
	/**
	 * ������ ��� ��ü�� ���� ������ �Է��ϴ� ��
	 * @param nose ���� ����
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}
	
	/**
	 * ������ ��� ��ü�� ���� ������ �ҷ����� ��
	 * @return ���� ����
	 */
	public int getMouse() {
		return mouse;
	}
	
	/**
	 * ������ ��� ��ü�� ���� ������ �Է��ϴ� ��
	 * @param mouse ���� ����
	 */
	public void setMouse(int mouse) {
		this.mouse = mouse;
	}
	
	/**
	 * ������ ��� ��ü�� �̸��� �ҷ����� ��
	 * @return �̸�
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ������ ��� ��ü�� �̸��� �Է��ϴ� ��
	 * @param name �̸�
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * ������ ��� ��ü�� ������ ���� �Դ� ����
	 * @return ���� �Դ� �ൿ
	 */
	public String eat() {
		return "���� " + eye+"��, �ڰ� "+nose+"��, ���� "+mouse+"�� �� "+name+"��(��) "+"������ ���� �Խ��ϴ�.";
	}
	
	/**
	 * ������ ��� ��ü�� �Ĵ翡�� ���� ��Դ� ����
	 * @param food �����̸�
	 * @param price ���İ���
	 * @return eat()�Ĵ翡�� �Դ� �ൿ
	 */
	public String eat(String food, int price) {
		return "���� " + eye+"��, �ڰ� "+nose+"��, ���� "+mouse+"�� �� "+name+"��(��) �Ĵ翡�� "+price+"���� " +food+"��(��) ��Խ��ϴ�.";
	}

}
