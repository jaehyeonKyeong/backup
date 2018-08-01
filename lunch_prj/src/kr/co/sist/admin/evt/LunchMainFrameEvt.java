package kr.co.sist.admin.evt;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.admin.dao.LunchMainDAO;
import kr.co.sist.admin.util.ImageResize;
import kr.co.sist.admin.view.LunchMainFrame;
import kr.co.sist.admin.vo.LunchListVO;
import kr.co.sist.admin.vo.LunchVO;
import kr.co.sist.admin.vo.OrderListVO;

/**
 * ������ȭ���� �̺�Ʈó���� ��������
 * @author owner
 *
 */
public class LunchMainFrameEvt extends MouseAdapter implements ActionListener {

	public static final int TAB_ORDER=0;
	public static final int TAB_LUNCH=2;

	private LunchMainFrame lmf;
	private boolean alertFlag;

	public LunchMainFrameEvt(LunchMainFrame lmf) {
		this.lmf=lmf;
	}//LunchMainFrameEvt

	/**
	 * ������ �ֹ���Ȳ ��ȸ�Ͽ� JTable�� ����
	 */
	
	
	public void setOrderList() {
		LunchMainDAO lm_dao=LunchMainDAO.getInstance();
		try {
			List<OrderListVO> list=lm_dao.selectTodayOrder();

			Object[] rowData=null;
			OrderListVO olv=null;

			//�ֹ���Ȳ�� ������ D.T.M ���
			DefaultTableModel dtm=lmf.getDtmOrderList();
			//D.T.M �ʱ�ȭ
			dtm.setRowCount(0);

			for(int i=0; i<list.size(); i++) {
				olv=list.get(i);
				rowData=new Object[8];
				rowData[0]=i+1;
				rowData[1]=olv.getOrderCode();
				rowData[2]=olv.getPrdName();
				rowData[3]=olv.getLunchCode();
				rowData[4]=olv.getName();
				rowData[5]=olv.getPhone();
				rowData[6]=olv.getQuantity();
				rowData[7]=olv.getStatus();

				dtm.addRow(rowData);

			}//end for

			if(!alertFlag && list.isEmpty()) {
				JOptionPane.showMessageDialog(lmf, "�����ڴ�!! ȫ���� �ñ��մϴ�.");
				alertFlag=true;
			}//end if
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(lmf, 
					"����� ������ �߻��߽��ϴ�.�˼��մϴ�. ��� �� �ٽ� �õ����ּ���.");
		}//end catch

	}//setOrderList

	private void setStatusUpdate() {

		JTable tab=lmf.getTabOrderList();
		String orderCode=(String)tab.getValueAt(tab.getSelectedRow(),1);
		String prdName=(String)tab.getValueAt(tab.getSelectedRow(),2);
		String name=(String)tab.getValueAt(tab.getSelectedRow(),4);
		String phone=(String)tab.getValueAt(tab.getSelectedRow(),5);
		String flag=(String)tab.getValueAt(tab.getSelectedRow(),7);

		if("Y".equals(flag)) {
			JOptionPane.showMessageDialog(lmf, 
					"�ش� ���ö��� �̹� ���ۿϷ� �Ǿ����ϴ�.");
			return;
		}//end if


		StringBuilder msg=new StringBuilder();
		msg.append("[").append(name).append("-").append(phone).append("] �Բ��� �ֹ��Ͻ� ")
		.append("\"").append(prdName).append("\"���ö��� �غ�Ǽ̽��ϱ�?");

		switch(JOptionPane.showConfirmDialog(lmf, msg.toString())){
		case JOptionPane.OK_OPTION :
			LunchMainDAO lm_dao=LunchMainDAO.getInstance();
			try {
				if(lm_dao.updateStatus(orderCode)==1) {
					setOrderList(); //���ö��� �ϼ��Ǹ� �ֹ�����Ʈ�� �����Ѵ�.
					JOptionPane.showMessageDialog(lmf, "���ö��� �ϼ��Ǿ����ϴ�.");
				}//end if
			} catch (SQLException e) {
				e.printStackTrace();
			}//end catch
		}//end switch


	}//setStatusUpdate

	/**
	 * ���ö� ��� ��ȸ
	 */
	private void setLunchList() {
		LunchMainDAO lm_dao=LunchMainDAO.getInstance();
		try {
			List<LunchListVO> list=lm_dao.selectLunchList();
			DefaultTableModel dtm=lmf.getDtmLunchList();
			dtm.setRowCount(0);

			Object[] rowData=null;
			for(LunchListVO llv : list) {
				rowData=new Object[5];
				rowData[0]=new ImageIcon("C:/Users/kimkn/git/backup/lunch_prj/src/kr/co/sist/img/"+llv.getImg());
				rowData[1]=llv.getPrdName();
				rowData[2]=llv.getLunchCode();
				rowData[3]=llv.getLunchInfo();
				rowData[4]=llv.getPrice();

				dtm.addRow(rowData);
			}//end for
		} catch (SQLException e) {
			e.printStackTrace();
		}//end catch


	}//setLunchList


	/**
	 * ���ö��� �����ϴ� ��
	 */
	private void removeLunch() {
		JTable tempTab=lmf.getTabLunchList();
		String prdName=
				(String)tempTab.getValueAt(tempTab.getSelectedRow(),1);
		String lunchCode=
				(String)tempTab.getValueAt(tempTab.getSelectedRow(),2);
		ImageIcon img=
				(ImageIcon)tempTab.getValueAt(tempTab.getSelectedRow(),0);

		StringBuilder msg=new StringBuilder();
		msg.append("[").append(prdName).append("-")
		.append(lunchCode).append("] ���ö��� �����Ͻðڽ��ϱ�?");

		switch(JOptionPane.showConfirmDialog(lmf,msg)) {
		case JOptionPane.OK_OPTION:
			LunchMainDAO lm_dao=LunchMainDAO.getInstance();

			try {
				lm_dao.deleteLunch(lunchCode);
				msgCenter(prdName+"���ö��� ���� �Ǿ����ϴ�.");
				//�̹��� ����
				File s_file=new File(img.toString());
				File file=new File(s_file.getParent()+"/"
									+s_file.getName().substring(2));
				file.delete();
				s_file.delete();

				//���̺��� �����Ѵ�.
				setLunchList();
			} catch (SQLException e) {
				e.printStackTrace();
				msgCenter(prdName+"���ö��� ������ ������ �߻��߾��.\n��� �� �ٽ� �õ����ּ���.");
			}//end catch
		}//end switch
	}//removeLunch


	@Override
	public void mouseClicked(MouseEvent me) {
		JTabbedPane jtp=lmf.getTabbMain();
		//		System.out.println(jtp.getSelectedIndex());

		switch(jtp.getSelectedIndex()) {
		case TAB_ORDER:	//�ֹ� �ǿ��� Ŭ�� �̺�Ʈ �߻�
			if(me.getClickCount()==2) {	//����Ŭ���Ǿ��ٸ�
				setStatusUpdate();	//�ֹ����¸� �����Ѵ�.
			}//end if
			//�ֹ� ���� Ŭ���Ǹ� �ֹ����¸� ����
			setOrderList();
			break;
		case TAB_LUNCH:	//���ö� �ǿ��� Ŭ�� �̺�Ʈ �߻�
			if(me.getClickCount()== 2) {
				removeLunch();
			}//end if

			setLunchList();//���� �Էµ� ���ö��� ����� ��ȸ�Ͽ� JTable�� �����Ѵ�.
		}//end switch
	}//mouseClicked

	private void setLunchImg() {
		//TODO
		FileDialog fd=new FileDialog(lmf, "�̹�������",FileDialog.LOAD);
		fd.setVisible(true);

		String path=fd.getDirectory();
		String name=fd.getFile();

		if(name !=null) {
			//�̹��� ���ϸ� ����ϵ��� ����
			String ext=name.substring(name.lastIndexOf(".")+1).toLowerCase();
			//��밡���� Ȯ������ ���� ó��
			//jpg,gif,png,bmp ��
			if("jpg".equals(ext)||"gif".equals(ext)||
					"png".equals(ext)||"bmp".equals(ext)) {

				JLabel lblImg=lmf.getLblImg();
				//������ �̹����� �����ش�.
				ImageIcon ii=new ImageIcon(path+name);
				lblImg.setIcon(ii);

			}else {//��밡���� Ȯ���ڰ� �ƴ�
				JOptionPane.showMessageDialog(lmf, 
						name+"�� ��밡���� �̹����� �ƴմϴ�.");

			}//end else


		}//end if

	}//setLunchImg


	private void addLunch()throws IOException {
		//TODO
		String prdName=lmf.getTfPrdName().getText().trim();
		String price=lmf.getTfPrice().getText().trim();
		String lunchInfo=lmf.getTaLunchInfo().getText().trim();

		//�ʼ� �Է»��׿� ���� üũ
		if("".equals(prdName)) {
			msgCenter("���ö����� �ʼ� �Է��Դϴ�.");
			lmf.getTfPrdName().requestFocus();
			return;
		}//end if

		if("".equals(price)) {
			msgCenter("������ �ʼ� �Է�.");
			lmf.getTfPrice().requestFocus();
			return;
		}//end if

		if("".equals(lunchInfo)) {
			msgCenter("���ö��� ����ȭ�� ������ �Է����ּ���.");
			lmf.getTaLunchInfo().requestFocus();
			return;
		}//end if

		//�̹����� ����ϴ� ������ ���ε�
		File original=new File(lmf.getLblImg().getIcon().toString());
		File copyFile=new File("C:/Users/kimkn/git/backup/lunch_prj/src/kr/co/sist/img/"+original.getName());

		//�ߺ� ������ ó��
		if(copyFile.exists()) {
			msgCenter(copyFile.getName()+
					"�̹� �����ϴ� ���ϸ��� �ֽ��ϴ�.\n�ٸ��̸����� �������ּ���.");
			return;
		}//end if

		//������ �̹��� ������ ������ ��η� ����
		FileInputStream fis=null; 
		FileOutputStream fos=null; 

		try {
			fis=new FileInputStream(original);
			fos=new FileOutputStream(copyFile);

			int cnt=0;
			byte[] temp=new byte[512];

			while((cnt=fis.read(temp))!=-1) {
				fos.write(temp, 0, cnt);
				fos.flush();
			}//end while

			//�����̹��� ����
			ImageResize.imgResize(lmf, copyFile.getAbsolutePath());

			//�̹��� ���� ����

			//VO����
			LunchVO lv=new LunchVO(original.getName(), 
					prdName, lunchInfo, Integer.parseInt(price));
			//DB�� �߰�
			LunchMainDAO lm_dao=LunchMainDAO.getInstance();

			try {
				lm_dao.insertLunch(lv);
				msgCenter("["+prdName+"���� �޴��� �߰� �Ǿ����ϴ�.");
			}catch(SQLException e) {
				e.printStackTrace();
				msgCenter("["+prdName+"���� �޴��� ���������� �߰����� �ʾҽ��ϴ�.");
				//��� �ø� ������ �����Ѵ�.
				copyFile.delete();

			}//end catch

			//�Է� ������Ʈ �ʱ�ȭ
			lmf.getTfPrdName().setText("");
			lmf.getTfPrice().setText("");
			lmf.getTaLunchInfo().setText("");
			lmf.getLblImg().setIcon(new ImageIcon("C:/dev/workspace/lunch_prj/src/kr/co/sist/img/default.jpg"));


		}finally {
			if(fis !=null) {fis.close();} //end if
			if(fos !=null) {fos.close();} //end if
		}//end finally

	}//setLunch


	private void msgCenter(String msg) {
		JOptionPane.showMessageDialog(lmf, msg);
	}//msgCenter

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==lmf.getBtnImg()) {
			setLunchImg();
		}//end if

		if(ae.getSource()==lmf.getBtnInput()) {
			try {
				addLunch();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch

		}//end if
	}//actionPerformed

}//class

