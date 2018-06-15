package day0404;

import day0330.Person;
import day0405.Fly;

public class Clark extends Person implements Fly {

	public int power;
	
	public Clark() {
		power=10;
	}
	
	
	@Override
	public String speed() {
		return getName()+"은 빠르게 난다";
	}
	
	@Override
	public String height() {
		return getName()+"은 높이 난다";
	}
	
	@Override
	public String eat() {
		// TODO Auto-generated method stub
		return getName()+"은 집에서 밥을 먹는다";
	}
	
	@Override
	public String eat(String menu, int price) {
		// TODO Auto-generated method stub
		return getName()+"은 밖에서"+menu+"를 "+price+"원으로 사먹는다";
	}
	
	@Override
	public String[] language() {
		return "한국어,중국어,수화".split(",");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	public String stoneType(String string) {
		// TODO Auto-generated method stub
		return null;
	}



}
