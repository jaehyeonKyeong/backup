package day0829;

import java.util.HashMap;
import java.util.Map;

public class UsePerson {

	/**
	 * �������̽��� ����Ͽ� Map���� �����
	 */
	public void useInterface() {
		// ��ü������, override
		Map<String, Person> map = new HashMap<String, Person>();

		map.put("kang", new Soye());
		map.put("kyeong", new JaeHyeon());
		map.put("choi", new JuO());

		String key = "kyeong";
		if (map.containsKey(key)) { //���࿡ ���� Ű�� ������ �ִٸ�
			Person p = map.get(key); //p ��ü������
			System.out.println(p.execute());// execute : method ������
		}

	}// useInterface

	/**
	 * �������̽��� ������� �ʰ� Map���� �����
	 */
	public void notUseInterface() {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("kang", new Soye());
		map.put("kyeong", new JaeHyeon());
		map.put("choi", new JuO());

		String key = "kang";

		// interface�� �������� ���� ��쿡�� Ű�� ���Ͽ� �� ��ü�� Casting �� ����ؾ� �Ѵ�.
		if ("kang".equals(key)) {
			Soye so = (Soye) map.get(key);
			System.out.println(so.execute());
		}
		if ("choi".equals(key)) {
			JuO j = (JuO) map.get(key);
			System.out.println(j.execute());
		}
		if ("kyeong".equals(key)) {
			JaeHyeon je = (JaeHyeon) map.get(key);
			System.out.println(je.execute());
		}

	}// notUseInterface

	public static void main(String[] args) {
		new UsePerson().notUseInterface();
		System.out.println("--------------------    interface ���          ---------------------------");
		new UsePerson().useInterface();
	}
}
