package day0330;

/**
 * ������ 5���� ������ ���ؼ� instance������ �����ϰ� instance������ ���� ��� ���� �ϴ� method�� ���� �Ͽ� 5���� �� �� ����� ���
 * @author owner
 */
public class Homework {
	private int sum;
	public void multi(int num) {
		for(int i=1;i<10;i++) {
			this.sum+=(num*i);
		}
	}
	public int getSum() {
		return sum;
	}
	public static void main(String[] args) {
		int num=5;
		Homework h=new Homework();
		h.multi(num);
		System.out.println(h.getSum());
	}

}
