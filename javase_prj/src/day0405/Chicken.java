package day0405;

public class Chicken implements Fly{

	@Override
	public String speed() {
		return "���� ������ ����";
	}//speed

	@Override
	public String height() {
		
		return "���� ���� ����";
	}//height
	public static void main(String[] args) {
		Chicken chic= new Chicken();
		System.out.println(chic.speed());
		System.out.println(chic.height());
	}
	
}
