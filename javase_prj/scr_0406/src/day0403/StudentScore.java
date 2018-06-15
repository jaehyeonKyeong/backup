package day0403;

/**
 *	학생의 점수를 구하는 일
 * @author owner
 */
public class StudentScore {
	
	
	public static void main(String[] args) {
		
		String[] names = {"이상훈","지승민","장현준","이종민","신종성","김동희"};
		int[][] score = {{84,88,86},{63,61,69},{72,77,75},{98,100,100},{91,64,89},{68,79,84}};
		PrintScore ps = new PrintScore(score,names);
		ps.printAllScore();
		
		//개별method를 main에서 호출
		ps.lastRank();
		//array 반환형태 method를 main에서 호출
		int [] temp= ps.testScore();
		System.out.print("마지막 학생의 점수 오름차순 정렬 출력 : ");
		for(int i : temp) {
			System.out.printf("%-5d",i);
		}
		System.out.println();
	}//main

}//class
