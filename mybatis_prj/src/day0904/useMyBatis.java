package day0904;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class useMyBatis {

	public static void main(String[] args) {
		try {
			// 1.XML과 연결
			Reader reader = Resources.getResourceAsReader("day0904/mybatis_config.xml");
			// 2.MyBatis Framework객체 생성(실행 중인 JVM하나당 하나만 생성)
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			// 3.생성된 Framework에서 session을 사용할 수 있는 객체 받기
			// DB연동에 대한 전반적인 정보를 가진 객체
			// 입력된 스트림으로 DB와 연동하여,연동 제반정보를 반환한다.
			SqlSessionFactory ssf = ssfb.build(reader);
			reader.close();
			// 4.DB와 연동정보를 가진 객체에서 MyBatis 객체를 사용하는 (Handling)객체인 SqlSession을 얻는다
			SqlSession ss = ssf.openSession();
			
//			String dname=ss.selectOne("dname");
//			System.out.println(dname);
			List<String> list=ss.selectList("dname");
			for(String dname:list) {
				System.out.println(dname);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}// main

}// useMyBatis
