package day0321;
/**
	�ڹ� ǥ�� ��� method ���
	System.out.println(��);		-��� �� �� ����o
	Systme.out.print(��);		-��� �� �� ����x
*/
class UsePrint{

	public static void main(String[] args){

		/* System.out.print("�ȳ�");
		System.out.print("�ڹ�");*/

		//////////////��� ���///////////////
		System.out.println(3);//���� ���
		System.out.println(3.21);//�Ǽ����
		System.out.println(true);//boolean���	
		System.out.println('A');//���ڻ��
		System.out.println('��');//���ڻ��
		System.out.println('1');//���ڻ��
		//System.out.println('12');//���ڻ�� : Error
		System.out.println("��¿���");//���ڿ� ���

		/////����
		int i = 0;
		System.out.println(i);//������ ���

		///// ����� : ����� ����� ���
		System.out.println(3+21);
		System.out.println("3+21="+3+21); //���ڿ��� ����� + �����ڸ� ����ϰ� �Ǹ� ��������� ���ڷ� �ν����� �ʰ� ���ڿ��� �ν���.

	} //main	

} //class

/*
���� : UsePirnt.Java
������ : javac UsePrint.Java (���� : bytecode����)
���� : java UsePrint
*/