package day0328;

/**
 * instance variable(=member 변수) 사용<br>
 * class field에 선언하고 사용하는 변수<br>
 * 객체가 생성될때 (객체화 : class명 객체명 = new class명();)<br>
 * 메모리에 올라고(heap) 객체가 소멸될때<br>
 * (Garbage collector : 메모리를 정리하는 자바의 객체) 사라진다.<br>
 * 작성법 ) <br>
 * 1. 선언 : 접근지정자 데이터형 변수명 =(필요시)값; ※ 바로 값할당 하는 것은 권장하지 않음 <br>
 * 2. 객체 생성 : class명 객체명 = new class명();<br>
 * 3. 값 할당 : 객체명.변수명 = 값; // 영역이 같다면 객체명은 생략가능<br>
 * 4. 값 사용 : 객체명.변수명; //영역이 같다면 객체명은 생략가능
 * 
 * 
 * @author owner
 */
public class TestInstanceVariable {
	// 1)선언
	int i; // instance 변수(=member 변수)
	int j;

	public static void main(String[] args) {
		// static 영역에서는 instance변수를 직접 참조할수 없다 error
		// System.out.println(i);
		// 2) 객체화
		TestInstanceVariable tiv = new TestInstanceVariable();
		TestInstanceVariable tiv1 = new TestInstanceVariable();
		 System.out.println("객체명 : "+tiv); //heap의 주소 : 10dea4e(16진수)
		 System.out.println("객체명 : "+tiv1); //heap의 주소 : 647e05
		 //3)값할당
		// 인스턴스 변수는 객체마다 같은 이름으로 생성된다
		 tiv.i=3;
		 tiv.j=28;
		 
		 tiv1.i=11;
		 tiv1.j=9;
		 
		 //4) 값 사용
		 System.out.println("tiv객체가 가지고있는 인스턴스 변수 i :"+tiv.i);
		 System.out.println("tiv1가 가지고있는 인스턴스 변수 j:"+ tiv1.j);
		 System.out.println("둘의 합 : "+ (tiv.i+tiv1.j));
		 
	}// main

}// class
