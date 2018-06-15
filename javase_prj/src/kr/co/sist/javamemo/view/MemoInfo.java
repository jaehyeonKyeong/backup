package kr.co.sist.javamemo.view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;

import kr.co.sist.javamemo.controller.MemoInfoEvt;

@SuppressWarnings("serial")
public class MemoInfo extends Dialog {

	public MemoInfo(JavaMemo jm) {
		super(jm, "메모장 정보", true);
		Label lblTitle = new Label("메모장 정보", Label.CENTER);

		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		TextArea taMemoInfo = new TextArea();
		taMemoInfo.append("이 메모장은 자바 언어로 제작된 메모장으로\n");
		taMemoInfo.append("경제현이 개발하였습니다.\n");
		taMemoInfo.append("License는 KPL(KyungJaeHyun Public License) 마음대로 배포하세요.\n");
		taMemoInfo.append("Version 1.0 향후 업그레이드 계획은 없습니다.\n");
		
		taMemoInfo.setEditable(false);
		
		Button btn=new Button("닫기");
		
		//배포
		Panel panelSouth=new Panel();
		panelSouth.add(btn);
		add("North",lblTitle);
		add("Center",taMemoInfo);
		add("South",panelSouth);
		
		lblTitle.setBackground(Color.WHITE);
		taMemoInfo.setBackground(Color.WHITE);
		panelSouth.setBackground(Color.WHITE);
		
		//이벤트 등록
		MemoInfoEvt mie=new MemoInfoEvt(this);
		addWindowListener(mie);
		btn.addActionListener(mie);
		
		setBounds(jm.getX()+150,jm.getY()+100,300,250);
		setResizable(false);//resizable은 보여지기 전에 리사이저블
		setVisible(true);
	}// constructor

}
