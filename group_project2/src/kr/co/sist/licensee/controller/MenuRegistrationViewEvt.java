package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import kr.co.sist.licensee.dao.RestaurantRegistrationDAO;
import kr.co.sist.licensee.view.MenuRegistrationView;
import kr.co.sist.licensee.vo.MenuRegistrationVO;

public class MenuRegistrationViewEvt implements ActionListener {
	private MenuRegistrationView mrv;
	String path,name;
	
	public MenuRegistrationViewEvt(MenuRegistrationView mrv) {
		this.mrv=mrv;
		mrv.setVisible(true);
	}//MenuRegistrationViewEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//텍스트
		if(ae.getSource()==mrv.getJtfName()) {
			mrv.getJtfPrice().requestFocus();
		}//end if
		
		//버튼
		if(ae.getSource()==mrv.getBtnAdd()) { // 이미지 버튼
			//TODO
			FileDialog fd=new FileDialog(mrv, "이미지선택",FileDialog.LOAD);
			fd.setVisible(true);

			path=fd.getDirectory();
			name=fd.getFile();
			File file=new File(path+name);
			FileClient fc=new FileClient();
			try {
				fc.menuUploadProcess(file, mrv.getrNum());
				mrv.getLblImg().setIcon(new ImageIcon(path+name));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}//end if
		if(ae.getSource()==mrv.getBtnRegistration()) {
			addMenu(mrv.getrNum());
		}//end if
		if(ae.getSource()==mrv.getBtnCancle()) {
			mrv.dispose();
		}//end if
		
		
	}//actionPerformed
	
	//식당메뉴등록//확인해야함~~
	public void addMenu(String rNum){
	
		String m_Img=name;
		String m_Name=mrv.getJtfName().getText().trim();
		String m_Price=mrv.getJtfPrice().getText().trim();
		String m_Intro=mrv.getTaIntroduction().getText().trim();
		
		MenuRegistrationVO mrvo=new MenuRegistrationVO(m_Img, m_Name, m_Price,  m_Intro,rNum );
		
		RestaurantRegistrationDAO rr_dao=RestaurantRegistrationDAO.getInstance();
		
		switch(JOptionPane.showConfirmDialog(mrv, "등록하시겠습니까?","확인",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)) {
		case JOptionPane.OK_OPTION:
			try {
				rr_dao.insertMenu(mrvo);
				JOptionPane.showMessageDialog(mrv, "등록이 성공적으로 완료되었습니다.");
				mrv.dispose();
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(mrv, "등록이 실패했습니다. 잠시 후 다시 시도해주세요.");
				se.printStackTrace();
			}//end catch
		}//end switch
	}//addRest
	
}//class
