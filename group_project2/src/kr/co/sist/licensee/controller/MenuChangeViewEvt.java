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
		//선택된 메뉴의 이름을 가지고 메뉴의정보를 세팅해주는 일 (레스토랑 넘버로 조회후 메뉴의 이름을 검색.)
		rNum=mcv.getrNum();
		oriMName=mcv.getmName();

		menuInfoSetting(rNum,oriMName);
		
	}//MenuChangeViewEvt
	


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==mcv.getJtfName()) {
			mcv.getJtfPrice().requestFocus();
		}//end if
		
		
		//버튼
		if(ae.getSource()==mcv.getBtnAddMenuImg()) {
			FileDialog menu_img=new FileDialog(mcv,"Open",FileDialog.LOAD);
			menu_img.setVisible(true);
			
			DirName=menu_img.getDirectory();
			FileName=menu_img.getFile();
			mcv.getLblImg().setIcon(new ImageIcon(DirName+FileName));
			
			System.out.println(DirName+FileName);
			
			
			
		}//end if
		if(ae.getSource()==mcv.getBtnChange()) {
			switch(JOptionPane.showConfirmDialog(mcv, "수정하시겠습니까?")){
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

	//수정버튼을 눌렀을때 메뉴 테이블에 수정된 정보를 update하는 일
	private void menuChange(String mName, String price, String intro, String imgFile, String orimName, String rNum) {
		MenuUpdateDAO mu_dao=MenuUpdateDAO.getInstance();
		try {
			mu_dao.menuUpdate(mName,price,intro,imgFile,orimName,rNum);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(mcv, "price는 숫자만 입력할수 있습니다.", "중요한 정보", JOptionPane.WARNING_MESSAGE);
			return;
		}
		JOptionPane.showMessageDialog(mcv, "수정에 성공하였어요", "수정 성공!", JOptionPane.INFORMATION_MESSAGE);
		
	}



	//선택된 메뉴의 이름을 가지고 메뉴의정보를 세팅해주는 일 (레스토랑 넘버로 조회후 메뉴의 이름을 검색.)
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
			//TODO 이미지 세팅
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}//class
