package day0406;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
public class TestAnonymous1 extends Frame{
	
	public TestAnonymous1() {
		super("anonymous innerclass");
		Button btn = new Button("난 버튼 ^o^");
		add(btn);
		
		//윈도우종료 처리
		//인터페이스를 구현한 자식클래스를 만들고, 생성하여, 입력
//		MyWinsowClose mwc = new MyWinsowClose();
//		addWindowListener(mwc);
		
		//anonymous inner class : 클래스를 별도로 생성할 필요가 없다 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}// windowClosing
		});
		
		setBounds(100, 100, 300, 400);
		setVisible(true);
		
	}//TestAnonymous1

	public static void main(String[] args) {
		new TestAnonymous1();
		
	}//main

}//class
