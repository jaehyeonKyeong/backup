package day0329;

public class EatRamen {

	public static void main(String[] args) {
		Ramen sin=new Ramen();
		sin.setName("�Ŷ��");
		sin.setTaste("�ſ�");
		sin.setPack("�Ŷ��");
		sin.setPay(1000);
		System.out.println(sin.boldEat());
		System.out.println(sin.brokenEat());
		sin.info();
		
		new Ramen();
		
	}

}
