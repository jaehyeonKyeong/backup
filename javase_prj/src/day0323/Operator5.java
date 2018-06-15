package day0323;
/**
	논리연산
		일반논리 : 여러개의 관계연산자를 묶어서 비교.
			● &&(and) : 전항과 후항이 동시에 참일때만 참 반환(그 이외에는 거짓) T&&T=T, T&&F=F, F&&T=F, F&&F=F :: 전항이 거짓이면 후항은 계산하지 않음.
			● || (or) : 전항과 후항이 동시에 거짓일때만 거짓 반환(그 이외에는 참) T||T=T, T||F=T, F||T=T, F||F=F :: 전항이 참이면 후항을 계산하지 않음
		-비트논리
			● & (and) : 상위비트와 하위비트 모두 1일때만 1을 내림
			● | (or) : 상위 비트와 하위비트 모두 0일때만 0을 내림
			● ^ (Xor) : 상위 비트와 하위비트 둘중 하나만 1일일때 1을 내림(둘이 동시에 1이거나 0이면 0을 내림)
*/
class Operator5{
	public static void main(String[] args) {
		int score=80;
		//점수의 범위는 0~100사이일때 true 출력
		System.out.println(score>-1 || score<101);
		boolean b1 = true ,b2= true, b3 =false, b4= false;
		System.out.println("-------------------&&--------------------");
		System.out.println(b1+"&&"+b2+"="+(b1&&b2));
		System.out.println(b1+"&&"+b3+"="+(b1&&b3));
		//전항이 거짓이면 후항을 계산하지 않고 거짓을 내보낸다.
		System.out.println(b3+"&&"+b1+"="+(b3&&b1));
		System.out.println(b3+"&&"+b4+"="+(b3&&b4));
		System.out.println("-------------------||--------------------");
		System.out.println(b1+"||"+b2+"="+(b1||b2));
		System.out.println(b1+"||"+b3+"="+(b1||b3));
		//전항이 참이면 후항을 계산하지 않고 참을 내보낸다.
		System.out.println(b3+"||"+b1+"="+(b3||b1));
		System.out.println(b3+"||"+b4+"="+(b3||b4));

		int i= 38;
		int j=13;
		System.out.println(i+"&"+j+"="+(i&j));//And 4
		System.out.println(i+"|"+j+"="+(i|j));//or 47
		System.out.println(i+"^"+j+"="+(i^j));//xor 43

		//And 전항이 거짓이면 후항을 계산하지 않는다.

		b1=true; // 전항
		b2=true; // 후항
		b3=true; //전체판정
//		b3=(b1=4>3)&&(b2=5<6); // 전 T, 후 T 판 T
//		b3=(b1=4>3)&&(b2=5>6); //전 T 후 F 판 F
		b3=(b1=4<3)&&(b2=5>6); //전 F 후 F 판 F but, 전항을 계산하자마자 후항을 계산하지 않아서 후항에는 초기값인 true가 들어가있음
		System.out.println("전항 : "+b1+", 후항 : "+b2+ ", 판정 : "+b3);


	}
}
