package myTest0402;

public class Account {
	
	private int balance;
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		if(balance>-1&&balance<1000000) {
			this.balance=balance;
		}else {
			System.out.println("��ȿ���� ���� ���Դϴ�.");
		}
	}

}
