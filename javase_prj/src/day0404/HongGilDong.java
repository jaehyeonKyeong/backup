package day0404;

import day0330.Person;

public class HongGilDong extends Person {

	@Override
	public String eat() {
		return getName() + "�� ������ ���� �Դ´�";
	}

	@Override
	public String eat(String menu, int price) {
		// TODO Auto-generated method stub
		return getName() + "�� �ۿ���" + menu + "�� " + price + "�� �ְ� ��Դ´�";
	}

	@Override
	public String[] language() {
		return "�ѱ���,�߱���,��ȭ".split(",");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person hgd = new HongGilDong();
		hgd.setName("ȫ�浿");
		System.out.println(hgd.eat());
		String[] lang = null;
		lang = hgd.language();
		System.out.println(hgd.getName()+"�� �����ϴ� ���");
		
		for(String value : lang) {
			System.out.println(value);
		}

	}

	public String fight(int i) {
		// TODO Auto-generated method stub
		return "¯��";
	}

	public String getLevel() {
		// TODO Auto-generated method stub
		return null;
	}

}
