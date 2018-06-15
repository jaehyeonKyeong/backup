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
		super("FlowLayout연습");
		//디자인에 피룡한 컴포넌트를 생성
		Label lbl=new Label("이름");
		TextField tfName=new TextField(10);
		List locList=new List();
		locList.add("서울");
		locList.add("경기");
		locList.add("인천");
		locList.add("대구");
		locList.add("대전");
		locList.add("부산");
		locList.add("광주");
		locList.add("강원");
		
		Button btnAdd=new Button("입력");
		//레이아웃 변경
		setLayout(new FlowLayout());
		//컴포넌트 배치
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
