package day0402;

public class EmailCheck {
	
	public EmailCheck() {
		String[] email= {"test@sist.co.kr","test@com","test.co.kr","test@kr","test@daum.net"};
		String temp="";
		
		System.out.println("�̸���\t��ȿ���˻�");
		System.out.println("====================");
		
		for(int i=0; i<email.length;i++) {
			if(email[i].contains(".")&&email[i].contains("@")&&(email[i].length()>9)){
				temp="����";
			} else {
				temp="����";
			}
			System.out.printf("%s\t%s\n",email[i],temp);
			
		}
	}

	public static void main(String[] args) {
		new EmailCheck();
		
		

	}

}
