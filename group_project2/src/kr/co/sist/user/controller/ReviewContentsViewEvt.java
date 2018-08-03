package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.sist.licensee.controller.FileClient;
import kr.co.sist.user.dao.ReviewDAO;
import kr.co.sist.user.view.ReviewContentsView;
import kr.co.sist.user.vo.ReviewContentVO;

public class ReviewContentsViewEvt implements ActionListener{
	ReviewContentsView rcv;
	
	public ReviewContentsViewEvt(ReviewContentsView rcv) {
		this.rcv=rcv;
		//기본 데이터 세팅
		selectReviewContentsSetting(rcv.getrNum(),rcv.getRiNum());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==rcv.getBtnThumbsUp()) {
			thumbsUp();
		}
		if(e.getSource()==rcv.getBtnReport()) {
			reportReview();
		}
		if(e.getSource()==rcv.getBtnSubmit()) {
			rcv.dispose();
		}
	}
	private void reportReview() {
		ReviewDAO r_dao=ReviewDAO.getInstance();
		try {
			r_dao.reportReview(rcv.getrNum(),rcv.getRiNum());
			JOptionPane.showMessageDialog(rcv, "신고되었습니다", "신고완료", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//추천테이블에 like카운터를 1증가하는 일
	private void thumbsUp() {
		ReviewDAO r_dao=ReviewDAO.getInstance();
		try {
			r_dao.reviewthumpsUp(rcv.getrNum(),rcv.getRiNum());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(rcv, "해당 리뷰가 추천되었어요", "추천완료!", JOptionPane.INFORMATION_MESSAGE);
		selectReviewContentsSetting(rcv.getrNum(),rcv.getRiNum());
	}
	private void selectReviewContentsSetting(String rNum, String riNum) {
		System.out.println(rNum);
		System.out.println(riNum);
		ReviewContentVO rcvo=null;
		ReviewDAO r_dao=null;
		r_dao=ReviewDAO.getInstance();
		try {
			rcvo=r_dao.selectGetContents(rNum,riNum);
			StringBuilder gradeStar=new StringBuilder();
			gradeStar.append("평점 ");
			for(int i=0;i<rcvo.getGrade();i++) {
			gradeStar.append("★");
			}
			FileClient fc=new FileClient();
			String imgfile;
			try {
				imgfile = fc.reviewDownloadProcess(rcvo.getId(), riNum);
				rcv.getLblReviewImg().setIcon(new ImageIcon(imgfile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rcv.getLblGrade().setText(gradeStar.toString());
			rcv.getLblReviewGrade().setText(Integer.toString(rcvo.getLike_number()));
			rcv.setTitle(rcvo.getReview_title());
			rcv.getTaReviewContent().setText(rcvo.getReview_contents());
			rcv.getTfReviewerID().setText(rcvo.getId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
