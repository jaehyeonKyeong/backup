package kr.co.sist.service;

import java.sql.SQLException;

import kr.co.sist.dao.NamecardDAO;
import kr.co.sist.vo.NamecardAllVO;

public class NamecardSearchService {
	public NamecardAllVO searchNamecard(int nc_num) {
		NamecardAllVO nav=null;

		NamecardDAO n_dao=NamecardDAO.getInstance();
		
		try {
			nav=n_dao.selectNamecard(nc_num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nav;
	}
}
