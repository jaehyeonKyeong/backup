package day0329;

public class MakeRamen {

	public static void main(String[] args) {
		
		//객체생성
		Ramen nuguri = new Ramen();
		
		
		//객체사용
		//기본초기화값 확인
		System.out.println("라면 이름: "+nuguri.getRamenName()+", 라면 개수 : "+nuguri.getRamenNumber()+", 숫자인수 : "+nuguri.getTime()+", 추가 여부 : "+nuguri.isAddMore());
		//값 입력
		nuguri.setRamenName("너구리");
		nuguri.setRamenNumber(2);
		nuguri.setTime(4);
		nuguri.setAddMore(false);
		nuguri.setEatFresh(false);
		
		//입력 값 확인
		System.out.println("라면 이름: "+nuguri.getRamenName()+", 라면 개수 : "+nuguri.getRamenNumber()+", 숫자인수 : "+nuguri.getTime()+", 추가 여부 : "+nuguri.isAddMore());
		System.out.println(nuguri.eat());
		
		Ramen pusiopusio = new Ramen();
		
		pusiopusio.setRamenName("뿌셔뿌셔");
		pusiopusio.setRamenNumber(2);
		pusiopusio.setTime(24);
		pusiopusio.setAddMore(false);
		pusiopusio.setEatFresh(true);
		
		System.out.println(pusiopusio.eat());

		
	}

}
