package day0322;
/*
	논리연산자
		일반논리
			&& , ||
		비트논리
			& , | , ^ ,~ 
*/

class Operator5 {
	public static void main(String[] args) {
		int score=100;
		//점수의 범위는 0~100 사이일 때만 true 출력
		System.out.println(score > -1 && score <101 );
		boolean b1=true, b2=true, b3=false, b4=false;
		System.out.println("------------------------------------");
		// && : 전항이 거짓이면 후항을 계산하지 않고 거짓을 내보낸다
		System.out.println(b1+"&&"+b2+" = "+(b1&&b2));
		System.out.println(b1+"&&"+b3+" = "+(b1&&b3));
		System.out.println(b3+"&&"+b1+" = "+(b3&&b1));
		System.out.println(b3+"&&"+b4+" = "+(b3&&b4));
		System.out.println("------------------------------------");
		// || : 전항이 참이면 후항을 계산하지 않고 참을 내보낸다
		System.out.println(b1+"||"+b2+" = "+(b1||b2));
		System.out.println(b1+"||"+b3+" = "+(b1||b3));
		System.out.println(b3+"||"+b1+" = "+(b3||b1));
		System.out.println(b3+"||"+b4+" = "+(b3||b4));
		
		int i=38; // 0010 0110 
		int j=13; // 0000 1101
		System.out.println(i+"&"+j+" = "+(i&j)); //AND	0000 0100 = 4
		System.out.println(i+"|"+j+" = "+(i|j)); //OR		0010 1111 = 47
		System.out.println(i+"^"+j+" = "+(i^j)); //XOR	0010 1011 = 43
		
		//AND는 전항이 거짓이면 후항을 계산하지 않는다
		b1=true; //전항
		b2=true; //후항
		b3=true; //전체판정
		//b3=(b1=4>3)&&(b2=5<6); //전체 true
		//b3=(b1=4>3)&&(b2=5>6); //전항 T ,후항 F, 판정 F
		//b3=(b1=4<3)&&(b2=5<6); //전항 F, 후항 T, 판정 F
		b3=(b1=4<3)&&(b2=5>6); //전항 F, 후항 F, 판정 F  전항이 거짓일 때 후항을 계산하지 않아 b2값이 초기값 true를 그대로 가지고 있다
		System.out.println("전항 : "+b1+", 후항 : "+b2+", 판정 : "+b3);

		b1=true; //전항
		b2=true; //후항
		b3=true; //전체판정
		//b3=(b1=4>3)||(b2=5<6); //전체 true					전항이 참일 때 후항을 계산하지 않아 b2값이 초기값 true를 그대로 가지고 있다
		b3=(b1=4>3)||(b2=5>6); //전항 T ,후항 F, 판정 T	전항이 참일 때 후항을 계산하지 않아 b2값이 초기값 true를 그대로 가지고 있다
		//b3=(b1=4<3)||(b2=5<6); //전항 F, 후항 T, 판정 T
		//b3=(b1=4<3)||(b2=5>6); //전항 F, 후항 F, 판정 F 
		System.out.println("전항 : "+b1+", 후항 : "+b2+", 판정 : "+b3);


	}//main
}//class
