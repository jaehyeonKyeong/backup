package day0403;

/**
 * �л��� ������ ���ϴ� ��
 * 
 * ����1. �Ʒ��� ��� �۾��� method�� ���� �Ͽ� �ʸ��Ѵ�
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
		System.out.println("��ȣ\t�̸�\t�ڹ�\t����Ŭ\tJSP\t����\t���");
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
			System.out.printf("%d\t%.1f\n",stuTot,stuAvg);//����1-1 ��� ���ϱ�
			stuTot=0;
			stuAvg=0;
			
		}//endfor
		System.out.println("--------------------------------------------------");
		System.out.printf("���� ����\t\t%d\t%d\t%d\t%d\t%.1f\n",javatot,oracletot,jsptot,tot,avgtot);
		System.out.printf("���� ���\t\t%.1f\t%.1f\t%.1f\n",(float)javatot/score.length,(float)oracletot/score.length,(float)jsptot/score.length);
		System.out.printf("�����ο�[%d��]\n",score.length);//
		System.out.printf("1�� \t\t%s\t%d\t%d");//1���л��� �̸��� ��ȣ ����
		System.out.printf("�ڹٰ���1������\t\t%d\n");//�ڹٰ����� 1�� ����
		System.out.println();//������ ��� �л� ���� �������� ���� ���
		
		
	}//printScore
	public static void main(String[] args) {
		String[] names= {"�̻���","���¹�","������","������","������","�赿��"};
		int[][] score= {{84,88,86},{63,61,69},{72,77,75},{98,100,100},{91,64,89},{68,79,84}};
		
		StudentScore ss=new StudentScore();
		ss.printScore(score, names);
		
	}

}
