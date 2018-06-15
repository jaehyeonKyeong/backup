package day0411;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Homework1 extends Frame {
	
	@SuppressWarnings("unused")
	public Homework1() {
		super("연습");
		
		Label lblName=new Label("이름");
		Label lblAge=new Label("나이");
		Label lblGender=new Label("성별");
		Label lblAddr=new Label("주소");
		
		TextField tfName=new TextField(8);
		TextField tfAge=new TextField(8);
		TextField tfAddr=new TextField(15);
		
		CheckboxGroup cbg=new CheckboxGroup();
		Checkbox male=new Checkbox("남자",true,cbg);
		Checkbox female=new Checkbox("여자",false,cbg);
		
		List list=new List();
		
		Button btnInput=new Button("입력");
		Button btnEdit=new Button("수정");
		Button btnDelete=new Button("삭제");
		Button btnExit=new Button("닫기");
		
		
		Panel southPanel=new Panel();
		Panel centerPanel=new Panel();
		Panel leftPanel=new Panel();
		Panel rightPanel=new Panel();
		Panel gridPanel=new Panel();
		Panel genderPanel=new Panel();
		
		Panel inGridPanel1=new Panel();
		Panel inGridPanel2=new Panel();
		Panel inGridPanel3=new Panel();
		Panel inGridPanel4=new Panel();
		Panel inGridPanel5=new Panel();
		Panel inGridPanel7=new Panel();
		Panel inGridPanel8=new Panel();
		
		
		//grid안에 들어가는 panel
		inGridPanel1.add(lblName);
		inGridPanel2.add(tfName);
		inGridPanel3.add(lblAge);
		inGridPanel4.add(tfAge);
		inGridPanel5.add(lblGender);
		inGridPanel7.add(lblAddr);
		inGridPanel8.add(tfAddr);
		
		//south에 붙는 panel
		southPanel.add(btnInput);
		southPanel.add(btnEdit);
		southPanel.add(btnDelete);
		southPanel.add(btnExit);
		
		//라디오버튼이 붙는 panel
		genderPanel.add(male);
		genderPanel.add(female);
		
		//grid 설계
		leftPanel.setLayout(new GridLayout(4,2));
		leftPanel.add(inGridPanel1);
		leftPanel.add(inGridPanel2);
		leftPanel.add(inGridPanel3);
		leftPanel.add(inGridPanel4);
		leftPanel.add(inGridPanel5);
		leftPanel.add(genderPanel);
		leftPanel.add(inGridPanel7);
		leftPanel.add(inGridPanel8);
		
		//오른쪽 panel
		rightPanel.add(list);
		
		//중간의 전체 panel
		centerPanel.setLayout(new GridLayout(1,2));
		centerPanel.add(leftPanel);
		centerPanel.add(rightPanel);
		
		//window
		add(BorderLayout.SOUTH,southPanel);
		add(BorderLayout.CENTER,centerPanel);
		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});//addwindowListener
		
		setSize(400,275);
		setVisible(true);
		
	}//constructor
	
	public static void main(String[] args) {
		new Homework1();
	}

}
