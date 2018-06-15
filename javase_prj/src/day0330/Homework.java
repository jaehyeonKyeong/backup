package day0330;

/**
 * 구구단 5단의 총합을 구해서 instance변수에 저장하고 instance변수에 값을 얻는 일을 하는 method를 정의 하여 5단의 총 합 결과를 출력
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
