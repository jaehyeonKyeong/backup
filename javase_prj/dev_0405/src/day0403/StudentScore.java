package day0403;

/**
 *	�л��� ������ ���ϴ� ��
 * @author owner
 */
public class StudentScore {
	
	
	public static void main(String[] args) {
		
		String[] names = {"�̻���","���¹�","������","������","������","�赿��"};
		int[][] score = {{84,88,86},{63,61,69},{72,77,75},{98,100,100},{91,64,89},{68,79,84}};
		PrintScore ps = new PrintScore(score,names);
		ps.printAllScore();
		
		//����method�� main���� ȣ��
		ps.lastRank();
		//array ��ȯ���� method�� main���� ȣ��
		int [] temp= ps.testScore();
		System.out.print("������ �л��� ���� �������� ���� ��� : ");
		for(int i : temp) {
			System.out.printf("%-5d",i);
		}
		System.out.println();
	}//main

}//class
