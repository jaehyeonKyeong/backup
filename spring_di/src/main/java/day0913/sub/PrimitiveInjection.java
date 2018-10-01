package day0913.sub;

import lombok.Getter;

/**
 * 기본형 데이터형에 대한 의존성 주입
 * @author owner
 */
@Getter
public class PrimitiveInjection {
	private int intValue; 
	private long longVal;
	private String strVal;
	
	public PrimitiveInjection(int intValue) {
		System.out.println("int");
		this.intValue = intValue;
	}
	public PrimitiveInjection(long longVal) {
		System.out.println("long");
		this.longVal = longVal;
	}
	public PrimitiveInjection(String strVal) {
		System.out.println("String");
		this.strVal = strVal;
	}
	
}
