package day0326;

public class Homework {
	public static final int BUS=1200;
	public static final int SUBWAY=1250;
	public static final int TAXI=3000;
	
	public static void main(String[] args) {
		int distance=Integer.parseInt(args[1]);
		
		
		int overPay=0;
		if(distance>10) {
			overPay=((distance-10)/5)*100;	
		}
		
		System.out.println(args[0]+"");
		
		if(args[0].equals("버스"))
			System.out.println(args[0]+"(은)는 편도요금 "+(BUS+overPay)+"원이고, 왕복요금 "+((BUS+overPay)*2)+"이고, 한달20일 기준 왕복교통비 "+(((BUS+overPay)*2)*20)+"원 입니다.");
		else if(args[0].equals("지하철"))
			System.out.println(args[0]+"(은)는 편도요금 "+(SUBWAY+overPay)+"원이고, 왕복요금 "+((SUBWAY+overPay)*2)+"이고, 한달20일 기준 왕복교통비 "+(((SUBWAY+overPay)*2)*20)+"원 입니다.");
		else if(args[0].equals("택시"))
			System.out.println(args[0]+"(은)는 편도요금 "+TAXI+"원이고, 왕복요금 "+TAXI*2+"이고, 한달20일 기준 왕복교통비 "+((TAXI*2)*20)+"원 입니다.");
		else if(args[0].equals("도보"))
			System.out.println("황족입니다.");
		
		
	}//main
}//class
