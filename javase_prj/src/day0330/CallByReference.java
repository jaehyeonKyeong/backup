package day0330;

/**
 * method의 매개변수가 class(객체)를 parameter로 정의하면 하나의 객체가 생성되고 그 주소가 그대로 전달됨.
 * 원본 변수의 값이 변경된다
 * @author owner
 */
public class CallByReference {
	private int i;
	private int j;
	
	public void swap(CallByReference cbr) {//참조형 parameter
		int temp=0;
		temp=cbr.i;
		cbr.i=cbr.j;
		cbr.j=temp;
		System.out.println("swap 내  cbr.i= "+cbr.i+", cbr.j = "+cbr.j);
	}

	public static void main(String[] args) {
		CallByReference cbr=new CallByReference();
		cbr.i=100;
		cbr.j=200;
		System.out.println("swap 전  cbr.i= "+cbr.i+", cbr.j = "+cbr.j);
		cbr.swap(cbr);//객체는 하나만 생성되고 그 주소가 전달된다.
		//주소는 하나만 생성되고 전달 되므로 주소를 전달받은 method 안에서 값을 변경하면 원본 변수의 값이 변경된다.
		
		System.out.println("swap 후  cbr.i= "+cbr.i+", cbr.j = "+cbr.j);

	}

}
