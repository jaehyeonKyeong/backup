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
 * 글꼴을 선택하여 has a 관계의 객체내에 존재하는 TextArea의 글꼴을 변경하는 일
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
		super(jm, "글꼴", true);
		this.jm=jm;
		taFont=jm.getTaNote().getFont();//현재 메모장의 글꼴정보 얻기
		
		Label lblFont=new Label("글꼴");
		Label lblStyle=new Label("글꼴 스타일");
		Label lblSize=new Label("크기");
		Label lblPreviewTitle=new Label("미리보기");
		
		lblPreview=new Label("AaBbYyZz",Label.CENTER);
		tfFont=new TextField();
		tfStyle=new TextField();
		tfSize=new TextField();
		
		listFont=new List();
		listStyle=new List();
		listSize=new List();
		
		btnOk=new Button("확인");
		btnCancel=new Button("취소");
		
		
		String[] style= {"보통","굵게","기울임꼴","굵은 기울임꼴"};
		String[] font= {"Dialog","DialogInput","Monospaced","Serif","SansSerif"};
		//데이터 채우기
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
		
		//배치
		setLayout(null);
		lblFont.setBounds(15,40,90,20);
		lblStyle.setBounds(175,40,90,20);
		lblSize.setBounds(320,40,90,20);
		
		lblPreviewTitle.setBounds(200,220,90,20);
		lblPreview.setBounds(220,250,200,70);
		lblPreview.setFont(taFont);//TextArea의 Font정보로 미리보기를 설정함
		
		
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
		
		//이벤트 등록
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
