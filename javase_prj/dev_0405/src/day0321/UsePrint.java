package day0321;
/**
	�ڹ� ǥ�� �߷� method ���
	System.out.println(��); -��� �� �� ����
	System.out.print(��); -��� �� �� ���� X
*/

public class UsePrint{
	public static void main(String[] args){
	//	System.out.println("�ȳ�");
	//	System.out.println("�ڹ�");
	//	System.out.print("�ȳ�");
	//	System.out.print("�ڹ�");
		//��� ���//
		System.out.println(3);//���� ���
		System.out.println(3.21);//�Ǽ� ���
		System.out.println(true);//�Ҹ� ���
		System.out.println('A');//���� ���
		System.out.println('��');//���� ���
		System.out.println('1');//���� ���
		//System.out.println('12');//���� ���
		System.out.println("��¿���");//���ڿ� ���
	
		//���� ���//
		int i = 0;
		int j = 0;
		System.out.println(i);//������ ���
		
		//����� : ����� ����� ���
		System.out.println(3+21);
		System.out.println("3+21="+(3+21)	);
		for (i=1;i<10;i++){
			for(j=2;j<10;j++){
				System.out.print(j+"*"+i+"="+(i*j)+'\t');
			}
		System.out.println();
		}
		//byte b=127;
		//char c=' ';
	}//main

}//class

/*
���� : UsePrint.java
������ : javac UsePrint.java (���� : bytecode ����)
���� : java UsePrint(byte code)

*/