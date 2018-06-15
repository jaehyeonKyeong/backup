package day0404;

/**
 * Person 클래스의 자식 클래스 <br>
 * 사람의 공통 특징(눈,코,입,이름,먹는일)은 Person에서 가져다 사용하고 <br>
 * 자신만의 특징(싸움잘함)만 정의 <br>
 * 싸움 레벨은 만렙 10
 * 
 * @author owner
 */
public class HongGilDong extends Person {

	private int level;

	/**
	 * 기본생성자 : 생성되면 싸움능력이 7로 설정
	 */
	public HongGilDong() {
		level = 7;
	}// HongGilDong
	
	
	/**
	 * 현재 홍길동의 싸움 능력치
	 * @return 능력
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param your_level
	 * @return 싸움의 결과
	 */
	public String fight(int your_level) {
		String result = "";
		if (level > your_level) {
			result = "이겼음.s('.^)v;";
			level++;
			if (level > 10) {
				level = 10;
			}
		} else if (level < your_level) {
			result = "졌음. Orz";
			level--;
			if (level < 0) {
				level = 0;
			}
		} else {
			result = "비겼음";
		}
		return result;
	} // fight
	
	/* (non-Javadoc)
	 * 	부모클래스에서 제공하는 기능이 맞지 않아 Override
	 * @see day0404.Person#eat(java.lang.String, int)
	 */
	@Override
	public String eat() {
		return getName()+"이 집에서 막을 먹습니다.";
	}
	
	@Override
	public String eat(String menu,int price) {
		return getName()+"이 주막에서 "+menu+"인 음식을 "+price+"냥 내고 사먹습니다.";
	}
	
	public String[] language() {
		return "한국어,중국어,수화".split(",");
	}//language
	
}//class
