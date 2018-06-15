package day0328;

/**
 * static 변수(=class변수)<br>
 * class field에 static을 붙여서 선언하는 변수<br>
 * 실행되는 JVM에서 하나만 생성되고 사용되는 변수.<br>
 * 1.선언법) static+@ 데이터형 변수명; 2.값 할당) class명.변수명=값; // 객체명으로 사용하지 않는다 3.값 사용)
 * class명.변수명
 * 
 * @author owner
 */
public class TestStaticVariable {
	// 1. static 변수의 선언
	static int i;
	int j; // instance 변수

	public static void main(String[] args) {

		// static변수는 자동 초기화
		System.out.println(i);
		// 2.값 할당
		i = 100;
		// 값 사용
		System.out.println(i);

		// 객체가 여러개 생성되더라도 static변수는 하나만 생성
		TestStaticVariable tsv1= new TestStaticVariable();
		TestStaticVariable tsv2= new TestStaticVariable();
		TestStaticVariable tsv3= new TestStaticVariable();
		
		//instance 변수에 값 할당(생성된 객체가 각각 값을 사용
		tsv1.j=10;
		tsv2.j=20;
		tsv3.j=30;
		
		/*//특정 객체가 공용 변수를 가진것이 아니기 때문에 객체명.static변수명으로 사용하면 사용은 되나 경고를 보여줌.
		tsv1.i=200;//static 변수 : 생성된 모든 객체가 하나의 값을 사용
		System.out.println("tsv1 j(각각) : "+tsv1.j+", 공용 : "+tsv1.i);
		System.out.println("tsv2 j(각각) : "+tsv2.j+", 공용 : "+tsv2.i);
		System.out.println("tsv3 j(각각) : "+tsv3.j+", 공용 : "+tsv3.i);
		tsv1.i=300;//static 변수 : 생성된 모든 객체가 하나의 값을 사용
		System.out.println("tsv1 j(각각) : "+tsv1.j+", 공용 : "+tsv1.i);
		System.out.println("tsv2 j(각각) : "+tsv2.j+", 공용 : "+tsv2.i);
		System.out.println("tsv3 j(각각) : "+tsv3.j+", 공용 : "+tsv3.i);*/
		

	}// main

}// class
