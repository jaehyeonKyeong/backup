package day0404;

import day0330.Person;
import day0405.Fly;

public class Clark extends Person implements Fly {

	public int power;
	
	public Clark() {
		power=10;
	}
	
	
	@Override
	public String speed() {
		return getName()+"�� ������ ����";
	}
	
	@Override
	public String height() {
		return getName()+"�� ���� ����";
	}
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getName()+"�� ������ ���� �Դ´�";
	}
	
	@Override
	public String eat(String menu, int price) {
		// TODO Auto-generated method stub
		return getName()+"�� �ۿ���"+menu+"�� "+price+"������ ��Դ´�";
	}
	
	@Override
	public String[] language() {
		return "�ѱ���,�߱���,��ȭ".split(",");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public String stoneType(String string) {
		// TODO Auto-generated method stub
		return null;
	}



}
