package day0529;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

@SuppressWarnings("serial")
public class SearchZipcode extends JFrame implements ActionListener {
	
	private JTextField tfDong;
	private JButton btnSearch;
	private JTable jtZipcode;
	private JLabel lblResult;
	private ZipcodeDAO z_dao;
	
	private DefaultTableModel dtm;
	public SearchZipcode() {
		super("�����ȣ(�����ּ�) �˻�");
		tfDong =new JTextField(10);
		btnSearch=new JButton("�˻�");
		z_dao=new ZipcodeDAO();
		
		String[] columnNames= {"�����ȣ","�ּ�"};
		String[][] data=null;
		
		dtm=new DefaultTableModel(data, columnNames);
		jtZipcode=new JTable(dtm);
		lblResult=new JLabel("��ȸ ��� : ");
		
		JPanel panel=new JPanel();
		panel.add(new JLabel("���̸�"));
		panel.add(tfDong);
		panel.add(btnSearch);
		panel.setBorder(new TitledBorder("���̸��� �Է����ּ���"));
		
		JScrollPane jsp=new JScrollPane(jtZipcode);
		jsp.setBorder(new TitledBorder("�˻����"));
		
		//�÷��� ���� ����
		jtZipcode.getColumnModel().getColumn(0).setPreferredWidth(60);
		jtZipcode.getColumnModel().getColumn(1).setPreferredWidth(300);
		
		add("North",panel);
		add("Center",jsp);
		add("South",lblResult);
		
		tfDong.addActionListener(this);
		btnSearch.addActionListener(this);
		
		setBounds(100,100,400,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//constructor
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String dong=tfDong.getText().trim();
		if("".equals(dong)) {
			JOptionPane.showMessageDialog(this, "�� �̸��� �Է����ּ���");
			tfDong.requestFocus();
			return;
		}
		searchDong(dong);
	}//actionPerformed
	/**
	 * 
	 * @param dong
	 */
	private void searchDong(String dong) {
		try {
			List<ZipcodeVO> list=z_dao.selectZipcode(dong);
			//JTable�� �ʱ�ȭ
			dtm.setRowCount(0);
			String[] rowData=null;
			StringBuilder tempAddr=null;
			for(ZipcodeVO zv:list) {
				rowData=new String[2];
				rowData[0]=zv.getZIPCODE();
				tempAddr=new StringBuilder();
				tempAddr.append(zv.getSIDO()).append(" ").append(zv.getGUGUN()).append(" ").append(zv.getDONG()).append(" ").append(zv.getBUNJI());
				rowData[1]=tempAddr.toString();
				dtm.addRow(rowData);
			}
			lblResult.setText("��ȸ��� : "+dong+"���� ["+list.size()+"] ���� ��ȸ�Ǿ����ϴ�.");
		}catch(SQLException se) {
			se.printStackTrace();
			JOptionPane.showMessageDialog(this, "�˼��մϴ�. ����� ������ �߻� �Ͽ����ϴ�.\n ���α׷��� ������ �� �ٽ� �õ����ּ���.");
		}
	}
	
	public static void main(String[] args) {
		new SearchZipcode();
	}//main
}
