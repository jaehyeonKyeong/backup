package day0416;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;

/**
 *	�����ο� ���� �ڵ常 ����(�̺�Ʈ ó���� ���� �ʴ´�)
 *	TextArea�� �Էµ� ���ڼ��� �ľ��Ͽ� 500�� ������ �Է°����ϵ��� �����ϴ� ��.
 * @author owner
 */
@SuppressWarnings("serial")
public class View extends Frame {
	
	private TextArea taContent;
	private Label lblOutput;
	
	public View() {
		super("�ڱ�Ұ�");
		taContent=new TextArea();
		lblOutput=new Label("50/50");
		
		add("Center",taContent);
		add("South",lblOutput);//is a
		
		//�̺�Ʈ�� ó���� ��ü�� �����ϰ� �̺�Ʈ�� ���
		
		Controller ctl=new Controller(this);//has a ����
		addWindowListener(ctl);
		taContent.addKeyListener(ctl);
		
		
		setBounds(200,300,500,300);//is a ������ method
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
