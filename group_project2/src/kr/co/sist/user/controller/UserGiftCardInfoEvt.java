package kr.co.sist.user.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import kr.co.sist.user.dao.UserGiftCardInfoDAO;
import kr.co.sist.user.view.UserGiftCardInfo;
import kr.co.sist.user.vo.UserGiftCardVO;

public class UserGiftCardInfoEvt implements ActionListener{

	private UserGiftCardInfo ugci;
//	;

	public UserGiftCardInfoEvt(UserGiftCardInfo ugci) {
		this.ugci=ugci;
		
	}//UserGiftCardInfoEvt

	public void setDtm() {
		List<UserGiftCardVO> lUserGiftCardInfo=new ArrayList<>();
		String[] rowData=null;
		DefaultTableModel dtm=ugci.getDtmGiftCard();
		
		UserGiftCardInfoDAO ugci_dao=UserGiftCardInfoDAO.getInstance();
		
		try {
			lUserGiftCardInfo=ugci_dao.selectGiftCard(ugci.getId()); //상품권 정보를 받아옴
			dtm.setRowCount(0);
			for(UserGiftCardVO ugc:lUserGiftCardInfo) {
				rowData=new String[3];
				rowData[0]=ugc.getDateIssued().substring(0,11);
				rowData[1]=ugc.getGiftCardName();
				rowData[2]=ugc.getUse();
				for(int i=0;i<rowData.length;i++) {
					System.out.println(rowData[i]);
				}
				dtm.addRow(rowData);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==ugci.getBtnClose()) {
			ugci.dispose();
		}//end if
	}//end actionPerformed
	
}//end class
