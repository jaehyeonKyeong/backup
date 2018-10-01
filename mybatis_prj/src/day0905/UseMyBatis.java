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
			//1.������ XML�� Stream�� ����Ͽ� ����
			Reader reader = Resources.getResourceAsReader("day0904/mybatis_config.xml");
			//2.MyBatis Framework ����
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			//3.DB ��� ���� ��ü ��� ( ���� )
			SqlSessionFactory ssf = ssfb.build(reader);
			reader.close();
			//4.MyBatis Handler ���
			SqlSession ss = ssf.openSession();
			
			//5.���� insert, update, delete�� transaction�� �Ϸ��ؾ��Ѵ�.
			//int cnt = ss.insert("insert_cpemp");
			//int cnt = ss.update("update_cpemp");
			int cnt = ss.delete("delete_cpemp");
			ss.commit();
			System.out.println("�߰�, ����, ���� ���� " +cnt);
			//6.Handler ��� ����
			ss.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//main
}//class
