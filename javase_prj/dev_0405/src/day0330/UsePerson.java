package day0330;


public class UsePerson {
	
	/**
	 * JAVA Application : �ܵ����� ���� ������ ���α׷�
	 * @param args ���ڰ�...
	 */
	public static void main(String[] args) {
		Person jsm=new Person();
		
		jsm.setName("���¹�");
		
		System.out.println(jsm.eat());
		System.out.println(jsm.eat("��",1500));
		
		
		Person jinban=new Person(3,1,1);
		jinban.setName("õ����");
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("����",1));
		
		
		
	}
	
	

}
