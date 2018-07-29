package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.sist.licensee.view.MenuChangeView;

public class MenuChangeViewEvt implements ActionListener {
	private MenuChangeView mcv;
	
	public MenuChangeViewEvt(MenuChangeView mcv) {
		this.mcv=mcv;
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
			
			String DirName=menu_img.getDirectory();
			String FileName=menu_img.getFile();
			mcv.getLblImg().setIcon(new ImageIcon(DirName+FileName));
			
			System.out.println(DirName+FileName);
			
			
			
		}//end if
		if(ae.getSource()==mcv.getBtnChange()) {
			switch(JOptionPane.showConfirmDialog(mcv, "수정하시겠습니까?")){
				case JOptionPane.OK_OPTION:
					// TODO Auto-generated method stub
					hjgjg;
			}//end 
		}//end if
		if(ae.getSource()==mcv.getBtnCancle()) {
			mcv.dispose();
		}//end if
		
		
		
	}//actionPerformed



}//class
