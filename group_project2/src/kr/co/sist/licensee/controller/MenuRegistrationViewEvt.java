package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.sist.licensee.dao.RestaurantRegistrationDAO;
import kr.co.sist.licensee.view.MenuRegistrationView;
import kr.co.sist.licensee.vo.MenuRegistrationVO;
import kr.co.sist.licensee.vo.RestaurantRegistrationVO;

public class MenuRegistrationViewEvt implements ActionListener {
	private MenuRegistrationView mrv;
	String imgPath;
	
	public MenuRegistrationViewEvt(MenuRegistrationView mrv) {
		this.mrv=mrv;
	}//MenuRegistrationViewEvt
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�ؽ�Ʈ
		if(ae.getSource()==mrv.getJtfName()) {
			mrv.getJtfPrice().requestFocus();
		}//end if
		
		//��ư
		if(ae.getSource()==mrv.getBtnAdd()) {
			FileDialog menu_img=new FileDialog(mrv,"Open",FileDialog.LOAD);
			menu_img.setVisible(true);
			
			String DirName=menu_img.getDirectory();
			String FileName=menu_img.getFile();
			imgPath=DirName+FileName;
			mrv.getLblImg().setIcon(new ImageIcon(imgPath));
			
			System.out.println(DirName+FileName);
			
			
		}//end if
		if(ae.getSource()==mrv.getBtnRegistration()) {
			addMenu(mrv.getrNum());
		}//end if
		if(ae.getSource()==mrv.getBtnCancle()) {
			mrv.dispose();
		}//end if
		
		
	}//actionPerformed
	
	//�Ĵ�޴����//Ȯ���ؾ���~~
	public void addMenu(String rNum){
	
		String m_Img=imgPath;
		String m_Name=mrv.getJtfName().getText().trim();
		String m_Price=mrv.getJtfPrice().getText().trim();
		String m_Intro=mrv.getTaIntroduction().getText().trim();
		
		MenuRegistrationVO mrvo=new MenuRegistrationVO(m_Img, m_Name, m_Price,  m_Intro,rNum );
		
		RestaurantRegistrationDAO rr_dao=RestaurantRegistrationDAO.getInstance();
		
		switch(JOptionPane.showConfirmDialog(mrv, "����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)) {
		case JOptionPane.OK_OPTION:
			try {
				rr_dao.insertMenu(mrvo);
				JOptionPane.showMessageDialog(mrv, "����� ���������� �Ϸ�Ǿ����ϴ�.");
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(mrv, "����� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.");
				se.printStackTrace();
			}//end catch
		}//end switch
	}//addRest
	
	
}//class
