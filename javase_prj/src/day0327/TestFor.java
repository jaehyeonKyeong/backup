package day0327;

/**
 * for ���۰� ���� �˶� ����ϴ� �ݺ���<br>
 * ����) <br>
 * for(�ʱⰪ; ���ǽ�; ����.���ҽ�;){<br>
 * �ݺ����� �����;<br>
 * }
 * 
 * @author owner
 */
public class TestFor {

	public static void main(String[] args) {

		// for �⺻
		for (int i = 0; i < 10; i++) {
			System.out.println("i=" + i);
		} // end for

		// 1~100���� ������ ���
		for (int i = 1; i <= 100; i++) {
			System.out.print(i + " ");
		} // end for

		// 1~100���� Ȧ����
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1) {
				System.out.print(i + " ");
			} // end if
		} // end for
		System.out.println();
		for (int i = 1; i <= 100; i += 2) {
			System.out.print(i + " ");
		} // end for
		System.out.println();

		// 1~100���� ¦�� ���
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			} // end if
		} // end for
		System.out.println();

		// 1~100���� ������ : 5050���
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println();

		// 1~100���� ��� : 3�� ����� �ڼ�
		for (int i = 1; i < 101; i++) {
			if (i % 3 == 0) {
				System.out.print("¦ ");
			} else {
				System.out.print(i + " ");
			} // end else
		} // end for

		///////////////////////// ����for/////////////////////
		System.out.println("============����for===========");
		// ����for �⺻
		for (int i = 0; i < 5; i++) {// �ٱ� for
			for (int j = 0; j < 6; j++) {// ����for
				System.out.println("i= " + i + " | j= " + j);
			} // end ���� for
			System.out.println("----------------------------");
		} // end �ٱ� for
		System.out.println();
		// 9*9��
		for (int i = 2; i < 10; i++) {
			System.out.println(i + "��");
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			} // end for
			System.out.println("------------------------");
		} // end for

		///////////////// �ʱⰪ�� �������� for///////////////////

		for (int i = 0, j = 10, k = 5; i < 10; i++, j--, k *= 5) {
			System.out.println("i : " + i + ", j : " + j + ", k : " + k);
		} // end for

		/////////////////// ���� loop////////////////
		for (;;) { // �����ϴ� ���� �������ϴ� for
			System.out.println("����");
			break;
		}//end for
		for (int i = 0;; i++) {// �����ϴ� ���� ���� for
			System.out.println(i);
			if (i == 5)
				break;
		}//end for
		System.out.println("____________________________");
		
		////////////////////// �ݺ����� ���� �ǳ� �ٱ� (continue)//////////////
		for(int i=0; i<50; i++) {
			if(i%2==1) {//Ȧ���� ��� �ݺ����� ������ �ǳ� �ڴ�.
				continue;
			}//endif
			System.out.println(i+" ");
		}//end for

	}// main

}// class
