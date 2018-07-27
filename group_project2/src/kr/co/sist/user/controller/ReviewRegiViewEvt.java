package kr.co.sist.user.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import kr.co.sist.user.view.ReviewRegiView;

public class ReviewRegiViewEvt implements ActionListener{
	private ReviewRegiView rrv;
	
	public ReviewRegiViewEvt(ReviewRegiView rrv) {
		this.rrv=rrv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rrv.getBtnAdd()) {
			addReview();
		}
		if(e.getSource()==rrv.getBtnClose()) {
			rrv.dispose();
		}
		if(e.getSource()==rrv.getBtnRegiImg()) {
			regiImg();
		}
	}

	private void regiImg() {
		FileDialog fd=new FileDialog(rrv, "이미지 등록", FileDialog.LOAD);
		fd.setVisible(true);
	}

	private void addReview() {
		JOptionPane.showMessageDialog(rrv, "등록이 완료되었어요", "등록완료", JOptionPane.INFORMATION_MESSAGE);
		
	}

}
