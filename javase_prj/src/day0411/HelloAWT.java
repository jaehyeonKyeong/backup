package day0411;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *AWT�� ����� component programming
 * @author owner
 */
@SuppressWarnings("serial")
//1.window ������Ʈ�� ��ӹ޴´�.
public class HelloAWT extends Frame{
	public HelloAWT() {
		super("�ȳ�!AWT");
		//2.����� ������Ʈ ����
		Button btn= new Button("�̰��� ��ư");
		Label lbl=new Label("�̰��� �̸�ǥ");
		//3.��ġ�����ڿ��� ��ġ(����)
		add("Center",btn);
		add("East",lbl);
		
		setSize(500,250);
		setVisible(true);
		
		//������ ���� �̺�Ʈ ó�� : anonymous inner class
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose(); //������ �����ϴ� �� System.exit(0);
			}//windowClosing
			
		});
	}//Constructor
	public static void main(String[] args) {
		new HelloAWT();
	}

}
