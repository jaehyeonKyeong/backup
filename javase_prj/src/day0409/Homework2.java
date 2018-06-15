package day0409;

import java.util.Random;

public class Homework2 {
	public Homework2(int num) {
		Random r=new Random();
		int[][] lotto=null;
		lotto=new int[num][5];
		for(int i=0; i<lotto.length;i++) {
			for(int j=0; j<lotto[i].length;j++) {
				lotto[i][j]=r.nextInt(45)+1;
				System.out.printf("%d ",lotto[i][j]);
			}
			System.out.println();
		}//for
		
	}//constructor
}//class
