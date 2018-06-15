package day0528;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class RunStatementCRUD {

	public void addCpEmp() {

		String inputData = JOptionPane.showInputDialog("사원정보입력\n사원번호,사원명,연봉,보너스\n의 형식으로 입력 :");

		if (inputData != null && inputData.split(",").length == 4) {

			String[] tempData = inputData.split(",");

			try {
				// 입력된 데이터를 잘라서 VO에 할당
				CpEmpVO cev = new CpEmpVO(parseInt(tempData[0]), parseInt(tempData[2]), parseInt(tempData[3]),
						tempData[1]);

				// 데이터를 가진 VO를 DB처리 객체에 추가
				StatementCRUD s_crud = new StatementCRUD();

				try {

					s_crud.insertCpEmp(cev);
					JOptionPane.showMessageDialog(null, cev.getEname() + "사원정보가 추가 되었습니다!");

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "사원명은 한글 3자까지만 허용됩니다!" + e.getErrorCode());
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "사원번호,연봉,보너스는 숫자로만 입력해 주세요!");
			}

		} else {
			JOptionPane.showMessageDialog(null, "입력형식을 맞춰 입력해주세요!");
		} // end else

	}// addCpEmp
	
	public void modifyCpEmp() {
		String inputData = JOptionPane.showInputDialog("사원정보수정\n사원번호,사원명,연봉\n의 형식으로 입력 :");

		if (inputData != null && inputData.split(",").length == 3) {

			String[] tempData = inputData.split(",");
			try {
				CpEmpVOUpdate cevu=new CpEmpVOUpdate(parseInt(tempData[0]),parseInt(tempData[2]),tempData[1]);
				//쿼리문을 처리하는 DBMS의 업무처리하는 클래스를 객체로 생성하여 사용
				StatementCRUD s_crud=new StatementCRUD();
				int row_count=s_crud.updateCpEmp(cevu);
				String msg=cevu.getEmpno()+"번 사원은 존재하지 않습니다!";
				if(row_count >0) {
					msg=  "요청하신 "+cevu.getEmpno()+"번 사원의 정보를"+row_count+"건 변경하였습니다.";
				}
				JOptionPane.showMessageDialog(null, msg);
				
			}catch(SQLException se) {
				se.printStackTrace();
				JOptionPane.showMessageDialog(null, "사원정보를 변경하는 도중에 문제가 발생했어요!");
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "사원번호와 연봉은 숫자입니다!");
			}//end catch
			
		}else {
			JOptionPane.showMessageDialog(null, "입력형식을 맞춰 입력해주세요!");
		}
		//end else
	}//modifyCpEmp
	public void removeCpEmp() {
		String empno=JOptionPane.showInputDialog("삭제할 사원번호 입력");
		
		try {
			StatementCRUD s_crud=new StatementCRUD();
			int row_cnt=s_crud.deleteCpEmp(parseInt(empno));
			String msg = empno+"번 사원은 존재하지 않습니다!";
			if(row_cnt>0) {
				msg=empno+"번 사원 ["+row_cnt+"]건 삭제 되었습니다!";
			}
			JOptionPane.showMessageDialog(null, msg);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "사원 삭제중 문제가 발생했어요!");
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "사원 번호는 숫자입니다!");
		}
	}
	public void searchAllCpEmp() {
		StatementCRUD s_crud=new StatementCRUD();
		try {
			List<CpEmpAllVO> list=s_crud.selectAllCpEmp();
			for(CpEmpAllVO ceav : list) {
				System.out.println(ceav.getEmpno()+"\t"+ceav.getEname()+"\t"+ceav.getSal()+"\t"+ceav.getComm()+"\t"+ceav.getHi1()+"\t"+ceav.getHi2());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//catch
	}//searchAllCpEmp

	public static void main(String[] args) {
		RunStatementCRUD rs_crud = new RunStatementCRUD();
//		rs_crud.addCpEmp();
//		rs_crud.modifyCpEmp();
//		rs_crud.removeCpEmp();
		rs_crud.searchAllCpEmp();
	}// main

}// class
