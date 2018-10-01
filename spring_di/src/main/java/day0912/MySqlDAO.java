
package day0912;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlDAO implements DAO {
	private List<List<String>> list;

	public MySqlDAO() {
		list=new ArrayList<List<String>>();
		List<String> mem1=new ArrayList<String>();
		mem1.add("이전영");
		mem1.add("최주오");
		mem1.add("강지형");
		List<String> mem2=new ArrayList<String>();
		mem1.add("송저거");
		mem1.add("경제현");
		mem1.add("이동근");
		mem1.add("강소예");
		List<String> mem3=new ArrayList<String>();
		mem1.add("이상훈");
		mem1.add("김대현");
		mem1.add("김동희");
		mem1.add("오경림");
		
		list.add(mem1);
		list.add(mem2);
		list.add(mem3);
	}

	@Override
	public void insert(String name) throws SQLException {
		System.out.println(name+"입력");

	}

	@Override
	public List<String> selectMember(int cnt) throws SQLException {
		return list.get(cnt);
	}

}
