package day0406;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

@SuppressWarnings({ "serial", "unused" })
public class TestAnonymous1 extends Frame{
	public TestAnonymous1() {
		super("anonymous inner class");
		Button btn =new Button("�� ��ư^^");
		add(btn);
		
		//������ ���� ó��
		//�������̽��� ������ �ڽ� Ŭ������ �����, �����Ͽ�, �Է�
//		MyWindowClose mwc=new MyWindowClose();
//		addWindowListener(mwc);
		//anonymous inner class:Ŭ������ ������ ������ �ʿ䰡 ����.
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
			
		});
		setBounds(100,100,300,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		new TestAnonymous1();
	}

}
