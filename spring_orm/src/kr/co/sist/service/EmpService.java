package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.EmpDAO;
import kr.co.sist.domain.CpEmp;

@Component
public class EmpService {

	@Autowired
	private EmpDAO e_dao;
	
	public List<CpEmp> searchAllEmp() throws SQLException{
		List<CpEmp> list=null;
		
		list=e_dao.selectAllEmp();
		
		return list;
	}
	
	
}
