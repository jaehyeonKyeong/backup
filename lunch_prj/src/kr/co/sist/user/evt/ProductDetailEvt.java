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
import kr.co.sist.user.vo.OrderingVO;

public class ProductDetailEvt implements ItemListener, ActionListener {
	private ProductDetail pd;

	public ProductDetailEvt(ProductDetail pd) {
		this.pd=pd;
	}//ProductDetailEvt


	@Override
	public void itemStateChanged(ItemEvent ie) {
		//		JComboBox<Integer> jcb=(JComboBox)ie.getSource();
		JComboBox<Integer> jcb=pd.getCbQuantity();

		int lunchCnt=(Integer)jcb.getSelectedItem();
		int price=Integer.parseInt(pd.getTfPrice().getText());

		pd.getTfTotal_price().setText(String.valueOf(price*lunchCnt)+"원");

	}//itemStateChanged


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== pd.getBtnOrder()) {
			//주문사항을 받아서 VO에 추가한 후 
			String lunchCode=pd.getTfLunch_code().getText().trim();
			String name=pd.getTfName().getText().trim();
			String phone=pd.getTfPhone().getText().trim();
			String address=pd.getTfAddress().getText().trim();
			String ipAdress="";

			try {
				ipAdress = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}//end catch

			int quantity=(Integer)pd.getCbQuantity().getSelectedItem();

			OrderingVO ov=new OrderingVO
					(lunchCode, name, phone, address, ipAdress, quantity);

			//DB Table에 insert 수행
			OrderingDAO o_dao=OrderingDAO.getInstance();
			try {
				StringBuilder orderInfo=new StringBuilder();
				orderInfo.append("----------------------------------------------------------------------------\n");
				orderInfo.append("\t주문정보\n");
				orderInfo.append("----------------------------------------------------------------------------\n");
				orderInfo.append("\t주문자 : ").append(name).append("님\n");
				orderInfo.append("\t품   명 : ").append(pd.getTfPrd_name().getText()).append("도시락\n");
				orderInfo.append("\t단   가 : ").append(pd.getTfPrice().getText()).append("원\n");
				orderInfo.append("\t수   량 : ").append(quantity).append("개\n");
				
				orderInfo.append("\t총금액 : ").append(Integer.parseInt
						(pd.getTfPrice().getText())*quantity).append("원\n");
				
				orderInfo.append("\t주문일자 : ").append(new SimpleDateFormat
						("yyyy-mm-dd hh:mm:ss").format(new Date())).append("\n");
				
				orderInfo.append("\t으로 주문 하시겠습니까?\n");
				orderInfo.append("----------------------------------------------------------------------------");

				JTextArea jt=new JTextArea(orderInfo.toString(),15,35 );
				jt.setEditable(false);
				JScrollPane jsp=new JScrollPane(jt);

				switch(JOptionPane.showConfirmDialog(pd,jsp)) {
				case JOptionPane.OK_OPTION: 
					o_dao.insertOredr(ov);
					JOptionPane.showMessageDialog(pd, 
							"주문이 성공적으로 완료되었습니다.");
					pd.dispose();
				}//end switch

				} catch (SQLException se) {
					JOptionPane.showMessageDialog(pd, name+
							"고객님 죄송합니다.주문이 정상적으로 진행되지 못하였습니다. 잠시 후 다시 시도해주세요.");
					se.printStackTrace();
			}//end catch


		}//end if

		if(ae.getSource()==pd.getBtnClose()) {
			pd.dispose();
		}//end if

	}//actionPerformed

}//class
