package day0321;
/**
	���������� ���
	method���� �����ϴ� ����
*/
class TestLocalVarable{

	public static void main(String[] args){

		//1. ������ ���� : �������� ������;
		int age;
		//double age;// ���� �̸��� ������ �����ϰ� �Ǹ� error
		//int month;//�ʱ�ȭ ���� ���� ������ ��� error
		//�ʱ�ȭ : ���� ����� �� �Ҵ��� ���ÿ� �� ��
		//2. ���Ҵ� : ������=��;
		int month=3;
		//�������� �ѱ۵� ����(�ƹ��� ���� ����)
		int ����=25;
		//���ڴ� �������� ���� ó���� ���� ����(�������̳� �߰��� ����)
		//int 1age=3; //error
		// ���������� ��밡���� Ư������'_','$' // _ �� ���̳ʽ��� ȥ�� $�� �ٸ� ��ɰ� �򰥸��� ������ �������� ����.
		int my_age;
		int my$age;
		int age1;
		age1=21;
		my_age=22;
		my$age=23;
		age=20;
		//3.�� ��� : ���, ���Ҵ�(�ٸ������� �Ҵ�), ����
		System.out.println(age);
		System.out.println(month);
		System.out.println(����);
		System.out.println(age1);
		System.out.println(my_age);
		System.out.println(my$age);
		System.out.println(age1+my_age+my$age);

	}//main

}//class