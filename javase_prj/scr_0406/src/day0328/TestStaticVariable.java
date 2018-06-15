package day0328;

/**
 *	static 변수(class 변수) <br>
 *	class field에 static을 붙여서 선언하는 변수 <br>
 *	실행되는 JVM에서 하나만 생성되고 사용되는 변수 <br>
 *	1. 선언 ) public(선택) static 데이터형 변수명; <br>
 *	2. 값 할당 ) 클래스명.변수명 = 값; //객체명으로 사용하지 않는다 <br>
 *	3. 값 사용 ) 클래스명.변수명 <br>
 * @author owner
 */
public class TestStaticVariable {
	
			//1. static 변수의 선언
			static int i;
			//instance 변수의 선언
			int j;		

	public static void main(String[] args) {
		//static 변수는 자동 초기화가 된다.
		System.out.println(TestStaticVariable.i);
		// 2. 값 할당
		i=100;
		
		// 3. 값 사용
		System.out.println(i);
		
		/////// 객체가 여러개 생성되더라도 static 변수는 하나만 생성
		TestStaticVariable tsv1 = new TestStaticVariable();
		TestStaticVariable tsv2 = new TestStaticVariable();
		TestStaticVariable tsv3 = new TestStaticVariable();
		
		tsv1.j=10;
		tsv2.j=20;
		tsv3.j=30;
		
		//특정 객체가 공용변수를 가진것이 아니기 때문에
		//객체명.static변수명으로 사용하면 사용은 되나 경고가 보여진다
		// 클래스명.변수명 으로 사용 할 것!!!!!!
		
		//static 변수에 객체를 이용한 접근은 권장되지 않는다
//		tsv1.i=200; //static 변수 : 생성된 모든 객체가 하나의 값을 사용
//		System.out.println(TestStaticVariable.i);
//		System.out.println("tsv1 j (각각) : "+tsv1.j+", 공용 : "+tsv1.i);
//		tsv2.i=300;//static 변수 : 생성된 모든 객체가 하나의 값을 사용
//		System.out.println("tsv2 j (각각) : "+tsv2.j+", 공용 : "+tsv2.i);
//		System.out.println("tsv3 j (각각) : "+tsv3.j+", 공용 : "+tsv3.i);
		
		
		
		
		
		

	}

}
