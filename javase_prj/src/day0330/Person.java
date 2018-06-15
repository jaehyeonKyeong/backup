package day0330;

/**
 * 사람을 대상으로 만드는 class<br>
 * 사람의 명사적인 특징 : 눈,코,입,이름<br>
 * 사람의 동사적인 특징 : 먹는일.<br>
 * 사용법) Person 객체명 = new Person();의 문법으로 객체화 하여 사용한다.
 * 
 * @author owner
 */
////////04-05-2018 추상클래스로 변경////////
public abstract class Person {
	
	private int eye,nose,mouth; //눈,코,입;
	private String name; //이름;
	
	/**
	 * Person의 기본생성자 : 사람이 태어날때 사용한다<br>
	 * 사람이 태어나면 기본적으로 눈2개,코1개,입1개를 설정하는일
	 */
	public Person() {
		this(2,1,1);
	}//default
	/**
	 * 눈2개,코1개,입1개가 아닌 사람 객체를 생성할때 사용하는 생성자
	 * @param eye 눈 갯수
	 * @param nose 코 갯수
	 * @param mouth 입 갯수
	 */
	public Person(int eye,int nose,int mouth) {
		this.eye=eye;
		this.nose=nose;
		this.mouth=mouth;	
	}//default
	/**
	 * 생성된 사람 객체에 눈의 갯수를 설정하는 일.
	 * @param eye 눈의 갯수
	 */
	public void setEye(int eye) {
		this.eye=eye;
	}
	/**
	 * 생성된 사람 객체에 코의 갯수를 설정하는 일.
	 * @param nose 코의 갯수
	 */
	public void setNose(int nose) {
		this.nose=nose;
	}
	/**
	 * 생성된 사람 객체에 입의 갯수를 설정하는 일.
	 * @param mouth 입의 갯수
	 */
	public void setMouth(int mouth) {
		this.mouth=mouth;
	}
	/**
	 * 생성된 사람 객체의 이름을 설정하는 일
	 * @param Name 사람 객체의 이름
	 */
	public void setName(String name) {
		this.name=name;
	}
	/**
	 *  생성된 사람 객체에 설정된 눈의 갯수를 반환하는 일
	 * @return 눈의 갯수
	 */
	public int getEye() {
		return eye;
	}
	/**
	 * 생성된 사람 객체에 설정된 코의 갯수를 반환하는 일
	 * @return 코의 갯수
	 */
	public int getNose() {
		return nose;
	}
	/**
	 * 생성된 사람 객체에 설정된 코의 갯수를 반환하는 일
	 * @return 입의 갯수
	 */
	public int getMouth() {
		return mouth;
	}
	/**
	 * 생성된 사람 객체에 설정된 이름을 반환하는 일
	 * @return 이름
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 생성된 사람 객체가 먹는 일 구현
	 * @return밥을 집에서 먹는 행동
	 */
	public abstract String eat(); 	/**
	 * 생성된 사람 객체가 집밖에서 먹는일 구현
	 * @param menu 사먹는 메뉴
	 * @param price 메뉴의 가격
	 * @return 밖에서 먹는 일;
	 */
	public abstract String eat(String menu,int price);
	
	/**
	 * 사람객체가 구사할 수 있는 언어.
	 * @return
	 */
	public abstract String[] language();
	public String height() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	


}
