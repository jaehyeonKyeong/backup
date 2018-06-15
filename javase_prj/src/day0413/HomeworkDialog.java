package day0413;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.WindowConstants;

import java.awt.List;


@SuppressWarnings({ "serial", "unused" })
public class HomeworkDialog extends Dialog implements ActionListener {
	private Label lblFontFormat,lblFontStyle,lblFontSize,lblPreview,lblOutput;
	private TextField tfFontFormat,tfFontStyle,tfFontSize;
	private List listFontFormat,listFontStyle,listFontSize;
	private Button btnConfirm,btnCancel;
	private Font font=new Font("���� ���",Font.BOLD,30);
	
	
	
	
	public HomeworkDialog(Homework hw) {
		super(hw, "�۲ü���",true);
		///////////////�Ϲ� component///////////////////////
		lblFontFormat=new Label("�۲�");
		lblFontStyle=new Label("��Ÿ��");
		lblFontSize=new Label("ũ��");
		
		tfFontFormat=new TextField();
		tfFontStyle=new TextField();
		tfFontSize=new TextField();
		
		lblPreview=new Label("�̸�����");
		lblOutput=new Label("AaBbYyZz");
		
		listFontFormat=new List();
		listFontStyle=new List();
		listFontSize=new List();
		
		btnConfirm=new Button("Ȯ��");
		btnCancel=new Button("���");
		
		///////////////////////////////////////////////////
		setLayout(null);
		lblFontFormat.setBounds(30,40,50,25);
		tfFontFormat.setBounds(30,65,100,20);
		listFontFormat.setBounds(30,90,100,200);
		
		lblFontStyle.setBounds(160,40,50,25);
		tfFontStyle.setBounds(160,65,100,20);
		listFontStyle.setBounds(160,90,100,200);
		
		lblFontSize.setBounds(290,40,50,25);
		tfFontSize.setBounds(290, 65, 100, 20);
		listFontSize.setBounds(290, 90, 100, 200);
		
		lblPreview.setBounds(130,320,100,15);
		lblOutput.setBounds(150,340,150,35);
		
		btnConfirm.setBounds(290,390,50,20);
		btnCancel.setBounds(350,390,50,20);
		
		lblOutput.setFont(font);
		
		///////////////////////////////////////////////////

		
		add(lblFontFormat);
		add(tfFontFormat);
		add(listFontFormat);
		
		add(lblFontStyle);
		add(tfFontStyle);
		add(listFontStyle);
		
		add(lblFontSize);
		add(tfFontSize);
		add(listFontSize);
		
		add(lblPreview);
		add(lblOutput);
		
		add(btnConfirm);
		add(btnCancel);
		
		///////////////////////////////////////////////////
		listFontFormat.add("Dialog");
		listFontFormat.add("MonoSpaced");
		listFontFormat.add("Serif");
		listFontFormat.add("SanSerif");
		listFontFormat.add("DialogInput");
		
		listFontStyle.add("����");
		listFontStyle.add("����");
		listFontStyle.add("Italic");
		listFontStyle.add("���� Italic");
		
		for(int i=8;i<=80;i+=2) {
			listFontSize.add(String.valueOf(i));
		}
		
		////////////////////////////////////////////////////////////				
		
//		tfFontFormat.addActionListener(this);
		btnCancel.addActionListener(this);
		
		windowClosing();
		
		setBounds(/*hw.getX()+150,hw.getY()+200*/0,0,430,440);
		setVisible(true);
		
		
		
	}
		
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("���")){
			dispose();
		}
		
	}
	public void windowClosing() {
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			
		});
	}
	public static void main(String[] args) {
		new HomeworkDialog(new Homework());
	}

}
