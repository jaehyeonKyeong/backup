package day0322;
/*
	���� ����ȯ : �����ڰ� ���ϴ� ������������ �Ͻ����� ��ȯ�� �ϴ� ��
*/
class Casting{
	public static void main(String[] args) {
		float f = (float) 3.22; //���
		System.out.println("���� ����ȯ�Ǿ� �Ҵ�� �� :"+f);

		double d = 3.22;
		float f1 = (float) d; //����
		System.out.println("double���� ���� ����ȯ�Ǿ� �Ҵ�� �� :"+f1);
		
		int i = (int) d; //���� ����ȯ�� �� �ս��� �߻��� �� �ִ�
		System.out.println("double���� int�� ���� ����ȯ�Ǿ� �Ҵ�� �� :"+i);

		//boolean�� ���� ����ȯ�� �ٸ������� �� �� ����
		boolean b = true;
		//int j = (int) b; �Ұ�
		boolean b1 = (boolean) b;
		System.out.println("boolean : "+b+","+b1);

		//�ڵ� ����ȯ�� ���� ���� ����ȯ
		byte num1 = 10, num2 = 20, result = 0;
		result = (byte) (num1 + num2);
		System.out.println(num1+"+"+num2+"="+result);


		//������(String)�� �⺻��(int)�δ� ���� ����ȯ�� ���� �ʴ´�
		//String s = "22";
		//int temp = (int) s;  //error
		//�⺻��(int)�� ������(String)���δ� ���� ����ȯ�� ���� �ʴ´�
		//int temp = 22;
		//String s = (String) temp;  //error



	}
}
