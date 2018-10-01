package day0914;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

public class MyBatisDAO {

	public List<DeptDomain> selectAllDept() throws PersistenceException {
		List<DeptDomain> list=null;
		
		//1.XML과 연결
		try {
			Reader reader = Resources.getResourceAsReader("day0914/mybatis_config.xml");
			
		//2.Builder생성
			SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
			
		//3.SqlSessionFactory얻기
			SqlSessionFactory ssf=ssfb.build(reader);
			reader.close();
			
		//4.MyBatis Handler얻기
			SqlSession ss=ssf.openSession();
			list=ss.selectList("selectAllDept");
			
		} catch (IOException e) {
			e.printStackTrace();
		}//end catch
		
		return list;
		
	}// selectAllDept

}// class
