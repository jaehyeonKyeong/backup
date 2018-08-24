package day0731;

public class CounterVO {
	private int count;
	
	public CounterVO() {
		count=0;
		System.out.println("기본생성자");
	}//CounterVO

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count += count;
	}
	
	
	
}
