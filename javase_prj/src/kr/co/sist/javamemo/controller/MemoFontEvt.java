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

		if (ie.getSource() == mf.getListFont()) {// 글꼴에서 이벤트가 발생했을때
			// 선택한 글꼴을 textField에 올린다.
			mf.getTfFont().setText(mf.getListFont().getSelectedItem());
			// 사용자가 글꼴을 선택했으므로 스타일과 사이즈는 같고 폰트만 바뀐다 변경하여 새로운 폰트를 만든다
			tempFont = new Font(mf.getListFont().getSelectedItem(), previewFont.getStyle(), previewFont.getSize());
		} // end if

		if (ie.getSource() == mf.getListStyle()) {// 스타일에서 이벤트가 발생했을때
			// 선택한 스타일을 textField에 올린다.
			mf.getTfStyle().setText(mf.getListStyle().getSelectedItem());
			tempFont = new Font(previewFont.getFamily(), mf.getListStyle().getSelectedIndex(), previewFont.getSize());
		} // end if

		if (ie.getSource() == mf.getListSize()) {// 크기에서 이벤트가 발생했을때
			// 선택한 크기를 textField에 올린다.
			mf.getTfSize().setText(mf.getListSize().getSelectedItem());
			tempFont = new Font(previewFont.getFamily(),previewFont.getStyle(), Integer.parseInt(mf.getListSize().getSelectedItem()));
		} // end if
		previewFont = tempFont;
		mf.getLblPreview().setFont(tempFont);

	}// itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mf.getBtnOk()) {
			//설정된 폰트정보가 부모창의 textara에 적용되고 닫힘
			mf.getJm().getTaNote().setFont(previewFont);
		}
//		if(ae.getSource()==mf.getBtnCancel()) {
			mf.dispose();
//		}
	}// actionPerformed

}// class
