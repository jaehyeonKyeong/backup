package day0326;

public class HomeWork0326 {
	public static final int BUS_COST=1200;
	public static final int SUBWAY_COST=1250;
	public static final int TAXI_COST=3000;

	public static void main(String[] args) {
		int distance = Integer.parseInt(args[1]);
		int add = (distance > 10) ? (distance - 6) / 5 * 100 : 0;	
		if (args[0].equals("����")) {
			int totalBusCost=BUS_COST+add;
			System.out.println(args[0] + "�� ����� " + totalBusCost + "�� �պ���� " + (totalBusCost * 2));
			System.out.println("�Ѵ� 20�� ���� ����� " + totalBusCost * 2 * 20 + "��");
		} else if (args[0].equals("����ö")) {
			int totalSubwayCost=SUBWAY_COST+add;
			System.out.println(args[0] + "�� ����� " + totalSubwayCost + "�� �պ���� " + (totalSubwayCost * 2));
			System.out.println("�Ѵ� 20�� ���� ����� " + totalSubwayCost * 2 * 20 + "��");
		} else if (args[0].equals("�ý�")) {
			System.out.println(args[0] + "�� ����� " + TAXI_COST + "�� �պ���� " + (TAXI_COST * 2));
			System.out.println("�Ѵ� 20�� ���� ����� " + TAXI_COST * 2 * 20 + "��");
		} else {
			System.out.println("����� Ȳ��!!");
		}

	}

}
