package day0411;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public final class UseLayout extends Frame {
	
	@SuppressWarnings("unused")
	public UseLayout() {
		super("여러개의 레이아웃 혼합");
		//사용할 컴포넌트 생성
		Label lblName=new Label("이름");
		Label lblAge=new Label("나이");
		Label lblOutput=new Label("출력");
		
		TextField tfName = new TextField(10);
		TextField tfOutput = new TextField(35);
		
		Choice choAge=new Choice();
		for(int i=1;i<=100;i++) {
			choAge.add(String.valueOf(i));//정수를 문자열로 변경하여 Item으로 추가
		}//for
		
		Button btnAdd=new Button("입력");
		
		TextArea taContents= new TextArea();
		
		//일반 컴포넌트를 저장할 수 있는 Container Component를 생성
		
		Panel panelNorth=new Panel();
		Panel panelSouth=new Panel();

		//일반 컴포넌트를 컨테이너 컴포넌트에 배치
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(lblAge);
		panelNorth.add(choAge);
		panelNorth.add(btnAdd);
		
		panelSouth.add(lblOutput);
		panelSouth.add(tfOutput);
		
		//container 컴포넌트와 일반 컴포넌트를 윈도우 컴포넌트에 배치
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
