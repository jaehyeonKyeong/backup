package kr.co.sist.service;

import java.sql.SQLException;

import kr.co.sist.dao.NamecardDAO;

public class NamecardRemoveService {
	public boolean namecardRemove(int ncNum) throws SQLException {
		boolean flag=false;

		NamecardDAO n_dao=NamecardDAO.getInstance();
		
		flag=n_dao.deleteNamecard(ncNum);
		
		return flag;
	}//namecardRemove
}//class
