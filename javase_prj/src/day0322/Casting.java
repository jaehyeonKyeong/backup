package day0322;
/**
	���� �� ��ȯ: �����ڰ� ���ϴ� ����Ʈ������ �Ͻ������� ��ȯ�� �ϴ°�.
*/
class Casting{
	public static void main(String[] args) {
		
		float f=(float)3.22;//���
		System.out.println("��������ȯ�Ǿ� �Ҵ�Ȱ� : "+f);

		double d=3.22;
		float f1=(float)d;//����
		System.out.println("��������ȯ�Ǿ� �Ҵ�Ȱ� : "+f1);

		int i=(int)d;//��������ȯ�� �� �ս��� �߻��� �� �ִ�
		System.out.println("������ : "+d+", ��ȯ �� : "+i);
		//boolean�� ��������ȯ�� �ٸ������δ� �� �� ����.
		boolean b=true;
		//int j = (int)b;
		boolean b1=(boolean)b;
		System.out.println("������ : "+b+", ��ȯ �� : "+b1);

		//�ڵ��� ��ȯ�� ���� ���� �� ��ȯ
		byte num1=10,num2=20,result=0;
		//�ڵ��� ��ȯ: int�� �������������� ����Ǹ� ����� int�� �߻��ȴ�.
		result=(byte)(num1+num2);
		System.out.println(num1+"+"+num2+"="+result);
		
		//������(String)�� �⺻��(int)�δ� ��������ȯ�� ���� �ʴ´�.(�ݴ뵵 ��������)
		/*String s="22";
		int temp=s;*/
		/*int temp=22;
		String s=(String)temp;*/ // error

	}//main
}//class