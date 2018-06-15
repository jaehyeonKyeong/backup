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
		super("사원 정보");
		// 패널생성
		JPanel panelCenter = new JPanel(new GridLayout(1, 2));
		JPanel panelSouth = new JPanel();
		JPanel panelNorth = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelLeft = new JPanel(null);
		JPanel panelRight = new JPanel(new BorderLayout());
		JPanel panelPhone = new JPanel();
		// 버튼생성
		btnAdd = new JButton("입력");
		btnDelete = new JButton("삭제");
		btnAdjust = new JButton("수정");
		btnClose = new JButton("닫기");
		// 텍스트필드 생성
		tfEmpno = new JTextField();
		tfEname = new JTextField();
		tfSal = new JTextField();
		tfComm = new JTextField();
		tfHiredate = new JTextField();

		// Model 생성
		String[] columnName = { "사원번호", "사원명", "연봉", "보너스", "입사일" };
		String[][] data = null;

		// dtm=new DefaultTableModel(data,columnName);
		dtm = new DefaultTableModel(data, columnName) {

			// 들어오는 모든 행과 컬럼에 대해서 변경하지 못하도록 막는다.(false)
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};

		// jtable생성,jtable대입
		tableEmpView = new JTable(dtm);

		// 컬럼의 크기 변경
		tableEmpView.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableEmpView.getColumnModel().getColumn(1).setPreferredWidth(80);
		tableEmpView.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableEmpView.getColumnModel().getColumn(3).setPreferredWidth(60);

		// 컬럼의 이동 변경 막기
		tableEmpView.getTableHeader().setReorderingAllowed(false);

		// 스크롤 생성 , 리스트대입
		JScrollPane jsp = new JScrollPane(tableEmpView);
		// 라벨생성
		JLabel lblEmpno = new JLabel("사원번호");
		JLabel lblEname = new JLabel("사원명");
		JLabel lblSal = new JLabel("연봉");
		JLabel lblComm = new JLabel("보너스");
		JLabel lblHiredate = new JLabel("입사일");

		// 센터페널에 좌측,우측패널 넣기
		panelCenter.add(panelLeft);
		panelCenter.add(panelRight);

		// 우측패널
		panelRight.add(jsp);

		// 좌측패널에 컴포넌트 추가
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

		// 좌측패널에 컴포넌트 배치
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

		// 하단 패널 셋팅
		panelSouth.add(btnAdd);
		panelSouth.add(btnDelete);
		panelSouth.add(btnAdjust);
		panelSouth.add(btnClose);

		add("Center", panelCenter);
		add("South", panelSouth);
		add("North", panelNorth);
		add("West", panelWest);
		add("East", panelEast);

		// 이벤트 등록
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnAdjust.addActionListener(this);
		btnClose.addActionListener(this);

		EmpForm.EmpMouseEvt eme = this.new EmpMouseEvt();

		tableEmpView.addMouseListener(eme);

		setTableData();// 테이블에 사원정보를 설정한다.
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
			// D3.리스트 방 하나의 값을 꺼내와서
			for (EmpVO ev : list) {
				// D4.일차원 배열의 방에 넣고
				temp = new Object[5];
				temp[0] = ev.getEmpno();
				temp[1] = ev.getEname();
				temp[2] = ev.getSal();
				temp[3] = ev.getComm();
				temp[4] = ev.getHiredate();
				// D5.일차원 배열의 값을 DefaultTableModel에 추가
				dtm.addRow(temp);
			}

			if (list.isEmpty()) {
				temp = new Object[1];
				temp[0] = "사원정보가 존재 하지 않습니다.";
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

			// 입력된 값을 VO에 넣는다
			EmpInsertVO ev = new EmpInsertVO(parseInt(empno), parseInt(sal), parseInt(comm), ename);
			// DAO객체를 얻어와서(single ton)
			EmpProcedureDAO ep_dao = EmpProcedureDAO.getInstance();
			String msg = "";
			try {
				// 추가작업
				msg = ep_dao.insertCpEmp(ev);
				setTableData();
				tfReset();
			} catch (SQLException se) {
				msg = "죄송합니다. 사용 중 문제가 발생하였습니다.";
				se.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, msg);
		}
		if (e.getSource() == btnAdjust) {
			String empno = tfEmpno.getText().trim();
			String sal = tfSal.getText().trim();

			StringBuilder updateMsg = new StringBuilder();
			updateMsg.append(empno).append("번 사원정보를 변경 하시겠습니까?");

			switch (JOptionPane.showConfirmDialog(this, updateMsg.toString())) {
			case JOptionPane.OK_OPTION:
				String msg = "";
				EmpUpdateVO euv = new EmpUpdateVO(parseInt(empno), parseInt(sal));

				EmpProcedureDAO ep_dao = EmpProcedureDAO.getInstance();
				try {
					msg = ep_dao.updateCpEmp(euv);
					// 변경된 데이터를 재 조회하여 테이블을 갱신
					setTableData();
					tfReset();

				} catch (NumberFormatException nfe) {
					msg = "연봉과 보너스는 숫자인 부분 인지용?";
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					msg = "사용 중 불편을 드려 죄송한 부분 인정?";
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, msg);
			}// end switch

		}
		if (e.getSource() == btnDelete) {
			String empno = tfEmpno.getText().trim();
			String msg = "";
			switch (JOptionPane.showConfirmDialog(this, empno+"번 사원의 정보를 정말 삭제하시겠습니까?")) {
			case JOptionPane.OK_OPTION:
				try {
					EmpProcedureDAO ep_dao = EmpProcedureDAO.getInstance();
					msg = ep_dao.deleteCpEmp(parseInt(empno));
					setTableData();
					tfReset();
				} catch (NumberFormatException nfe) {
					msg = "사원번호는 숫자형태 인지용?";

				} catch (SQLException se) {
					msg = "서비스가 원활하지 못하여 여윽시 뎨동!";
					se.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, msg);
			}
		}

	}
}
