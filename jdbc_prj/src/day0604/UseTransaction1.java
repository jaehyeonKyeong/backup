package day0604;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import properties.DataBaseConnection;

public class UseTransaction1 {
	private Connection con;

	public int[] insertTrigger(String name, String addr, int age) throws SQLException {
		int[] cnt = new int[2];
		PreparedStatement pstmt = null;
		try {
			// 1.
			// 2.
			con = DataBaseConnection.getInstance().getConnection();
			con.setAutoCommit(false);
			// 3.
			String sql = "insert into trigger1(name,addr,age)values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			// 4.
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, age);
			cnt[0]=pstmt.executeUpdate();
			
			pstmt.close();
			// 3.
			sql = "insert into trigger2(name,addr,age)values(?,?,?)";
			pstmt=con.prepareStatement(sql);
			// 4.
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, age);
			cnt[1]=pstmt.executeUpdate();
			
		} finally {
			// 5.
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return cnt;

	}// insertTrigger

	public void useInsertTrigger() throws SQLException {
		String name = "Ż�״�";
		String addr = "��⵵ ������";
		int age = 28;
		try {
			// ���� ������ ����� �޾ƿͼ�
			int[] cnt = insertTrigger(name, addr, age);
			// Transaction�� �Ϸ� �� ������,��� �� ������ �Ǵ�.
			if (cnt[0] == 1 && cnt[1] == 0) {
				con.commit();
				System.out.println(name + "( " + age + " / " + addr + "���� )�� �߰��Ǿ����ϴ�.");
			} else {
				con.rollback();
				System.out.println("��� �����۾��� ��ҵǾ����ϴ�.");
			}
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}// useInsertTrigger

	public static void main(String[] args) {
		UseTransaction1 ut = new UseTransaction1();
		try {
			ut.useInsertTrigger();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end try
	}// main

}
