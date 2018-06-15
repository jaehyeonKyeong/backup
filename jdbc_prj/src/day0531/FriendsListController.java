package day0531;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class FriendsListController extends MouseAdapter implements ActionListener {

	private FriendsListView flv;
	private boolean selectFlag; // List���� ���θ� ������ ����

	public FriendsListController(FriendsListView flv) {
		this.flv = flv;
		viewList();
		
	}// constructor

	@Override
	public void mouseClicked(MouseEvent me) {
		String selectedData = flv.getDlm().getElementAt(flv.getFriendsList().getSelectedIndex());
		StringTokenizer stk = new StringTokenizer(selectedData, "/-");

		// ���õ� �����͸� tf�� ä���
		if (me.getClickCount() == 2) {
			flv.getTfName().setText(stk.nextToken());
			flv.getTfAge().setText(stk.nextToken());
			flv.getTfPhone1().setText(stk.nextToken());
			flv.getTfPhone2().setText(stk.nextToken());
			flv.getTfPhone3().setText(stk.nextToken());
		}

		selectFlag = true;

	}

	private FriendsListVO inputData() {
		FriendsListVO flVO = null;
		String name = flv.getTfName().getText().trim();
		int age = Integer.parseInt(flv.getTfAge().getText().trim());
		String phn1 = flv.getTfPhone1().getText().trim();
		String phn2 = flv.getTfPhone2().getText().trim();
		String phn3 = flv.getTfPhone3().getText().trim();

		StringBuilder phoneNumber = new StringBuilder();
		phoneNumber.append(phn1).append("-").append(phn2).append("-").append(phn3);
		// �Էµ����͸� model��ü�� �Է��Ѵ�
		flVO = new FriendsListVO(name, phoneNumber.toString(), age);
		return flVO;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == flv.getBtnAdd()) {// �߰�
			FriendsListVO flVO=inputData();
			FriendsListDAO flDAO=FriendsListDAO.getInstance();
			List<FriendsListVO> list=null;
			flv.getDlm().removeAllElements();
			try {
				flDAO.insertColumnInfo(flVO);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "�߰��� ������ �߻��Ͽ����ϴ�.");
				e.printStackTrace();
			}
			viewList();
			// ���� �Է��� ���ϰ� �ϱ� ���� tf�� �ʱ�ȭ �Ѵ�.
			flv.getTfName().setText("");
			flv.getTfAge().setText("");
			flv.getTfPhone1().setText("");
			flv.getTfPhone2().setText("");
			flv.getTfPhone3().setText("");

			flv.getTfName().requestFocus();
			selectFlag = false;// �߰��� ���´� ����Ʈ�� ������ ���°� �ƴϹǷ� false
		}
		if (ae.getSource() == flv.getBtnDelete()) {// ����
			if (!selectFlag) {
				JOptionPane.showMessageDialog(flv, "������ ģ���� �������ּ���");
				return;// ��ȯ�� void�� return�� ����� ���� ��ȯ�ϴ� ���� �ƴ϶�, �Ʒ��� �ڵ��� ������ ���� ���� �ϰ� �˴ϴ�.
			}
			if (showConfirm("���� �����Ұǰ���?")) {
				flv.getDlm().removeElementAt(flv.getFriendsList().getSelectedIndex());
				selectFlag = false;
			}
		}
		if (ae.getSource() == flv.getBtnAdjust()) {// ����
			if (!selectFlag) {
				JOptionPane.showMessageDialog(flv, "������ ������ ģ���� �������ּ���");
				return;// ��ȯ�� void�� return�� ����� ���� ��ȯ�ϴ� ���� �ƴ϶�, �Ʒ��� �ڵ��� ������ ���� ���� �ϰ� �˴ϴ�.
			}
			if (showConfirm("���� �����Ͻðھ��?")) {
				int indx = flv.getFriendsList().getSelectedIndex();
				// ������
				flv.getDlm().removeElementAt(indx);
				// ������ �������ڸ��� �߰�
//				flv.getDlm().add(indx, userData());

				selectFlag = false;
			}

		}
		if (ae.getSource() == flv.getBtnClose()) {// ����
			if (showConfirm("������ �����Ͻǰǰ���?")) {
				flv.dispose();
			}
		}
	}

	private boolean showConfirm(String msg) {
		boolean flag = false;
		flag = JOptionPane.showConfirmDialog(flv, msg) == 0;
		return flag;
	}
	
	public void viewList() {
		FriendsListDAO flDAO=FriendsListDAO.getInstance();
		List<FriendsListVO> list=null;
		try {
			list=flDAO.selectColumnInfo();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(flv, "�����ͺ��̽��� �ҷ����� �� ������ �߻��Ͽ����ϴ�");
			e.printStackTrace();
		}
		
		for(FriendsListVO flVO : list) {
		StringBuilder userData=new StringBuilder();
		userData.append(flVO.getName()).append(" / ").append(flVO.getAge()).append(" / ").append(flVO.getPhone_num());
		flv.getDlm().addElement(userData.toString());
		}
	}

}
