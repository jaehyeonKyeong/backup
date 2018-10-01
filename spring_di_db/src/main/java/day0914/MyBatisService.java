package day0914;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBatisService {

	private MyBatisDAO mb_dao;
	
	public MyBatisService(MyBatisDAO mb_dao) {
		this.mb_dao=mb_dao;
	}
	
	public List<DeptDomain> searchDept()throws PersistenceException{
		List<DeptDomain> list=null;
		list=mb_dao.selectAllDept();
		
		//부서명이 앞 3글자 부터 끝까지 "x"로 마스킹하여 설정 
		String dname=null;
		StringBuilder temp=new StringBuilder();
		for(DeptDomain dd:list) {
			dname=dd.getDname();
			if(dname.length()>3) {
				temp.append(dname.subSequence(0, 3));
				for(int i=3; i<dname.length(); i++) {
					temp.append("*");
				}//end for
				dd.setDname(temp.toString());
				temp.delete(0, dname.length());
			}//end if
		}//end for
		
		return list;
		
	}//searchDept
	
	


	
}//class
