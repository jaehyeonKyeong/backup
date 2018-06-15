package day0425;

/**
 * Runnable�� �����Ͽ� Thread ����ϱ�
 * @author owner
 */
public class UseRunnable implements Runnable{


	@Override
	public void run() {
		for(int i=0; i<1000;i++) {
//			try {
//				Thread.sleep(1000);//run���¿��� block���·� �̵�
//			} catch (InterruptedException e) {
//				e.printStackTrace();//cpu�� ��� ���� �ʴ� ���(deadLock���) ó��
//			}
			System.out.println("run-----------i="+i);
		}
	}
	public void temp() {
		for(int i=0;i<1000;i++) {
			System.out.println("temp===========i="+i);
		}
	}
	public static void main(String[] args) {
		//Thread�� �����ϴ� �ڵ�� ������ �� ����.
		long st=System.currentTimeMillis();
		UseRunnable ur=new UseRunnable();
		//5.Thread�� ���� �ϰ� runnable�� ������ Ŭ������ has a���� ����
		Thread th=new Thread(ur);
		//6.start()ȣ�� ->run
		th.start();
		ur.temp();
		long et=System.currentTimeMillis();
		System.out.println("���� �ð� : "+(et-st)+"ms"); // ���� ���߰� ���� �𸥴�.
	}
	
}
