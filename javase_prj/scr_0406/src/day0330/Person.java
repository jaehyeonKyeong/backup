package day0330;

/**
 *	사람을 대상으로 만드는 클래스 <br>
 *	명사적인 특징 - 눈, 코, 입, 이름 <br>
 *	동사적 특징 - 먹는 일 <br>
 *	사용법) Person 객체명 = new Person(); 의 문법으로 객체화하여 사용한다 <br>
 *
 * @author owner
 */
public class Person {
	private int eye,nose,mouse;	// 눈,코,입
	private String name; //이름 
	
	/**
	 * Person의 기본생성자 : 사람이 태어날 때 사용한다. <br>
	 * 사람이 태어나면 기본적으로 눈 2개, 코 1개, 입 1개를 설정 하는 일 <br>
	 */
	public Person() {
		this(2,1,1);
//		eye=2;
//		nose=1;
//		mouse=1;
	}//Person
	
	/**
	 * 눈 2개, 코1개, 입 1개가 아닌 사람 객체를 생성할 때 사용하는 생성자
	 * @param eye 눈 갯수
	 * @param nose 코 갯수
	 * @param mouse 입 갯수
	 */
	public Person(int eye, int nose, int mouse) {
		this.eye=eye;
		this.nose=nose;
		this.mouse=mouse;
	}//Person
	
	/**
	 * 생성된 사람 객체의 눈의 갯수를 불러오는 일
	 * @return 눈의 갯수
	 */
	public int getEye() {
		return eye;
	}
	
	/**
	 * 생성된 사람 객체에 눈의 갯수를 입력하는 일
	 * @param eye 눈의 갯수
	 */
	public void setEye(int eye) {
		this.eye = eye;
	}
	
	/**
	 * 생성된 사람 객체의 코의 갯수를 불러오는 일
	 * @return 코의 갯수
	 */
	public int getNose() {
		return nose;
	}
	
	/**
	 * 생성된 사람 객체에 코의 갯수를 입력하는 일
	 * @param nose 코의 갯수
	 */
	public void setNose(int nose) {
		this.nose = nose;
	}
	
	/**
	 * 생성된 사람 객체의 입의 갯수를 불러오는 일
	 * @return 입의 갯수
	 */
	public int getMouse() {
		return mouse;
	}
	
	/**
	 * 생성된 사람 객체에 입의 갯수를 입력하는 일
	 * @param mouse 입의 갯수
	 */
	public void setMouse(int mouse) {
		this.mouse = mouse;
	}
	
	/**
	 * 생성된 사람 객체의 이름을 불러오는 일
	 * @return 이름
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 생성된 사람 객체에 이름을 입력하는 일
	 * @param name 이름
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 생성된 사람 객체가 집에서 밥을 먹는 행위
	 * @return 밥을 먹는 행동
	 */
	public String eat() {
		return "눈이 " + eye+"개, 코가 "+nose+"개, 입이 "+mouse+"개 인 "+name+"이(가) "+"집에서 밥을 먹습니다.";
	}
	
	/**
	 * 생성된 사람 객체가 식당에서 밥을 사먹는 행위
	 * @param food 음식이름
	 * @param price 음식가격
	 * @return eat()식당에서 먹는 행동
	 */
	public String eat(String food, int price) {
		return "눈이 " + eye+"개, 코가 "+nose+"개, 입이 "+mouse+"개 인 "+name+"이(가) 식당에서 "+price+"원인 " +food+"을(를) 사먹습니다.";
	}

}
