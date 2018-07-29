package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.sist.util.ImageResize;
import kr.co.sist.licensee.dao.RestaurantRegistrationDAO;
import kr.co.sist.licensee.view.MenuRegistrationView;
import kr.co.sist.licensee.view.RestaurantRegistrationView;
import kr.co.sist.licensee.vo.RestaurantRegistrationVO;

public class RestaurantRegistrationViewEvt implements ActionListener {
	private RestaurantRegistrationView rrv;
	String imgPath;
	String mapPath;
	String rNum;
	public RestaurantRegistrationViewEvt(RestaurantRegistrationView rrv) {
		this.rrv=rrv;
	}//RestaurantRegistrationViewEvt
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�ؽ�Ʈ�ʵ�
		if(ae.getSource()==rrv.getTfName()) {
			rrv.getTfbNumber().requestFocus();
		}//end if
		if(ae.getSource()==rrv.getTfbNumber()) {
			rrv.getTfCeo().requestFocus();
		}//end if
		if(ae.getSource()==rrv.getTfCeo()) {
			rrv.getTfAddr().requestFocus();
		}//end if
		if(ae.getSource()==rrv.getTfAddr()) {
			rrv.getTfCustomerTransaction().requestFocus();
		}//end if
		if(ae.getSource()==rrv.getTfCustomerTransaction()) {
			rrv.getTfTel().requestFocus();
		}//end if
		
		//
		//�Ĵ��̹���
		if(ae.getSource()==rrv.getBtnRImg()){
			FileDialog r_img=new FileDialog(rrv,"Open",FileDialog.LOAD);
			r_img.setVisible(true);
			
			String DirName=r_img.getDirectory(); //������
			String FileName=r_img.getFile(); //���ϸ�
			imgPath=DirName+FileName;
			rrv.getLblImg1().setIcon(new ImageIcon(imgPath));
			
			System.out.println(imgPath);
			
		}//end if
		
		//�Ĵ� ����
		if(ae.getSource()==rrv.getBtnMapImg()){
			FileDialog m_img=new FileDialog(rrv,"Open",FileDialog.LOAD);
			m_img.setVisible(true);
			
			String DirName=m_img.getDirectory();
			String FileName=m_img.getFile();
			mapPath=DirName+FileName;
			rrv.getLblImg2().setIcon(new ImageIcon(mapPath));
			
			System.out.println(mapPath);
		}//end if
		
		//�Ĵ��Ϲ�ư
		if(ae.getSource()==rrv.getBtnRegistration()){
				addRest();
			}//end switch
		
		//�Ĵ� �޴����
		if(ae.getSource()==rrv.getBtnMenuegistration()){
			new MenuRegistrationView(rNum);
		}//end if
		
		//Ȯ�ι�ư
		if(ae.getSource()==rrv.getBtnOk()){
			switch(JOptionPane.showConfirmDialog(rrv, "�̴��\n ��� �Ͻðڽ��ϱ�?")){
			case JOptionPane.OK_OPTION:
			}
		}//end if
		
		//��ҹ�ư
		if(ae.getSource()==rrv.getBtnCc()){
			rrv.dispose();
		}//end if
		
		
		
	}//actionPerformed
	
	//�Ĵ���
	public void addRest(){
		String l_id=rrv.getId();
		String r_Img=imgPath;
		String r_Map=mapPath;
		String r_Name=rrv.getTfName().getText().trim();
		String b_Number=rrv.getTfbNumber().getText().trim();
		String c_Name=rrv.getTfCeo().getText().trim();
		String r_Addr=rrv.getTfAddr().getText().trim();
		String c_Price=rrv.getTfCustomerTransaction().getText().trim();
		String r_Tel=rrv.getTfTel().getText().trim();
		String r_Intro=rrv.getTaIntro().getText().trim();
		int f_Category=rrv.getCbFoodCategory().getSelectedIndex();
	    
	    
	    RestaurantRegistrationVO rrvo=new RestaurantRegistrationVO
	    		(r_Img,r_Map,r_Name,b_Number,c_Name,r_Addr,c_Price,r_Tel,r_Intro,l_id
	    				,f_Category);
	    
	    RestaurantRegistrationDAO rr_dao=RestaurantRegistrationDAO.getInstance();
	    
	    switch(JOptionPane.showConfirmDialog(rrv, "����Ͻðڽ��ϱ�?","Ȯ��",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)) {
	    case JOptionPane.OK_OPTION:
	    	try {
	    		rNum=rr_dao.restaurantNumGet();
				rr_dao.insertRestaurant(rrvo,rNum);
				JOptionPane.showMessageDialog(rrv, "����� ���������� �Ϸ�Ǿ����ϴ�.");
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(rrv, "����� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.");
				se.printStackTrace();
			}//end catch
	    }//end switch
	}//addRest
	

	


	
	
	
	
}//class
