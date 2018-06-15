package day0412;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class ManualLayout extends Frame {

	public ManualLayout() {
		super("������ġ");
		Label lbl=new Label("Label");
		lbl.setBackground(Color.CYAN);
		Button btn=new Button("Button");
		TextField tf=new TextField("TextField");
		tf.setEchoChar('��');//���⹮�� : �Էµ� ���ڰ� ������ ���ڷ� �ٲ�� ����.
		
		//��ġ������ ����
		setLayout(null);
		
		//��ġ ����
		lbl.setLocation(100,80);
		//ũ�⼳��
		lbl.setSize(70,30);
		tf.setBounds(200,300,100,40);
		btn.setBounds(400,150,80,15);
		
		//��ġ
		add(lbl);
		add(tf);
		add(btn);
		
		//�������� ũ�� ����
		setBounds(700,350,500,500);
		setVisible(true);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
		
		
	}
	public static void main(String[] args) {
		new ManualLayout();
	}

}
