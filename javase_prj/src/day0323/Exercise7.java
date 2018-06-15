package day0323;
import java.util.Scanner;
class  Exercise7{
	private static Scanner scanner;

	public static void main(String[] args) {
		boolean run=true;
		int balance=0;
		scanner = new Scanner(System.in);
		while(run){
		System.out.println("----------------------------------------------");
		System.out.println("1. 예금 | 2. 출금 | 3. 종료");
		System.out.println("계좌 잔액 : "+balance);
		System.out.println("----------------------------------------------");
		System.out.print("선택> ");
		String inputString=scanner.nextLine();
		int num=Integer.parseInt(inputString);
		switch (num){
		case 1:
			System.out.print("예금액> ");
			Scanner scanner2 = new Scanner(System.in);
			String inputString2=scanner2.nextLine();
			int num2=Integer.parseInt(inputString2);
			balance+=num2;
			break;
		case 2:
			System.out.print("출금액> ");
			Scanner scanner3 = new Scanner(System.in);
			String inputString3=scanner3.nextLine();
			int num3=Integer.parseInt(inputString3);
			balance-=num3;
			break;
		case 31:
			run=false;
			break;
		default:
			break;
		


		
		}


		}
		System.out.println("프로그램종료");

	}
}
