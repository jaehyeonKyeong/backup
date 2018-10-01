package day0914;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseAnnotation {
	
	
	public static void main(String[] args) {
		//1.SpringContainer생성
		ApplicationContext ac=new ClassPathXmlApplicationContext("day0914/applicationContext4.xml");
		//2.bean얻기
		Songs jaewon=ac.getBean(Songs.class);
		System.out.println(jaewon.getKjh().doWork());
	}
}
