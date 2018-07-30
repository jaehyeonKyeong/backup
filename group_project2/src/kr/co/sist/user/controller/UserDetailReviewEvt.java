package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import kr.co.sist.user.dao.MemberDAO;
import kr.co.sist.user.view.UserDetailReview;
import kr.co.sist.user.vo.UserDetailReviewVO;

public class UserDetailReviewEvt implements ActionListener {
	private UserDetailReview udr;
	private UserDetailReviewVO udrv;
	private int grade;
	private String reviewImg;
	public UserDetailReviewEvt(UserDetailReview udr) {
		this.udr=udr;
		MemberDAO m_dao=MemberDAO.getInstance();
		try {
			udrv=m_dao.selectDetailReview(udr.getId(), udr.getrNum());
			System.out.println(udrv.getReview_contents()+"/"+udrv.getGrade()+"/"+udrv.getReview_image());
			reviewImg=udrv.getReview_image();
			grade=udrv.getGrade();//º°°¹¼ö
			udr.getTaReview().setText(udrv.getReview_contents());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UserDetailReview getUdr() {
		return udr;
	}

	public UserDetailReviewVO getUdrv() {
		return udrv;
	}

	public String getReviewImg() {
		return reviewImg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public int getGrade() {
		return grade;
	}

}
