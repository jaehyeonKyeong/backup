package kr.co.sist.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.properties.DataBaseConnection;
import kr.co.sist.user.vo.ReviewContentVO;
import kr.co.sist.user.vo.ReviewVO;

public class ReviewDAO {
	private static ReviewDAO r_dao;

	private ReviewDAO() {

	}

	public static ReviewDAO getInstance() {
		if (r_dao == null) {
			r_dao = new ReviewDAO();
		}
		return r_dao;
	}

	public static Connection getConnection() throws SQLException {
		Connection con = null;
		DataBaseConnection dbc = DataBaseConnection.getInstance();
		String driver = dbc.getDriver();
		String url = dbc.getUrl();
		String id = dbc.getId();
		String pass = dbc.getPass();
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		con = DriverManager.getConnection(url, id, pass);
		return con;
	}

	public List<ReviewVO> selectRankReview(String rNum) throws SQLException {
		List<ReviewVO> reviewList = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select distinct r.review_number,r.review_contents, r.ID, r.REVIEW_TITLE, l.LIKE_NUMBER,r.restaurant_number from review r,review_like l where r.restaurant_number=l.restaurant_number and trim(r.restaurant_number)=? order by like_number desc";
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, rNum.trim());
			rs = pstmt.executeQuery();
			ReviewVO rvo = null;
			while (rs.next()) {
				rvo = new ReviewVO(rs.getString("review_number"), rs.getString("review_contents"), rs.getString("iD"),
						rs.getString("rEVIEW_TITLE"), rs.getString("restaurant_number"), rs.getInt("lIKE_NUMBER"));
				reviewList.add(rvo);
				System.out.println("--");
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return reviewList;
	}

	public List<ReviewVO> selectTodayReview(String rNum) throws SQLException {
		List<ReviewVO> reviewList = new ArrayList<>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select distinct r.review_number,r.review_contents, r.ID, r.REVIEW_TITLE, l.LIKE_NUMBER,r.restaurant_number from review r,review_like l where r.restaurant_number=l.restaurant_number and trim(r.restaurant_number)=? and to_char(input_date,'yyyy-mm-dd')=to_char(sysdate,'yyyy-mm-dd') order by r.input_date desc";
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, rNum.trim());
			rs = pstmt.executeQuery();
			ReviewVO rvo = null;
			while (rs.next()) {
				rvo = new ReviewVO(rs.getString("review_number"), rs.getString("review_contents"), rs.getString("iD"),
						rs.getString("rEVIEW_TITLE"), rs.getString("restaurant_number"), rs.getInt("lIKE_NUMBER"));
				reviewList.add(rvo);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return reviewList;
	}

	// 보기 버튼이 눌렸을때 해당하는 rNum과 riNum을 가지고 추천과 평점, 내용,제목,이미지를 가지고 돌려주는일.(VO)
	public ReviewContentVO selectGetContents(String rNum, String riNum) throws SQLException {
		ReviewContentVO rvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select r.review_number, r.restaurant_number, r.id, r.review_title, r.review_contents, r.review_image, r.grades, l.like_number from review r,review_like l where r.restaurant_number(+)=l.restaurant_number and trim(r.restaurant_number)=? and trim(r.review_number)=?";
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, rNum.trim());
			pstmt.setString(2, riNum.trim());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rvo = new ReviewContentVO(rs.getString("review_number"), rs.getString("review_contents"),
						rs.getString("id"), rs.getString("review_title"), rs.getString("restaurant_number"),
						rs.getInt("like_number"), rs.getInt("grades"));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return rvo;
	}

	// review like테이블에 like_number를 하나 올리는 일
	public void reviewthumpsUp(String rNum, String riNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String updateSql = "update review_like set like_number=like_number+1 where trim(review_number)=? and trim(restaurant_number)=?";
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1, riNum.trim());
			pstmt.setString(2, rNum.trim());
			pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	// 리뷰를 등록하는 일
	public void regiReview(String id, String rNum, String imgfile, String reviewTitle, String reviewCont, int grade)
			throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String insertSql = "insert into review(review_number,id,restaurant_number,review_image,review_title,review_contents,grades,input_date) values (seq_review_num.nextval,?,?,?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, id);
			pstmt.setString(2, rNum);
			pstmt.setString(3, imgfile);
			pstmt.setString(4, reviewTitle);
			pstmt.setString(5, reviewCont);
			pstmt.setInt(6, grade);
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	// 리뷰가 등록될때 리뷰라이크에 해당하는 cnt로 생성하여 인설트하는 일
	public void regiReviewLike(String id, String rNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String insertSql = "insert into review_like(review_number,id,restaurant_number,like_number,like_date) values ((select review_number from review where id=? and trim(restaurant_number)=?),?,?,?,sysdate)";
			pstmt = con.prepareStatement(insertSql);
			pstmt.setString(1, id);
			pstmt.setString(2, rNum.trim());
			pstmt.setString(3, id);
			pstmt.setString(4, rNum);
			pstmt.setInt(5, 0);
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public void deleteReviewData(String riNum, String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String deleteSql = "delete from review where id=? and trim(review_number)=?";
			pstmt = con.prepareStatement(deleteSql);
			System.out.println("dao -" + id + "," + riNum);
			pstmt.setString(1, id);
			pstmt.setString(2, riNum.trim());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public void deleteReviewLike(String riNum, String id) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String deleteSql = "delete from review_like where id=? and trim(review_number)=?";
			pstmt = con.prepareStatement(deleteSql);
			System.out.println("dao -" + id + "," + riNum);
			pstmt.setString(1, id);
			pstmt.setString(2, riNum.trim());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public int searchReview(String id, String rNum) throws SQLException {
		int cnt = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String selectSql = "select count(id) cnt from review where trim(id)=? and trim(restaurant_number)=?";
			pstmt = con.prepareStatement(selectSql);
			pstmt.setString(1, id.trim());
			pstmt.setString(2, rNum.trim());
			rs = pstmt.executeQuery();
			System.out.println("====" + id);
			while (rs.next()) {
				cnt = rs.getInt("cnt");
				System.out.println("----dao" + rs.getInt("cnt"));
			}

		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}

		}

		return cnt;
	}

	public void reportReview(String rNum, String riNum) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = getConnection();
			String updateSql = "update review set report=1 where trim(restaurant_number)=? and trim(review_Number)=?";
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1, rNum.trim());
			pstmt.setString(2, riNum.trim());
			pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {pstmt.close();}
			if (con != null) {con.close();}
		}

	}
}
