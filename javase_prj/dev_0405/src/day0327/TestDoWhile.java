package day0327;

/**
 *	 do~while : ���۰� ���� �� �� ����ϴ� �ݺ��� <br>
 *	�ּ� 1�� ����, �ִ� ���Ǳ��� ����<br>
 *	����) do{ <br>
 *				�ݺ��� �ڵ�;<br>
 *				} while (���ǽ�);<br>
 * @author owner
 */
public class TestDoWhile {

	public static void main(String[] args) {
		int i=100;
		do {
			System.out.println(i);
			i++;
		} while(i<10);
		
		
		///���ѷ���
		do {
			System.out.println(i);
			i++;
		} while(true);
		

	}//main

}//class
