package day0323;
/*
	main method�� ���� �� �ֱ�
	java Ŭ������ �� �� ��...
	java TestArguments ������ �ݿ��� �p
*/
class TestArguments {
	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);

		System.out.println(args[0]+args[1]);
		//int i=args[0]; //���ڿ��� ������ �Ҵ��ϰų� �� ��ȯ�� �� ����
		int i=Integer.parseInt(args[0]); //���������� ���ڿ��� ������ ����
		int j=Integer.parseInt(args[1]);
		System.out.println(i+j);
	}//main
}//class
