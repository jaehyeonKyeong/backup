package day0326;

public class Homework {
	public static final int BUS=1200;
	public static final int SUBWAY=1250;
	public static final int TAXI=3000;
	
	public static void main(String[] args) {
		int distance=Integer.parseInt(args[1]);
		
		
		int overPay=0;
		if(distance>10) {
			overPay=((distance-10)/5)*100;	
		}
		
		System.out.println(args[0]+"");
		
		if(args[0].equals("����"))
			System.out.println(args[0]+"(��)�� ����� "+(BUS+overPay)+"���̰�, �պ���� "+((BUS+overPay)*2)+"�̰�, �Ѵ�20�� ���� �պ������ "+(((BUS+overPay)*2)*20)+"�� �Դϴ�.");
		else if(args[0].equals("����ö"))
			System.out.println(args[0]+"(��)�� ����� "+(SUBWAY+overPay)+"���̰�, �պ���� "+((SUBWAY+overPay)*2)+"�̰�, �Ѵ�20�� ���� �պ������ "+(((SUBWAY+overPay)*2)*20)+"�� �Դϴ�.");
		else if(args[0].equals("�ý�"))
			System.out.println(args[0]+"(��)�� ����� "+TAXI+"���̰�, �պ���� "+TAXI*2+"�̰�, �Ѵ�20�� ���� �պ������ "+((TAXI*2)*20)+"�� �Դϴ�.");
		else if(args[0].equals("����"))
			System.out.println("Ȳ���Դϴ�.");
		
		
	}//main
}//class
