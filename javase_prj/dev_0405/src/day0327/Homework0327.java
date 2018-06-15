package day0327;

public class Homework0327 {

	public static void main(String[] args) {
		System.out.println("===============숙제1==============");
		//숙제 1
		for(int i=0;i<4;i++) {
			for(int j=i+1;j<5;j++) {
				System.out.print(i+" "+j+"  ");
			}
			System.out.println();
		}
		
		System.out.println("===============숙제2==============");
		
		//숙제 2
		for(int i=0;i<4;i++) {
			for(int j=0;j<i+1;j++) {
				System.out.print(i+" "+j+"  ");
			}
			System.out.println();
		}

		//숙제 1	
		System.out.println("===============숙제1==============");
		int score=Integer.parseInt(args[0]);
		if(score<0 || score>100) {
			System.out.println("잘못된 점수입니다.");
		} else {
			System.out.print("점수 "+score+" : ");
			switch(score/20) {
			case 0:
			case 1:
				System.out.println("과락");
				break;
			case 2:
				System.out.println("다른과목 참조");
				break;
			default :
				System.out.println("합격");
				
			}//end switch 
		}//end if~else
		
		

		//숙제 2 A(65) a(97) 
		System.out.println("===============숙제2==============");
		int j1=0;
		for(int i=65;i<91;i++) {
			 j1=i+32;
			System.out.print((char)i+"("+i+")"+" ");
			System.out.print((char)j1+"("+j1+")"+" ");
			j1=0;
		}//end for
		System.out.println();
		

		//숙제 3 - 구구단
		System.out.println("===============숙제3==============");
		for(int i=1;i<10;i++) {
			for(int j=2;j<10;j++) {
				System.out.print(j+"x"+i+"="+i*j+" \t");
			}//end for j
			System.out.println();
		}//end for i
		
		

		//숙제 4
		System.out.println("===============숙제4==============");
		int count=0,sum=0;
		for(int i=1;i<1001;i++) {
			if(i%4==0) {
				count++;
				sum+=i;
			}//end if
		}//end for
		System.out.println("1~1000까지 4의 배수는 "+count+"개 있으며, 4의 배수의 합은 "+sum+"입니다");
		
		

		//숙제 5
		System.out.println("===============숙제5==============");
		int num1=Integer.parseInt(args[1]);
		if(num1>1 && num1 < 10) {
			int num2=1;
			while(num2<10) {
				System.out.println(num1+"x"+num2+"="+num1*num2);
				num2++;				
			}//end while
		}else {
			System.out.println("구구단은 2~9단 까지만 입력");
		}//end else
		

	}

}
