package day0322;
/**
	�⺻�� ���������� ���� ���
*/
class UsePrimitiveType{
	public static void main(String[] args) 
	{
		//������ ���������� ����� ���� ����
		byte a=10;
		short b=20;
		int c=30;
		long d=40;//�Ҵ�Ǵ� ������ ������ 4byte ����� ����ø� �����Ҽ� �ִ�.
		long e=2147483648L;//����� : literal�� ũ�⸦ �Ͻ������� ����
		System.out.println("byte: "+a+", short: "+b+", int : "+c+", long: "+d+" e : "+e);
		/////////////////////������ : ���ڿ����� unicode���� ����
		char f='A';//65
		char g='0'; //48
		char h='��';//44032
		System.out.println("char : "+f+", "+g+", " +h);
		///////�Ǽ���
		float i =3.22F;//�����(8byte -> 4byte)
		double j=3.22;//����� ��������
		double k=3.22D;//����� ���
		System.out.println("float: "+i+", double: "+j+", "+k);
		///////boolean��
		boolean l = true;
		boolean m=false;
		System.out.println("boolean: "+l+", "+m);
		byte num1=10;
		byte num2=20;
		int num3=0;
		num3=num1+num2;
		System.out.println(num1+"+"+num2+"="+num3);
		
	}//main
}//class
