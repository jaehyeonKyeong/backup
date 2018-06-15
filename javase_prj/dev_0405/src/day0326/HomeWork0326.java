package day0326;

public class HomeWork0326 {
	public static final int BUS_COST=1200;
	public static final int SUBWAY_COST=1250;
	public static final int TAXI_COST=3000;

	public static void main(String[] args) {
		int distance = Integer.parseInt(args[1]);
		int add = (distance > 10) ? (distance - 6) / 5 * 100 : 0;	
		if (args[0].equals("버스")) {
			int totalBusCost=BUS_COST+add;
			System.out.println(args[0] + "는 편도요금 " + totalBusCost + "원 왕복요금 " + (totalBusCost * 2));
			System.out.println("한달 20일 기준 교통비 " + totalBusCost * 2 * 20 + "원");
		} else if (args[0].equals("지하철")) {
			int totalSubwayCost=SUBWAY_COST+add;
			System.out.println(args[0] + "는 편도요금 " + totalSubwayCost + "원 왕복요금 " + (totalSubwayCost * 2));
			System.out.println("한달 20일 기준 교통비 " + totalSubwayCost * 2 * 20 + "원");
		} else if (args[0].equals("택시")) {
			System.out.println(args[0] + "는 편도요금 " + TAXI_COST + "원 왕복요금 " + (TAXI_COST * 2));
			System.out.println("한달 20일 기준 교통비 " + TAXI_COST * 2 * 20 + "원");
		} else {
			System.out.println("당신은 황족!!");
		}

	}

}
