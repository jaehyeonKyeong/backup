package day0330;

/**
 * Call by Value : method의 매개변수가 기본형을 정의하면 입력값이 복사되어 할당됩니다.(원래변수에 변경된 값이 적용되지 않는다.)
 * @author owner
 */
public class CallByValue {
	public void swap(int i, int j) {
		int temp=0;
		temp=i;
		i=j;
		j=temp;
		System.out.println("swap method : i ="+i+", j="+j);
		
	}

	public static void main(String[] args) {
		CallByValue cbv=new CallByValue();
		int i=100,j=200;
		System.out.println("swap호출전 i="+i+", j ="+j);
		cbv.swap(i, j);
		System.out.println("swap호출후 i="+i+", j ="+j);
	}
}
