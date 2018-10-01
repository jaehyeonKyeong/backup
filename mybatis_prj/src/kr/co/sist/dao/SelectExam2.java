package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.sist.domain.CarModel;
import kr.co.sist.domain.DeptEmpJoin;
import kr.co.sist.domain.Emp;
import kr.co.sist.domain.JoinSubquery;
import kr.co.sist.vo.DynamicVO;
import kr.co.sist.vo.SubQueryVO;

public class SelectExam2 {
	//테이블명이 동적일 때
	public List<Emp> dynamicTab(String tab)throws PersistenceException{
		List<Emp> list = null;
		
		DynamicVO dv = new DynamicVO(tab);
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		list = ss.selectList("dynamic_tab", dv);
		
		return list;
	}//dynamicTab
	
//	<!-- subquery -->
	
	public List<CarModel> subquery(int st, int et) throws PersistenceException{
		List<CarModel> list = null;
		
		SubQueryVO svo = new SubQueryVO(st, et);
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		list = ss.selectList("subquery",svo);
		
		return list;
	}//subquery
	
//	<!-- union -->
	public List<Emp> union() throws PersistenceException{
		List<Emp> list = null;
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		list = ss.selectList("union");
		
		if (ss != null) {
			ss.close();
		} // end if

		return list;
	}//union
	
	public List<Integer> selectAllMgr() throws PersistenceException{
		List<Integer> list = null;
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		list = ss.selectList("mgrSelect");
		if(ss!=null) {
			ss.close();
		}//end if
		return list;
	}//selectAllMgr

	public List<DeptEmpJoin> join(Integer mgr) throws PersistenceException{
		List<DeptEmpJoin> list = null;
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		list = ss.selectList("join",mgr);
		if(ss!=null) {
			ss.close();
		}
		return list;
	}//join
	
	public List<JoinSubquery> joinSubquery(String maker) throws PersistenceException{
		List<JoinSubquery> list = null;
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		list = ss.selectList("join_subquery",maker);
		if(ss!=null) {
			ss.close();
		}
		return list;
	}//joinSubquery
	
	public static void main(String[] args) {
		SelectExam2 s = new SelectExam2();
		System.out.println(s.joinSubquery("현대"));
	}
	
//	<!-- join -->
//	<!-- subquery + join -->
//	<!-- dynamic query if -->
//	<!-- dynamic query choose -->
//	<!-- dynamic query foreach -->
//	<!-- procedure insert -->
//	<!-- procedure select -->

	
}//class
