package kr.co.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.sist.vo.NCListVO;
import kr.co.sist.vo.NCStartEndVO;
import kr.co.sist.vo.NamecardAllVO;
import kr.co.sist.vo.NamecardModifyVO;
import kr.co.sist.vo.NamecardVO;

public class NamecardDAO {
	private static NamecardDAO n_dao;
	
	private NamecardDAO() {
	}//NamecardDAO

	public static NamecardDAO getInstance() {
		if( n_dao == null) {
			n_dao=new NamecardDAO();
		}//getInstance
		return n_dao;
	}//getInstance
	
	private Connection getConn() throws SQLException{
		
		Connection con=null;
		
		try {
			//1.
			Context ctx=new InitialContext();
			//2.
			DataSource ds=
			(DataSource)ctx.lookup("java:comp/env/jdbc/nc_dbcp");
			//3.
			con=ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}//end catch
		
		return con;		
	}//getConn
	
	
	
	/**
	 * 전체 게시물의 수
	 * @return
	 * @throws SQLException
	 */
	public int namecardTotalCount()throws SQLException{
		int cnt=0;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConn();
			StringBuilder selectCnt=new StringBuilder();
			selectCnt.append("select count(*) cnt from namecard ");
			
					
			pstmt=con.prepareStatement(selectCnt.toString());
			//bind변수는 조건에 의해 붙는다.(무조건X)
			
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}//end if
			
		}finally {
			if(rs !=null) {rs.close();}//end if
			if(pstmt !=null) {pstmt.close();}//end if
			if(con !=null) {con.close();}//end if
		}//end finally
		
		return cnt;
	}//namecardTotalCount
	
	/**
	 * 시작번호와 끝번호에 해당하는 리스트 얻기
	 * @param nc_vo
	 * @return
	 * @throws SQLException
	 */
	public List<NCListVO> selectList(NCStartEndVO nc_vo)throws SQLException{
		
		List<NCListVO> list=new ArrayList<NCListVO>();
	
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			con=getConn();
			
			StringBuilder selectList=new StringBuilder();
			selectList
				.append("select nc_num, company, manager, dept, to_char(input_date,'yyyy-mm-dd hh24:mi')input_date from ")
				.append("(select rownum runm, nc_num, company, manager, dept, input_date from ")
				.append("(select nc_num, company, manager, dept, input_date from namecard ");
				
				selectList.append(" order by input_date desc)) ")
				.append("where runm between ? and ?");
			
				pstmt=con.prepareStatement(selectList.toString());
				pstmt.setInt(1, nc_vo.getStartNum());
				pstmt.setInt(2, nc_vo.getEndNum());
				
				rs=pstmt.executeQuery();
				
				NCListVO nclv=null;
				while(rs.next()) {
					nclv=new NCListVO(rs.getInt("nc_num"),rs.getString("company"),
							rs.getString("manager"),rs.getString("dept"),rs.getString("input_date"));
					
					list.add(nclv);
				}//end while
		}finally {
			if(rs !=null) {rs.close();}//end if
			if(pstmt !=null) {pstmt.close();}//end if
			if(con !=null) {con.close();}//end if
		}//end finally
		
		return list;
	}//selectList
	
	/**
	 * 명함세부조회
	 * @param ncNum
	 * @return
	 * @throws SQLException
	 */
	public NamecardAllVO selectNamecard(int ncNum)throws SQLException{
		NamecardAllVO nav=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=getConn();
			StringBuilder selectNamecard=new StringBuilder();
			selectNamecard.append("select com_img, company, manager, dept, email, phone, fax, addr, to_char(input_date,'yyyy-mm-dd') input_date, position")
			.append(" from namecard where nc_num=?");
					
			pstmt=con.prepareStatement(selectNamecard.toString());
			pstmt.setInt(1, ncNum);
			
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				nav=new NamecardAllVO(ncNum,rs.getString("com_img"),rs.getString("company"),rs.getString("dept"),rs.getString("manager"),rs.getString("position"),rs.getString("phone"),rs.getString("fax"),rs.getString("addr"),rs.getString("email"),rs.getString("input_date"));
			}//end if
			
		}finally {
			if(rs !=null) {rs.close();}//end if
			if(pstmt !=null) {pstmt.close();}//end if
			if(con !=null) {con.close();}//end if
		}//end finally
		
		return nav;
	}//selectNamecard
	
	/**
	 * 명함 추가
	 * @param nv
	 * @throws SQLException
	 */
	public void insertNamecard(NamecardVO nv)throws SQLException{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			con=getConn();
			
			StringBuilder insertNamecard=new StringBuilder();
			
			insertNamecard.append("insert into namecard")
			.append("(nc_num,com_img,company,manager,dept,email,phone,fax,addr,position)")
			.append(" values(seq_namecard.nextval,?,?,?,?,?,?,?,?,?)");
			
			pstmt=con.prepareStatement(insertNamecard.toString());
			pstmt.setString(1, nv.getComImg());
			pstmt.setString(2, nv.getCompany());
			pstmt.setString(3, nv.getManager());
			pstmt.setString(4, nv.getDept());
			pstmt.setString(5, nv.getEmail());
			pstmt.setString(6, nv.getPhone());
			pstmt.setString(7, nv.getFax());
			pstmt.setString(8, nv.getAddr());
			pstmt.setString(9, nv.getPosition());
			
			pstmt.executeUpdate();
		}finally {
			if(rs !=null) {rs.close();}//end if
			if(pstmt !=null) {pstmt.close();}//end if
			if(con !=null) {con.close();}//end if
		}//end finally
		
	}//insertNamecard
	
	/**
	 *  명함 수정<br>
	 *  식별번호에 일치하는 명함의 담당자명, 이메일, 직급을 변경
	 * @param nmvo
	 * @return
	 * @throws SQLException
	 */
	public boolean updateNamecard(NamecardModifyVO nmvo)throws SQLException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			con=getConn();
			
			StringBuilder updateNamecard=new StringBuilder();
			
			updateNamecard.append(" update namecard set ")
			.append(" manager=?,dept=?,email=?,position=? ")
			.append(" where nc_num=? ");
			
			pstmt=con.prepareStatement(updateNamecard.toString());
			pstmt.setString(1, nmvo.getManager());
			pstmt.setString(2, nmvo.getDept());
			pstmt.setString(3, nmvo.getEmail());
			pstmt.setString(4, nmvo.getPosition());
			pstmt.setInt(5, nmvo.getNcNum());
			
			if(pstmt.executeUpdate()==1) {
				flag=true;
			}
		}finally {
			if(rs !=null) {rs.close();}//end if
			if(pstmt !=null) {pstmt.close();}//end if
			if(con !=null) {con.close();}//end if
		}//end finally
		
		return flag;
	}//updateNamecard
	
	/**
	 * 명함삭제<br>
	 * 식별번호와 일치하는 명함 삭제
	 * @param ncNum
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteNamecard(int ncNum)throws SQLException{
		boolean flag=false;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
			
		try {
			con=getConn();
			
			StringBuilder deleteNamecard=new StringBuilder();
			
			deleteNamecard.append(" delete from namecard where nc_num=?");
			
			pstmt=con.prepareStatement(deleteNamecard.toString());
			pstmt.setInt(1, ncNum);
			
			if(pstmt.executeUpdate()==1) {
				flag=true;
			}
		}finally {
			if(rs !=null) {rs.close();}//end if
			if(pstmt !=null) {pstmt.close();}//end if
			if(con !=null) {con.close();}//end if
		}//end finally
		
		return flag;
	}//deleteNamecard

}//class






