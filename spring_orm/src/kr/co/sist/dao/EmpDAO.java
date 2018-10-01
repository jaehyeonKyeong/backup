package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.CpEmp;

@Component
public class EmpDAO {

	@Autowired
	private SqlSessionTemplate sst;
	
	public List<CpEmp> selectAllEmp() throws SQLException{
		List<CpEmp> list=null;
		
		list=sst.selectList("selectAllEmp");
		
		return list;
	}
	
}
