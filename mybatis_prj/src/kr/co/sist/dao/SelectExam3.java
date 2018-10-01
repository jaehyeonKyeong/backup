package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.domain.DynamicIf;
import kr.co.sist.domain.Emp;
import kr.co.sist.vo.DeptVO;
import kr.co.sist.vo.DynamicForeachVO;
import kr.co.sist.vo.DynamicSetVO;
import kr.co.sist.vo.EmpInsertVO;
import kr.co.sist.vo.SelectProcVO;

public class SelectExam3 {
	
	public List<DynamicIf> dynamicIf(int deptno) throws PersistenceException{
		List<DynamicIf> list = null;
		
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		DeptVO dv = new DeptVO(deptno);
		list = ss.selectList("dynamicIf", dv);
		
		return list;
	}//dynamicIf
	
	
	public int dynamicSet(DynamicSetVO ds_vo) throws PersistenceException {
		int cnt = 0;
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		cnt = ss.update("dynamicSet", ds_vo);
		
		if(cnt>1) {
			ss.commit();
		}//end if
		
		return cnt;
	} //dynamicSet
	
	public List<DynamicIf> dynamicChoose(int deptno)throws PersistenceException{
		List<DynamicIf> list=null;
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		DeptVO dv=new DeptVO(deptno);
		list=ss.selectList("dynamicChoose", dv);
		
		return list;
		
		
	}
	
	public List<DynamicIf> dynamicForeach(DynamicForeachVO dfv)throws PersistenceException{
		List<DynamicIf> list=null;
		SqlSession ss = GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		list=ss.selectList("dynamicForeach",dfv);
		
		return list;
		
	}
	public String insertProc(EmpInsertVO eiv)throws PersistenceException{
		String msg="";
		SqlSession ss=GetSqlSessionFactory.getSqlSessionFactory().openSession();
		
		ss.selectOne("insertProc",eiv);
		msg=eiv.getResultMsg();
		return msg;
	}
public List<Emp> selectProc(int deptno)throws PersistenceException{
		
		
		List<Emp> list=null;
		
		SqlSession ss=GetSqlSessionFactory.getSqlSessionFactory().openSession();
		//proc로 넘겨줄 값(in)과 처리된 결과(out)를 가진 VO
		SelectProcVO sp_vo=new SelectProcVO(deptno,list);
		
		ss.selectOne("selectProc",sp_vo);
		list=sp_vo.getEmp();
		
		return list;
		
	}//selectProc
	
	public static void main(String[] args) {
		SelectExam3 se = new SelectExam3();
//		EmpInsertVO eiv=new EmpInsertVO("최주오","",5555,4000,2000);
		System.out.println(se.selectProc(10));
		
/*		long st = System.currentTimeMillis();
		int sum = 0;
		for(int i=0; i<10000; i++) {
//			System.out.println(i);
			sum+=i;
		}
		long et = System.currentTimeMillis();
		System.out.println("결과 : " +sum );
		System.out.println("수행시간 : " +(et-st) + "ms");
		*/
	}//main
}//class
