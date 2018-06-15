package day0404;

import day0405.Fly;

/**
 * Person 클래스의 자식 클래스 <br>
 * 사람의 공통 특징(눈,코,입,이름,먹는일)은 Person에서 가져다 사용하고 <br>
 * 자신만의 특징(힘이 쎄다)만 정의 <br>
 * final 클래스이므로 자식 클래스가 있을 수 없다(상속되지 않는 클래스) <br>
 *  힘은 최대 10까지만 설정
 * @author owner
 */
public final class Clark extends Person implements Fly{
	public int power;
	
	public Clark() {
		power=10;
	}//Clark
	
	public String stoneType(String stone) {
		String result="";
		if(stone.equals("다이아몬드")) {
			result="감사합니다.";
			power=10;
		} else if (stone.equals("크립토나이트")) {
			result="힘이 빠진다. ~(_-_)~";
			power=0;
		} else {
			result="기분나쁨 ㅡㅡ;;";
			power=11;
		}//end else
		return result;
	}
	
	/* (non-Javadoc)
	 * 부모클래스에서 제공하는 기능이 맞지 않아 Override
	 * @see day0404.Person#eat(java.lang.String, int)
	 */
	@Override
	public String eat(String menu,int price) {
		return getName()+"이 레스토랑에서 "+menu+"인 음식을 "+price+"$ 내고 사먹습니다.";
	}//eat(String,int)
	
	public String eat() {
		return getName()+"가 집에서 빵을 먹는다.";
	}//eat

	@Override
	public String[] language() {
		String[] lang= {"영어","외계어"};
		return lang;
	}
	
	@Override
	public String speed() {
		return getName()+"은 빠르게 난다.";
	}
	
	
	@Override	
	public String height() {
		return getName()+"은 높이 난다.";
	}
	
	

}//class
