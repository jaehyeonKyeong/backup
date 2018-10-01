package kr.co.sist.service;

import java.sql.SQLException;

import kr.co.sist.dao.NamecardDAO;
import kr.co.sist.vo.NamecardModifyVO;

public class NamecardModifyService {
	public boolean namecardModify( NamecardModifyVO nmvo ) throws SQLException{
		boolean cnt=false;
		
		NamecardDAO n_dao=NamecardDAO.getInstance();
		
		cnt=n_dao.updateNamecard(nmvo);
		
		return cnt;
	}//namecardModify
}//class
