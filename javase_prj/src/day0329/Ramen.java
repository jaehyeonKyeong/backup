package day0329;
//����� ����� Ư¡
// �̸�, ��, ����, ���� :
// ������ �Դ�:
public class Ramen {
	private String name;
	private String taste;
	private int pay;
	private String pack;
	
	public Ramen() {//������
		this("�Ŷ��","�ſ�","�������");
	}
	public Ramen(String name, String taste,String pack) {//������ overload
		this.name=name;
		this.taste=taste;
		this.pack=pack;
		info();
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setTaste(String taste) {
		this.taste=taste;
	}
	public void setPay(int pay) {
		this.pay=pay;
	}
	public void setPack(String pack) {
		this.pack=pack;
	}
	
	public String getName() {
		return name;
	}
	public String getTaste() {
		return taste;
	}
	public int getPay() {
		return pay;
	}
	public String getPack() {
		return pack;
	}
	
	
	public void info() {//����
		System.out.println("��ǰ��: "+name+", ��: "+taste+"��, ���� : "+pay+"���� : "+pack);
	}
	public String boldEat() {//����
		return taste+"�� "+name+"�� �����Ծ����ϴ�.";
	}
	public String brokenEat() {//����
		return taste+"�� "+name+"�� �ѼŸԾ����ϴ�.";
	}
	
}
