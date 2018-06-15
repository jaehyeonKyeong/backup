package day0330;

/**
 * ����� ������� ����� class<br>
 * ����� ������� Ư¡ : ��,��,��,�̸�<br>
 * ����� �������� Ư¡ : �Դ���.<br>
 * ����) Person ��ü�� = new Person();�� �������� ��üȭ �Ͽ� ����Ѵ�.
 * 
 * @author owner
 */
////////04-05-2018 �߻�Ŭ������ ����////////
public abstract class Person {
	
	private int eye,nose,mouth; //��,��,��;
	private String name; //�̸�;
	
	/**
	 * Person�� �⺻������ : ����� �¾�� ����Ѵ�<br>
	 * ����� �¾�� �⺻������ ��2��,��1��,��1���� �����ϴ���
	 */
	public Person() {
		this(2,1,1);
	}//default
	/**
	 * ��2��,��1��,��1���� �ƴ� ��� ��ü�� �����Ҷ� ����ϴ� ������
	 * @param eye �� ����
	 * @param nose �� ����
	 * @param mouth �� ����
	 */
	public Person(int eye,int nose,int mouth) {
		this.eye=eye;
		this.nose=nose;
		this.mouth=mouth;	
	}//default
	/**
	 * ������ ��� ��ü�� ���� ������ �����ϴ� ��.
	 * @param eye ���� ����
	 */
	public void setEye(int eye) {
		this.eye=eye;
	}
	/**
	 * ������ ��� ��ü�� ���� ������ �����ϴ� ��.
	 * @param nose ���� ����
	 */
	public void setNose(int nose) {
		this.nose=nose;
	}
	/**
	 * ������ ��� ��ü�� ���� ������ �����ϴ� ��.
	 * @param mouth ���� ����
	 */
	public void setMouth(int mouth) {
		this.mouth=mouth;
	}
	/**
	 * ������ ��� ��ü�� �̸��� �����ϴ� ��
	 * @param Name ��� ��ü�� �̸�
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 *  ������ ��� ��ü�� ������ ���� ������ ��ȯ�ϴ� ��
	 * @return ���� ����
	 */
	public int getEye() {
		return eye;
	}
	/**
	 * ������ ��� ��ü�� ������ ���� ������ ��ȯ�ϴ� ��
	 * @return ���� ����
	 */
	public int getNose() {
		return nose;
	}
	/**
	 * ������ ��� ��ü�� ������ ���� ������ ��ȯ�ϴ� ��
	 * @return ���� ����
	 */
	public int getMouth() {
		return mouth;
	}
	/**
	 * ������ ��� ��ü�� ������ �̸��� ��ȯ�ϴ� ��
	 * @return �̸�
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ������ ��� ��ü�� �Դ� �� ����
	 * @return���� ������ �Դ� �ൿ
	 */
	public abstract String eat(); 	/**
	 * ������ ��� ��ü�� ���ۿ��� �Դ��� ����
	 * @param menu ��Դ� �޴�
	 * @param price �޴��� ����
	 * @return �ۿ��� �Դ� ��;
	 */
	public abstract String eat(String menu,int price);
	
	/**
	 * �����ü�� ������ �� �ִ� ���.
	 * @return
	 */
	public abstract String[] language();
	public String height() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	


}
