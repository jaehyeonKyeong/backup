package day0329;

public class MakeRamen {

	public static void main(String[] args) {
		
		//��ü����
		Ramen nuguri = new Ramen();
		
		
		//��ü���
		//�⺻�ʱ�ȭ�� Ȯ��
		System.out.println("��� �̸�: "+nuguri.getRamenName()+", ��� ���� : "+nuguri.getRamenNumber()+", �����μ� : "+nuguri.getTime()+", �߰� ���� : "+nuguri.isAddMore());
		//�� �Է�
		nuguri.setRamenName("�ʱ���");
		nuguri.setRamenNumber(2);
		nuguri.setTime(4);
		nuguri.setAddMore(false);
		nuguri.setEatFresh(false);
		
		//�Է� �� Ȯ��
		System.out.println("��� �̸�: "+nuguri.getRamenName()+", ��� ���� : "+nuguri.getRamenNumber()+", �����μ� : "+nuguri.getTime()+", �߰� ���� : "+nuguri.isAddMore());
		System.out.println(nuguri.eat());
		
		Ramen pusiopusio = new Ramen();
		
		pusiopusio.setRamenName("�ѼŻѼ�");
		pusiopusio.setRamenNumber(2);
		pusiopusio.setTime(24);
		pusiopusio.setAddMore(false);
		pusiopusio.setEatFresh(true);
		
		System.out.println(pusiopusio.eat());

		
	}

}
