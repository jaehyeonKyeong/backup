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
		super("수동배치");
		Label lbl=new Label("Label");
		lbl.setBackground(Color.CYAN);
		Button btn=new Button("Button");
		TextField tf=new TextField("TextField");
		tf.setEchoChar('●');//반향문자 : 입력된 문자가 설정한 문자로 바뀌어 나옴.
		
		//배치관리자 해재
		setLayout(null);
		
		//위치 설정
		lbl.setLocation(100,80);
		//크기설정
		lbl.setSize(70,30);
		tf.setBounds(200,300,100,40);
		btn.setBounds(400,150,80,15);
		
		//배치
		add(lbl);
		add(tf);
		add(btn);
		
		//윈도우의 크기 설정
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
