package day0411;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author owner
 */
@SuppressWarnings("serial")
public class UseFlowLayout extends Frame{
	
	@SuppressWarnings("unused")
	public UseFlowLayout() {
		super("FlowLayout����");
		//�����ο� �Ƿ��� ������Ʈ�� ����
		Label lbl=new Label("�̸�");
		TextField tfName=new TextField(10);
		List locList=new List();
		locList.add("����");
		locList.add("���");
		locList.add("��õ");
		locList.add("�뱸");
		locList.add("����");
		locList.add("�λ�");
		locList.add("����");
		locList.add("����");
		
		Button btnAdd=new Button("�Է�");
		//���̾ƿ� ����
		setLayout(new FlowLayout());
		//������Ʈ ��ġ
		add(lbl);
		add(tfName);
		add(locList);
		add(btnAdd);
		
		setSize(400,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
		
	}//Constructor

	public static void main(String[] args) {
		new UseFlowLayout();
	}//main

}//class
