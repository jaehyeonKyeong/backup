package day0913;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OracleDAO implements DAO {
	private List<List<String>> list;

	public OracleDAO() {
		System.out.println("오라클 DAO가 생성");
		list=new ArrayList<List<String>>();
		List<String> mem1=new ArrayList<String>();
		mem1.add("신종성");
		mem1.add("이종민");
		mem1.add("김우현");
		List<String> mem2=new ArrayList<String>();
		mem1.add("강소예");
		mem1.add("경제현");
		mem1.add("이동근");
		mem1.add("송쓰");
		List<String> mem3=new ArrayList<String>();
		mem1.add("뚜딘");
		mem1.add("김동희");
		
		list.add(mem1);
		list.add(mem2);
		list.add(mem3);
	}

	@Override
	public void insert(String name) throws SQLException {
		System.out.println(name+"추가");

	}

	@Override
	public List<String> selectMember(int cnt) throws SQLException {
		return list.get(cnt);
	}

}
