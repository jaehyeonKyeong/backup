package day0418;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UseJTable extends JFrame {
	public UseJTable() {
		super("���̺�");
		String[] columnName = { "��ȣ", "�̸�", "����", "�ּ�" };
		String[][] rowData = { { "1", "���¹�", "28", "��õ�� ��籸" }, { "2", "�����", "27", "����� ���Ǳ�" },
				{ "3", "�赿��", "29", "����� �߱�" }, { "4", "������", "27", "����� ���ﵿ" } };

		// Model ��ü ����
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnName);
		
		//������ �߰�
		dtm.addRow(new String[] {"5","������","28","����� ������"});
		
		//view��ü ����
		JTable table= new JTable(dtm);//Į������ �������� ����\
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBorder(new TitledBorder("ģ�����"));
		
		//column�� ũ������(��������)
		//���̺� �ϳ��� �÷��� ���ͼ� table.getColumnModel().getColumn(0)
		//�ش� �÷��� ���̸� ����.setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(240);
		add("Center",jsp);
		
		setBounds(100,100,400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}// Constructor

	public static void main(String[] args) {
		new UseJTable();
	}// main

}// class UseJTable
