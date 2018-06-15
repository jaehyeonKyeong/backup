package day0430;

@FunctionalInterface
public interface TestLambda1 {
	// method의 반환형이 String이기 때문에 lambda식으로 생성할 때 인터페이스 객체에 할당 될 수 없으므로, 일반 클래스로 구현하여
	// 사용
	public void printName(String name);
	}
