//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import kr.co.sist.properties.DataBaseConnection;
//
///**
//	 * �ֹ��� ���ö��� �ϼ��Ǿ������� ���� ���� ��ȭ.
//	 * @param orderCode ���ۿϷ�� ���ö��� �ֹ��ڵ�
//	 * @return ����� ���
//	 * @throws SQLException
//	 */
//	public int updateStatus(String orderCode)throws SQLException{
//		int cnt=0;
//		Connection con=null;
//		PreparedStatement pstmt=null;
//		
//		try {
//		//1.
//		//2.
//			con=DataBaseConnection.getInstance().getConnection();
//		//3.
//			String updateOrder=
//					"update ordering set status='Y' where order_code=?";
//			pstmt=con.prepareStatement(updateOrder);
//		//4.
//			pstmt.setString(1, orderCode);
//		//5.
//			cnt=pstmt.executeUpdate();
//			
//		}finally {
//		//6.
//			if(pstmt !=null) {pstmt.close();} //end if
//			if(con !=null) {con.close();} //end if
//		}//end finally
//		
//		return cnt;
//	}//updateStatus