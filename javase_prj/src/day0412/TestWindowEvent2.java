package day0412;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings({ "serial", "unused" })
// 1.발생한 이벤트를 처리할 Listener를 구현
public class TestWindowEvent2 extends Frame {

	public TestWindowEvent2() {
		super("윈도우 이벤트 연습");
		
		addWindowListener(this.new WindowClose());

		setSize(300, 300);
		setVisible(true);
	}// constructor
		// class는 단일 상속만 지원하기 때문에 디자인 class에서는 XXXAdapter class를 상속받을 수 없다. 
		// 따라서 inner class로 XXXAdapter를 상속받아 편리하게 이벤트를 처리함

	public class WindowClose extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			dispose();
		}

	}

	public static void main(String[] args) {
		new TestWindowEvent2();
	}

}
