package day0404;

import day0330.Person;

public class HongGilDong extends Person {

	@Override
	public String eat() {
		return getName() + "이 집에서 밥을 먹는다";
	}

	@Override
	public String eat(String menu, int price) {
		// TODO Auto-generated method stub
		return getName() + "이 밖에서" + menu + "를 " + price + "원 주고 사먹는다";
	}

	@Override
	public String[] language() {
		return "한국어,중국어,수화".split(",");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person hgd = new HongGilDong();
		hgd.setName("홍길동");
		System.out.println(hgd.eat());
		String[] lang = null;
		lang = hgd.language();
		System.out.println(hgd.getName()+"이 구사하는 언어");
		
		for(String value : lang) {
			System.out.println(value);
		}

	}

	public String fight(int i) {
		// TODO Auto-generated method stub
		return "짱쌤";
	}

	public String getLevel() {
		// TODO Auto-generated method stub
		return null;
	}

}
