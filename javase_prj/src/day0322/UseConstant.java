package day0322;
/**
	�ٸ� Ŭ���� �ȿ� �����ϴ� ��� ���
*/
class UseConstant{
	public static void main(String[] args) 
	{
		//TestConstant.MAX_VALUE=10000;//�� ���� �Ұ���
		//Ŭ������.�����
		System.out.println(TestConstant.MAX_VALUE);
		System.out.println("byte�� �ּҰ� : "+Byte.MIN_VALUE+", �ִ밪 :"+Byte.MAX_VALUE+", ũ��:"+Byte.BYTES);
		System.out.println("long�� �ּҰ� : "+Long.MIN_VALUE+", �ִ밪 :"+ Long.MAX_VALUE);

		int num1=10;//10����
		int num2=012;//8����
		int num3=0xa;//16����

		System.out.println(num1+" / "+num2+" / "+num3);
		System.out.println(num1+num2+num3);

		//Wrapper class(Integer)�� ��� (method ȣ��)
		//10���� ���� 2������ ���ڿ��� ���
		System.out.println(num1+" ��(��) 2������ "+Integer.toBinaryString(num1));
		System.out.println(num1+" ��(��) 8������ "+Integer.toOctalString(num1));
		System.out.println(num1+" ��(��) 16������ "+Integer.toHexString(num1));

		

	}//main
}//class
