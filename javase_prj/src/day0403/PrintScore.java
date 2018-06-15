package day0403;

public class PrintScore {
	private int[][] score = null;
	private String[] name = null;
	private int subjectCount;
	private int total;
	private int[] studentTotal=null;
	private int[] subjectTotalArray =null;
	//������
	public PrintScore(int[][] score, String[] name) {
		this.score = score;
		this.name = name;
		subjectCount = score[0].length;
	}
	//��ü ��� method
	public void printAllScore() {
		// ��� method�� �����Ͽ� �ۼ�
		studentTotal=new int[score.length];
		System.out.println("��ȣ\t�̸�\t�ڹ�\t����Ŭ\tJSP\t����\t���");
		System.out.println("==================================");

		for (int cnt = 0; cnt < score.length; cnt++) {
			System.out.printf("%d\t%s\t", cnt + 1, name[cnt]);
			studentTotal[cnt] = 0;
			for (int sub = 0; sub < score[cnt].length; sub++) {
				System.out.printf("%d\t", score[cnt][sub]);
				studentTotal[cnt] += score[cnt][sub];
			}
			System.out.printf("%4d\t%.1f\n", studentTotal[cnt], studentAverage(studentTotal[cnt], score[cnt])); // ���� 1-1. ����� ���Ͻÿ�
		}
		System.out.println("--------------------------------------------------------");
		System.out.printf("�����ο� [%d]��\n", score.length);
		// 1-2. ���� ����, ��ü ����, ��ü ���
		subjectTotal();
		// 1-3. �������
		subjectAverage();
		// 1-4. 1���л��� �̸��� ��ȣ, ����, ���
		firstRank();
		// 1-5. �ڹٰ����� 1�� ����
		javaMax();
		// 1-6. ��������� �л��� ������ �������� ���� ���
		lastRank();
		// 1-6 
		System.out.print("������ �л��� ���� �������� ���� ��� : ");
		for(int i : testScore()) {
			System.out.printf("%-5d",i);
		}
		System.out.println();
	}// PrintAllScore
	
	//��� method
	public double studentAverage(int studentTotal,int[] score) {
		return (double)studentTotal/score.length;
	}
	
	//���� ����,��ü ����, ��ü ��� method
	public void subjectTotal() {
		subjectTotalArray = new int[subjectCount];
		total=0;
		for (int cnt = 0; cnt < score.length; cnt++) {
			for (int sub = 0; sub < score[cnt].length; sub++) {
				subjectTotalArray[sub] += score[cnt][sub];
			}
		}
		System.out.println("\t\t\t�ڹ�\t����Ŭ\tJSP\t����\t���");
		System.out.printf("���� ����\t");
		for(int sub=0;sub < subjectCount; sub++) {
			System.out.printf("\t%d",subjectTotalArray[sub]);
			total+=subjectTotalArray[sub];
		}
		System.out.printf("\t%d\t%.2f\n",total,(double)total/subjectCount);
	}
	
	//���� ��� method
	public void subjectAverage() {
		System.out.printf("���� ���\t");
		for(int sub=0;sub < subjectCount; sub++) {
			System.out.printf("\t%.2f",(double)subjectTotalArray[sub]/score.length);
		}
		System.out.printf("\t%.2f\n",(double)total/subjectCount);
	}
	
	//1���л� ��ȣ,�̸�,����,��� method
	public void firstRank(){
		int temp=0;
		int firstCnt=0;
		for (int cnt = 0; cnt < score.length; cnt++) {
			if(studentTotal[cnt]>temp) {
				temp=studentTotal[cnt];
				firstCnt=cnt;
			}
		}
		System.out.printf("1��\t\t%d��\t%s\t����[%d]\t���[%.2f]\n",firstCnt+1,name[firstCnt] ,temp,(double)temp/subjectCount);
	}
	
	// �ڹ�1�� ���� method
	public void javaMax() {
		int temp=0;
		for(int i=0;i<score.length;i++) {
			if(score[i][2]>temp) {
				temp=score[i][2];
			}
		}
		System.out.printf("�ڹٰ�1������ \t\t%d\n", temp);
	}
	
	//������ �л� ���� �������� ��� method
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
		System.out.print("������ �л��� ���� �������� ���� ��� : ");
		for(int sub=0;sub<subjectCount;sub++) {
			System.out.printf("%-5d",score[lastCnt][sub]);
		}
		System.out.println();
	}
	
	//������ �л� ���� �������� ��� method - array ��ȯ
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
