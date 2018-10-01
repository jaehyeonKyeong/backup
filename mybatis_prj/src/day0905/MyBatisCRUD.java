package day0905;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.Session;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisCRUD {

	private static SqlSessionFactory ssf;
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if( ssf == null ) {
			try {
				//1.  
				Reader reader = Resources.getResourceAsReader("data/mybatis_config.xml");
				//2.
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				ssf=ssfb.build(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//getSqlSessionFactory
	
	public void insertString(String ename) {
		SqlSessionFactory ssf = getSqlSessionFactory();
		SqlSession ss= ssf.openSession();
		try {
		int cnt = ss.insert("insert_cpemp_ename", ename);
		ss.commit();
		ss.close();
		System.out.println(ename+"사원정보"+cnt+"건 추가 성공");
		}catch (PersistenceException pe) {
			System.out.println("문제 발생 잠시 후 다시 시도");
			pe.printStackTrace();
		}//end catch
	}//insertString
	
	public void insertVO(CpEmpVO cev) {
		try {
		SqlSession ss = getSqlSessionFactory().openSession();
		int cnt = ss.insert("insertCpempVo", cev);
		ss.commit();
		ss.close();
		System.out.println(cev.getEname() + "사원 정보 " + cnt + " 건 추가 하였습니다.");
		}catch (PersistenceException pe) {
			System.out.println("어이쿠 죄송");
			pe.printStackTrace();
		}//end catch
	}//insertVO
	
	public void updateCpEmp(CpEmpVO cev) {
		try {
		SqlSession ss = getSqlSessionFactory().openSession();
		int cnt = ss.update("updateCpEmp", cev);
		if(cnt == 0) {
			System.out.println(cev.getEmpno() + "번 사원은 존재하지 않음");
		}else {
			System.out.println(cev.getEname() + "번 사원 정보가 변경 성공");
		}//end else
		ss.commit();
		ss.close();
		}catch (PersistenceException pe) {
			System.out.println("ㅈㅅ!");
			pe.printStackTrace();
		}//end catch
	}//updateCpEmp
	
//	public void deleteCpEmp(int empno) {
	public void deleteCpEmp(Integer empno) {
		try {
			SqlSession ss = getSqlSessionFactory().openSession();
			int cnt = ss.delete("deleteCpEmp", empno);
			if(cnt == 0) {
				System.out.println(empno + "번 해당 사원은 존재하지 않습니다.");
			}else {
				System.out.println(empno + "번 사원이 정상적으로 삭제되었습니다.");
				ss.commit();
			}//end else
			ss.close();
		}catch (PersistenceException pe) {
			System.err.println("ㅈㅅ!");
			pe.printStackTrace();
		}//end catch
	}//deleteCpEmp
	
	public void selectDeptno() {
		try {
			
			SqlSession ss = getSqlSessionFactory().openSession();
			List<Integer> list = ss.selectList("selectAllDeptno"); 
			for(int deptno : list) {
				System.out.println(deptno);
			}//end for
			
		}catch (PersistenceException pe) {
			System.out.println("죄송합니다.");
			pe.printStackTrace();
		}//end catch
	}//selectDeptno
	
	public void selectAllDept() {
		try {
			SqlSession ss = getSqlSessionFactory().openSession();
			List<DeptDomain> list = ss.selectList("selectAllDept");
			for(DeptDomain dd : list) {
				System.out.println(dd.getDeptno() +"/"+ dd.getDname() +"/"+ dd.getLoc());
			}//end for
		}catch (PersistenceException pe) {
			System.out.println("죄송합니다");
			pe.printStackTrace();
		}//end catch
		
	}//selectAllDept
	
	public static void main(String[] args) {
		MyBatisCRUD mb_crud = new MyBatisCRUD();
		//mb_crud.insertString("지각왕 뚜딘스");
		//CpEmpVO cev = new CpEmpVO(6666, 7, 7, "최주7");
		//mb_crud.insertVO(cev);
		
		//mb_crud.updateCpEmp(cev); // 기본형 사용
		
		//mb_crud.deleteCpEmp(new Integer(1235)); //wrapper 사용
		
		//mb_crud.selectDeptno();
		mb_crud.selectAllDept();
		
	}//main

}//class
