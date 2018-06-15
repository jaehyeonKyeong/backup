package day0411;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public final class UseLayout extends Frame {
	
	@SuppressWarnings("unused")
	public UseLayout() {
		super("�������� ���̾ƿ� ȥ��");
		//����� ������Ʈ ����
		Label lblName=new Label("�̸�");
		Label lblAge=new Label("����");
		Label lblOutput=new Label("���");
		
		TextField tfName = new TextField(10);
		TextField tfOutput = new TextField(35);
		
		Choice choAge=new Choice();
		for(int i=1;i<=100;i++) {
			choAge.add(String.valueOf(i));//������ ���ڿ��� �����Ͽ� Item���� �߰�
		}//for
		
		Button btnAdd=new Button("�Է�");
		
		TextArea taContents= new TextArea();
		
		//�Ϲ� ������Ʈ�� ������ �� �ִ� Container Component�� ����
		
		Panel panelNorth=new Panel();
		Panel panelSouth=new Panel();

		//�Ϲ� ������Ʈ�� �����̳� ������Ʈ�� ��ġ
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(lblAge);
		panelNorth.add(choAge);
		panelNorth.add(btnAdd);
		
		panelSouth.add(lblOutput);
		panelSouth.add(tfOutput);
		
		//container ������Ʈ�� �Ϲ� ������Ʈ�� ������ ������Ʈ�� ��ġ
		add(BorderLayout.NORTH,panelNorth);
		add(taContents,BorderLayout.CENTER);
		add(BorderLayout.SOUTH,panelSouth);
		
		setBounds(300, 250, 700, 500);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
	}//constructor
	public static void main(String[] args) {
		new UseLayout();
		
	}

}
