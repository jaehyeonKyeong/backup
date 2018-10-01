package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.domain.Dept;
import kr.co.sist.domain.Emp;
import kr.co.sist.domain.Zipcode;

public class SelectExam1 {
//	<!-- 컬럼하나 행하나 조회 -->
	public String singleColumn(int deptno)throws PersistenceException {
		String dname = "";
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		dname = ss.selectOne("singleColumn", deptno);
		
		if( ss != null ) {
			ss.close();
		}
		
		return dname;
	}//singleColumn
//	<!-- 컬럼여러개 행하나 조회-->
	public Dept multiColumn(int deptno) throws PersistenceException{
		Dept dept = null;
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		dept = ss.selectOne("class4.selectMapper1.multiColumn", deptno);
		
		if( ss != null ) {
			ss.close();
		}
		
		return dept;
	}//multiColumn
	
//	<!-- 컬럼하나 여러행 조회-->
	public List<String> singleRow() throws PersistenceException{
		List<String> list = null;
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		list = ss.selectList("class4.selectMapper1.singleRow");
		
		if(ss != null) {
			ss.close();
		}//end if
		
		return list;
	}//singleRow
	
//	<!-- 컬럼여러개 여러행 조회-->
	public List<Emp> multiRow(int deptno) throws PersistenceException{
		List<Emp> list = null;
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		list = ss.selectList("class4.selectMapper1.multiRow", deptno);
		
		if(ss != null) {
			ss.close();
		}//end if
		
		return list;
	}//multiRow
	
//	<!-- >의 조회 -->
	public List<Emp> greaterThan(int sal) throws PersistenceException{
		List<Emp> list=null;
		
		SqlSession ss=GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		list=ss.selectList("class4.selectMapper1.greaterThan",sal);
		if(ss!=null) {
			ss.close();
		}
		
		return list;
	}//lessThan
	
//	<!-- <의 조회 -->
	public List<Emp> lessThan(int sal) throws PersistenceException{
		List<Emp> list=null;
		
		SqlSession ss=GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		list=ss.selectList("class4.selectMapper1.lessThan",sal);
		if(ss!=null) {
			ss.close();
		}
		
		return list;
	}//lessThan
	
//	<!-- like 의 조회 -->
	public List<Zipcode> like(String dong) throws PersistenceException{
		List<Zipcode> list=null;
		
		SqlSession ss=GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		list=ss.selectList("class4.selectMapper1.like",dong);
		if(ss!=null) {
			ss.close();
		}
		return list;
	}//like
	
}//class
