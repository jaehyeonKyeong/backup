package kr.co.sist.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAop {
	
	@Before("execution( * serviceB())")
	public void testAdvice() {
		System.out.println("------------------");
		System.out.println("Before 호출되었습니다");
		System.out.println("에러나면 각오해..");
		System.out.println("------------------");
	}
	@Before("execution( * user*(..))")
	public void useJoinPoint(JoinPoint jp) {
		Signature sign=jp.getSignature();
		System.out.println("------------------");
		System.out.println("Advice : "+sign.getName()+" 호출 aop");//메소드 명 얻기
		Object[] paramObj=jp.getArgs();
		System.out.println("Advice : 매개변수갯수 :: "+paramObj.length);
		for(int i=0;i<paramObj.length;i++) {
			System.out.println("Advice : 매개변수 :: "+paramObj[i]);
		}
	}
}
