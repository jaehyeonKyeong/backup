package kr.co.sist.user.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class UserGiftCardInfo extends JFrame {
	private DefaultTableModel dtmGiftCard;
	private JTable tGiftCard;
	private JScrollPane spScroll;
	private JButton btnClose;
	public UserGiftCardInfo() {
		super("��״ٴ� ��ǰ�� ����Ʈ");
		String[]  title= {"���� ��¥","��ǰ�� ��","��뿩��"};
		String[][] date= {
				{"2018/07/08","2000��","O"},
				{"2018/07/09","3000��",""},
				{"2018/07/10","4000��",""}
		};//��������
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
		
		add(btnClose);
		add(spScroll);
		setLayout(null);
		spScroll.setBounds(20, 20, 280, 250);
		btnClose.setBounds(125, 290, 60, 30);
		setBounds(100,100,340,400);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new UserGiftCardInfo();
	}
}
