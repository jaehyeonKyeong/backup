package day0829;

import java.util.HashMap;
import java.util.Map;

public class UsePerson {

	/**
	 * 인터페이스를 사용하여 Map에서 값얻기
	 */
	public void useInterface() {
		// 객체다형성, override
		Map<String, Person> map = new HashMap<String, Person>();

		map.put("kang", new Soye());
		map.put("kyeong", new JaeHyeon());
		map.put("choi", new JuO());

		String key = "kyeong";
		if (map.containsKey(key)) { //만약에 맵이 키를 가지고 있다면
			Person p = map.get(key); //p 객체다형성
			System.out.println(p.execute());// execute : method 다형성
		}

	}// useInterface

	/**
	 * 인터페이스를 사용하지 않고 Map에서 값얻기
	 */
	public void notUseInterface() {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("kang", new Soye());
		map.put("kyeong", new JaeHyeon());
		map.put("choi", new JuO());

		String key = "kang";

		// interface를 구현하지 않은 경우에는 키를 비교하여 얻어낸 객체를 Casting 해 사용해야 한다.
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
		System.out.println("--------------------    interface 사용          ---------------------------");
		new UsePerson().useInterface();
	}
}
