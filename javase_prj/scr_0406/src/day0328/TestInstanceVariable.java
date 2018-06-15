package day0328;

/**
 *	instance variable(member 변수) 사용 <br>
 *	클래스field에 선언하고 사용하는 변수 <br>
 *	객체가 생성될 때(객체화: 클래스명 객체명 = new 클래스명();) <br>
 *	메모리에 올라가고(heap) 객체가 소멸될 때 사라진다 <br>
 *	(Garbage collector : 메모리를 정리하는 객체)<br>
 *	작성법)<br>
 *		1. 선언) 접근 지정자 데이터형 변수명 = 값;<br>
 *		2. 객체 생성) 클래스명 객체명 = new 클래스명(); <br>
 *		3. 값 할당) 객체명.변수명=값; //영역이 같다면 객체명은 생략 가능 <br>
 *		4. 값 사용) 객체명.변수명; //영역이 같다면 객체명은 생략 가능 <br>
 *
 * @author owner
 */
public class TestInstanceVariable {
	// 1.선언)
	int i; //member 변수 = instance 변수
	int j; //member 변수 = instance 변수
	static int s=999;
	TestInstanceVariable(int i, int j){
		this.i=i+j;
		this.j=i*j;
	}

	public static void main(String[] args) {
		// 2. 객체화)
		TestInstanceVariable tiv = new TestInstanceVariable(3,5);
		TestInstanceVariable tiv1 = new TestInstanceVariable(2,8);
		
		System.out.println(tiv.i);
		System.out.println(tiv.j);
		
		System.out.println(tiv1.i);
		System.out.println(tiv1.j);
		
		System.out.println("객체명 : "+tiv); //heap의 주소
		//10dea4e(16진수) -> 0001 0000 1101 1110 1010 0100 1110
		System.out.println("객체명 : "+tiv1);
		//677e05(16진수) 
		
		// 3. 값 할당)
		tiv.i=3;
		tiv.j=28;
		
		tiv1.i=11;
		tiv1.j=9;
		
		// 4. 값 사용)
		
		System.out.println("tiv객체가 가지고 있는 instance 변수 i :"+tiv.i+", j: "+tiv.j);
		System.out.println("tiv1객체가 가지고 있는 instance 변수 i :"+tiv1.i+", j: "+tiv1.j);
		
		System.out.println(s);
		System.out.println(TestInstanceVariable.s);
//		System.out.println(this.s); // this는 생성자에서만 사용가능?
		
		System.out.println(s);
		
		//static 변수에 객체를 이용한 접근은 권장되지 않는다
//		TestInstanceVariable newt= new  TestInstanceVariable(1,2);
//		newt.s=888;
//		System.out.println(newt.s);
		
		
		

	}

}
