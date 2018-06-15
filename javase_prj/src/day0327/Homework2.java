package day0327;

public class Homework2 {
	public static void main(String[] args) {
		// 문제 1. 하나의 점수를 입력받아 결과 판정.
		System.out.println("=============문제1=============");
		int score = Integer.parseInt(args[0]);
		
		if (score > 0 && score < 101) {
			switch (score / 10) {

			case 0:
			case 1:
			case 2:
			case 3:
				System.out.println("과락");
				break;
			case 4:
			case 5:
				System.out.println("다른 과목 참조");
				break;
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				System.out.println("합격");
				break;
			}// end switch
		} else {
			System.out.println("잘못된 점수입니다.");
		} // end else

		System.out.println("==============문제2=================");
		char upperAlphaBet =' ';
		char lowerAlphaBet=' ';
		for (int i = 65, j = 97; j <= 122; i++, j++) {
			upperAlphaBet = (char) i;
			lowerAlphaBet = (char) j;
			System.out.print(upperAlphaBet + "(" + i + ") " + lowerAlphaBet + "(" + j + ")   ");
		} // end for
		System.out.println();
		System.out.println("==============문제3=================");
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + "*" + i + "= " + (j * i) + "   ");
			} // end for
			System.out.println();
		} // end for
		System.out.println("==============문제4=================");
		int count = 0;
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 4 == 0) {
				count++;
				sum += i;
			} // end if
		} // end for
		System.out.println("4의 배수 갯수는 " + count + "이고, 4의 배수 합은 " + sum + "입니다.");

		System.out.println("==============문제5=================");
		int multiply = Integer.parseInt(args[1]);
		if(multiply>1&&multiply<10) {
			int i=1;
			while(i<10) {
				System.out.println(multiply+"*"+i+"= "+(multiply*i));
				i++;
			}//end for
		}else {
			System.out.println("구구단은 2~9단 까지만 입력");
		}//end else

	}// end main
}// end class
