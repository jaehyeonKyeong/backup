package day0601;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import static java.lang.Integer.parseInt;

@SuppressWarnings("serial")
public class EmpForm extends JFrame implements ActionListener {

	private JButton btnAdd, btnDelete, btnAdjust, btnClose;
	private JTextField tfEmpno, tfEname, tfSal, tfComm, tfHiredate;
	private JTable tableEmpView;

	private DefaultTableModel dtm;

	public EmpForm() {
		super("��� ����");
		// �гλ���
		JPanel panelCenter = new JPanel(new GridLayout(1, 2));
		JPanel panelSouth = new JPanel();
		JPanel panelNorth = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelLeft = new JPanel(null);
		JPanel panelRight = new JPanel(new BorderLayout());
		JPanel panelPhone = new JPanel();
		// ��ư����
		btnAdd = new JButton("�Է�");
		btnDelete = new JButton("����");
		btnAdjust = new JButton("����");
		btnClose = new JButton("�ݱ�");
		// �ؽ�Ʈ�ʵ� ����
		tfEmpno = new JTextField();
		tfEname = new JTextField();
		tfSal = new JTextField();
		tfComm = new JTextField();
		tfHiredate = new JTextField();

		// Model ����
		String[] columnName = { "�����ȣ", "�����", "����", "���ʽ�", "�Ի���" };
		String[][] data = null;

		// dtm=new DefaultTableModel(data,columnName);
		dtm = new DefaultTableModel(data, columnName) {

			// ������ ��� ��� �÷��� ���ؼ� �������� ���ϵ��� ���´�.(false)
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		// jtable����,jtable����
		tableEmpView = new JTable(dtm);

		// �÷��� ũ�� ����
		tableEmpView.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableEmpView.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableEmpView.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableEmpView.getColumnModel().getColumn(3).setPreferredWidth(60);

		// �÷��� �̵� ���� ����
		tableEmpView.getTableHeader().setReorderingAllowed(false);

		// ��ũ�� ���� , ����Ʈ����
		JScrollPane jsp = new JScrollPane(tableEmpView);
		// �󺧻���
		JLabel lblEmpno = new JLabel("�����ȣ");
		JLabel lblEname = new JLabel("�����");
		JLabel lblSal = new JLabel("����");
		JLabel lblComm = new JLabel("���ʽ�");
		JLabel lblHiredate = new JLabel("�Ի���");

		// ������ο� ����,�����г� �ֱ�
		panelCenter.add(panelLeft);
		panelCenter.add(panelRight);

		// �����г�
		panelRight.add(jsp);

		// �����гο� ������Ʈ �߰�
		panelLeft.add(lblEmpno);
		panelLeft.add(tfEmpno);
		panelLeft.add(lblEname);
		panelLeft.add(tfEname);
		panelLeft.add(lblSal);
		panelLeft.add(tfSal);
		panelLeft.add(lblComm);
		panelLeft.add(tfComm);
		panelLeft.add(lblHiredate);
		panelLeft.add(tfHiredate);

		// �����гο� ������Ʈ ��ġ
		lblEmpno.setBounds(5, 5, 60, 30);
		tfEmpno.setBounds(65, 5, 175, 30);

		lblEname.setBounds(5, 35, 60, 30);
		tfEname.setBounds(65, 35, 175, 30);

		lblSal.setBounds(5, 70, 60, 30);
		tfSal.setBounds(65, 70, 175, 30);

		lblComm.setBounds(5, 105, 60, 30);
		tfComm.setBounds(65, 105, 175, 30);

		lblHiredate.setBounds(5, 140, 60, 30);
		tfHiredate.setBounds(65, 140, 175, 30);

		// �ϴ� �г� ����
		panelSouth.add(btnAdd);
		panelSouth.add(btnDelete);
		panelSouth.add(btnAdjust);
		panelSouth.add(btnClose);

		add("Center", panelCenter);
		add("South", panelSouth);
		add("North", panelNorth);
		add("West", panelWest);
		add("East", panelEast);

		// �̺�Ʈ ���
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnAdjust.addActionListener(this);
		btnClose.addActionListener(this);

		EmpForm.EmpMouseEvt eme = this.new EmpMouseEvt();

		tableEmpView.addMouseListener(eme);

		setTableData();// ���̺� ��������� �����Ѵ�.
		setBounds(750, 250, 700, 250);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public class EmpMouseEvt extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent me) {
			if (me.getClickCount() == 2) {
				int selectedRow = tableEmpView.getSelectedRow();

				Integer empno = (Integer) tableEmpView.getValueAt(selectedRow, 0);
				String ename = (String) tableEmpView.getValueAt(selectedRow, 1);
				Integer sal = (Integer) tableEmpView.getValueAt(selectedRow, 2);
				Integer comm = (Integer) tableEmpView.getValueAt(selectedRow, 3);
				String hiredate = (String) tableEmpView.getValueAt(selectedRow, 4);

				tfEmpno.setText(empno.toString());
				tfEname.setText(ename);
				tfSal.setText(sal.toString());
				tfComm.setText(comm.toString());
				tfHiredate.setText(hiredate);
			}
		}// mouseClicked

	}// class

	private void tfReset() {
		tfEmpno.setText("");
		tfEname.setText("");
		tfSal.setText("");
		tfComm.setText("");
		tfHiredate.setText("");
	}

	private void setTableData() {
		dtm.setRowCount(0);
		EmpProcedureDAO ep_dao = EmpProcedureDAO.getInstance();
		try {
			List<EmpVO> list = ep_dao.selectAllEmp();
			Object[] temp = null;
			// D3.����Ʈ �� �ϳ��� ���� �����ͼ�
			for (EmpVO ev : list) {
				// D4.������ �迭�� �濡 �ְ�
				temp = new Object[5];
				temp[0] = ev.getEmpno();
				temp[1] = ev.getEname();
				temp[2] = ev.getSal();
				temp[3] = ev.getComm();
				temp[4] = ev.getHiredate();
				// D5.������ �迭�� ���� DefaultTableModel�� �߰�
				dtm.addRow(temp);
			}

			if (list.isEmpty()) {
				temp = new Object[1];
				temp[0] = "��������� ���� ���� �ʽ��ϴ�.";
				dtm.addRow(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new EmpForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnAdd) {
			String empno = tfEmpno.getText().trim();
			String ename = tfEname.getText().trim();
			String sal = tfSal.getText().trim();
			String comm = tfComm.getText().trim();

			// �Էµ� ���� VO�� �ִ´�
			EmpInsertVO ev = new EmpInsertVO(parseInt(empno), parseInt(sal), parseInt(comm), ename);
			// DAO��ü�� ���ͼ�(single ton)
			EmpProcedureDAO ep_dao = EmpProcedureDAO.getInstance();
			String msg = "";
			try {
				// �߰��۾�
				msg = ep_dao.insertCpEmp(ev);
				setTableData();
				tfReset();
			} catch (SQLException se) {
				msg = "�˼��մϴ�. ��� �� ������ �߻��Ͽ����ϴ�.";
				se.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, msg);
		}
		if (e.getSource() == btnAdjust) {
			String empno = tfEmpno.getText().trim();
			String sal = tfSal.getText().trim();

			StringBuilder updateMsg = new StringBuilder();
			updateMsg.append(empno).append("�� ��������� ���� �Ͻðڽ��ϱ�?");

			switch (JOptionPane.showConfirmDialog(this, updateMsg.toString())) {
			case JOptionPane.OK_OPTION:
				String msg = "";
				EmpUpdateVO euv = new EmpUpdateVO(parseInt(empno), parseInt(sal));

				EmpProcedureDAO ep_dao = EmpProcedureDAO.getInstance();
				try {
					msg = ep_dao.updateCpEmp(euv);
					// ����� �����͸� �� ��ȸ�Ͽ� ���̺��� ����
					setTableData();
					tfReset();

				} catch (NumberFormatException nfe) {
					msg = "������ ���ʽ��� ������ �κ� ������?";
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					msg = "��� �� ������ ��� �˼��� �κ� ����?";
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, msg);
			}// end switch

		}
		if (e.getSource() == btnDelete) {
			String empno = tfEmpno.getText().trim();
			String msg = "";
			switch (JOptionPane.showConfirmDialog(this, empno+"�� ����� ������ ���� �����Ͻðڽ��ϱ�?")) {
			case JOptionPane.OK_OPTION:
				try {
					EmpProcedureDAO ep_dao = EmpProcedureDAO.getInstance();
					msg = ep_dao.deleteCpEmp(parseInt(empno));
					setTableData();
					tfReset();
				} catch (NumberFormatException nfe) {
					msg = "�����ȣ�� �������� ������?";

				} catch (SQLException se) {
					msg = "���񽺰� ��Ȱ���� ���Ͽ� ������ ����!";
					se.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, msg);
			}
		}

	}
}
