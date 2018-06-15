package day0330;

/**
 * method�� �Ű������� class(��ü)�� parameter�� �����ϸ� �ϳ��� ��ü�� �����ǰ� �� �ּҰ� �״�� ���޵�.
 * ���� ������ ���� ����ȴ�
 * @author owner
 */
public class CallByReference {
	private int i;
	private int j;
	
	public void swap(CallByReference cbr) {//������ parameter
		int temp=0;
		temp=cbr.i;
		cbr.i=cbr.j;
		cbr.j=temp;
		System.out.println("swap ��  cbr.i= "+cbr.i+", cbr.j = "+cbr.j);
	}

	public static void main(String[] args) {
		CallByReference cbr=new CallByReference();
		cbr.i=100;
		cbr.j=200;
		System.out.println("swap ��  cbr.i= "+cbr.i+", cbr.j = "+cbr.j);
		cbr.swap(cbr);//��ü�� �ϳ��� �����ǰ� �� �ּҰ� ���޵ȴ�.
		//�ּҴ� �ϳ��� �����ǰ� ���� �ǹǷ� �ּҸ� ���޹��� method �ȿ��� ���� �����ϸ� ���� ������ ���� ����ȴ�.
		
		System.out.println("swap ��  cbr.i= "+cbr.i+", cbr.j = "+cbr.j);

	}

}
