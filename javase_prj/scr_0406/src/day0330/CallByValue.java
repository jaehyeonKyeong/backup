package day0330;

/**
 *	Call by value : method�� �Ű������� �⺻���� �����ϸ� �Է°��� ����Ǿ� �Ҵ�ȴ� <br>
 *	(���� ������ ����� ���� ������� �ʴ´�)
 * @author owner
 */
public class CallByValue {
	
	public void swap(int i, int j) {
		int temp=0;
		temp=i;
		i=j;
		j=temp;
		System.out.println("swap method  i= "+i+", j= "+j);
	}

	public static void main(String[] args) {
		
		CallByValue cbv = new CallByValue();
		int i=100,j=200; //���� ����
		System.out.println("swap ȣ�� ��  i= "+i+", j= "+j);
		cbv.swap(i, j); //���� ������ ���� ����Ǿ� ����
		// method �ȿ��� ����� ���� ���� ������ ������� �ʴ´�
		System.out.println("swap ȣ�� ��  i= "+i+", j= "+j);

		
	}

}
