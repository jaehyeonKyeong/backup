package day0404;

/**
 *	사람을 상속받은 자식 클래스를 사용
 * @author owner
 */
public class UsePerson {
	
	public static void main(String[] args) {
		//부모클래스의 자원 사용 : 변수 사용
		HongGilDong gildong = new HongGilDong();
		Clark superman = new Clark();
		//부모클래스의 자원 사용 : method 사용
		gildong.setName("홍길동");
		superman.setName("클락 켄트");
		System.out.println(gildong.getName()+"의 눈 "+gildong.getEye()+"개, 코 "+gildong.getNose()+"개, 입 "+gildong.getMouse()+"개");
		
		//동사적인 특인
		System.out.println(gildong.eat());
		System.out.println(gildong.eat("국밥", 1));
		System.out.println(superman.eat());
		System.out.println(superman.eat("피자", 5));
		
		//자식만의 특징
		System.out.println(gildong.fight(6)+"싸움 후 레벨"+gildong.getLevel());
		System.out.println(gildong.fight(7)+"싸움 후 레벨"+gildong.getLevel());
		System.out.println(gildong.fight(10)+"싸움 후 레벨"+gildong.getLevel());
		System.out.println(gildong.fight(8)+"싸움 후 레벨"+gildong.getLevel());
		
		System.out.println(superman.stoneType("짱돌")+" 돌을 가진후 힘 "+superman.power);
		System.out.println(superman.stoneType("다이아몬드")+" 돌을 가진후 힘 "+superman.power);
		System.out.println(superman.stoneType("크립토나이트")+" 돌을 가진후 힘 "+superman.power);
		
		System.out.println("----------------------------------------------------------------------");
		//상속관계의 객체화(is a 관계의 객체화)
		//부모클래스명 객체명 = new 자식클래스생성자();
		//부모클래스생성자로 자식클래스를 생성 할 수는 없다
		Person p= new HongGilDong();
		Person p1 = new Clark();
		//Override한 method가 있다면 자식의 method가 호출된다
		System.out.println(p.eat("칼국수",30));
		System.out.println(p1.eat("구내식당",300));
		//is a 관계의 객체화를 하게 되면 자식클래스의 변수,method는 사용할 수 없다
//		p.fight(30);
//		p1.stoneType("다이아몬드");
		
		LeeHyungSik lhs = new LeeHyungSik(); // 자식객체 생성
		lhs.setName("이형식"); //이름 설정
		lhs.setAddress("서울시 서초구 양재동"); //주소 설정
		lhs.print(); //주소 출력
		System.out.println(lhs.eat()); //Override 된 method 출력 - parameter 없음
		System.out.println(lhs.eat("닭꼬치", 3000));//Override 된 method 출력 - parameter 있음
		
		//가위바위보 5번 
		String myChoice;
		int cnt=5;
		for(int i=0;i<cnt;i++) {
			myChoice=lhs.selectChoice();
			System.out.println(lhs.rockPaperScissors(myChoice));
		}
		
		System.out.println("--------------------------------------------");
		String[] lang = superman.language();
		System.out.println(superman.getName()+"이 구사하는 언어");
		for(int i=0;i<lang.length;i++) {
			System.out.println(lang[i]);
		} //end for
		
		lang=gildong.language();
		System.out.println(gildong.getName()+"이 구사하는 언어");
		
		for(String value : lang) {
			System.out.println(value);
		}//end for
		System.out.println("--------------------------------------------");
		System.out.println(superman.speed());
		System.out.println(superman.height());
		
		
		
		
	}// main

}//class
