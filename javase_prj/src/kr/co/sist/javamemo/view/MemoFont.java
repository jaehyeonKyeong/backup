package kr.co.sist.javamemo.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

import kr.co.sist.javamemo.controller.MemoFontEvt;

/**
 * �۲��� �����Ͽ� has a ������ ��ü���� �����ϴ� TextArea�� �۲��� �����ϴ� ��
 * @author owner
 */
@SuppressWarnings({ "serial", "unused" })
public class MemoFont extends Dialog {
	private Font taFont;
	private JavaMemo jm;
	
	private Label lblPreview;
	private TextField tfFont,tfStyle,tfSize;
	private List listFont,listStyle,listSize;
	private Button btnOk,btnCancel;
	
	
	
	public MemoFont(JavaMemo jm) {
		super(jm, "�۲�", true);
		this.jm=jm;
		taFont=jm.getTaNote().getFont();//���� �޸����� �۲����� ���
		
		Label lblFont=new Label("�۲�");
		Label lblStyle=new Label("�۲� ��Ÿ��");
		Label lblSize=new Label("ũ��");
		Label lblPreviewTitle=new Label("�̸�����");
		
		lblPreview=new Label("AaBbYyZz",Label.CENTER);
		tfFont=new TextField();
		tfStyle=new TextField();
		tfSize=new TextField();
		
		listFont=new List();
		listStyle=new List();
		listSize=new List();
		
		btnOk=new Button("Ȯ��");
		btnCancel=new Button("���");
		
		
		String[] style= {"����","����","����Ӳ�","���� ����Ӳ�"};
		String[] font= {"Dialog","DialogInput","Monospaced","Serif","SansSerif"};
		//������ ä���
		tfStyle.setText(style[taFont.getStyle()]);
		tfSize.setText(String.valueOf(taFont.getSize()));
		tfFont.setText(taFont.getFamily());
		
		for(String temp:font) {
			listFont.add(temp);
		}
		for(String temp:style) {
			listStyle.add(temp);
		}
		listSize.add("8");
		listSize.add("9");
		for(int i=9;i<81;i++) {
			listSize.add(String.valueOf(++i));
		}
		
		//��ġ
		setLayout(null);
		lblFont.setBounds(15,40,90,20);
		lblStyle.setBounds(175,40,90,20);
		lblSize.setBounds(320,40,90,20);
		
		lblPreviewTitle.setBounds(200,220,90,20);
		lblPreview.setBounds(220,250,200,70);
		lblPreview.setFont(taFont);//TextArea�� Font������ �̸����⸦ ������
		
		
		tfFont.setBounds(15,60,120,20);
		tfStyle.setBounds(175,60,100,20);
		tfSize.setBounds(320,60,70,20);
				
		listFont.setBounds(15,80,120,110);
		listStyle.setBounds(175,80,100,110);
		listSize.setBounds(320,80,70,110);
		
		btnOk.setBounds(220,350,80,20);
		btnCancel.setBounds(330,350,80,20);
		
		add(lblFont);
		add(lblStyle);
		add(lblSize);
		
		add(tfFont);
		add(tfStyle);
		add(tfSize);
		
		add(listFont);
		add(listStyle);
		add(listSize);
		
		add(lblPreviewTitle);
		add(lblPreview);
		
		add(btnOk);
		add(btnCancel);
		
		//�̺�Ʈ ���
		MemoFontEvt mfe=new MemoFontEvt(this);
		addWindowListener(mfe);
		
		btnOk.addActionListener(mfe);
		btnCancel.addActionListener(mfe);
		
		listFont.addItemListener(mfe);
		listSize.addItemListener(mfe);
		listStyle.addItemListener(mfe);
		
		
		setBounds(jm.getX()+100,jm.getY()+90,450,400);
		setVisible(true);
		
		
		
		
	}// constructor

	
	
//getter

	public Font getTaFont() {
		return taFont;
	}



	public JavaMemo getJm() {
		return jm;
	}



	public Label getLblPreview() {
		return lblPreview;
	}



	public TextField getTfFont() {
		return tfFont;
	}



	public TextField getTfStyle() {
		return tfStyle;
	}



	public TextField getTfSize() {
		return tfSize;
	}



	public List getListFont() {
		return listFont;
	}



	public List getListStyle() {
		return listStyle;
	}



	public List getListSize() {
		return listSize;
	}



	public Button getBtnOk() {
		return btnOk;
	}



	public Button getBtnCancel() {
		return btnCancel;
	}
	
}//class
