package day0403;

public class PrintScore {
	private int[][] score = null;
	private String[] name = null;
	private int subjectCount;
	private int total;
	private int[] studentTotal=null;
	private int[] subjectTotalArray =null;
	//생성자
	public PrintScore(int[][] score, String[] name) {
		this.score = score;
		this.name = name;
		subjectCount = score[0].length;
	}
	//전체 출력 method
	public void printAllScore() {
		// 모두 method를 구현하여 작성
		studentTotal=new int[score.length];
		System.out.println("번호\t이름\t자바\t오라클\tJSP\t총점\t평균");
		System.out.println("==================================");

		for (int cnt = 0; cnt < score.length; cnt++) {
			System.out.printf("%d\t%s\t", cnt + 1, name[cnt]);
			studentTotal[cnt] = 0;
			for (int sub = 0; sub < score[cnt].length; sub++) {
				System.out.printf("%d\t", score[cnt][sub]);
				studentTotal[cnt] += score[cnt][sub];
			}
			System.out.printf("%4d\t%.1f\n", studentTotal[cnt], studentAverage(studentTotal[cnt], score[cnt])); // 숙제 1-1. 평균을 구하시오
		}
		System.out.println("--------------------------------------------------------");
		System.out.printf("응시인원 [%d]명\n", score.length);
		// 1-2. 과목별 총점, 전체 총점, 전체 평균
		subjectTotal();
		// 1-3. 과목별평균
		subjectAverage();
		// 1-4. 1등학생의 이름과 번호, 총점, 평균
		firstRank();
		// 1-5. 자바과목의 1등 점수
		javaMax();
		// 1-6. 마지막등수 학생의 점수를 오름차순 정렬 출력
		lastRank();
		// 1-6 
		System.out.print("마지막 학생의 점수 오름차순 정렬 출력 : ");
		for(int i : testScore()) {
			System.out.printf("%-5d",i);
		}
		System.out.println();
	}// PrintAllScore
	
	//평균 method
	public double studentAverage(int studentTotal,int[] score) {
		return (double)studentTotal/score.length;
	}
	
	//과목별 총점,전체 총점, 전체 평균 method
	public void subjectTotal() {
		subjectTotalArray = new int[subjectCount];
		total=0;
		for (int cnt = 0; cnt < score.length; cnt++) {
			for (int sub = 0; sub < score[cnt].length; sub++) {
				subjectTotalArray[sub] += score[cnt][sub];
			}
		}
		System.out.println("\t\t\t자바\t오라클\tJSP\t총점\t평균");
		System.out.printf("과목별 총점\t");
		for(int sub=0;sub < subjectCount; sub++) {
			System.out.printf("\t%d",subjectTotalArray[sub]);
			total+=subjectTotalArray[sub];
		}
		System.out.printf("\t%d\t%.2f\n",total,(double)total/subjectCount);
	}
	
	//과목별 평균 method
	public void subjectAverage() {
		System.out.printf("과목별 평균\t");
		for(int sub=0;sub < subjectCount; sub++) {
			System.out.printf("\t%.2f",(double)subjectTotalArray[sub]/score.length);
		}
		System.out.printf("\t%.2f\n",(double)total/subjectCount);
	}
	
	//1등학생 번호,이름,총점,평균 method
	public void firstRank(){
		int temp=0;
		int firstCnt=0;
		for (int cnt = 0; cnt < score.length; cnt++) {
			if(studentTotal[cnt]>temp) {
				temp=studentTotal[cnt];
				firstCnt=cnt;
			}
		}
		System.out.printf("1등\t\t%d번\t%s\t총점[%d]\t평균[%.2f]\n",firstCnt+1,name[firstCnt] ,temp,(double)temp/subjectCount);
	}
	
	// 자바1등 점수 method
	public void javaMax() {
		int temp=0;
		for(int i=0;i<score.length;i++) {
			if(score[i][2]>temp) {
				temp=score[i][2];
			}
		}
		System.out.printf("자바과1등점수 \t\t%d\n", temp);
	}
	
	//마지막 학생 점수 오름차순 출력 method
	public void lastRank() {
		int lastCnt=0;
		int compare=Integer.MAX_VALUE;
		for (int cnt = 0; cnt < score.length; cnt++) {
			if(studentTotal[cnt]<compare) {
				compare=studentTotal[cnt];
				lastCnt=cnt;
			}
		}
		int temp=0;
		for(int i=0;i<subjectCount;i++) {
			for(int j=i+1;j<subjectCount;j++) {
				if(score[lastCnt][i]>score[lastCnt][j]) {
					temp=score[lastCnt][i];
					score[lastCnt][i]=score[lastCnt][j];
					score[lastCnt][j]=temp;
				}
			}
		}
		System.out.print("마지막 학생의 점수 오름차순 정렬 출력 : ");
		for(int sub=0;sub<subjectCount;sub++) {
			System.out.printf("%-5d",score[lastCnt][sub]);
		}
		System.out.println();
	}
	
	//마지막 학생 점수 오름차순 출력 method - array 반환
	public int[] testScore() {
		int lastCnt=0;
		int compare=Integer.MAX_VALUE;
		for (int cnt = 0; cnt < score.length; cnt++) {
			if(studentTotal[cnt]<compare) {
				compare=studentTotal[cnt];
				lastCnt=cnt;
			}
		}
		int temp=0;
		for(int i=0;i<subjectCount;i++) {
			for(int j=i+1;j<subjectCount;j++) {
				if(score[lastCnt][i]>score[lastCnt][j]) {
					temp=score[lastCnt][i];
					score[lastCnt][i]=score[lastCnt][j];
					score[lastCnt][j]=temp;
				}
			}
		}
		return score[lastCnt];
	}
}
