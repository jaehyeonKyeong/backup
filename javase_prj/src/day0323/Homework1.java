package day0323;
class Homework1{
	public static void main(String[] args){
		
		System.out.println("============숙제 1=============");
		int price = Integer.parseInt(args[3]);
		System.out.println();
		if(args[1].equals("특별")){
			System.out.println(args[0]+"님 "+args[1]+"등급으로 "+args[2]+" 상품을 정가 " +price+"원에서 할인받아 결재금액 "+(int)(price*0.7)+"원입니다.");
		}
		if(args[1].equals("일반")){
			System.out.println(args[0]+"님 "+args[1]+"등급으로 "+args[2]+" 상품을 정가 " +price+"원에서 할인받아 결재금액 "+(int)(price*0.9)+"원입니다.");
		}


	}
}
