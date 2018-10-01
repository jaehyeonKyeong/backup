package day0905;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author owner
 */
public class UseMyBatis {
	
	public static void main(String[] args) {
		try {
			//1.설정용 XML에 Stream을 사용하여 연결
			Reader reader = Resources.getResourceAsReader("day0904/mybatis_config.xml");
			//2.MyBatis Framework 생성
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			//3.DB 사용 제반 객체 얻기 ( 연동 )
			SqlSessionFactory ssf = ssfb.build(reader);
			reader.close();
			//4.MyBatis Handler 얻기
			SqlSession ss = ssf.openSession();
			
			//5.조작 insert, update, delete는 transaction을 완료해야한다.
			//int cnt = ss.insert("insert_cpemp");
			//int cnt = ss.update("update_cpemp");
			int cnt = ss.delete("delete_cpemp");
			ss.commit();
			System.out.println("추가, 삭제, 변경 성공 " +cnt);
			//6.Handler 사용 종료
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main
}//class
