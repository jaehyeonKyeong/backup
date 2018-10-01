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
			// 1.XML�� ����
			Reader reader = Resources.getResourceAsReader("day0904/mybatis_config.xml");
			// 2.MyBatis Framework��ü ����(���� ���� JVM�ϳ��� �ϳ��� ����)
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			// 3.������ Framework���� session�� ����� �� �ִ� ��ü �ޱ�
			// DB������ ���� �������� ������ ���� ��ü
			// �Էµ� ��Ʈ������ DB�� �����Ͽ�,���� ���������� ��ȯ�Ѵ�.
			SqlSessionFactory ssf = ssfb.build(reader);
			reader.close();
			// 4.DB�� ���������� ���� ��ü���� MyBatis ��ü�� ����ϴ� (Handling)��ü�� SqlSession�� ��´�
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
