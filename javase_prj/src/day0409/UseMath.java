package day0409;

/**
 * �߻�Ŭ������ �ƴ����� ��ü�� �����Ͽ� ������� �ʴ� Ŭ����
 * 
 * @author owner
 */
public class UseMath {
	public UseMath() {
		// Math m=new Math(); // �����ڰ� private���������ڿ��� ��ü�� ������ �� ����
		System.out.println("-9�� ���밪 : "+Math.abs(-9));
		System.out.println("3.4�� �ݿø� : "+Math.round(3.4));
		System.out.println("3.4�� �ø� : "+Math.ceil(3.4));
		System.out.println("3.4�� ���� : "+Math.floor(3.4));
		double d=Math.random();
		System.out.println("�߻� ���� : "+d);
		System.out.println("���� ���� : "+d*10);
		System.out.println("���� ���� : "+(int)(d*10));
		
		//���� �ҹ��� (a(97)~z(122) : 25��)
		//�빮�� (65)
		//����(4)
		System.out.println((char)(d*26+97));
		
		
		

	}// contructor

	public static void main(String[] args) {
		new UseMath();
	}// main

}// class
