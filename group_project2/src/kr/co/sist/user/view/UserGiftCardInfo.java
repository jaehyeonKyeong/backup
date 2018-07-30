package kr.co.sist.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.co.sist.user.controller.UserGiftCardInfoEvt;

@SuppressWarnings("serial")
public class UserGiftCardInfo extends JFrame {
	private DefaultTableModel dtmGiftCard;
	private JTable tGiftCard;
	private JScrollPane spScroll;
	private JButton btnClose;
	private String id;
	


	public UserGiftCardInfo(String id,String name) {
		super(name+"�� ��ǰ�� ����Ʈ");
		this.id=id;
		String[]  title= {"���� ��¥","��ǰ�� ��","��뿩��"};
		String[][] date= null;
//		for(int i=0; i<)
				
		//1. �𵨰� �����͸� ����
		dtmGiftCard=new DefaultTableModel(date, title);
		tGiftCard=new JTable(dtmGiftCard); //���̺� ���߰�
		spScroll=new JScrollPane(tGiftCard);//���̺� ��ũ���߰�
		btnClose=new JButton("�ݱ�");
		tGiftCard.getTableHeader().setReorderingAllowed(false);
		
		// DefaultTableCellHeaderRenderer ���� (��� ������ ����)
		DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
		// DefaultTableCellHeaderRenderer�� ������ ��� ���ķ� ����
		tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		// ������ ���̺��� ColumnModel�� ������
		TableColumnModel tcmSchedule = tGiftCard.getColumnModel();
		// �ݺ����� �̿��Ͽ� ���̺��� ��� ���ķ� ����
		for (int i = 0; i < tcmSchedule.getColumnCount(); i++) {
		tcmSchedule.getColumn(i).setCellRenderer(tScheduleCellRenderer);
		}
		
//		tGiftCard.getColumnModel().getColumn(0).setMaxWidth(100); 
//		tGiftCard.getColumnModel().getColumn(0).setMinWidth(100); 
		tGiftCard.getColumnModel().getColumn(0).setWidth(200); 
		
		setLayout(null);
		spScroll.setBounds(20, 20, 350, 250);
		btnClose.setBounds(125, 290, 60, 30);
		setBounds(100,100,400,400);
		
		UserGiftCardInfoEvt ugie=new UserGiftCardInfoEvt(this);
		btnClose.addActionListener(ugie);
		ugie.setDtm();
		
		add(btnClose);
		add(spScroll);
		
		setVisible(true);
//		ugci_dao.selectLogin(ugci_vo);
	}
	
	public DefaultTableModel getDtmGiftCard() {
		return dtmGiftCard;
	}

	public void setDtmGiftCard(DefaultTableModel dtmGiftCard) {
		this.dtmGiftCard = dtmGiftCard;
	}

	public String getId() {
		return id;
	}
	public JButton getBtnClose() {
		return btnClose;
	}
}
