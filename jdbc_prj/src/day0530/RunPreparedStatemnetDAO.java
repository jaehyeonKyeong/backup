package day0530;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * preparedstatementdao��ü�� ����Ͽ� �߰�, ����, ����, ��ü �� ��ȸ, �μ���ȣ�� ���� �μ� �ϳ� ��ȸ �۾� ���
 * 
 * @author owner
 *
 */
public class RunPreparedStatemnetDAO {

	private PreparedStatemnetDAO ps_dao;

	public RunPreparedStatemnetDAO() {
		ps_dao = PreparedStatemnetDAO.getInstance();

	}

	public void addCpDept() {
		String data = JOptionPane.showInputDialog("�μ������Է�\n�μ���ȣ,�μ���,��ġ\n�� �������� �Է� : ");
		try {
			String[] tempData = data.split(",");
			CpDeptVO cdv = new CpDeptVO(Integer.parseInt(tempData[0]), tempData[1], tempData[2]);
			ps_dao.insertCpDept(cdv);
			JOptionPane.showMessageDialog(null, cdv.getDeptno() + "�� �μ������� �� �ԷµǾ����ϴ�.");
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "�μ����� �߰� �۾��� ������ �߻��Ͽ����ϴ�.");
			se.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�Է°��� Ȯ�����ּ���!");
		}
	}// addCpDept �μ���ȣ �߰�

	public void modifyCpDept() {
		String data = JOptionPane.showInputDialog("�μ���������\n�μ���ȣ,�μ���,��ġ\n�� �������� �Է� : ");
		try {
			String[] tempData = data.split(",");
			CpDeptVO cdv = new CpDeptVO(Integer.parseInt(tempData[0]), tempData[1], tempData[2]);
			int cnt = ps_dao.updateCpDept(cdv);
			String msg = cdv.getDeptno() + "�� �μ��� �������� �ʽ��ϴ�";
			if (cnt > 0) {
				msg = cdv.getDeptno() + "�� �μ� [" + cnt + "]���� ���� �Ǿ����ϴ�.";
			}
			JOptionPane.showMessageDialog(null, msg);
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "�μ����� ���� �۾��� ������ �߻��Ͽ����ϴ�.");
			se.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�Է°��� Ȯ�����ּ���!");
		}

	}// modifyCpDept

	public void removeCpDept() {
		String data = JOptionPane.showInputDialog("�μ���������\n�μ���ȣ\n�� �������� �Է� : ");
		try {
			int cnt = ps_dao.deleteCpDept(Integer.parseInt(data));
			String msg = data + "�� �μ��� �������� �ʽ��ϴ�";
			if (cnt > 0) {
				msg = data + "�� �μ� [" + cnt + "]���� ���� �Ǿ����ϴ�.";
			}
			JOptionPane.showMessageDialog(null, msg);
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "�μ����� ���� �۾��� ������ �߻��Ͽ����ϴ�.");
			se.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�Է°��� Ȯ�����ּ���!");
		}
	}// removeCpDept

	public void searchAllCpDept() {
		try {
			List<CpDeptVO> list = ps_dao.selectAllCpDept();
			System.out.println("[ ��ȣ ]\t[ �μ���ȣ ]\t[ �μ��� ]\t\t[ ��ġ ]");
			CpDeptVO cdv = null;

			for (int i = 0; i < list.size(); i++) {
				cdv = list.get(i);
				System.out.printf("[ %d ]\t[ %d ]\t\t[ %s ]\t[ %s ]\n", i + 1, cdv.getDeptno(), cdv.getDname(),
						cdv.getLoc());
			}
			if (list.isEmpty()) {
				System.out.println("���� �μ������� �����ϴ�.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// �μ���ȣ ��ü ��ȸ

	public void searchCpDept() {
		String data = JOptionPane.showInputDialog("�μ�������ȸ\n�μ���ȣ\n�� �������� �Է� : ");
		try {
			OneCpDeptV ocdv = ps_dao.selectOneCpDept(Integer.parseInt(data));
			String msg = data + "�� �μ��� �������� �ʽ��ϴ�";
			if (ocdv != null) {
				msg = data + "�� �μ���ȸ���\n �μ��� : [" + ocdv.getDname() + "],��ġ :[" + ocdv.getLoc() + "]";
			}
			JOptionPane.showMessageDialog(null, msg);
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "�μ����� ��ȸ �۾��� ������ �߻��Ͽ����ϴ�.");
			se.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "�Է°��� Ȯ�����ּ���!");
		}
	}// �μ���ȣ �ϳ� ��ȸ

	public static void main(String[] args) {
		RunPreparedStatemnetDAO rps_dao = new RunPreparedStatemnetDAO();
		// rps_dao.addCpDept();
		// rps_dao.modifyCpDept();
		// rps_dao.removeCpDept();
		// rps_dao.searchAllCpDept();
		rps_dao.searchCpDept();
	}

}
