package day0402;

/**
 * �迭�� �⺻�� ���� ���<br>
 * ��������[] �迭��={��,...,��}
 * 
 * @author owner
 */
public class UseArray1_1 {
	public UseArray1_1() {
		// 1.����:
		int[] score = { 85, 79, 90, 69, 98, 50 };
		String[] name = { "�����", "��", "��", "��", "����", "��" };
		// �⺻������ �����ϴ��� ���� �Ҵ�ȴ�.
		score[5] = 50;
		// ��� ���� �� ���
		System.out.println("��ȣ\t�̸�\tjava ����");
		System.out.println("===========================");
		int total = 0;
		int topScore = score[0];
		int worstScore = score[0];

		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d\t%s\t%d\n", i + 1, name[i], score[i]);
			total += score[i];
			if (topScore < score[i]) {
				topScore = score[i];
			}
			if (worstScore > score[i]) {
				worstScore = score[i];
			}
		}
		System.out.println("-------------------------");
		System.out.printf("�� �����ο�[%d��]\n", score.length);
		System.out.printf("����[%d��]\t���[%.2f]\n", total, (double) total / score.length);
		System.out.printf("�ְ���[%d��]\t������[%d��]\n", topScore, worstScore);

		int temp = 0;
		for (int i = 0; i < score.length - 1; i++) {// ���� ������ ���� ���� �ʿ䰡 ������ length-1
			for (int j = i + 1; j < score.length; j++) {
				if (score[i] < score[j]) {// �չ�<�޹� ��������,�չ� >�޹� ��������
					temp = score[i];
					score[i] = score[j];
					score[j] = temp;
				}
			}
		}
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%-4d", score[i]);
		}
	}// ������

	public static void main(String[] args) {
		new UseArray1_1();
	}
}
