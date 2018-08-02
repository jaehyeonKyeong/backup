package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.dao.MemberDAO;
import kr.co.sist.user.dao.ReviewDAO;
import kr.co.sist.user.view.UserDetailReview;
import kr.co.sist.user.view.UserReview;
import kr.co.sist.user.vo.UserReviewVO;

public class UserReviewEvt implements ActionListener {
	UserReview ur;
	List<String> listRNum;
	String id;

	public UserReviewEvt(UserReview ur) {
		this.ur = ur;
		this.id = ur.getId();
		setDtm();
	}

	public void setDtm() {

		List<UserReviewVO> lUserReviewInfo = new ArrayList<>();
		String[] rowData = null;
		DefaultTableModel dtm = ur.getDtmReview();
		String reviewNumber = "";

		MemberDAO m_dao = MemberDAO.getInstance();
		listRNum = new ArrayList<>();
		try {
			lUserReviewInfo = m_dao.selectReview(ur.getId()); // ��ǰ�� ������ �޾ƿ�
			dtm.setRowCount(0);
			for (UserReviewVO urv : lUserReviewInfo) {
				rowData = new String[3];
				rowData[0] = urv.getReviewTitle();
				rowData[1] = urv.getRestaurantNumber();
				rowData[2] = String.valueOf(urv.getGrades());
				reviewNumber = urv.getReviewNumber();
				dtm.addRow(rowData);
				listRNum.add(reviewNumber);
				for (int i = 0; i < rowData.length; i++) {
					System.out.println(rowData[i]);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == ur.getBtnSee()) {
			try {
			int row = ur.gettTable().getSelectedRow();
			String rNum = listRNum.get(row);
			System.out.println("�����ȣ : " + rNum);

			new UserDetailReview(rNum, id);
			System.out.println(id);
			}catch(ArrayIndexOutOfBoundsException aiooe) {
				JOptionPane.showMessageDialog(ur, "���õ� ���䰡 �����ϴ�.", "warning", JOptionPane.WARNING_MESSAGE);
			}

		}
		if (ae.getSource() == ur.getBtnDelete()) {
			int row = ur.gettTable().getSelectedRow();
			String rNum=listRNum.get(row);
			deleteReview(rNum, id);
		}

	}

	private void deleteReview(String rNum, String id) {
		ReviewDAO r_dao = ReviewDAO.getInstance();
		try {
			r_dao.deleteReviewLike(rNum, id);
			r_dao.deleteReviewData(rNum, id);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		JOptionPane.showMessageDialog(ur, "������ �Ϸ��Ǿ����ϴ�", "���� �Ϸ�", JOptionPane.INFORMATION_MESSAGE);
		setDtm();
	}

}
