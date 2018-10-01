package kr.co.sist.service;

import java.sql.SQLException;

import kr.co.sist.dao.NamecardDAO;
import kr.co.sist.vo.NamecardVO;

/**
 *������ �߰��ϴ� ����
 * @author owner
 */
public class NamecardAddService {
	
	public void addNamecard(NamecardVO nv) throws SQLException {
		if("".equals(nv.getComImg())||null==nv.getComImg()) {
			nv.setComImg("default.jpg");
		}
		NamecardDAO n_dao=NamecardDAO.getInstance();
		n_dao.insertNamecard(nv);
	}//addNamecard
}//class
