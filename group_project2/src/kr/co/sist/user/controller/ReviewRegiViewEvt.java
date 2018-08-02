package kr.co.sist.user.controller;

import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import kr.co.sist.user.dao.ReviewDAO;
import kr.co.sist.user.view.ReviewRegiView;

public class ReviewRegiViewEvt implements ActionListener {
	private ReviewRegiView rrv;
	String dir, file;

	public ReviewRegiViewEvt(ReviewRegiView rrv) {
		this.rrv = rrv;
		rrv.getTfReviewerID().setText(rrv.getId());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == rrv.getBtnAdd()) {
			addReview();
		}
		if (e.getSource() == rrv.getBtnClose()) {
			rrv.dispose();
		}
		if (e.getSource() == rrv.getBtnRegiImg()) {
			regiImg();
		}
	}

	private void regiImg() {
		FileDialog fd = new FileDialog(rrv, "�̹��� ���", FileDialog.LOAD);
		fd.setVisible(true);
		dir = fd.getDirectory();
		file = fd.getFile();
		File imgFile=new File(dir+file);
		rrv.getLblReviewImg().setIcon(new ImageIcon(dir+file));
		FileClient fc=new FileClient();
		//TODO
	}

	private void addReview() {
		String id = rrv.getId();
		String rNum = rrv.getrNum();
		String reviewTitle = rrv.getTfReviewTitle().getText();
		String reviewCont = rrv.getTaReviewContent().getText();
		int grade = rrv.getcGradeBox().getSelectedIndex();
		switch (JOptionPane.showConfirmDialog(rrv, "�ѹ�����ϸ� �ι��� ����� �ȵǴµ�\n ���� ����Ͻðھ��?", "������",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE)) {
		case JOptionPane.OK_OPTION:
			ReviewDAO r_dao = ReviewDAO.getInstance();
			try {
				System.out.println("Evt-"+id+" "+rNum);
				int cnt=r_dao.searchReview(id,rNum);
				System.out.println("----"+cnt);
				if(cnt==0) {
					r_dao.regiReview(id, rNum, dir + file, reviewTitle, reviewCont, grade);
					r_dao.regiReviewLike(id, rNum);
					JOptionPane.showMessageDialog(rrv, "����� �Ϸ�Ǿ����", "��ϿϷ�", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(rrv, "�˼��ؿ� �Ф� ����� �ѹ��ۿ� ����� ���� �ʾƿ�.\n���並 �����ϰ� �ٽõ�����ּ���", "�˼��մϴ� �Ф�",
							JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return;
			}
		}
		rrv.dispose();
	}
}
