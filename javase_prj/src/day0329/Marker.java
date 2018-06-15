package day0329;

/**
 * ��ī���� ������� �����Ͽ� �߻�ȭ(��ü �𵨸�)�� �� ��<br>
 * �����ϴ� Ŭ���� <br>
 * ��ī ���� ����� Ư¡�� : �Ѳ�, ��ü, �� <br>
 * �������� Ư¡ : ����.<br>
 * ��ī���� �Ϲ�Ŭ�����̸� ��üȭ�� �ؼ� ����Ѵ�.<br>
 *  ��üȭ ���) Marker m= new Marker();<br>
 *  ��� ���) m.write("������� ��");
 *  
 * @author owner
 */
public class Marker {
	private int cap,body;
	private String color;
	
	/**
	 * 2018-03-30 ������ �ڵ� �߰�<br>
	 * ��ī ���� �����Ǹ� �Ѳ�1��,��ü1��,���� ���������� ����; 
	 */
	public Marker() {
		this(1,1,"black");
//		cap=1;
//		body=1;
//		color="black";
	}
	/**
	 * �����ڸ� �Ѳ� �ϳ� ��ü �ϳ� ���� �������� �ƴ� ��ī���� �����Ҷ� ����ϴ� ������
	 * @param cap �Ѳ��� ����
	 * @param body ��ü�� ����
	 * @param color ���� ��
	 */
	public Marker(int cap, int body, String color) {
		this.cap=cap;
		this.body=body;
		this.color=color;
	}
	
	/**
	 * ������ ��ī�� ��ü�� �Ѳ��� ������ �����ϴ� ��
	 * @param cap ������ �Ѳ��� ����
	 */
	public void setCap(int cap) {
		this.cap=cap;
	}//setCap
	/**
	 * ������ ��ī�� ��ü�� ��ü�� ������ �����ϴ� ��
	 * @param body ������ ��ü�� ����
	 */
	public void setBody(int body) {
		this.body=body;
	}//setBody
	/**
	 * ������ ��ī�� ��ü�� ���� �����ϴ� ��
	 * @param color ������ ��
	 */
	public void setColor(String color) {
		this.color=color;
	}
	
	public int getCap() {
		return cap;
	}
	public int getBody() {
		return body;
	}
	public String getColor() {
		return color;
	}
	
	public String write(String msg) {
		return msg;
	}
	
} //class
