package day0416;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;

/**
 *	디자인에 대한 코드만 정의(이벤트 처리를 하지 않는다)
 *	TextArea의 입력된 글자수를 파악하여 500자 까지만 입력가능하도록 설정하는 일.
 * @author owner
 */
@SuppressWarnings("serial")
public class View extends Frame {
	
	private TextArea taContent;
	private Label lblOutput;
	
	public View() {
		super("자기소개");
		taContent=new TextArea();
		lblOutput=new Label("50/50");
		
		add("Center",taContent);
		add("South",lblOutput);//is a
		
		//이벤트를 처리할 객체를 생성하고 이벤트를 등록
		
		Controller ctl=new Controller(this);//has a 관계
		addWindowListener(ctl);
		taContent.addKeyListener(ctl);
		
		
		setBounds(200,300,500,300);//is a 관계의 method
		setVisible(true);
				
	}//constructor
	
	
	public TextArea getTaContent() {
		return taContent;
	}


	public Label getLblOutput() {
		return lblOutput;
	}


	public static void main(String[] args) {
		new View();
	}//main

}//class
