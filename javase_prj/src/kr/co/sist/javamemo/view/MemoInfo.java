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
		super(jm, "�޸��� ����", true);
		Label lblTitle = new Label("�޸��� ����", Label.CENTER);

		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		TextArea taMemoInfo = new TextArea();
		taMemoInfo.append("�� �޸����� �ڹ� ���� ���۵� �޸�������\n");
		taMemoInfo.append("�������� �����Ͽ����ϴ�.\n");
		taMemoInfo.append("License�� KPL(KyungJaeHyun Public License) ������� �����ϼ���.\n");
		taMemoInfo.append("Version 1.0 ���� ���׷��̵� ��ȹ�� �����ϴ�.\n");
		
		taMemoInfo.setEditable(false);
		
		Button btn=new Button("�ݱ�");
		
		//����
		Panel panelSouth=new Panel();
		panelSouth.add(btn);
		add("North",lblTitle);
		add("Center",taMemoInfo);
		add("South",panelSouth);
		
		lblTitle.setBackground(Color.WHITE);
		taMemoInfo.setBackground(Color.WHITE);
		panelSouth.setBackground(Color.WHITE);
		
		//�̺�Ʈ ���
		MemoInfoEvt mie=new MemoInfoEvt(this);
		addWindowListener(mie);
		btn.addActionListener(mie);
		
		setBounds(jm.getX()+150,jm.getY()+100,300,250);
		setResizable(false);//resizable�� �������� ���� ����������
		setVisible(true);
	}// constructor

}
