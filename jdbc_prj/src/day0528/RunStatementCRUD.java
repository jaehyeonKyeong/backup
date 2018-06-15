package day0528;

import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class RunStatementCRUD {

	public void addCpEmp() {

		String inputData = JOptionPane.showInputDialog("��������Է�\n�����ȣ,�����,����,���ʽ�\n�� �������� �Է� :");

		if (inputData != null && inputData.split(",").length == 4) {

			String[] tempData = inputData.split(",");

			try {
				// �Էµ� �����͸� �߶� VO�� �Ҵ�
				CpEmpVO cev = new CpEmpVO(parseInt(tempData[0]), parseInt(tempData[2]), parseInt(tempData[3]),
						tempData[1]);

				// �����͸� ���� VO�� DBó�� ��ü�� �߰�
				StatementCRUD s_crud = new StatementCRUD();

				try {

					s_crud.insertCpEmp(cev);
					JOptionPane.showMessageDialog(null, cev.getEname() + "��������� �߰� �Ǿ����ϴ�!");

				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "������� �ѱ� 3�ڱ����� ���˴ϴ�!" + e.getErrorCode());
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "�����ȣ,����,���ʽ��� ���ڷθ� �Է��� �ּ���!");
			}

		} else {
			JOptionPane.showMessageDialog(null, "�Է������� ���� �Է����ּ���!");
		} // end else

	}// addCpEmp
	
	public void modifyCpEmp() {
		String inputData = JOptionPane.showInputDialog("�����������\n�����ȣ,�����,����\n�� �������� �Է� :");

		if (inputData != null && inputData.split(",").length == 3) {

			String[] tempData = inputData.split(",");
			try {
				CpEmpVOUpdate cevu=new CpEmpVOUpdate(parseInt(tempData[0]),parseInt(tempData[2]),tempData[1]);
				//�������� ó���ϴ� DBMS�� ����ó���ϴ� Ŭ������ ��ü�� �����Ͽ� ���
				StatementCRUD s_crud=new StatementCRUD();
				int row_count=s_crud.updateCpEmp(cevu);
				String msg=cevu.getEmpno()+"�� ����� �������� �ʽ��ϴ�!";
				if(row_count >0) {
					msg=  "��û�Ͻ� "+cevu.getEmpno()+"�� ����� ������"+row_count+"�� �����Ͽ����ϴ�.";
				}
				JOptionPane.showMessageDialog(null, msg);
				
			}catch(SQLException se) {
				se.printStackTrace();
				JOptionPane.showMessageDialog(null, "��������� �����ϴ� ���߿� ������ �߻��߾��!");
			}catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, "�����ȣ�� ������ �����Դϴ�!");
			}//end catch
			
		}else {
			JOptionPane.showMessageDialog(null, "�Է������� ���� �Է����ּ���!");
		}
		//end else
	}//modifyCpEmp
	public void removeCpEmp() {
		String empno=JOptionPane.showInputDialog("������ �����ȣ �Է�");
		
		try {
			StatementCRUD s_crud=new StatementCRUD();
			int row_cnt=s_crud.deleteCpEmp(parseInt(empno));
			String msg = empno+"�� ����� �������� �ʽ��ϴ�!";
			if(row_cnt>0) {
				msg=empno+"�� ��� ["+row_cnt+"]�� ���� �Ǿ����ϴ�!";
			}
			JOptionPane.showMessageDialog(null, msg);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "��� ������ ������ �߻��߾��!");
		}catch(NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "��� ��ȣ�� �����Դϴ�!");
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
