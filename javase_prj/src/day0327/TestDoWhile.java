package day0327;

/**
 * do~while : ���۰� ���� �� �� ����ϴ� �ݺ���<br>
 * �ּ� 1�� ���࿡ �ִ� ���Ǳ��� ����<br>
 * ����)<br>
 * 		�ʱⰪ;<br>
 * 		do{<br>
 * 			�ݺ����� ����;<br>
 * 			��,���ҽ�;<br>
 * 		}while(���ǽ�);<br>
 * 
 * @author owner
 */
public class TestDoWhile {
	
	public static void main(String[] args) {
		
		//do~while �⺻
		int i = 100; 
		do {
			System.out.println(i);
			i++;
		}while(i<10); // 100�� 10���� �������� ������ �ѹ��� ������ ������(������ ���߿� Ȯ���ϱ� ����)
		
		// do~while ����loop
		do {
			System.out.println("����");
			break;//���ѷ��� ���������� ����
		}while(true);
	}//main
	
}//class
