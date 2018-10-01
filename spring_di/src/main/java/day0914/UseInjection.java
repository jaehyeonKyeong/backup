package day0914;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseInjection {
	
	public static void main(String[] args) {
		//1.Spring Container 생성 : 설정파일에 존재하는 모든 <bean>이 사용 여부에 상관없이 생성된다 
		ApplicationContext ac=new ClassPathXmlApplicationContext("day0914/applicationContext3.xml"); //("{applicationContext3.xml,..,..,..}")형태 (배열 형태)로 집어넣으면 설정파일을 여러개 넣을 수 있다.
		//2.bean얻기
		//매개변수 하나인 생성자.
		Injection in_single=ac.getBean("in_single_param",Injection.class);
		System.out.println("\n맥애변수 한아 : Data :: "+in_single.getData()+"\n\t: inputdate ::"+in_single.getInputdate());
		//매개변수 여러개인 생성자
		Injection in_multi=ac.getBean("in_multi_param",Injection.class);
		System.out.println("\n맥애변수 열억애 : Data :: "+in_multi.getData()+"\n\t: inputdate ::"+in_multi.getInputdate());
		//method 의존성 주입
		Injection in_method=ac.getBean("in_method",Injection.class);
		System.out.println("\nmethod 으존성 주입 : Data :: "+in_method.getData()+"\n\t: inputdate ::"+in_method.getInputdate());
		
	}
	
}
