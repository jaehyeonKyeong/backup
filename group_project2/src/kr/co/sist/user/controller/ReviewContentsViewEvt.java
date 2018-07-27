package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import kr.co.sist.user.view.ReviewContentsView;

public class ReviewContentsViewEvt implements ActionListener{
	ReviewContentsView rcv;
	public ReviewContentsViewEvt(ReviewContentsView rcv) {
		this.rcv=rcv;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rcv.getBtnThumbsUp()) {
			thumbsUp();
		}
	}
	private void thumbsUp() {
		JOptionPane.showMessageDialog(rcv, "추천되었어요", "추천완료!", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
}
