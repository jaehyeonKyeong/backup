package day0403;

/**
 * 학생의 점수를 구하는 일
 * 
 * 숙제1. 아래의 모든 작업은 method로 정의 하여 초리한다
 * @author owner
 */
public class StudentScore {
	private int tot=0;
	private double avgtot=0;
	private int stuTot=0;
	private float stuAvg=0;
	private int javatot=0;
	private int oracletot=0;
	private int jsptot=0;
	public void stuTotal(int score) {
		stuTot+=score;
		tot+=score;
	}//stuTotal
	public void stuAverg() {
		stuAvg=(float)stuTot/3;
	}
	public void javaTotal(int score) {
		javatot+=score;
	}
	public void oracleTotal(int score) {
		oracletot+=score;
	}
	public void jspTotal(int score) {
		jsptot+=score;
	}
	public void avgTotal() {
		avgtot+=stuAvg;
	}
	
	public void printScore(int[][] score,String[]names) {
		System.out.println("번호\t이름\t자바\t오라클\tJSP\t총점\t평균");
		System.out.println("===================================================");
		for(int i=0;i<score.length;i++) {
			System.out.printf("%d\t%s\t",i+1,names[i]);
			for(int j=0;j<score[i].length;j++) {
				stuTotal(score[i][j]);
				System.out.printf("%d\t",score[i][j]);
			}//endfor
			stuAverg();
			avgTotal();
			javaTotal(score[i][0]);
			oracleTotal(score[i][1]);
			jspTotal(score[i][2]);
			System.out.printf("%d\t%.1f\n",stuTot,stuAvg);//숙제1-1 평균 구하기
			stuTot=0;
			stuAvg=0;
			
		}//endfor
		System.out.println("--------------------------------------------------");
		System.out.printf("과목별 총점\t\t%d\t%d\t%d\t%d\t%.1f\n",javatot,oracletot,jsptot,tot,avgtot);
		System.out.printf("과목별 평균\t\t%.1f\t%.1f\t%.1f\n",(float)javatot/score.length,(float)oracletot/score.length,(float)jsptot/score.length);
		System.out.printf("응시인원[%d명]\n",score.length);//
		System.out.printf("1등 \t\t%s\t%d\t%d");//1등학생의 이름과 번호 총점
		System.out.printf("자바과목1등점수\t\t%d\n");//자바과목의 1등 점수
		System.out.println();//마지막 등수 학생 점수 오름차순 정렬 출력
		
		
	}//printScore
	public static void main(String[] args) {
		String[] names= {"이상훈","지승민","장현준","이종민","신종성","김동희"};
		int[][] score= {{84,88,86},{63,61,69},{72,77,75},{98,100,100},{91,64,89},{68,79,84}};
		
		StudentScore ss=new StudentScore();
		ss.printScore(score, names);
		
	}

}
