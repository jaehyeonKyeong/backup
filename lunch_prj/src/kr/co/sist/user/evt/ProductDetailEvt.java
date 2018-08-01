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

		pd.getTfTotal_price().setText(String.valueOf(price*lunchCnt)+"��");

	}//itemStateChanged


	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== pd.getBtnOrder()) {
			//�ֹ������� �޾Ƽ� VO�� �߰��� �� 
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

			//DB Table�� insert ����
			OrderingDAO o_dao=OrderingDAO.getInstance();
			try {
				StringBuilder orderInfo=new StringBuilder();
				orderInfo.append("----------------------------------------------------------------------------\n");
				orderInfo.append("\t�ֹ�����\n");
				orderInfo.append("----------------------------------------------------------------------------\n");
				orderInfo.append("\t�ֹ��� : ").append(name).append("��\n");
				orderInfo.append("\tǰ   �� : ").append(pd.getTfPrd_name().getText()).append("���ö�\n");
				orderInfo.append("\t��   �� : ").append(pd.getTfPrice().getText()).append("��\n");
				orderInfo.append("\t��   �� : ").append(quantity).append("��\n");
				
				orderInfo.append("\t�ѱݾ� : ").append(Integer.parseInt
						(pd.getTfPrice().getText())*quantity).append("��\n");
				
				orderInfo.append("\t�ֹ����� : ").append(new SimpleDateFormat
						("yyyy-mm-dd hh:mm:ss").format(new Date())).append("\n");
				
				orderInfo.append("\t���� �ֹ� �Ͻðڽ��ϱ�?\n");
				orderInfo.append("----------------------------------------------------------------------------");

				JTextArea jt=new JTextArea(orderInfo.toString(),15,35 );
				jt.setEditable(false);
				JScrollPane jsp=new JScrollPane(jt);

				switch(JOptionPane.showConfirmDialog(pd,jsp)) {
				case JOptionPane.OK_OPTION: 
					o_dao.insertOredr(ov);
					JOptionPane.showMessageDialog(pd, 
							"�ֹ��� ���������� �Ϸ�Ǿ����ϴ�.");
					pd.dispose();
				}//end switch

				} catch (SQLException se) {
					JOptionPane.showMessageDialog(pd, name+
							"���� �˼��մϴ�.�ֹ��� ���������� ������� ���Ͽ����ϴ�. ��� �� �ٽ� �õ����ּ���.");
					se.printStackTrace();
			}//end catch


		}//end if

		if(ae.getSource()==pd.getBtnClose()) {
			pd.dispose();
		}//end if

	}//actionPerformed

}//class
