package kr.co.sist.service;

import org.springframework.stereotype.Component;

@Component
public class TestService {
	public void serviceA() {
		System.out.println("종민의 업무로직");
	}
	public void serviceB() {
		System.out.println("요정의 업무로직");
	}
	public void serviceC() {
		System.out.println("노을이의 업무로직");
	}
	public void userName(String name) {
		System.out.println("Service : "+name+"님 안녕?");
	}
	public void userAddr(String addr1,String addr2) {
		System.out.println("Service : 당신의 주소는 "+addr1+", "+addr2+"이에요");
		
	}
}
