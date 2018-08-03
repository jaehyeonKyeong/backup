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
		//�ؽ�Ʈ
		if(ae.getSource()==mrv.getJtfName()) {
			mrv.getJtfPrice().requestFocus();
		}//end if
		
		//��ư
		if(ae.getSource()==mrv.getBtnAdd()) { // �̹��� ��ư
			//TODO
			FileDialog fd=new FileDialog(mrv, "�̹�������",FileDialog.LOAD);
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
	
	//�Ĵ�޴����//Ȯ���ؾ���~~
	public void addMenu(String rNum){
	
		String m_Img=name;
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
				mrv.dispose();
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(mrv, "����� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.");
				se.printStackTrace();
			}//end catch
		}//end switch
	}//addRest
	
}//class
