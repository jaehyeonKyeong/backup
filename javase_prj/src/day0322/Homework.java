package day0322;
class Homework{
	public static final int MONEY=10000;
	public static void main(String[] args){
		////����1 
		int transExpen=1250;
		int lunchExpen=7000;

		System.out.println("===============����1=============== ");
		System.out.println();
		System.out.println("�Ϸ� �뵷 "+MONEY+"�� �Դϴ�.");
		System.out.println("������ ���� "+transExpen+"���̰�, �պ� "+(transExpen*2)+"�� �Դϴ�.");
		System.out.println("���ɺ���� "+lunchExpen+"���Դϴ�. �������� "+(MONEY-transExpen*2-lunchExpen)+"�� �Դϴ�."); 
		
		////����2
		double leftEye=1.0;
		double rightEye=1.2;
		System.out.println();
		System.out.println("===============����2=============== ");
		System.out.println();
		System.out.println("�޴� �÷��� "+leftEye+"�̰�, ������ �÷��� "+rightEye+"�̰�, ��� �÷��� "+(double)((leftEye+rightEye)/2)+"�Դϴ�.");
		
		////����3
		char initial='K';
		System.out.println();
		System.out.println("===============����3=============== ");
		System.out.println();
		System.out.println("�� �̸��� �̴ϼ��� ù���ڴ� "+initial+"�Դϴ�.");
	
		////����4
		System.out.println();
		System.out.println("===============����4=============== ");
		System.out.println();
		System.out.println("byte�� �ּҰ��� "+Byte.MIN_VALUE+"�̰�, �ִ밪�� "+Byte.MAX_VALUE+"�Դϴ�.");
		System.out.println("short�� �ּҰ��� "+Short.MIN_VALUE+"�̰�, �ִ밪�� "+Short.MAX_VALUE+"�Դϴ�.");
		System.out.println("int�� �ּҰ��� "+Integer.MIN_VALUE+"�̰�, �ִ밪�� "+Integer.MAX_VALUE+"�Դϴ�.");
		System.out.println("long�� �ּҰ��� "+Long.MIN_VALUE+"�̰�, �ִ밪�� "+Long.MAX_VALUE+"�Դϴ�.");
		System.out.println("char�� �ּҰ��� "+(int)(Character.MIN_VALUE)+"�̰�, �ִ밪�� "+(int)(Character.MAX_VALUE)+"�Դϴ�.");
		System.out.println("float�� �ּҰ��� "+Float.MIN_VALUE+"�̰�, �ִ밪�� "+Float.MAX_VALUE+"�Դϴ�.");
		System.out.println("double�� �ּҰ��� "+Double.MIN_VALUE+"�̰�, �ִ밪�� "+Double.MAX_VALUE+"�Դϴ�.");
		System.out.println("boolean�� �ּҰ� �ִ밪�� �����ϴ�.");


	}
}