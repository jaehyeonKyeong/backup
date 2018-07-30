package kr.co.sist.licensee.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.co.sist.licensee.dao.RestaurantDAO;
import kr.co.sist.licensee.view.RestaurantManagementView;
import kr.co.sist.licensee.view.RestaurantRegistrationView;
import kr.co.sist.licensee.view.RestaurantUpdateView;
import kr.co.sist.licensee.vo.RestaurantLicenseeVO;

public class RestaurantManagementViewEvt extends MouseAdapter implements ActionListener {
	private RestaurantManagementView rmv;
	
	String id;
	List<String> listrNum; 
	
	
	public RestaurantManagementViewEvt(RestaurantManagementView rmv) {//������
		this.rmv=rmv;
		//����� ���̵� ������ ������� �Ĵ� ����Ʈ�� ��ȸ.
		JOptionPane.showMessageDialog(rmv, "���������� �α��εǾ����ϴ�." ,"Ȯ��.",JOptionPane.INFORMATION_MESSAGE);
		selectRest();
		rmv.setVisible(true);
		id=rmv.getId();
	}//RestaurantManagementViewEvt
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//�Ĵ���
		if(ae.getSource()==rmv.getBtnRegistration()) {
			new RestaurantRegistrationView(id);
		}//end if
		
		//�Ĵ����
		if(ae.getSource()==rmv.getBtnChange()) {
			try {
			int row=rmv.getJtRestaurant().getSelectedRow();
			String rNum=listrNum.get(row);
			new RestaurantUpdateView(rNum);
			}catch(ArrayIndexOutOfBoundsException aioobe) {
				JOptionPane.showMessageDialog(rmv, "�Ĵ��� �������ּ���", "�Ĵ��� �������� �ʾƿ�!", JOptionPane.INFORMATION_MESSAGE);
				aioobe.printStackTrace();
			}
			
		}//end if
		
		//�Ĵ����
		if(ae.getSource()==rmv.getBtnRemove()) {
			switch(JOptionPane.showConfirmDialog(rmv, "������ �����Ͻǰǰ���?\n �����ϰԵǸ� �ǵ����� �����")) {
			case JOptionPane.OK_OPTION:
			int row=rmv.getJtRestaurant().getSelectedRow();
			String rNum=listrNum.get(row);
			delectRest(rNum);
			default:
			}
		}//end if
		if(ae.getSource()==rmv.getBtnNew()) {
			selectRest();
		}
			
	}//actionPerformed

	//�Ĵ����̺��� �ش��ϴ� ���̵��� ���� ������ �Ĵ����� ��ȸ
	public void selectRest() {
		RestaurantDAO r_dao=RestaurantDAO.getInstance();
		List<RestaurantLicenseeVO> list=null;
		
		try {
			list=r_dao.selectMyRe(rmv.getId());
			Object[] rowData=null;
			
			//�ֹ���Ȳ�� ������ 
			DefaultTableModel dtm=rmv.getDtmRestaurant();
			//dtm�ʱ�ȭ
			dtm.setRowCount(0);
			String rNum="";
			listrNum=new ArrayList<>();
			for(RestaurantLicenseeVO rvo1 :list){
				rowData=new Object[1];
				rowData[0]=rvo1.getRestaurantName();
				
				rNum=rvo1.getRestaurantNumber();
				
				dtm.addRow(rowData);
				listrNum.add(rNum);
			}//end for
			
		}catch(SQLException se) {
			se.printStackTrace();
		}//end catch
	}//selectRest
	
	
	
	//////////�Ĵ� ��� ����
	public void delectRest(String rNum) {
		RestaurantDAO r_dao=RestaurantDAO.getInstance();
		try {
			r_dao.deleteRest(rNum);
			JOptionPane.showMessageDialog(rmv, "�����Ǿ����ϴ�." ,"Ȯ��.",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectRest();
	}
	
	
		
	
	
}//class
