package day0912;

import java.sql.SQLException;
import java.util.List;

public interface DAO {
	public void insert(String name)throws SQLException;
	public List<String> selectMember(int cnt)throws SQLException;
	
}
