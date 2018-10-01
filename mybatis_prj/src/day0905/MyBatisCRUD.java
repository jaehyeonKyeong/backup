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
		System.out.println(ename+"�������"+cnt+"�� �߰� ����");
		}catch (PersistenceException pe) {
			System.out.println("���� �߻� ��� �� �ٽ� �õ�");
			pe.printStackTrace();
		}//end catch
	}//insertString
	
	public void insertVO(CpEmpVO cev) {
		try {
		SqlSession ss = getSqlSessionFactory().openSession();
		int cnt = ss.insert("insertCpempVo", cev);
		ss.commit();
		ss.close();
		System.out.println(cev.getEname() + "��� ���� " + cnt + " �� �߰� �Ͽ����ϴ�.");
		}catch (PersistenceException pe) {
			System.out.println("������ �˼�");
			pe.printStackTrace();
		}//end catch
	}//insertVO
	
	public void updateCpEmp(CpEmpVO cev) {
		try {
		SqlSession ss = getSqlSessionFactory().openSession();
		int cnt = ss.update("updateCpEmp", cev);
		if(cnt == 0) {
			System.out.println(cev.getEmpno() + "�� ����� �������� ����");
		}else {
			System.out.println(cev.getEname() + "�� ��� ������ ���� ����");
		}//end else
		ss.commit();
		ss.close();
		}catch (PersistenceException pe) {
			System.out.println("����!");
			pe.printStackTrace();
		}//end catch
	}//updateCpEmp
	
//	public void deleteCpEmp(int empno) {
	public void deleteCpEmp(Integer empno) {
		try {
			SqlSession ss = getSqlSessionFactory().openSession();
			int cnt = ss.delete("deleteCpEmp", empno);
			if(cnt == 0) {
				System.out.println(empno + "�� �ش� ����� �������� �ʽ��ϴ�.");
			}else {
				System.out.println(empno + "�� ����� ���������� �����Ǿ����ϴ�.");
				ss.commit();
			}//end else
			ss.close();
		}catch (PersistenceException pe) {
			System.err.println("����!");
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
			System.out.println("�˼��մϴ�.");
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
			System.out.println("�˼��մϴ�");
			pe.printStackTrace();
		}//end catch
		
	}//selectAllDept
	
	public static void main(String[] args) {
		MyBatisCRUD mb_crud = new MyBatisCRUD();
		//mb_crud.insertString("������ �ѵ�");
		//CpEmpVO cev = new CpEmpVO(6666, 7, 7, "����7");
		//mb_crud.insertVO(cev);
		
		//mb_crud.updateCpEmp(cev); // �⺻�� ���
		
		//mb_crud.deleteCpEmp(new Integer(1235)); //wrapper ���
		
		//mb_crud.selectDeptno();
		mb_crud.selectAllDept();
		
	}//main

}//class
