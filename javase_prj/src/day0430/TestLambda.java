package day0430;

//abstract method를 단 하나 가지고 있는 인터페이스를 함수형 인터페이스
//또는 SAM(Single Abstract Method)라고 한다.
@FunctionalInterface
public interface TestLambda {
	public void test();
}
