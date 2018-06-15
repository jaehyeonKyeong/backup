package day0412;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings({ "serial", "unused" })
// 1.�߻��� �̺�Ʈ�� ó���� Listener�� ����
public class TestWindowEvent2 extends Frame {

	public TestWindowEvent2() {
		super("������ �̺�Ʈ ����");
		
		addWindowListener(this.new WindowClose());

		setSize(300, 300);
		setVisible(true);
	}// constructor
		// class�� ���� ��Ӹ� �����ϱ� ������ ������ class������ XXXAdapter class�� ��ӹ��� �� ����. 
		// ���� inner class�� XXXAdapter�� ��ӹ޾� ���ϰ� �̺�Ʈ�� ó����

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
