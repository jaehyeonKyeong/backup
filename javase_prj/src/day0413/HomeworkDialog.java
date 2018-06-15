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
	private Font font=new Font("맑은 고딕",Font.BOLD,30);
	
	
	
	
	public HomeworkDialog(Homework hw) {
		super(hw, "글꼴설정",true);
		///////////////일반 component///////////////////////
		lblFontFormat=new Label("글꼴");
		lblFontStyle=new Label("스타일");
		lblFontSize=new Label("크기");
		
		tfFontFormat=new TextField();
		tfFontStyle=new TextField();
		tfFontSize=new TextField();
		
		lblPreview=new Label("미리보기");
		lblOutput=new Label("AaBbYyZz");
		
		listFontFormat=new List();
		listFontStyle=new List();
		listFontSize=new List();
		
		btnConfirm=new Button("확인");
		btnCancel=new Button("취소");
		
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
		
		listFontStyle.add("보통");
		listFontStyle.add("굵게");
		listFontStyle.add("Italic");
		listFontStyle.add("굵게 Italic");
		
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
		if(ae.getActionCommand().equals("취소")){
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
