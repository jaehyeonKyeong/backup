package day0403;

/**
 *	�л��� ������ ���ϴ� ��
 * @author owner
 */
public class StudentScoreBak {
	
	public void printScore(int[][] Score, String[] name) {
		
		System.out.println("��ȣ\t�̸�\t�ڹ�\t����Ŭ\tJSP\t����\t���");
		System.out.println("==================================");
		int studentTotal=0;
		int[] subjectTotal =null;
		subjectTotal = new int[Score[0].length];
		
		
		for(int cnt=0;cnt<Score.length;cnt++) {
			System.out.printf("%d\t%s\t",cnt+1,name[cnt]);
			studentTotal=0;
			for(int sub=0;sub<Score[cnt].length;sub++) {
				System.out.printf("%d\t",Score[cnt][sub]);
				subjectTotal[sub]+=Score[cnt][sub];
				studentTotal+=Score[cnt][sub];
			}
			System.out.printf("%4d\t%.1f\n",studentTotal,(double)studentTotal/Score[0].length);
		}
		
	}// printScore

	public static void main(String[] args) {
		
		String[] names = {"�̻���","���¹�","������","������","������","�赿��"};
		int[][] score = {{84,88,86},{63,61,69},{72,77,72},{98,100,100},{91,64,89},{68,79,84}};
		StudentScoreBak ss = new StudentScoreBak();
		ss.printScore(score, names);

	}//main

}//class
