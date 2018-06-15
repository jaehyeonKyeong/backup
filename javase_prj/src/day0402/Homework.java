package day0402;

/**
 * 숙제1. 아래와 같은 배열을 만들고 유효성 검사 수행<br>
 * String[]
 * email={"test@sist.co.kr","test@com","test.co.kr","test@kr","test@daum.net"}<br>
 * 이메일 유효성검사 ~~~~~ 실패 ~~~~~ 정상 이메일 ~~~~~<br>
 * 
 * 유효성검사: 이메일 . , @ 이 존재하면서 10자이상인 경우"정상이메일" 위의 경우에 해당하지 않으면 "실패"를 출력<br>
 * 
 * 숙제2. 생성자에서 주민번호를 입력받아 instance변수에 저장하고 instance변수의 값을 사용하여 연산된 값을 얻는 프로그램 작성
 * -아래의 항목은 method로 구분하여 작업 <br>
 * 2-1 주민번호는 - 포함 14자 이어야 한다( 반환형은 boolean) <br>
 * 2-2 주민번호의 7번째 자리는 - 이어야 한다(반환형은 boolean)<br>
 * 2-3 입력된 주민번호로 생년월일을 구하는 일(반환형 String ex)1988년 1월1일)<br>
 * 2-4 나이를 구하는 일(반환형 int) 2-5 성별을 구하는 일(String "남" "여" ) 1 3= 남자 2 4 여자 (홀 남 짝
 * 여)<br>
 * 2-6 외국인을 구하는 일 (반환형 String "내국인" "외국인")<br>
 * 2-7 띠 구하기 ( 반 String)<br>
 * 
 * 
 * @author owner
 *
 */
public class Homework {
	String ss;

	public Homework() {
		// 문제1.
		System.out.println("===================문제1======================");
		String[] email = { "test@sist.co.kr", "test@com", "test.co.kr", "test@kr", "test@daum.net" };
		for (int i = 0; i < email.length; i++) {
			if (email[i].contains(".") && email[i].contains("@") && email[i].length() >= 10) {
				System.out.println(email[i] + " 의 유효성 : 정상이메일");
			} else {
				System.out.println(email[i] + " 의 유효성 : 실패");
			} // .이 포함되어있는지
		}
		System.out.println("==========================================");
	}// 생성자
		// 문제2
	// * 여)<br>
	// 숙제2. 생성자에서 주민번호를 입력받아 instance변수에 저장하고 instance변수의 값을 사용하여 연산된 값을 얻는 프로그램 작성
	// * -아래의 항목은 method로 구분하여 작업 <br>

	public Homework(String ss) {
		this.ss = ss;
	}//overloading

	// * 2-1 주민번호는 - 포함 14자 이어야 한다( 반환형은 boolean) <br>
	public boolean method1() {
		if (ss.length() == 14) {
			return true;
		} else {
			return false;
		}
	}

	// * 2-2 주민번호의 7번째 자리는 - 이어야 한다(반환형은 boolean)<br>
	public boolean method2() {
		char hf = ss.charAt(6);
		if (hf == '-') {
			return true;
		} else {
			return false;
		}
	}

	// * 2-3 입력된 주민번호로 생년월일을 구하는 일(반환형 String ex)1988년 1월1일)<br>
	public String method3() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		String birth = ss.substring(0, ss.indexOf("-"));
		if (s.equals("1") || s.equals("2")) {
			return "19" + birth.substring(0, 2) + "년 " + birth.substring(2, 4) + "월 " + birth.substring(4, 6)+"일";
		} else if (s.equals("3") || s.equals("4")) {
			return "20" + birth.substring(0, 2) + "년 " + birth.substring(2, 4) + "월 " + birth.substring(4, 6)+"일";
		}else {
			return null;
		}

	}

	// * 2-4 나이를 구하는 일(반환형 int)
	public int method4() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		String birth = ss.substring(0, ss.indexOf("-"));
		if (s.equals("1") || s.equals("2")) {
			return 2018-(Integer.parseInt("19" + birth.substring(0, 2)))+1;
		} else if (s.equals("3") || s.equals("4")) {
			return 2018-(Integer.parseInt("20" + birth.substring(0, 2)))+1;
		} else {
			return 1;
		}
	}
	
	//2-5 성별을 구하는 일(String "남" "여" ) 1 3= 남자 2 4 여자 (홀 남 짝 여)
	public String method5() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		if (Integer.parseInt(s)%2==0) {
			return "여자입니다";
		} else  {
			return "남자입니다";
		}
	}
	// * 2-6 외국인을 구하는 일 (반환형 String "내국인" "외국인")<br>
	public String method6() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		if(Integer.parseInt(s)<=4) {
			return "내국인";
		}else {
			return "외국인";
		}
	}
	// * 2-7 띠 구하기 ( 반환형 String)<br>
	public String method7() {
		String s = ss.substring(ss.indexOf("-") + 1, ss.indexOf("-") + 2);
		String birth = ss.substring(0, ss.indexOf("-"));
		int year=0;
		if (s.equals("1") || s.equals("2")) {
			 year=Integer.parseInt("19" + birth.substring(0, 2));
		} else if (s.equals("3") || s.equals("4")) {
			 year=Integer.parseInt("20" + birth.substring(0, 2));
		}
		if(year%12==0) {
			return "원숭이 띠";
		}else if(year%12==1) {
			return "닭 띠";
		}else if(year%12==2) {
			return "개 띠";
		}else if(year%12==3) {
			return "돼지 띠";
		}else if(year%12==4) {
			return "쥐 띠";
		}else if(year%12==5) {
			return "소 띠";
		}else if(year%12==6) {
			return"호랑이 띠";
		}else if(year%12==7) {
			return "토끼 띠";
		}else if(year%12==8) {
			return "용 띠";
		}else if(year%12==9) {
			return "뱀 띠";
		}else if(year%12==10) {
			return "말 띠";
		}else if(year%12==11) {
			return "양 띠";
		}else {
			return null;
		}
		
	}
	public static void main(String[] args) {
		String ss = "820228-1198446";
		new Homework();
		Homework h = new Homework(ss);
		 /*2-1 주민번호는 - 포함 14자 이어야 한다( 반환형은 boolean) <br>-
		 * 2-2 주민번호의 7번째 자리는 - 이어야 한다(반환형은 boolean)<br>-
		 * 2-3 입력된 주민번호로 생년월일을 구하는 일(반환형 String ex)1988년 1월1일)<br>
		 * 2-4 나이를 구하는 일(반환형 int) 2-5 성별을 구하는 일(String "남" "여" ) 1 3= 남자 2 4 여자 (홀 남 짝
		 * 여)<br>
		 * 2-6 외국인을 구하는 일 (반환형 String "내국인" "외국인")<br>-
		 * 2-7 띠 구하기 ( 반 String)<br>*/
		if(h.method1()) {
			if(h.method2()) {
				if(h.method6().equals("내국인")) {
					System.out.println("국적 : "+h.method6());
					System.out.println("생년월일 : "+h.method3());
					System.out.println("나이 : "+h.method4());
					System.out.println("성별 : "+h.method5());
					System.out.println("띠 : "+h.method7());
					
				}else {
					System.out.println("국적 : "+h.method6());
				}
			}else {
				System.out.println("주민번호의 7번째 자리는 - 이어야 합니다.");
			}//2-2
		}else {
			System.out.println("주민번호는 14자리여야 합니다.");
		}//2-1
	}

}
