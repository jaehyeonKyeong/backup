package day0329;
//라면의 공통된 특징
// 이름, 맛, 가격, 포장 :
// 끓여서 먹다:
public class Ramen {
	private String name;
	private String taste;
	private int pay;
	private String pack;
	
	public Ramen() {//생성자
		this("신라면","매운","봉지라면");
	}
	public Ramen(String name, String taste,String pack) {//생성자 overload
		this.name=name;
		this.taste=taste;
		this.pack=pack;
		info();
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setTaste(String taste) {
		this.taste=taste;
	}
	public void setPay(int pay) {
		this.pay=pay;
	}
	public void setPack(String pack) {
		this.pack=pack;
	}
	
	public String getName() {
		return name;
	}
	public String getTaste() {
		return taste;
	}
	public int getPay() {
		return pay;
	}
	public String getPack() {
		return pack;
	}
	
	
	public void info() {//동사
		System.out.println("제품명: "+name+", 맛: "+taste+"맛, 가격 : "+pay+"종류 : "+pack);
	}
	public String boldEat() {//동사
		return taste+"맛 "+name+"을 끓여먹었습니다.";
	}
	public String brokenEat() {//동사
		return taste+"맛 "+name+"을 뿌셔먹었습니다.";
	}
	
}
