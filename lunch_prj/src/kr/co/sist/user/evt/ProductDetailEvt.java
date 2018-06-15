package kr.co.sist.user.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import kr.co.sist.user.dao.OrderingDAO;
import kr.co.sist.user.view.ProductDetail;
import kr.co.sist.user.vo.OrderVO;

public class ProductDetailEvt implements ItemListener,ActionListener {

	private ProductDetail pd;
	
	public ProductDetailEvt(ProductDetail pd) {
		this.pd=pd;
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		
//		JComboBox<Integer> jbc=(JComboBox)ie.getSource();
		JComboBox<Integer> jbc=pd.getCbQuantity();
		int lunchCnt=(Integer)jbc.getSelectedItem();
		int price=Integer.parseInt(pd.getTfPrice().getText());
		
		pd.getTfTotal_price().setText(String.valueOf(price*lunchCnt)+"원");

	}// itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==pd.getBtnOrder()) {
			//주문 사항을 받아서 vo에 추가한 후
			String lunchCode=pd.getTfLunch_code().getText().trim();
			String name=pd.getTfName().getText().trim();
			String phone=pd.getTfPhone().getText().trim();
			String address=pd.getTfAddress().getText().trim();
			String ipAddress="";
			
			try {
				ipAddress=InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			
			
			
			int quantity=(Integer)pd.getCbQuantity().getSelectedItem();
			OrderVO ov=new OrderVO(lunchCode, name, phone, address, ipAddress, quantity);
			//DB Table에 insert 수행
			
			OrderingDAO o_dao=OrderingDAO.getInstance();
			try {
				StringBuilder orderInfo=new StringBuilder();
				
				orderInfo.append("------------------------------------------------------------------------------------\n");
				orderInfo.append("\t\t주문정보\n");
				orderInfo.append("------------------------------------------------------------------------------------\n");
				orderInfo.append("\t주문자 :").append(name).append("님\n");
				orderInfo.append("\t 품명 : ").append(pd.getTfPrd_name().getText()).append("도시락\n");
				
				orderInfo.append("\t 단 가 :").append(pd.getTfPrice().getText()).append(" 원\n");
				orderInfo.append("\t 수 량 :").append(quantity).append(" 개\n");
				orderInfo.append("\t 총 금액 :").append(Integer.parseInt(pd.getTfPrice().getText())*quantity).append(" 원\n");
				orderInfo.append("\t 주문일 : ").append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())).append("\n");
				orderInfo.append("\t으로 주문? \n");
				orderInfo.append("------------------------------------------------------------------------------------");
				
				JTextArea jt=new JTextArea(orderInfo.toString(),15,35);
				jt.setEditable(false);
				JScrollPane jsp=new JScrollPane(jt);
				
				switch(JOptionPane.showConfirmDialog(pd,jsp)) {
				case JOptionPane.OK_OPTION:
					o_dao.insertOrder(ov);
					JOptionPane.showMessageDialog(pd, "주문 성공적");
					pd.dispose();
				}//end switch
				
				
//				JOptionPane.showConfirmDialog(pd,orderInfo.toString());

					
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(pd, name+"호갱님 주문 정상적으로 진행되지 못하였다 다시 시도");
				se.printStackTrace();
			}
			
		}//end if
		if(ae.getSource()==pd.getBtnClose()) {
			pd.dispose();
		}
		
	}// actionPerformed

}//class
