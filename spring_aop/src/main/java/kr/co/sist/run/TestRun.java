package kr.co.sist.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.service.TestService;

public class TestRun {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("kr/co/sist/run/applicationContext.xml");
		TestService ts=ac.getBean(TestService.class);
		ts.serviceB();
		ts.serviceC();
		System.out.println("====================");
		ts.userName("뚜딘");
		ts.userAddr("서울시 관악구", "대구 달서구");
	}
}
