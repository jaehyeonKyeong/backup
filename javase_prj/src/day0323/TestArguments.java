package day0323;
/**
	main method�� ���� �� �ֱ�
	java Ŭ������ �� �� �� ...... (~21�ﰳ���� ����)
	java TestArguments ������ �ݿ��� �p
*/

class  TestArguments{
	public static void main(String[] args) {
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);

		int i =Integer.parseInt(args[0]); // ���������� ���ڿ��� ������ ��ȯ.
		int j =Integer.parseInt(args[1]);
		System.out.println(args[0]+args[1]);
		System.out.println(i+j);
	}//main
}//class