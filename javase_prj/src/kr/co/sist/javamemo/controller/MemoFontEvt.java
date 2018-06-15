package kr.co.sist.javamemo.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.javamemo.view.MemoFont;

public class MemoFontEvt extends WindowAdapter implements ActionListener, ItemListener {
	private MemoFont mf;
	private Font previewFont;

	public MemoFontEvt(MemoFont mf) {
		this.mf = mf;
		previewFont = mf.getLblPreview().getFont();

	}// constructor

	@Override
	public void windowClosing(WindowEvent we) {
		mf.dispose();
	}// windowClosing

	@Override
	public void itemStateChanged(ItemEvent ie) {

		Font tempFont = null;

		if (ie.getSource() == mf.getListFont()) {// �۲ÿ��� �̺�Ʈ�� �߻�������
			// ������ �۲��� textField�� �ø���.
			mf.getTfFont().setText(mf.getListFont().getSelectedItem());
			// ����ڰ� �۲��� ���������Ƿ� ��Ÿ�ϰ� ������� ���� ��Ʈ�� �ٲ�� �����Ͽ� ���ο� ��Ʈ�� �����
			tempFont = new Font(mf.getListFont().getSelectedItem(), previewFont.getStyle(), previewFont.getSize());
		} // end if

		if (ie.getSource() == mf.getListStyle()) {// ��Ÿ�Ͽ��� �̺�Ʈ�� �߻�������
			// ������ ��Ÿ���� textField�� �ø���.
			mf.getTfStyle().setText(mf.getListStyle().getSelectedItem());
			tempFont = new Font(previewFont.getFamily(), mf.getListStyle().getSelectedIndex(), previewFont.getSize());
		} // end if

		if (ie.getSource() == mf.getListSize()) {// ũ�⿡�� �̺�Ʈ�� �߻�������
			// ������ ũ�⸦ textField�� �ø���.
			mf.getTfSize().setText(mf.getListSize().getSelectedItem());
			tempFont = new Font(previewFont.getFamily(),previewFont.getStyle(), Integer.parseInt(mf.getListSize().getSelectedItem()));
		} // end if
		previewFont = tempFont;
		mf.getLblPreview().setFont(tempFont);

	}// itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mf.getBtnOk()) {
			//������ ��Ʈ������ �θ�â�� textara�� ����ǰ� ����
			mf.getJm().getTaNote().setFont(previewFont);
		}
//		if(ae.getSource()==mf.getBtnCancel()) {
			mf.dispose();
//		}
	}// actionPerformed

}// class
