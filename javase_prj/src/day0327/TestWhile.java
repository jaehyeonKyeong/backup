package day0327;

/**
 * while : ���۰� ���� �� �� ���� �� ����ϴ� �ݺ���(�ݺ� Ƚ���� �𸦶� ���)<br>
 * ����)<br>
 * �ʱⰪ; while(���ǽ�){<br>
 * �ݺ����� ����;<br>
 * ������; }<br>
 * 
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {
		
		//while �⺻
		int i = 0;//�ʱⰪ
		//�ּ� 0�� ����, �ִ� ���Ǳ��� ����
		while (i < 10) {//���ǽ�
			System.out.println("i : "+i);//�ݺ�����
			i++;//������
		} // end while
		
		//���� loop
		while(true) {
			System.out.println("����");
			break;
		}
		System.out.println();
		
		

	}// main

}// class
