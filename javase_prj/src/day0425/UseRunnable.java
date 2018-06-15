package day0425;

/**
 * Runnable을 구현하여 Thread 사용하기
 * @author owner
 */
public class UseRunnable implements Runnable{


	@Override
	public void run() {
		for(int i=0; i<1000;i++) {
//			try {
//				Thread.sleep(1000);//run상태에서 block상태로 이동
//			} catch (InterruptedException e) {
//				e.printStackTrace();//cpu를 잡고 놓지 않는 경우(deadLock경우) 처리
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
		//Thread로 동작하는 코드는 설정할 수 없다.
		long st=System.currentTimeMillis();
		UseRunnable ur=new UseRunnable();
		//5.Thread를 생성 하고 runnable을 구현한 클래스와 has a관계 설정
		Thread th=new Thread(ur);
		//6.start()호출 ->run
		th.start();
		ur.temp();
		long et=System.currentTimeMillis();
		System.out.println("수행 시간 : "+(et-st)+"ms"); // 언제 멈추게 될지 모른다.
	}
	
}
