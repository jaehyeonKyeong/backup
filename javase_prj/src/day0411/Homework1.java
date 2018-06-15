package day0411;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Homework1 extends Frame {
	
	@SuppressWarnings("unused")
	public Homework1() {
		super("����");
		
		Label lblName=new Label("�̸�");
		Label lblAge=new Label("����");
		Label lblGender=new Label("����");
		Label lblAddr=new Label("�ּ�");
		
		TextField tfName=new TextField(8);
		TextField tfAge=new TextField(8);
		TextField tfAddr=new TextField(15);
		
		CheckboxGroup cbg=new CheckboxGroup();
		Checkbox male=new Checkbox("����",true,cbg);
		Checkbox female=new Checkbox("����",false,cbg);
		
		List list=new List();
		
		Button btnInput=new Button("�Է�");
		Button btnEdit=new Button("����");
		Button btnDelete=new Button("����");
		Button btnExit=new Button("�ݱ�");
		
		
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
		
		
		//grid�ȿ� ���� panel
		inGridPanel1.add(lblName);
		inGridPanel2.add(tfName);
		inGridPanel3.add(lblAge);
		inGridPanel4.add(tfAge);
		inGridPanel5.add(lblGender);
		inGridPanel7.add(lblAddr);
		inGridPanel8.add(tfAddr);
		
		//south�� �ٴ� panel
		southPanel.add(btnInput);
		southPanel.add(btnEdit);
		southPanel.add(btnDelete);
		southPanel.add(btnExit);
		
		//������ư�� �ٴ� panel
		genderPanel.add(male);
		genderPanel.add(female);
		
		//grid ����
		leftPanel.setLayout(new GridLayout(4,2));
		leftPanel.add(inGridPanel1);
		leftPanel.add(inGridPanel2);
		leftPanel.add(inGridPanel3);
		leftPanel.add(inGridPanel4);
		leftPanel.add(inGridPanel5);
		leftPanel.add(genderPanel);
		leftPanel.add(inGridPanel7);
		leftPanel.add(inGridPanel8);
		
		//������ panel
		rightPanel.add(list);
		
		//�߰��� ��ü panel
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
