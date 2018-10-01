package day0912;

import java.sql.SQLException;
import java.util.List;

public class Class4MemberService implements Service{
	//DAO와 약결합
	private DAO dao;
	public Class4MemberService(DAO dao) {
		//의존성 주입 (DI : Dependency Injection)
		this.dao=dao;
	}

	@Override
	public void addMember(String name) {
		try {
			dao.insert(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<String> searchMember(int cnt) {
		if(cnt>2) {
			cnt=0;
		}
		List<String> list=null;
		try {
			list=dao.selectMember(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
