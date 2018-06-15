package day0530;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * preparedstatementdao객체를 사용하여 추가, 삭제, 변경, 전체 행 조회, 부서번호에 따른 부서 하나 조회 작업 사용
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
		String data = JOptionPane.showInputDialog("부서정보입력\n부서번호,부서명,위치\n의 형식으로 입력 : ");
		try {
			String[] tempData = data.split(",");
			CpDeptVO cdv = new CpDeptVO(Integer.parseInt(tempData[0]), tempData[1], tempData[2]);
			ps_dao.insertCpDept(cdv);
			JOptionPane.showMessageDialog(null, cdv.getDeptno() + "번 부서정보가 잘 입력되었습니다.");
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "부서정보 추가 작업중 문제가 발생하였습니다.");
			se.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "입력값을 확인해주세요!");
		}
	}// addCpDept 부서번호 추가

	public void modifyCpDept() {
		String data = JOptionPane.showInputDialog("부서정보변경\n부서번호,부서명,위치\n의 형식으로 입력 : ");
		try {
			String[] tempData = data.split(",");
			CpDeptVO cdv = new CpDeptVO(Integer.parseInt(tempData[0]), tempData[1], tempData[2]);
			int cnt = ps_dao.updateCpDept(cdv);
			String msg = cdv.getDeptno() + "번 부서는 존재하지 않습니다";
			if (cnt > 0) {
				msg = cdv.getDeptno() + "번 부서 [" + cnt + "]건이 변경 되었습니다.";
			}
			JOptionPane.showMessageDialog(null, msg);
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "부서정보 변경 작업중 문제가 발생하였습니다.");
			se.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "입력값을 확인해주세요!");
		}

	}// modifyCpDept

	public void removeCpDept() {
		String data = JOptionPane.showInputDialog("부서정보삭제\n부서번호\n의 형식으로 입력 : ");
		try {
			int cnt = ps_dao.deleteCpDept(Integer.parseInt(data));
			String msg = data + "번 부서는 존재하지 않습니다";
			if (cnt > 0) {
				msg = data + "번 부서 [" + cnt + "]건이 삭제 되었습니다.";
			}
			JOptionPane.showMessageDialog(null, msg);
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "부서정보 삭제 작업중 문제가 발생하였습니다.");
			se.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "입력값을 확인해주세요!");
		}
	}// removeCpDept

	public void searchAllCpDept() {
		try {
			List<CpDeptVO> list = ps_dao.selectAllCpDept();
			System.out.println("[ 번호 ]\t[ 부서번호 ]\t[ 부서명 ]\t\t[ 위치 ]");
			CpDeptVO cdv = null;

			for (int i = 0; i < list.size(); i++) {
				cdv = list.get(i);
				System.out.printf("[ %d ]\t[ %d ]\t\t[ %s ]\t[ %s ]\n", i + 1, cdv.getDeptno(), cdv.getDname(),
						cdv.getLoc());
			}
			if (list.isEmpty()) {
				System.out.println("현재 부서정보가 없습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// 부서번호 전체 조회

	public void searchCpDept() {
		String data = JOptionPane.showInputDialog("부서정보조회\n부서번호\n의 형식으로 입력 : ");
		try {
			OneCpDeptV ocdv = ps_dao.selectOneCpDept(Integer.parseInt(data));
			String msg = data + "번 부서는 존재하지 않습니다";
			if (ocdv != null) {
				msg = data + "번 부서조회결과\n 부서명 : [" + ocdv.getDname() + "],위치 :[" + ocdv.getLoc() + "]";
			}
			JOptionPane.showMessageDialog(null, msg);
		} catch (SQLException se) {
			JOptionPane.showMessageDialog(null, "부서정보 조회 작업중 문제가 발생하였습니다.");
			se.printStackTrace();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "입력값을 확인해주세요!");
		}
	}// 부선번호 하나 조회

	public static void main(String[] args) {
		RunPreparedStatemnetDAO rps_dao = new RunPreparedStatemnetDAO();
		// rps_dao.addCpDept();
		// rps_dao.modifyCpDept();
		// rps_dao.removeCpDept();
		// rps_dao.searchAllCpDept();
		rps_dao.searchCpDept();
	}

}
