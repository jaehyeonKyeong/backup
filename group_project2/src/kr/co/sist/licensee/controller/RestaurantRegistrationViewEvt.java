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
	String imgPath;
	String mapPath;
	String rNum;

	public RestaurantRegistrationViewEvt(RestaurantRegistrationView rrv) {
		this.rrv = rrv;
	}// RestaurantRegistrationViewEvt

	@Override
	public void actionPerformed(ActionEvent ae) {
		// 텍스트필드
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
		// 식당이미지
		if (ae.getSource() == rrv.getBtnRImg()) {
			FileDialog r_img = new FileDialog(rrv, "Open", FileDialog.LOAD);
			r_img.setVisible(true);

			String DirName = r_img.getDirectory(); // 폴더명
			String FileName = r_img.getFile(); // 파일명
			imgPath = DirName + FileName;
			rrv.getLblImg1().setIcon(new ImageIcon(imgPath));

			System.out.println(imgPath);

		} // end if

		// 식당 지도
		if (ae.getSource() == rrv.getBtnMapImg()) {
			FileDialog m_img = new FileDialog(rrv, "Open", FileDialog.LOAD);
			m_img.setVisible(true);

			String DirName = m_img.getDirectory();
			String FileName = m_img.getFile();
			mapPath = DirName + FileName;
			rrv.getLblImg2().setIcon(new ImageIcon(mapPath));

			System.out.println(mapPath);
		} // end if

		// 식당등록버튼
		if (ae.getSource() == rrv.getBtnRegistration()) {
			if(!"".equals(rrv.getTfName().getText().trim())) {
			addRest();
			}else {
				JOptionPane.showMessageDialog(rrv, "식당명은 필수로 입력해주세요!", "식당명입력해주세요ㅠㅠ", JOptionPane.INFORMATION_MESSAGE);
				rrv.getTfName().requestFocus();
			}
		} // end switch

		// 식당 메뉴등록
		if (ae.getSource() == rrv.getBtnMenuegistration()) {
			new MenuRegistrationView(rNum,rrv);
		} // end if

		// 확인버튼
		if (ae.getSource() == rrv.getBtnOk()) {
			switch (JOptionPane.showConfirmDialog(rrv, "이대로\n 등록 하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				
			}
		} // end if

		// 취소버튼
		if (ae.getSource() == rrv.getBtnCc()) {
			rrv.dispose();
		} // end if
		//새로고침버튼
		if(ae.getSource()==rrv.getBtnNewMenu()) {
			searchMenu(rNum);
		}

	}// actionPerformed

	// 식당등록
	public void addRest() {
		String l_id = rrv.getId();
		String r_Img = imgPath;
		String r_Map = mapPath;
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

		RestaurantRegistrationDAO rr_dao = RestaurantRegistrationDAO.getInstance();

		switch (JOptionPane.showConfirmDialog(rrv, "등록하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE)) {
		case JOptionPane.OK_OPTION:
			try {
				rNum = rr_dao.restaurantNumGet();
				rr_dao.insertRestaurant(rrvo, rNum);
				JOptionPane.showMessageDialog(rrv, "등록이 성공적으로 완료되었어요!\n새로고침버튼을 눌러주세요");
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(rrv, "등록이 실패했습니다. 잠시 후 다시 시도해주세요.");
				se.printStackTrace();
			} // end catch
		}// end switch
	}// addRest

	// 메뉴가 등록되었을때 메뉴를 창에 보여준다.
	private void searchMenu(String rNum) {
		List<MenuVO> menuList = null;
		RestaurantRegistrationDAO rr_dao = RestaurantRegistrationDAO.getInstance();
		try {
			menuList = rr_dao.selectMenu(rNum);
			System.out.println(menuList);
			Object[] rowData = null;

			// 주문현황을 보여줄
			DefaultTableModel dtm = rrv.getDtmMenu();
			// dtm초기화
			dtm.setRowCount(0);
			MenuVO mvo=null;
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
			JOptionPane.showMessageDialog(rrv, "식당이 존재하지 않아요\n식당을 먼저 등록해주세요!", "죄송해요ㅠ", JOptionPane.ERROR_MESSAGE);
		}

	}

}// class
