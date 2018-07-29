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
		userId=us.getCg().getBtnID().getText();//���̵� ����
		userPoint=us.getCg().getUserPoint();
		UserShopDAO u_dao=UserShopDAO.getInstance();
		if (ae.getSource() == us.getBtnThousandImg()) {
			giftCardName="1000�� ��ǰ��";
			int optionType=JOptionPane.showConfirmDialog(us, giftCardName+"��(��) �����Ͻðڽ��ϱ�?", "����Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (optionType) {
			case JOptionPane.OK_OPTION://�� Ŭ����
				userPoint-=1000;
				System.out.println( "---����Ȯ��---"+ userPoint);
				try {
					u_dao.updateUserInfo(userId,userPoint);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			default://�ƴϿ� Ŭ����
				//
			}
		} // õ�� ��ǰ��
		if (ae.getSource() == us.getBtnFiveThousandImg()) {
			giftCardName="5000�� ��ǰ��";
			int optionType=JOptionPane.showConfirmDialog(us, giftCardName+"��(��) �����Ͻðڽ��ϱ�?", "����Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (optionType) {
			case JOptionPane.OK_OPTION://�� Ŭ����
				userPoint-=5000;
				try {
					u_dao.updateUserInfo(userId,userPoint);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				break;
			default://�ƴϿ� Ŭ����
				//
			}
		} // 5õ���� ��ǰ��
		if (ae.getSource() == us.getBtnTenThousandImg()) {
			giftCardName="10000�� ��ǰ��";
			int optionType=JOptionPane.showConfirmDialog(us, giftCardName+"��(��) �����Ͻðڽ��ϱ�?", "����Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (optionType) {
			case JOptionPane.OK_OPTION://�� Ŭ����
				userPoint-=10000;
				try {
					u_dao.updateUserInfo(userId,userPoint);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				break;
			default://�ƴϿ� Ŭ����
				//
			}
		} // ���� ��ǰ��
	}

}
