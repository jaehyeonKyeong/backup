package day0322;
class HomeWork0322{
	public static final int POCKET_MONEY = 10000;
	public static void main(String[] args) {
		
		System.out.println("================ 1 ================");
		int transportationExpense = 1250;
		int lunchExpense = 7000;
		System.out.println("�Ϸ��� �뵷 "+POCKET_MONEY+"�� �Դϴ�");
		System.out.println("������ �� "+transportationExpense+"�� �̰� �պ��� "+ transportationExpense*2+"�� �Դϴ�.");
		System.out.println("���� ���� "+lunchExpense+"�� �Դϴ�. ���� �ݾ��� "+(POCKET_MONEY-2*transportationExpense-lunchExpense));

		System.out.println("================ 2 ================");
		double leftEye = 0.7;
		double rightEye = 0.8;
		System.out.println("�޴� �÷� "+leftEye+" ������ �÷� "+rightEye+" ����� "+(rightEye+leftEye)/2+"�Դϴ�.");

		System.out.println("================ 3 ================");
		char myName = 'L';
		System.out.println("�� �̸��� �̴ϼ� �� ù���ڴ� '"+myName+"'�Դϴ�.");
		

		System.out.println("================ 4 ================");
		System.out.println("Byte�� �ּҰ� ("+ Byte.MIN_VALUE+"), �ִ밪 ("+ Byte.MAX_VALUE+")");
		System.out.println("Short�� �ּҰ� ("+ Short.MIN_VALUE+"), �ִ밪 ("+ Short.MAX_VALUE+")");
		System.out.println("int�� �ּҰ� ("+ Integer.MIN_VALUE+"), �ִ밪 ("+ Integer.MAX_VALUE+")");
		System.out.println("long�� �ּҰ� ("+ Long.MIN_VALUE+"), �ִ밪 ("+ Long.MAX_VALUE+")");
		System.out.println("char�� �ּҰ� ("+ (int)Character.MIN_VALUE+"), �ִ밪 ("+ (int)Character.MAX_VALUE+")");
		//System.out.println("char�� �ּҰ� ("+ Character.MIN_CODE_POINT+"), �ִ밪 ("+ Character.MAX_CODE_POINT+")");
		System.out.println("float�� �ּҰ� ("+ Float.MIN_VALUE+"), �ִ밪 ("+ Float.MAX_VALUE+")");
		System.out.println("double�� �ּҰ� ("+ Double.MIN_VALUE+"), �ִ밪 ("+ Double.MAX_VALUE+")");
		//System.out.println("boolean�� �ּҰ� ("+ Boolean.MIN_VALUE+"), �ִ밪 ("+ Boolean.MAX_VALUE+")");
		//System.out.println("boolean�� �ּҰ� ("+ Boolean.FALSE+"), �ִ밪 ("+ Boolean.TRUE+")");
	
	}
}
