package day0405;

public class Chicken implements Fly{
	
	@Override
	public String speed() {
		return "´ßÀº ´À¸®°Ô ³­´Ù.";
	}

	@Override
	public String height() {
		return "´ßÀº ³·°Ô ³­´Ù.";
	}


	public static void main(String[] args) {
		Chicken chic = new Chicken();
		System.out.println(chic.speed());
		System.out.println(chic.height());
		

	}

	
}
