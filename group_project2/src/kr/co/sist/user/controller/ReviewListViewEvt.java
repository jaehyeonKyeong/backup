package kr.co.sist.user.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kr.co.sist.user.view.ReviewContentsView;
import kr.co.sist.user.view.ReviewListView;
import kr.co.sist.user.view.ReviewRegiView;

public class ReviewListViewEvt extends MouseAdapter implements ActionListener {
	ReviewListView rlv;

	public ReviewListViewEvt(ReviewListView rlv) {
		this.rlv = rlv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rlv.getBtnAddReview()) {
			addReview();
		}
		if (e.getSource() == rlv.getBtnViewReview()) {
			viewReview();
		}
		if (e.getSource() == rlv.getBtnClose()) {
			rlv.dispose();
		}

	}

	


		

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == rlv.getTodayReviewTable()) {
			rlv.getTodayReviewTable().requestFocus(false);
			rlv.getTodayReviewTable().setSelectionBackground(Color.CYAN);
			rlv.getRankReviewTable().setSelectionBackground(Color.WHITE);
		} else {
			rlv.getRankReviewTable().requestFocus(false);
			rlv.getRankReviewTable().setSelectionBackground(Color.CYAN);
			rlv.getTodayReviewTable().setSelectionBackground(Color.WHITE);
		}
	}

	public void addReview() {
		new ReviewRegiView();
	}

	public void viewReview() {

		new ReviewContentsView();
	}

}
