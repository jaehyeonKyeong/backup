package day0409;

import java.util.Random;

/**
 * ������ �߻���Ű�� ���� Ŭ����
 * 
 * @author owner
 */
public class UseRandom {
	public UseRandom() {
		Random r=new Random();
		System.out.println(r);
		int i=r.nextInt();
		int j=r.nextInt(10);//�߻���ų 1~10 ������ ����
	
		System.out.println("�Ű����� ���� "+i);
		System.out.println("�Ű����� ���� ���� "+i%10);		
		System.out.println("�Ű����� ���� ���� �����"+Math.abs(i%10));		
		System.out.println("�Ű����� ���� "+j);
		
		//�Ҹ� ����
		boolean b= r.nextBoolean();
		System.out.println(b);
		
		//�Ǽ� ����
		float f=r.nextFloat();
		double d=r.nextDouble();
		System.out.println("float : "+f);
		System.out.println("float : "+(int)(f*10));
		System.out.println("double : "+d);
		System.out.println("double : "+(int)(d*10));
	}// constructor

	public static void main(String[] args) {
		new UseRandom();
	}

}
