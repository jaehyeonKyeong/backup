package day0326;

/**
 * ���� if���� ����� �ڵ�<br>
 * ����)<br> if( ���ǽ�){<br>
 * 				���ǿ� ������ ����� �ڵ�;<br>
 * 			} <br><br>
 * main method�� arguments�� �޾Ƽ� ó���ϴ� ���α׷�<br>
 * ����) java TestWork ����� �̸� ��ǰ�� ����
 * @author owner
 */
public class TestWork {
	
	public static void main(String[] args) {
		int price=0;
		double sale=0.9;
		
		//Ư�� ȸ���� ��쿡�� �������� ����ȴ�.
		if(args[0].equals("Ư��")) {
			sale=0.7;//����ô� ������ �� �ִ�.
		}//end if
		price=Integer.parseInt(args[3]);
		
		System.out.println(args[1]+" ȸ������ �� ����� "+args[0]+"�̸� "+ args[2]+" ��ǰ�� ������ "+args[3]+"������ ���ε� ������ "+(int)(price*sale)+"���Դϴ�.");
	}//main

}//class
