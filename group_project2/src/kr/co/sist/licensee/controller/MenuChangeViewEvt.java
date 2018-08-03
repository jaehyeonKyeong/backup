package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.sist.licensee.dao.MenuUpdateDAO;
import kr.co.sist.licensee.view.MenuChangeView;
import kr.co.sist.licensee.vo.MenuUpdateVO;

public class MenuChangeViewEvt implements ActionListener {
	private MenuChangeView mcv;
	String rNum,oriMName,DirName,FileName;
	
	public MenuChangeViewEvt(MenuChangeView mcv) {
		this.mcv=mcv;
		//���õ� �޴��� �̸��� ������ �޴��������� �������ִ� �� (������� �ѹ��� ��ȸ�� �޴��� �̸��� �˻�.)
		rNum=mcv.getrNum();
		oriMName=mcv.getmName();

		menuInfoSetting(rNum,oriMName);
		
	}//MenuChangeViewEvt
	


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mcv.getJtfName()) {
			mcv.getJtfPrice().requestFocus();
		}//end if
		
		
		//��ư
		if(ae.getSource()==mcv.getBtnAddMenuImg()) {
			FileDialog menu_img=new FileDialog(mcv,"Open",FileDialog.LOAD);
			menu_img.setVisible(true);
			
			DirName=menu_img.getDirectory();
			FileName=menu_img.getFile();
			mcv.getLblImg().setIcon(new ImageIcon(DirName+FileName));
			
			System.out.println(DirName+FileName);
			
			
			
		}//end if
		if(ae.getSource()==mcv.getBtnChange()) {
			switch(JOptionPane.showConfirmDialog(mcv, "�����Ͻðڽ��ϱ�?")){
				case JOptionPane.OK_OPTION:
					String mName=mcv.getJtfName().getText();
					String price=mcv.getJtfPrice().getText();
					String intro=mcv.getTaIntroduction().getText();
					menuChange(mName,price,intro,DirName+FileName,oriMName,rNum);
					mcv.dispose();
			}//end 
		}//end if
		if(ae.getSource()==mcv.getBtnCancle()) {
			mcv.dispose();
		}//end if
		
		
		
	}//actionPerformed

	//������ư�� �������� �޴� ���̺� ������ ������ update�ϴ� ��
	private void menuChange(String mName, String price, String intro, String imgFile, String orimName, String rNum) {
		MenuUpdateDAO mu_dao=MenuUpdateDAO.getInstance();
		try {
			mu_dao.menuUpdate(mName,price,intro,imgFile,orimName,rNum);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(mcv, "price�� ���ڸ� �Է��Ҽ� �ֽ��ϴ�.", "�߿��� ����", JOptionPane.WARNING_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(mcv, "������ �����Ͽ����", "���� ����!", JOptionPane.INFORMATION_MESSAGE);
		
	}



	//���õ� �޴��� �̸��� ������ �޴��������� �������ִ� �� (������� �ѹ��� ��ȸ�� �޴��� �̸��� �˻�.)
	private void menuInfoSetting(String rName, String mName) {
		MenuUpdateDAO mu_dao=MenuUpdateDAO.getInstance();
		try {
			MenuUpdateVO muvo=new MenuUpdateVO();
			muvo=mu_dao.settingMenuInfo(rName,mName);
			System.out.println(muvo);
			FileClient fc=new FileClient();
			try {
				String imgPath=fc.menuDownloadProcess(mName, rName);
				mcv.getLblImg().setIcon(new ImageIcon(imgPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mcv.getJtfName().setText(muvo.getMenuName());
			mcv.getJtfPrice().setText(Integer.toString(muvo.getMenuPrice()));
			mcv.getTaIntroduction().setText(muvo.getMenuIntro());
			mcv.dispose();
			//TODO �̹��� ����
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}//class
