package day0402;

/**
 *	�迭�� �⺻�� ���� ��� <br>
 *	��������[] �迭�� = {��,��,.................}; <br>
 * @author owner
 */
public class UseArray1_1 {
	
	public UseArray1_1() {
		//1. ����
		int[] score = {85,79,100,69,98,50};
		String[] name = {"������","���¹�","������","�赿��","�����","���ֿ�"};
		// �⺻������ �����ϴ��� ���� �Ҵ�ȴ�
		score[5]=66;
		System.out.println("��ȣ\t�̸�\t\tjava����");
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
		System.out.printf("�� �����ο�[%d��]\n",score.length);
		System.out.printf("����[%d��]\t���[%.2f]\n",total,(double)total/score.length);
		System.out.printf("�ְ���[%d]\t������[%d]\n",topScore,bottomScore);
		
		//////////////////////////////////����//////////////////////////////////////
		int temp=0;
		
		for(int i=0;i<score.length-1;i++) { // ���������� ���� �ʿ䰡 ����
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
		System.out.println("��ȣ\t�̸�\t\tjava����");
		System.out.println("=================");
		for(int i=0;i<score.length;i++) {
			System.out.printf("%-4d\t",score[i]);
		}
		System.out.printf("�ְ���[%d]\t������[%d]\n",score[0],score[5]);
		
		
	}//UseArray1_1

	public static void main(String[] args) {
		new UseArray1_1();

	}//main

}//class
