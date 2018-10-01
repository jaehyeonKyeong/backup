package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSqlSessionFactory {
	private static SqlSessionFactory ssf;
	
	private GetSqlSessionFactory() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//GetSqlSessionFactory
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if(ssf==null) {
			try {
				Reader reader = Resources.getResourceAsReader("data/mybatis_config.xml");
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
				ssf = ssfb.build(reader); //커넥션을 얻은것과 같다
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}//end catch
		}//end if
		return ssf;
	}//SqlSessionFactory
	
}//class
