package day0425;

/**
 *������� Thread ����ϱ�
 * @author owner
 */
//1.Thread class�� ��ӹ޴´�.
public class UseThread extends Thread {
	//2.run method�� Override
	@Override
	public void run() {
		//Thread�� ó���Ǿ�� �� �ڵ� (���ÿ� ����Ǿ�� �� �ڵ�)
		for(int i=0; i<1000; i++) {
			System.out.println("run method i=============== "+i);
		}
	}
	public void temp() {
		for(int i=0;i<1000;i++) {
			System.out.println("---------------temp method i "+i);
		}
	}
	public static void main(String[] args) {
		//4.��üȭ 
		UseThread ut=new UseThread();
		//5.start()ȣ��
		ut.start();//start() ->���� ���� �� run()ȣ�� //run�� ���� �θ��� Thread�� �������� ����.
		ut.temp();
	}//main

}//class
