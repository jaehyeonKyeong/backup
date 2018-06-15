package day0604;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import properties.DataBaseConnection;

public class UseTrasaction {
	private Connection con = null;

	public int autoCommitFalse() throws SQLException {
		int cnt=0;
		PreparedStatement pstmt = null;
		try {
			// 1.
			// 2.
			con = DataBaseConnection.getInstance().getConnection();
			con.setAutoCommit(false);// ����Ǵ� ������ �ϳ��� transaction �Ϸ�
			// 3.
			pstmt = con.prepareStatement("insert into cp_dept(deptno,dname,loc)values(?,?,?)");
			// 4.
			pstmt.setInt(1, 25);
			pstmt.setString(2, "����");
			pstmt.setString(3, "GyeongGi");
			// 5.
			cnt = pstmt.executeUpdate();
			

		} finally {
			// 6.
			 if (pstmt != null) {
			 pstmt.close();
			 }
			// if (con != null) {
			// con.close();
			// }
		}
		return cnt;

	}// autoCommitFalse
	
	public void useTransaction() throws SQLException{
		try {
			int cnt=autoCommitFalse();
			if (cnt == 1) {//������ ������ ���� ���� 1�϶�
				//transaction�� �Ϸ�� ��Ȳ
				con.commit();
			}else {//������ �����δ� rollBack�� �� �ʿ䰡 ����
				con.rollback();
			}
			System.out.println("�������� "+cnt);
		} finally {
			if (con != null) {
				 con.close();
				 }
		}
	}

	public static void main(String[] args) {
		try {
			new UseTrasaction().useTransaction();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}// main

}
