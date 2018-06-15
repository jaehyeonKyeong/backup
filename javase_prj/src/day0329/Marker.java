package day0329;

/**
 * 마카펜을 대상으로 선정하여 추상화(객체 모델링)를 한 후<br>
 * 개발하는 클래스 <br>
 * 마카 펜의 명사적 특징은 : 뚜껑, 몸체, 색 <br>
 * 동사적인 특징 : 쓴다.<br>
 * 마카펜은 일반클래스이며 객체화를 해서 사용한다.<br>
 *  객체화 방법) Marker m= new Marker();<br>
 *  사용 방법) m.write("쓰고싶은 말");
 *  
 * @author owner
 */
public class Marker {
	private int cap,body;
	private String color;
	
	/**
	 * 2018-03-30 생성자 코드 추가<br>
	 * 마카 펜이 생성되면 뚜껑1개,몸체1개,색은 검은색으로 설정; 
	 */
	public Marker() {
		this(1,1,"black");
//		cap=1;
//		body=1;
//		color="black";
	}
	/**
	 * 생성자를 뚜껑 하나 몸체 하나 색이 검은색이 아닌 마카펜을 생성할때 사용하는 생성자
	 * @param cap 뚜껑의 갯수
	 * @param body 몸체의 갯수
	 * @param color 설정 색
	 */
	public Marker(int cap, int body, String color) {
		this.cap=cap;
		this.body=body;
		this.color=color;
	}
	
	/**
	 * 생성된 마카펜 객체에 뚜껑의 갯수를 설정하는 일
	 * @param cap 설정할 뚜껑의 갯수
	 */
	public void setCap(int cap) {
		this.cap=cap;
	}//setCap
	/**
	 * 생성된 마카펜 객체에 몸체의 갯수를 설정하는 일
	 * @param body 설정할 몸체의 갯수
	 */
	public void setBody(int body) {
		this.body=body;
	}//setBody
	/**
	 * 생성된 마카펜 객체의 색을 설정하는 일
	 * @param color 설정할 색
	 */
	public void setColor(String color) {
		this.color=color;
	}
	
	public int getCap() {
		return cap;
	}
	public int getBody() {
		return body;
	}
	public String getColor() {
		return color;
	}
	
	public String write(String msg) {
		return msg;
	}
	
} //class
