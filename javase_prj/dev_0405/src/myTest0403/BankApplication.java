package myTest0403;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
			System.out.println("--------------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = scanner.nextInt();

			if (selectNo == 1) {
				createAccount();
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			}

		}
		System.out.println("프로그램 종료");

	}

	private static void createAccount() {
		// 계좌생성
		System.out.println("-----------");
		System.out.println("계좌생성");
		System.out.println("-----------");
		System.out.print("계좌번호:");
		String ano = scanner.next();
		System.out.print("계좌주:");
		String owner = scanner.next();
		System.out.print("초기 입금액:");
		int balance = scanner.nextInt();
		// int temp=accountArray.length;
		Account newAccount = new Account(ano, owner, balance);
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = newAccount;
				System.out.println("계좌가 생성 되었습니다");
				System.out.println("계좌번호 : " + accountArray[i].getAno() + ", 계좌주 : " + accountArray[i].getOwner()
						+ ", 예금액 : " + accountArray[i].getBalance());
				break;
			}
		}

	}

	private static void accountList() {
		// 계좌목록
		System.out.println("-----------");
		System.out.println("계좌목록");
		System.out.println("-----------");
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			}
			System.out.printf("%s\t%s\t%d\n", accountArray[i].getAno(),accountArray[i].getOwner(),accountArray[i].getBalance());
		}
	}

		 private static void deposit() {
		 //예금하기
			 System.out.println("-----------");
			 System.out.println("예금");
			 System.out.println("-----------");
			 System.out.print("계좌번호: ");
			 String ano = scanner.next();
			 System.out.print("예금액: ");
			 int balance = scanner.nextInt();
			 Account account = findAccount(ano);
			 if(account==null) {
				 System.out.println("결과 : 계좌가 없습니다.");
				 return;
			 }
			 account.setBalance(account.getBalance()+balance);
			 System.out.println("결과 : 예금이 성공되었습니다.");
		 }
		
		 private static void withdraw() {
		 //출금하기
			 System.out.println("-----------");
			 System.out.println("출금");
			 System.out.println("-----------");
			 System.out.print("계좌번호: ");
			 String ano = scanner.next();
			 System.out.print("예금액: ");
			 int balance = scanner.nextInt();
			 Account account = findAccount(ano);
			 if(account==null) {
				 System.out.println("결과 : 계좌가 없습니다.");
				 return;
			 }
			 account.setBalance(account.getBalance()-balance);
			 System.out.println("결과 : 예금이 성공되었습니다.");
		 }

		// Account 배열에서 ano와 동일한 Account 객체 찾기
		 private static Account findAccount(String ano) {
			 Account account =null;
			 for(int i=0;i<accountArray.length;i++) {
				 if(accountArray[i]!=null) {
					 String dbAno=accountArray[i].getAno();
					 if(dbAno.equals(ano)) {
						 account= accountArray[i];
						 break;
					 }
				 }
			 }
			 return account;	
		 }
	}

	
