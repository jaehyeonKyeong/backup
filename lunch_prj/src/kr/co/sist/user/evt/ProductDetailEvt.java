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
		
		pd.getTfTotal_price().setText(String.valueOf(price*lunchCnt)+"��");

	}// itemStateChanged

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==pd.getBtnOrder()) {
			//�ֹ� ������ �޾Ƽ� vo�� �߰��� ��
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
			//DB Table�� insert ����
			
			OrderingDAO o_dao=OrderingDAO.getInstance();
			try {
				StringBuilder orderInfo=new StringBuilder();
				
				orderInfo.append("------------------------------------------------------------------------------------\n");
				orderInfo.append("\t\t�ֹ�����\n");
				orderInfo.append("------------------------------------------------------------------------------------\n");
				orderInfo.append("\t�ֹ��� :").append(name).append("��\n");
				orderInfo.append("\t ǰ�� : ").append(pd.getTfPrd_name().getText()).append("���ö�\n");
				
				orderInfo.append("\t �� �� :").append(pd.getTfPrice().getText()).append(" ��\n");
				orderInfo.append("\t �� �� :").append(quantity).append(" ��\n");
				orderInfo.append("\t �� �ݾ� :").append(Integer.parseInt(pd.getTfPrice().getText())*quantity).append(" ��\n");
				orderInfo.append("\t �ֹ��� : ").append(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())).append("\n");
				orderInfo.append("\t���� �ֹ�? \n");
				orderInfo.append("------------------------------------------------------------------------------------");
				
				JTextArea jt=new JTextArea(orderInfo.toString(),15,35);
				jt.setEditable(false);
				JScrollPane jsp=new JScrollPane(jt);
				
				switch(JOptionPane.showConfirmDialog(pd,jsp)) {
				case JOptionPane.OK_OPTION:
					o_dao.insertOrder(ov);
					JOptionPane.showMessageDialog(pd, "�ֹ� ������");
					pd.dispose();
				}//end switch
				
				
//				JOptionPane.showConfirmDialog(pd,orderInfo.toString());

					
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(pd, name+"ȣ���� �ֹ� ���������� ������� ���Ͽ��� �ٽ� �õ�");
				se.printStackTrace();
			}
			
		}//end if
		if(ae.getSource()==pd.getBtnClose()) {
			pd.dispose();
		}
		
	}// actionPerformed

}//class
