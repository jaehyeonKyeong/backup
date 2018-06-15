package day0329;

/**
 *	��ī���� ������� �����Ͽ� �߻�ȭ(��ü�𵨸�)�� �� �� �����ϴ� Ŭ���� <br>
 *	��ī���� ����� Ư¡ : �Ѳ�, ��ü, �� <br>
 *	�������� Ư¡ : ���� <br>
 *	�Ϲ�Ŭ�����̸� ��üȭ�� �ؼ� ����Ѵ� <br>
 *	��üȭ ���) Marker m = new Marker(); <br>
 *		���) m.write("���� ���� ��"); <br>
 * @author owner
 */
public class Marker {
	private int cap, body;
	private String color;
	
	/**
	 * 03-30-2018 ������ �ڵ� �߰� <br>
	 * ��ī���� �����Ǹ� �Ѳ� 1��, ��ü1��, ���� ���������� ����
	 */
	public Marker() {
		this(1,1,"����");
//		this.cap=1;
//		this.body=1;
//		this.color="����";		
	} //Marker

	/**
	 * 03-30-2018 ������ �ڵ� �߰� <br>
	 * @param cap �Ѳ��� ����
	 * @param body ��ü�� ����
	 * @param color ��
	 */
	public Marker(int cap, int body, String color) {
		this.cap=cap;
		this.body=body;
		this.color=color;		
	} //Marker
	
	
	/**
	 * ��ī�� ��ü�� cap�� ����
	 * @param cap cap ����
	 */
	public void setCap(int cap) {
		this.cap=cap;
	}//setCap
	
	/**
	 * ��ī�� ��ü�� body�� ����
	 * @param body body ����
	 */
	public void setBody(int body) {
		this.body=body;
	}//setBody
	
	
	/**
	 * ��ī�� ��ü�� color�� ����
	 * @param color ����
	 */
	public void setColor(String color) {
		this.color=color;
	}//setColor

	/**
	 * ������ ��ī�� ��ü�� cap�� ��� ��
	 * @return ��ī�� cap�� ��
	 */
	public int getCap() {
		return cap;
	}//getCap

	/**
	 * ������ ��ī�� ��ü�� body�� ��� ��
	 * @return ��ī�� body�� ��
	 */
	public int getBody() {
		return body;
	}//getBody
	
	/**
	 * ������ ��ī�� ��ü�� ���� ��� ��
	 * @return ��ī�� ��ü�� ��
	 */
	public String getColor() {
		return color;
	}//getColor
	
	public String write(String message) {
		return color+"���� ��ī������ ĥ�ǿ� \""+message+"\" �� ����.";
	}
	

}//class
