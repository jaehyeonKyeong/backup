package day0323;
class Homework0323 {
	public static void main(String[] args) {

		System.out.println("======================= 1 =======================");
		int price = Integer.parseInt(args[3]);
		int bill=(int)(price*9.0/10);
		if(args[0].equals("특별")){
			bill=(int)(bill*7.0/9);
		}
	
		System.out.println(args[1]+"님 "+args[0]+"등급으로 "+args[2]+"상품을 정가 "+price+"에서 할인 받아 결재금액"+bill+"원 입니다.");



		System.out.println("======================= 2 =======================");
		int num1 = Integer.parseInt(args[4]);
		int num2 = Integer.parseInt(args[5]);
		System.out.println("입력값1 :"+num1+", 입력값 2 : "+num2);
		if(num1<0){
			num1=-num1;
		}
		if(num2<0){
			num2=-num2;
		}
		System.out.println(num1+" AND "+num2+" = "+(num1&num2));




		System.out.println("======================= 3 =======================");
//		int max=(-1>>>1);
		int max=Integer.MAX_VALUE;
		int temp=max<<16;
		int result=temp>>>16;
		System.out.println("결과값은 : "+result);



	}
}
