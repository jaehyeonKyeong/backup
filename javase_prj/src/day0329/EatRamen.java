package day0329;

public class EatRamen {

	public static void main(String[] args) {
		Ramen sin=new Ramen();
		sin.setName("신라면");
		sin.setTaste("매운");
		sin.setPack("컵라면");
		sin.setPay(1000);
		System.out.println(sin.boldEat());
		System.out.println(sin.brokenEat());
		sin.info();
		
		new Ramen();
		
	}

}
