package kr.co.sist.licensee.controller;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.util.ImageResize;
import kr.co.sist.licensee.dao.RestaurantRegistrationDAO;
import kr.co.sist.licensee.view.MenuRegistrationView;
import kr.co.sist.licensee.view.RestaurantRegistrationView;
import kr.co.sist.licensee.vo.MenuVO;
import kr.co.sist.licensee.vo.RestaurantLicenseeVO;
import kr.co.sist.licensee.vo.RestaurantRegistrationVO;

public class RestaurantRegistrationViewEvt implements ActionListener {
	private RestaurantRegistrationView rrv;
	String imgPath, mapPath, mapFileName, imgFileName, rNum;
	RestaurantRegistrationDAO rr_dao;

	public RestaurantRegistrationViewEvt(RestaurantRegistrationView rrv) {
		this.rrv = rrv;
		rr_dao = RestaurantRegistrationDAO.getInstance();
		try {
			rNum = rr_dao.restaurantNumGet();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// RestaurantRegistrationViewEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		// �ؽ�Ʈ�ʵ�
		if (ae.getSource() == rrv.getTfName()) {
			rrv.getTfbNumber().requestFocus();
		} // end if
		if (ae.getSource() == rrv.getTfbNumber()) {
			rrv.getTfCeo().requestFocus();
		} // end if
		if (ae.getSource() == rrv.getTfCeo()) {
			rrv.getTfAddr().requestFocus();
		} // end if
		if (ae.getSource() == rrv.getTfAddr()) {
			rrv.getTfCustomerTransaction().requestFocus();
		} // end if
		if (ae.getSource() == rrv.getTfCustomerTransaction()) {
			rrv.getTfTel().requestFocus();
		} // end if

		//
		// �Ĵ��̹���
		if (ae.getSource() == rrv.getBtnRImg()) {
			FileDialog r_img = new FileDialog(rrv, "Open", FileDialog.LOAD);
			r_img.setVisible(true);

			String DirName = r_img.getDirectory(); // ������
			imgFileName = r_img.getFile(); // ���ϸ�
			imgPath = DirName + imgFileName;
			if (imgFileName != null) {
				// �̹��� ���ϸ� ����ϵ��� ����
				String ext = imgFileName.substring(imgFileName.lastIndexOf(".") + 1).toLowerCase();
				// ��밡���� Ȯ������ ���� ó��
				// jpg,gif,png,bmp ��
				if ("jpg".equals(ext) || "gif".equals(ext) || "png".equals(ext) || "bmp".equals(ext)) {

					rrv.getLblImg1().setIcon(new ImageIcon(imgPath));

				} else {// ��밡���� Ȯ���ڰ� �ƴ�
					JOptionPane.showMessageDialog(rrv, imgFileName + "�� ��밡���� �̹����� �ƴմϴ�.");

				} // end else
			}

			System.out.println(imgPath);

		} // end if

		// �Ĵ� ����
		if (ae.getSource() == rrv.getBtnMapImg()) {
			FileDialog m_img = new FileDialog(rrv, "Open", FileDialog.LOAD);
			m_img.setVisible(true);

			String DirName = m_img.getDirectory();
			mapFileName = m_img.getFile();
			mapPath = DirName + mapFileName;
			if (mapFileName != null) {
				// �̹��� ���ϸ� ����ϵ��� ����
				String ext = imgFileName.substring(mapFileName.lastIndexOf(".") + 1).toLowerCase();
				// ��밡���� Ȯ������ ���� ó��
				// jpg,gif,png,bmp ��
				if ("jpg".equals(ext) || "gif".equals(ext) || "png".equals(ext) || "bmp".equals(ext)) {

					rrv.getLblImg2().setIcon(new ImageIcon(mapPath));
				} else {// ��밡���� Ȯ���ڰ� �ƴ�
					JOptionPane.showMessageDialog(rrv, mapFileName + "�� ��밡���� �̹����� �ƴմϴ�.");

				} // end else
			}

			System.out.println(mapPath);
		} // end if

		// �Ĵ��Ϲ�ư
		if (ae.getSource() == rrv.getBtnRegistration()) {
			if (!"".equals(rrv.getTfName().getText().trim())) {
				addRest();
			} else {
				JOptionPane.showMessageDialog(rrv, "�Ĵ���� �ʼ��� �Է����ּ���!", "�Ĵ���Է����ּ���Ф�", JOptionPane.INFORMATION_MESSAGE);
				rrv.getTfName().requestFocus();
			}
		} // end switch

		// �Ĵ� �޴����
		if (ae.getSource() == rrv.getBtnMenuegistration()) {
			new MenuRegistrationView(rNum, rrv);
		} // end if

		// Ȯ�ι�ư
		if (ae.getSource() == rrv.getBtnOk()) {
			switch (JOptionPane.showConfirmDialog(rrv, "�̴��\n ��� �Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:
				rrv.dispose();
			default:
			}
		} // end if

		// ��ҹ�ư
		if (ae.getSource() == rrv.getBtnCc()) {
			rrv.dispose();
		} // end if
			// ���ΰ�ħ��ư
		if (ae.getSource() == rrv.getBtnNewMenu()) {
			searchMenu(rNum);
		}

	}// actionPerformed

	// �Ĵ���
	public void addRest() {
		String l_id = rrv.getId();
		String r_Img = imgFileName;
		String r_Map = mapFileName;
		String r_Name = rrv.getTfName().getText().trim();
		String b_Number = rrv.getTfbNumber().getText().trim();
		String c_Name = rrv.getTfCeo().getText().trim();
		String r_Addr = rrv.getTfAddr().getText().trim();
		String c_Price = rrv.getTfCustomerTransaction().getText().trim();
		String r_Tel = rrv.getTfTel().getText().trim();
		String r_Intro = rrv.getTaIntro().getText().trim();
		int f_Category = rrv.getCbFoodCategory().getSelectedIndex();

		RestaurantRegistrationVO rrvo = new RestaurantRegistrationVO(r_Img, r_Map, r_Name, b_Number, c_Name, r_Addr,
				c_Price, r_Tel, r_Intro, l_id, f_Category);

		switch (JOptionPane.showConfirmDialog(rrv, "����Ͻðڽ��ϱ�?", "Ȯ��", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {
		case JOptionPane.OK_OPTION:
			File imgfile = new File(imgPath);
			FileClient imgfc = new FileClient();
			try {
				imgfc.restaurantUploadProcess(imgfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File mapfile = new File(mapPath);
			FileClient mapfc = new FileClient();
			try {
				mapfc.mapUploadProcess(rNum, mapfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {

				rr_dao.insertRestaurant(rrvo, rNum);
				JOptionPane.showMessageDialog(rrv, "����� ���������� �Ϸ�Ǿ����!\n���ΰ�ħ��ư�� �����ּ���");
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(rrv, "����� �����߽��ϴ�. ��� �� �ٽ� �õ����ּ���.");
				se.printStackTrace();
			} // end catch
		}// end switch
	}// addRest

	// �޴��� ��ϵǾ����� �޴��� â�� �����ش�.
	private void searchMenu(String rNum) {
		List<MenuVO> menuList = null;
		RestaurantRegistrationDAO rr_dao = RestaurantRegistrationDAO.getInstance();
		try {
			menuList = rr_dao.selectMenu(rNum);
			System.out.println(menuList);
			Object[] rowData = null;

			// �ֹ���Ȳ�� ������
			DefaultTableModel dtm = rrv.getDtmMenu();
			// dtm�ʱ�ȭ
			dtm.setRowCount(0);
			MenuVO mvo = null;
			for (int i = 0; i < menuList.size(); i++) {
				mvo = menuList.get(i);
				System.out.println(rNum);
				rowData = new Object[2];
				rowData[0] = mvo.getMenuName();
				rowData[1] = mvo.getMenuPrice();

				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {
			JOptionPane.showMessageDialog(rrv, "�Ĵ��� �������� �ʾƿ�\n�Ĵ��� ���� ������ּ���!", "�˼��ؿ��", JOptionPane.ERROR_MESSAGE);
		}

	}

}// class
