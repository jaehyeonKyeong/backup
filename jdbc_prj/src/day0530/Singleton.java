package day0530;

/**
 * singleton pattern �� ������ Ŭ���� 
 * @author owner
 *
 */
public class Singleton {
	private static Singleton s;
	
	// 1. �ܺο��� ��üȭ �� �� ������ ������ ���������� private����
	private Singleton() {
		System.out.println("��üȭ");
		
	}

	public static Singleton getInstance() {
		// TODO Auto-generated method stub
		if(s==null) {
			s =new Singleton();	
		}//end if
		
		return s;
	}//singleton
	//2. instance�� ��� method�� ����
	

}
