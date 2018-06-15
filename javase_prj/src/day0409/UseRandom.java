package day0409;

import java.util.Random;

/**
 * 난수를 발생시키기 위한 클래스
 * 
 * @author owner
 */
public class UseRandom {
	public UseRandom() {
		Random r=new Random();
		System.out.println(r);
		int i=r.nextInt();
		int j=r.nextInt(10);//발생시킬 1~10 범위를 설정
	
		System.out.println("매개변수 없음 "+i);
		System.out.println("매개변수 없음 범위 "+i%10);		
		System.out.println("매개변수 없음 범위 양수만"+Math.abs(i%10));		
		System.out.println("매개변수 있음 "+j);
		
		//불린 난수
		boolean b= r.nextBoolean();
		System.out.println(b);
		
		//실수 난수
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
