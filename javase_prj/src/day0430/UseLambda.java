package day0430;

public class UseLambda {

	public UseLambda() {
		//class�� �������� �ʰ� �߻� method�� �ۼ��Ͽ� ȣ�� �� �� �ִ�.
		TestLambda tl=()->{
			System.out.println("test�޼ҵ� ����");
			
		};
//		Runnable test=()->{
//			for(int i=0;i<1000;i++)
//			{
//				System.out.println("run-----i="+i);
//			}
//			
//		};
		//�߻� method ȣ��
//		Thread t=new Thread(test);
//		t.start();
		tl.test();
//		for(int i=0;i<1000;i++)
//		{
//			System.out.println("test "+i);
//			
//		}
		//�Ű����� �ִ�  �߻� method ȣ��
		TestLambda1 t2=(/*Lambda�� ������ �޼ҵ� �ȿ� ���������̸�*/m)->{
			System.out.println("�Է� �̸� : "+m);
		};
		String name="���¹�";
		t2.printName(name);
		if(name.equals("���¹�")) {
			System.out.println("�� �� �߸� �Դϴ�");
		}
	}//constructor
	
	
	public static void main(String[] args) {
		
		new UseLambda();
		

	}//main

}//class UseLambda
