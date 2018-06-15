package day0404;

/**
 *	����� ��ӹ��� �ڽ� Ŭ������ ���
 * @author owner
 */
public class UsePerson {
	
	public static void main(String[] args) {
		//�θ�Ŭ������ �ڿ� ��� : ���� ���
		HongGilDong gildong = new HongGilDong();
		Clark superman = new Clark();
		//�θ�Ŭ������ �ڿ� ��� : method ���
		gildong.setName("ȫ�浿");
		superman.setName("Ŭ�� ��Ʈ");
		System.out.println(gildong.getName()+"�� �� "+gildong.getEye()+"��, �� "+gildong.getNose()+"��, �� "+gildong.getMouse()+"��");
		
		//�������� Ư��
		System.out.println(gildong.eat());
		System.out.println(gildong.eat("����", 1));
		System.out.println(superman.eat());
		System.out.println(superman.eat("����", 5));
		
		//�ڽĸ��� Ư¡
		System.out.println(gildong.fight(6)+"�ο� �� ����"+gildong.getLevel());
		System.out.println(gildong.fight(7)+"�ο� �� ����"+gildong.getLevel());
		System.out.println(gildong.fight(10)+"�ο� �� ����"+gildong.getLevel());
		System.out.println(gildong.fight(8)+"�ο� �� ����"+gildong.getLevel());
		
		System.out.println(superman.stoneType("¯��")+" ���� ������ �� "+superman.power);
		System.out.println(superman.stoneType("���̾Ƹ��")+" ���� ������ �� "+superman.power);
		System.out.println(superman.stoneType("ũ���䳪��Ʈ")+" ���� ������ �� "+superman.power);
		
		System.out.println("----------------------------------------------------------------------");
		//��Ӱ����� ��üȭ(is a ������ ��üȭ)
		//�θ�Ŭ������ ��ü�� = new �ڽ�Ŭ����������();
		//�θ�Ŭ���������ڷ� �ڽ�Ŭ������ ���� �� ���� ����
		Person p= new HongGilDong();
		Person p1 = new Clark();
		//Override�� method�� �ִٸ� �ڽ��� method�� ȣ��ȴ�
		System.out.println(p.eat("Į����",30));
		System.out.println(p1.eat("�����Ĵ�",300));
		//is a ������ ��üȭ�� �ϰ� �Ǹ� �ڽ�Ŭ������ ����,method�� ����� �� ����
//		p.fight(30);
//		p1.stoneType("���̾Ƹ��");
		
		LeeHyungSik lhs = new LeeHyungSik(); // �ڽİ�ü ����
		lhs.setName("������"); //�̸� ����
		lhs.setAddress("����� ���ʱ� ���絿"); //�ּ� ����
		lhs.print(); //�ּ� ���
		System.out.println(lhs.eat()); //Override �� method ��� - parameter ����
		System.out.println(lhs.eat("�߲�ġ", 3000));//Override �� method ��� - parameter ����
		
		//���������� 5�� 
		String myChoice;
		int cnt=5;
		for(int i=0;i<cnt;i++) {
			myChoice=lhs.selectChoice();
			System.out.println(lhs.rockPaperScissors(myChoice));
		}
		
		System.out.println("--------------------------------------------");
		String[] lang = superman.language();
		System.out.println(superman.getName()+"�� �����ϴ� ���");
		for(int i=0;i<lang.length;i++) {
			System.out.println(lang[i]);
		} //end for
		
		lang=gildong.language();
		System.out.println(gildong.getName()+"�� �����ϴ� ���");
		
		for(String value : lang) {
			System.out.println(value);
		}//end for
		System.out.println("--------------------------------------------");
		System.out.println(superman.speed());
		System.out.println(superman.height());
		
		
		
		
	}// main

}//class
