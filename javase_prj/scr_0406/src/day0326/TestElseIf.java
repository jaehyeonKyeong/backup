package day0326;

/**
 *	else~if(다중 if)<br>
 *	연관된 여러 조건을 비교<br>
 *	문법) if(조건식){} else if {} else if {} .....   } else{}<br>
 *
 * @author owner
 */
public class TestElseIf {

	public static void main(String[] args) {
//		입력된 점수에 대한 가부 판정
//		0~100 사이 점수라면 "성공"을 그렇지 않으면 실패의 이유를 보여주는 다중 if
		int score = Integer.parseInt(args[0]);
		System.out.print(score+" 점 ");
		if (score < 0) {
			System.out.println("은 0보다 작을 수 없습니다. 실패! ToT");
		} else if (score > 100) {
			System.out.println("은 100보다 클 수 없습니다. 실패! ToT");
		} else {
			System.out.println("은 입력성공. s(^.~)v");
		}
		
//		이름과 태어난 해를 입력받아 아래와 같이 띠를 출력
//		아래와 같이 출력
//		양-11, 말-10, 뱀-9, 용,토끼,호랑이,소,쥐,돼지,개,닭,원숭이-0
		int born = Integer.parseInt(args[2]);
		int num=born%12;
		if (num==11) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"양띠");
		} else if (num==10) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"말띠");
		} else if (num==9) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"뱀띠");
		} else if (num==8) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"용띠");
		} else if (num==7) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"토끼띠");
		} else if (num==6) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"호랑이띠");
		} else if (num==5) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"소띠");
		} else if (num==4) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"쥐띠");
		} else if (num==3) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"돼지띠");
		} else if (num==2) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"개띠");
		} else if (num==1) {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"닭띠");
		} else {
			System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+"원숭이띠");
		} 
		
		
		
		/*
		int born = Integer.parseInt(args[2]);
		String animal[]= {"양","말","뱀","용","토끼","호랑이","소","쥐","돼지","개","닭","원숭이"};
		System.out.println(args[1]+"님 "+args[2]+"년생 나이는 "+(2018-born+1)+"살 띠는 "+animal[11-(born%12)]+"띠");
		
		*/

	}

}
