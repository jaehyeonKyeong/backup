package day0418;

import static java.lang.Integer.parseInt;

/**
 * JVM�� �ڵ����� ����ó���� ���ִ� RuntimeException���
 * @author owner
 */
public class UseRuntimeException {
	
	public static void main(String[] args) {
		//main method���� ���������� arguments�� �ΰ� �޾Ƽ�
		//���ڷ� ��ȯ �� ������ ���� ����
		try {
		int num1=parseInt(args[0]);
		int num2=parseInt(args[1]);
		
		int result = num1/num2;
		
		System.out.println(num1+"/"+num2+"="+result);
		}catch(ArrayIndexOutOfBoundsException aioobe) {
			System.err.println("��뿹) java UseRuntimeException ��1 ��2");//err = ���������� ���ڰ� ����
		}catch(NumberFormatException nfe) {
			System.err.println("���� �������¿��� �մϴ�");
			System.out.println("������ �޼���:"+nfe.getMessage());
			System.out.println("���ܹ߻� Ŭ������, �޽���: "+nfe);
			nfe.printStackTrace();//method��ü�� ������ش�
		}catch(ArithmeticException ae) {
			System.err.println("0���δ� ������ �����ϴ�");
		}catch(Exception e) {
			System.err.println("�����ڰ� �������� ���� ����");
		}finally{
			System.out.println("�ݵ�� ����Ǿ���� �ڵ�");
		}
		
		
	}

}
