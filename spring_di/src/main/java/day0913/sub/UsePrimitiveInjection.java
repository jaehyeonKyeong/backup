package day0913.sub;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsePrimitiveInjection {

	public static void main(String[] args) { 
		//1.SpringContainer 생성
		ApplicationContext ac=new ClassPathXmlApplicationContext("day0913/sub/applicationContext1.xml");
		//2.객체(bean) 얻기 : method가 매게변수로 Class<T>을 가지면 클래스 파일명을 직접 넣어준다. (Reflect)
		PrimitiveInjection pi=ac.getBean(PrimitiveInjection.class);
		System.out.println("int : "+pi.getIntValue()+"\nlong : "+pi.getLongVal()+"\nString : "+pi.getStrVal());
	}

}
