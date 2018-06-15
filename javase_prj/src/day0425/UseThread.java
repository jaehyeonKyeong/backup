package day0425;

/**
 *상속으로 Thread 사용하기
 * @author owner
 */
//1.Thread class를 상속받는다.
public class UseThread extends Thread {
	//2.run method를 Override
	@Override
	public void run() {
		//Thread로 처리되어야 할 코드 (동시에 실행되어야 할 코드)
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
		//4.객체화 
		UseThread ut=new UseThread();
		//5.start()호출
		ut.start();//start() ->내가 정의 한 run()호출 //run을 직접 부르면 Thread로 동작하지 않음.
		ut.temp();
	}//main

}//class
