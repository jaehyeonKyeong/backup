package day0406;

public class TestInterImpl implements TestInter {

	@Override
	public void test() {
		System.out.println("TestInterImpl에서 구현한 method");
	}

	@Override
	public String week() {
		return "금요일";
	}

}
