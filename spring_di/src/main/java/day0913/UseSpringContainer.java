package day0913;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseSpringContainer {

	public static void main(String[] args) {
		//2.스프링 컨테이너 생성
		ApplicationContext ac=new ClassPathXmlApplicationContext("day0913/applicationContext.xml"); 
		//3.스프링 컨테이너가 생성한 객체 얻기
		//<bean id=""로 찾는 코드 : Spring2.5-에서 사용가능
//		Class4MemberService cms=(Class4MemberService) ac.getBean("c4ms");
		//Class<T>을 매개변수로 사용하여 객체 얻기
		Class4MemberService cms=ac.getBean(Class4MemberService.class,"c4ms");
		
		
		//4.얻은 객체 사용하기
		cms.addMember("에러요정");
		List<String> list=cms.searchMember(0);
		System.out.println("-----------------------------");
		for(String name:list) {
			System.out.println(name);
		}
	}

}
