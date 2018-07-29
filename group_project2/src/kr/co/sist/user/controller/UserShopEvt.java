package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.UserShopDAO;
import kr.co.sist.user.view.Category;
import kr.co.sist.user.view.UserShop;

public class UserShopEvt implements ActionListener {

	private UserShop us;
	private Category cg;
	private String giftCardName,userId;
	private int userPoint;
	public UserShopEvt(UserShop us) {
		this.us=us;
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		userId=us.getCg().getBtnID().getText();//아이디 받음
		userPoint=us.getCg().getUserPoint();
		UserShopDAO u_dao=UserShopDAO.getInstance();
		if (ae.getSource() == us.getBtnThousandImg()) {
			giftCardName="1000원 상품권";
			int optionType=JOptionPane.showConfirmDialog(us, giftCardName+"을(를) 구매하시겠습니까?", "구매확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (optionType) {
			case JOptionPane.OK_OPTION://예 클릭시
				userPoint-=1000;
				System.out.println( "---구매확인---"+ userPoint);
				try {
					u_dao.updateUserInfo(userId,userPoint);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			default://아니오 클릭시
				//
			}
		} // 천원 상품권
		if (ae.getSource() == us.getBtnFiveThousandImg()) {
			giftCardName="5000원 상품권";
			int optionType=JOptionPane.showConfirmDialog(us, giftCardName+"을(를) 구매하시겠습니까?", "구매확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (optionType) {
			case JOptionPane.OK_OPTION://예 클릭시
				userPoint-=5000;
				try {
					u_dao.updateUserInfo(userId,userPoint);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			default://아니오 클릭시
				//
			}
		} // 5천원원 상품권
		if (ae.getSource() == us.getBtnTenThousandImg()) {
			giftCardName="10000원 상품권";
			int optionType=JOptionPane.showConfirmDialog(us, giftCardName+"을(를) 구매하시겠습니까?", "구매확인", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (optionType) {
			case JOptionPane.OK_OPTION://예 클릭시
				userPoint-=10000;
				try {
					u_dao.updateUserInfo(userId,userPoint);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				break;
			default://아니오 클릭시
				//
			}
		} // 만원 상품권
	}

}
