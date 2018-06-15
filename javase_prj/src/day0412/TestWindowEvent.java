package day0412;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings("serial")
//1.�߻��� �̺�Ʈ�� ó���� Listener�� ����
public class TestWindowEvent extends Frame implements WindowListener {

	public TestWindowEvent() {
		super("������ �̺�Ʈ ����");
		addWindowListener(this);
		
		setSize(300,300);
		setVisible(true);
	}//constructor
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		dispose();
//		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}

	public static void main(String[] args) {
		new TestWindowEvent();
	}

}
