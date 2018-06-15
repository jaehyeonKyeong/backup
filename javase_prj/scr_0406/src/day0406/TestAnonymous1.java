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
		Button btn = new Button("�� ��ư ^o^");
		add(btn);
		
		//���������� ó��
		//�������̽��� ������ �ڽ�Ŭ������ �����, �����Ͽ�, �Է�
//		MyWinsowClose mwc = new MyWinsowClose();
//		addWindowListener(mwc);
		
		//anonymous inner class : Ŭ������ ������ ������ �ʿ䰡 ���� 
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
