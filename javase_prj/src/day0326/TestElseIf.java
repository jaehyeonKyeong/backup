package day0326;

/**
 * else~if(다중 if)<br>
 * 연관된 여러 조건을 비교<br>
 * 문법) if(조건식){<br>
 * 조건에 맞을때 수행 코드;<br>
 * }else if(조건식){<br>
 * 조건에 맞을때 수행코드;<br>
 * .<br>
 * .<br>
 * .<br>
 * }else{<br>
 * 모든 조건에 맞지 않을때 수행코드;<br>
 * }<br>
 * 
 * @author owner
 */
public class TestElseIf {

	public static void main(String[] args) {
		// 입력된 점수에 대한 가부 판정
		// 0~100사이 점수라면 "성공"을 그렇지 않으면 "실패"의 이유를 보여주는 다중 if문을 만듬
		int score = Integer.parseInt(args[0]);
		System.out.print(score + "점");
		if (score < 0) {
			System.out.println("은 0보다 작을수 없습니다! T0T");
		} else if (score > 100) {
			System.out.println("은 100보다 작을수 없습니다! o(T-T)o");
		} else {
			System.out.println("은 입력 성공! v(^_~)v");
		} // end else

		// 이름과 태어난 해를 입력받아서 띠를 출력
		// 아래와 같이 출력
		// xxx님 xxxx년생 나이는 xx살 xx띠 입니다.
		//양 -11, 말-10, 뱀-9 용-8 토끼-7 호랑이-6소-5 쥐-4 돼지-3 개-2 닭-1 원숭이 -0
		int year=Integer.parseInt(args[2]);
		System.out.print(args[1]+"님 "+year+"년생 나이는 "+(2018-year+1)+"살 ");
		if(year%12==0) {
			System.out.print("원숭이");
		}else if(year%12==1) {
			System.out.print("닭");
		}else if(year%12==2) {
			System.out.print("개");
		}else if(year%12==3) {
			System.out.print("돼지");
		}else if(year%12==4) {
			System.out.print("쥐");
		}else if(year%12==5) {
			System.out.print("소");
		}else if(year%12==6) {
			System.out.print("호랑이");
		}else if(year%12==7) {
			System.out.print("토끼");
		}else if(year%12==8) {
			System.out.print("용");
		}else if(year%12==9) {
			System.out.print("뱀");
		}else if(year%12==10) {
			System.out.print("말");
		}else if(year%12==11) {
			System.out.print("양");
		}
		System.out.println("띠 입니다.");

	}// main

}// class
