package day0322;
/*
	����(����) ������
	? : 
*/

class Operator6 {
	public static void main(String[] args) {
		int i=-23;
		System.out.println(i+"�� "+(i>=0? "���":"����"));
		
		//����, �̼��� �����ϴ� ���׿���
		int age=29;
		int temp=0;
		System.out.println(age+"���� "+(age>=20?"����":"�̼���")+"�Դϴ�");

		//���׿����ڴ� ��ȯ�ϴ� ���� ���������� �޶� �ȴ�
		System.out.println(age+"���� "+(age>=20?"����":temp)+"�Դϴ�");

		int absolute=-12;
		//���� ������ ���밪�� ���ؼ� ��ȯ�ϴ� �ڵ�
		absolute=(absolute>=0? absolute : -absolute);
		System.out.println(absolute);

	}//main
}//class
