package day0404;

public class TestSub extends TestSuper {
	
	int j;
	int k;
	
	public TestSub() {
		System.out.println("자식의 생성자");
	}//Testsub
	
	public void print() {
		System.out.println("자식 j="+j+", k="+k); //현재클래스의 변수
//		System.out.println("자식 j="+this.j+", k="+this.k); //현재클래스의 변수 //현재클래스의 변수를 this.변수 형태로 호출 가능
		System.out.println("자식(부모) i="+this.i+"/"+super.i); // this.i와 super.i가 동일하게 부모의 변수 i를 지칭 - i 변수는 부모클래스에만 존재
		//부모클래스와 자식클래스의 변수명이 같다면 자식것을 먼저 사용
		j=3000; // this.j=3000;
		super.j=1000;
		System.out.println("자식 j="+j+", 부모 j="+super.j);
//		System.out.println("자식 j="+this.j+", 부모 j="+super.j);
		System.out.println("-----------------------------------------------------");
		super.print(); //부모의 method를 호출
		//print(); //자신의 method 호출 (재귀호출 : recursive call) - StackOverFlowError가 발생할 수 있다
		
	}

	public static void main(String[] args) {
		TestSub ts= new TestSub();
		ts.print();
//		System.out.println(super); // 객체가 생성되기 전에 호출 되는 static 영역에서는 객체의 주소로 대체되는 this나 super를 사용할 수 없다
		
	}//main

}//class
