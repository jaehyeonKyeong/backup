package day0323;
/**
	����(����)������
	?:
*/

class  Operator6{
	public static void main(String[] args){
		int i = -23;
		System.out.println(i+"��(��) "+(i>=0?"����Դϴ�":"�����Դϴ�"));

		//����,�̼��� ����

		int age=20;
		System.out.println("���� "+age+"���� "+(age>=20?"�����Դϴ�.":"�̼����Դϴ�"));

		int temp=0;
		//���׿����ڴ� ��ȯ�ϴ� ���� ���������� �޶� �ȴ�.
		System.out.println(i+"��(��) "+(i>=0?"����Դϴ�":temp));

		//
		int absolute=-30;
		//���� ������ ���밪�� ���ؼ� ��ȯ�ϴ� ���׿����ڸ� �ۼ�
		System.out.println(absolute+"�� ���밪�� "+(absolute>=0?absolute:-absolute)+"�Դϴ�");
	}//main
}//class