package day0330;

/**
 * method�� �Ű� ������ ��ü(class)�� parameter�� �����ϸ� �ϳ��� ��ü�� �����ǰ� �� �ּҰ� �״�� ���޵ȴ� <br>
 * ���������� ���� ����ȴ� <br>
 * @author owner
 */
public class CallByReference {
	
	private int i=0;
	private int j=0;
	
//	public void swap(CallByReference cbr) {//������ parameter
	
	public void swap() {//������ parameter -����
//		int temp=0;
//		temp=cbr.i;
//		cbr.i=cbr.j;
//		cbr.j=temp;
//		System.out.println("swap �� cbr.i = "+cbr.i+", cbr.j = "+cbr.j);
	
		int temp=0;
		temp=this.i;
		this.i=this.j;
		this.j=temp;
		System.out.println("swap �� this.i = "+this.i+", this.j = "+this.j);
	
	
	}

	public static void main(String[] args) {
		CallByReference cbr = new CallByReference();
		cbr.i=100;
		cbr.j=200;
		System.out.println("swap �� cbr.i = "+cbr.i+", cbr.j = "+cbr.j);
//		cbr.swap(cbr); //��ü�� �ϳ��� �����ǰ� �� �ּҰ� ���޵ȴ�
		cbr.swap(); //��ü�� �ϳ��� �����ǰ� �� �ּҰ� ���޵ȴ�
		//�ּҴ� �ϳ��� �����ǰ� ���� �ǹǷ� �ַθ� ���޹��� method �ȿ��� ���� �����ϸ� ���� ������ ������ ��ģ��
		System.out.println("swap �� cbr.i = "+cbr.i+", cbr.j = "+cbr.j);
		
		
		
		
		
		

	}

}
