package day0321;
/**
	��������
	method ���� �����ϴ� ����
*/
class TestLocalVariable{
	public static void main(String[] args){
		//1.���� ���� : �������� ������;
		int age1=21;
		int my_age;
		int my$age;
		//���� �̸��� ������ �����ϸ� error
		//double age;
		//2.�� �Ҵ� : ������ = ��;
		
		age1 = 21;
		my_age = 22;
		my$age = 23;
		//3. �� ��� : ���, �ٸ� ������ �Ҵ�, ����
		System.out.println(age1);
		System.out.println(my_age);
		System.out.println(my$age);
		System.out.println(age1+my_age+my$age);


	}//main
}//class