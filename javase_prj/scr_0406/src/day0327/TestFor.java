package day0327;

/**
 * for : ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 * ����) for ( ���۰�; ����; ��.���ҽ�;){<br>
 * �ݺ����� �����.... ; <br>
 * }<br>
 * * @author owner
 */
public class TestFor {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println("���Ѻκ� ����?" + i);
		} // end for

		// 1~100���� ������ ���
		for (int i = 1; i < 101; i++) {
			System.out.print(i + " ");
		} // end for
		System.out.println();

		// 1~100���� Ȧ���� ������ ���
		for (int i = 1; i < 101; i = i + 2) {
			System.out.print(i + " ");
		} // end for
		System.out.println();

		// 1~100���� ¦���� ������ ���
		for (int i = 1; i < 101; i++) {
			if (i % 2 == 0)
				System.out.print(i + " ");
		} // end for
		System.out.println();

		// 1~100���� ������ ���
		int sum = 0;
		for (int i = 1; i < 101; sum += i++)
			;// end for
		System.out.println("1~100������ �������� " + sum);

		// 1~100���� ��� : 1 2 ¦ 4 5 ¦ 7 8.....
		for (int i = 1; i < 101; i++) {
			if (i % 3 == 0) {
				System.out.print("¦ ");
			} else {
				System.out.print(i + " ");
			}
		} // end for

		/////////////////////////////// ���� for////////////////////////////
		System.out.println("-----------------------------���� for-------------------------");
		for (int i = 0; i < 5; i++) {// �ٱ� for
			for (int j = 0; j < 6; j++) {// ���� for
				System.out.print("i=" + i + ", j=" + j + " / ");
			} // end for j
			System.out.println();
			System.out.println("--------------------------");
		} // end for i

		// ������
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + "*" + i + "=" + i * j + " \t");
			} // end for j
			System.out.println();
		} // end for i

		//////////////// �ʱⰪ�� �������� for /////////////////////////
		for (int i = 0, j = 10, k = 5; i < 10; i++, j--, k *= 5) {
			System.out.print("i: " + i + ",j= " + j + ", k= " + k + "   ");
		} // end for
		System.out.println();
		///////// ���� loop ////////////////////
		for (;;) {
			System.out.println("����");
			break;
		} // end for
		System.out.println("�ȳ�");

		for (byte i = 0;; i++) {// �����ϴ� ���� ���� for
			System.out.print(i+"  ");
			if (i == 5) {
				break;
			} // end if
		} // end for
		System.out.println();

		///// �ݺ����� ���� �ǳ� �ٱ�///////////
		for (int i = 0; i < 50; i++) {
			if (i % 2 == 1) {//Ȧ���� ��� �ݺ����� ������ �ǳʶ�
				continue;
			}//end if
			System.out.print(i+" ");
		} // end for
		System.out.println();
		
	}// main
}// class