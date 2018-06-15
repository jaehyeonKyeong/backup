package cap_05;

import java.util.Scanner;

public class ex09 {

	private static Scanner scanner;

	public static void main(String[] args) {
		boolean run=true;
		int[] score= null;
		scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("----------------------------------------------------------------");			
			System.out.println("1. 학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");			
			System.out.println("----------------------------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo=scanner.nextInt();
			
			if(selectNo==1) {
				System.out.print("학생수> ");
				int studentNumber=scanner.nextInt();
				score= new int[studentNumber];			
			}else if(selectNo==2) {
				int i=0;
				for (int j = 0; j < score.length; j++) {
					System.out.print("score["+i+"]> ");
					int inputScore=scanner.nextInt();
					score[i]=inputScore;
					i++;
				}
				
			}else if(selectNo==3) {
				int i=0;
				for(int eachScore : score) {
					System.out.println("score["+i+"]> "+eachScore);
					i++;
				}
				
			}else if(selectNo==4) {
				int i=0;
				int max=0;
				int sum=0;
				for(int eachScore : score) {
					if(eachScore>max)max=eachScore;
					sum+=eachScore;
					i++;
				}
				System.out.println("최고 점수: "+max);
				System.out.println("평균 점수: "+(double)sum/i);
				
				
			}else if(selectNo==5) {
				run=false;
			}//end if~else
		}//end while

	}//main

}//class
