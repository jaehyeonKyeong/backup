package day0404;

public class OverrideSub extends OverrideSuper{
	
	//광의의 접근 지정자로 변경 가능
	//default->public, protected 
//	@Overridez
	public void test1(String msg) {
		System.out.println("자식이 변경 test1 "+msg);
	}
	
	//protected -> public
//	@Override
	public void test(int i) {
		System.out.println("자식이 변경 test "+ i);
	}
	
	//public -> public
//	@Override //컴파일러가 컴파일할 때 Override가 제대로 되었는지 체크
	public String myName() {
		return "지승민";
	}

	public static void main(String[] args) {
		OverrideSub os = new OverrideSub();
		os.test(35);
		os.test1("화창한 수요일");
		System.out.println(os.myName());
		
		
		
		

	}

}
