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
		System.out.println("1. ���� | 2. ��� | 3. ����");
		System.out.println("���� �ܾ� : "+balance);
		System.out.println("----------------------------------------------");
		System.out.print("����> ");
		String inputString=scanner.nextLine();
		int num=Integer.parseInt(inputString);
		switch (num){
		case 1:
			System.out.print("���ݾ�> ");
			Scanner scanner2 = new Scanner(System.in);
			String inputString2=scanner2.nextLine();
			int num2=Integer.parseInt(inputString2);
			balance+=num2;
			break;
		case 2:
			System.out.print("��ݾ�> ");
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
		System.out.println("���α׷�����");

	}
}
