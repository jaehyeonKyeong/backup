package day0405;

import day0404.Clark;
import day0404.Person;

/**
 *	������ ��ü�� Ư�� Ŭ�����κ��� �����Ǿ����� ����� ������	
 * @author owner
 */
public class UseInstanceof {
	
	public UseInstanceof() {
		Clark c = new Clark();
		//Clark�� Person�� ��Ӱ����̰� Fly�� ��������(is a)
		//c ��ü�� Clark���� �����Ǿ�����
		if(c instanceof Clark) {
			System.out.println("Clark���� ���� ����");
		} else {
			System.out.println("Clark���� ���� ����");
		}
		//c ��ü�� Person���� �����Ǿ����� - �θ�Ŭ���� O
		if (c instanceof Person) {
			System.out.println("Person���� ���� ����");
		} else {
			System.out.println("Person���� ���� ����");
		}
		// c ��ü�� Fly���� �����Ǿ����� - interface O
		if (c instanceof Fly) {
			System.out.println("Fly���� ���� ����");
		} else {
			System.out.println("Fly���� ���� ����");
		}
		// c ��ü�� UseInstanceof���� �����Ǿ����� - X
//		if (c instanceof UseInstanceof) {
//			System.out.println("UseInstanceof���� ���� ����");
//		} else {
//			System.out.println("UseInstanceof���� ���� ����");
//		}
		
		

	}// UseInstanceof

	public static void main(String[] args) {

		new UseInstanceof();
		

	}//main

}//class
