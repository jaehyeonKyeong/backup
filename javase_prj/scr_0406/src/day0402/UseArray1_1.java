package day0402;

/**
 *	배열의 기본형 형식 사용 <br>
 *	데이터형[] 배열명 = {값,값,.................}; <br>
 * @author owner
 */
public class UseArray1_1 {
	
	public UseArray1_1() {
		//1. 선언
		int[] score = {85,79,100,69,98,50};
		String[] name = {"이종민","지승민","이진영","김동휘","김대현","최주오"};
		// 기본형으로 선언하더라도 값이 할당된다
		score[5]=66;
		System.out.println("번호\t이름\t\tjava점수");
		System.out.println("=================");
		int total=0;
		int topScore=score[0];
		int bottomScore=score[0];
		for(int i=0;i<score.length;i++) {
			total+=score[i];
			if(topScore<score[i]) {
				topScore=score[i];
			}
			if(bottomScore>score[i]) {
				bottomScore=score[i];
			}
			System.out.printf("%d\t%s\t%d\n",i+1,name[i],score[i]);
		}
		System.out.println("-----------------------------");
		System.out.printf("총 응시인원[%d명]\n",score.length);
		System.out.printf("총점[%d점]\t평균[%.2f]\n",total,(double)total/score.length);
		System.out.printf("최고점[%d]\t최하점[%d]\n",topScore,bottomScore);
		
		//////////////////////////////////정렬//////////////////////////////////////
		int temp=0;
		
		for(int i=0;i<score.length-1;i++) { // 마지막방은 비교할 필요가 없다
			for(int j=i+1;j<score.length;j++) {
				if(score[i]<score[j]) {
					temp=score[i];
					score[i]=score[j];
					score[j]=temp;
					}
			}
		}
		
//		for(int i=1;i<score.length;i++) {
//			for(int j=0;j<score.length-i;j++) {
//				if(score[j]<score[j+1]) {
//					temp=score[j];
//					score[j]=score[j+1];
//					score[j+1]=temp;
//					}
//			}
//		}
		System.out.println("번호\t이름\t\tjava점수");
		System.out.println("=================");
		for(int i=0;i<score.length;i++) {
			System.out.printf("%-4d\t",score[i]);
		}
		System.out.printf("최고점[%d]\t최하점[%d]\n",score[0],score[5]);
		
		
	}//UseArray1_1

	public static void main(String[] args) {
		new UseArray1_1();

	}//main

}//class
