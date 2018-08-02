package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import kr.co.sist.user.dao.UserGiftCardInfoDAO;
import kr.co.sist.user.dao.UserShopDAO;
import kr.co.sist.user.view.Category;
import kr.co.sist.user.view.UserShop;
import kr.co.sist.user.vo.UserGiftCardInfoVO;

public class UserShopEvt implements ActionListener {

	private UserShop us;
	private Category cg;
	private String giftCardName,userId;
	private int userPoint;
	private UserGiftCardInfoVO ugci_vo;

	public UserShopEvt(UserShop us) {
		this.us=us;                                           
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		userId=us.getCg().getBtnID().getText();//���̵� ����
		userPoint=us.getUserPoint();
		System.out.println("���������� ����Ʈ : "+userPoint);
		boolean flag=false; // Ʈ��� ��ȯ�ɰ�� ���� ��ǰ�� ����Ʈ�� �߰�
		UserShopDAO u_dao=UserShopDAO.getInstance();
		UserGiftCardInfoDAO ugci_dao=UserGiftCardInfoDAO.getInstance();
		
		
		
		if (ae.getSource() == us.getBtnThousandImg()) {
			giftCardName="1000�� ��ǰ��";
			int optionType=JOptionPane.showConfirmDialog(us, giftCardName+"��(��) �����Ͻðڽ��ϱ�?", "����Ȯ��", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			switch (optionType) {
			case JOptionPane.OK_OPTION://�� Ŭ����
				try {
					if(userPoint>=1000) {
						userPoint-=1000;
						us.setUserPoint(userPoint);
					u_dao.updateUserInfo(userId,userPoint);
//					flag=true;
					ugci_vo=new UserGiftCardInfoVO("1",userId,"1000��","X","");
					ugci_dao.insertUserGiftCard(ugci_vo);
					}else {
						JOptionPane.showMessageDialog(us, "��������Ʈ�� �����մϴ�", "���� ����! :(", JOptionPane.WARNING_MESSAGE);
					}
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
				if(userPoint>=5000) {
					userPoint-=5000;
					us.setUserPoint(userPoint);
				try {
					u_dao.updateUserInfo(userId,userPoint);
					ugci_vo=new UserGiftCardInfoVO("5",userId,"5000��","X","");
					ugci_dao.insertUserGiftCard(ugci_vo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}else {
					JOptionPane.showMessageDialog(us, "��������Ʈ�� �����մϴ�", "���� ����! :(", JOptionPane.WARNING_MESSAGE);
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
				if(userPoint>=10000) {
					userPoint-=10000;
					us.setUserPoint(userPoint);
				try {
					u_dao.updateUserInfo(userId,userPoint);
					flag=true;
					ugci_vo=new UserGiftCardInfoVO("10",userId,"10000��","X","");
					ugci_dao.insertUserGiftCard(ugci_vo);
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				}else {
					JOptionPane.showMessageDialog(us, "��������Ʈ�� �����մϴ�", "���� ����! :(", JOptionPane.WARNING_MESSAGE);
				}
				break;
			default://�ƴϿ� Ŭ����
				//
			}
		} // ���� ��ǰ��
	}//end actionPerformed
	public UserGiftCardInfoVO getUgci_vo() {
		return ugci_vo;
	}
	
	
}
