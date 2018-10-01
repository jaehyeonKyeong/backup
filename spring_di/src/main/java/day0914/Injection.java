package day0914;

public class Injection {
	private Data data;
	private String inputdate;
	public Injection(Data data) {
		super();
		this.data = data;
		System.out.println("Data를 받는 생성자 의존성 주입");
	}
	public Injection(Data data, String inputdate) {
		super();
		this.data = data;
		this.inputdate = inputdate;
		System.out.println("Data와 inputdate를 받는 생성자 의존성 주입");
	}
	
	public void setData(Data data) {
		this.data = data;
		System.out.println("method 의존성 주입");
	}
	public Injection() {
		super();
		System.out.println("injection의 기본생성자 호출");
	}
	
	public Data getData() {
		return data;
	}
	public String getInputdate() {
		return inputdate;
	}
	
	
}
