package day0327;

public class Homework2 {
	public static void main(String[] args) {
		// ���� 1. �ϳ��� ������ �Է¹޾� ��� ����.
		System.out.println("=============����1=============");
		int score = Integer.parseInt(args[0]);
		
		if (score > 0 && score < 101) {
			switch (score / 10) {

			case 0:
			case 1:
			case 2:
			case 3:
				System.out.println("����");
				break;
			case 4:
			case 5:
				System.out.println("�ٸ� ���� ����");
				break;
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
				System.out.println("�հ�");
				break;
			}// end switch
		} else {
			System.out.println("�߸��� �����Դϴ�.");
		} // end else

		System.out.println("==============����2=================");
		char upperAlphaBet =' ';
		char lowerAlphaBet=' ';
		for (int i = 65, j = 97; j <= 122; i++, j++) {
			upperAlphaBet = (char) i;
			lowerAlphaBet = (char) j;
			System.out.print(upperAlphaBet + "(" + i + ") " + lowerAlphaBet + "(" + j + ")   ");
		} // end for
		System.out.println();
		System.out.println("==============����3=================");
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + "*" + i + "= " + (j * i) + "   ");
			} // end for
			System.out.println();
		} // end for
		System.out.println("==============����4=================");
		int count = 0;
		int sum = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 4 == 0) {
				count++;
				sum += i;
			} // end if
		} // end for
		System.out.println("4�� ��� ������ " + count + "�̰�, 4�� ��� ���� " + sum + "�Դϴ�.");

		System.out.println("==============����5=================");
		int multiply = Integer.parseInt(args[1]);
		if(multiply>1&&multiply<10) {
			int i=1;
			while(i<10) {
				System.out.println(multiply+"*"+i+"= "+(multiply*i));
				i++;
			}//end for
		}else {
			System.out.println("�������� 2~9�� ������ �Է�");
		}//end else

	}// end main
}// end class
