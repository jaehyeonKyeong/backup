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
	
	
	public RestaurantManagementViewEvt(RestaurantManagementView rmv) {//생성자
		this.rmv=rmv;
		//사업자 아이디를 가지고 사업자의 식당 리스트를 조회.
		selectRest();
		id=rmv.getId();
	}//RestaurantManagementViewEvt
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//식당등록
		if(ae.getSource()==rmv.getBtnRegistration()) {
			new RestaurantRegistrationView(id);
		}//end if
		
		//식당수정
		if(ae.getSource()==rmv.getBtnChange()) {
			int row=rmv.getJtRestaurant().getSelectedRow();
			String rNum=listrNum.get(row);
			System.out.println("evt"+rNum);
			new RestaurantUpdateView(rNum);
			
		}//end if
		
		//식당삭제
		if(ae.getSource()==rmv.getBtnRemove()) {
			int row=rmv.getJtRestaurant().getSelectedRow();
			String rNum=listrNum.get(row);
			delectRest(rNum);
		}//end if
			
	}//actionPerformed

	//식당테이블에서 해당하는 아이디의 값을 가지고 식당목록을 조회
	public void selectRest() {
		RestaurantDAO r_dao=RestaurantDAO.getInstance();
		List<RestaurantLicenseeVO> list=null;
		
		try {
			list=r_dao.selectMyRe(rmv.getId());
			System.out.println("===="+ list.size()+"/"+rmv.getId());
			Object[] rowData=null;
			
			//주문현황을 보여줄 
			DefaultTableModel dtm=rmv.getDtmRestaurant();
			//dtm초기화
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
	
	
	
	//////////식당 목록 삭제
	public void delectRest(String rNum) {
		RestaurantDAO r_dao=RestaurantDAO.getInstance();
		try {
			r_dao.deleteRest(rNum);
			JOptionPane.showMessageDialog(rmv, "삭제되었습니다." ,"확인.",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		selectRest();
	}
	
	
		
	
	
}//class
