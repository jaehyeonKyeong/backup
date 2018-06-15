package day0329;

/**
 *	마카펜을 대상으로 선정하여 추상화(객체모델링)를 한 후 개발하는 클래스 <br>
 *	마카펜의 명사적 특징 : 뚜껑, 몸체, 색 <br>
 *	동사적인 특징 : 쓴다 <br>
 *	일반클래스이며 객체화를 해서 사용한다 <br>
 *	객체화 방법) Marker m = new Marker(); <br>
 *		사용) m.write("쓰고 싶은 말"); <br>
 * @author owner
 */
public class Marker {
	private int cap, body;
	private String color;
	
	/**
	 * 03-30-2018 생성자 코드 추가 <br>
	 * 마카펜이 생성되면 뚜껑 1개, 몸체1개, 색은 검은색으로 설정
	 */
	public Marker() {
		this(1,1,"검은");
//		this.cap=1;
//		this.body=1;
//		this.color="검은";		
	} //Marker

	/**
	 * 03-30-2018 생성자 코드 추가 <br>
	 * @param cap 뚜껑의 갯수
	 * @param body 몸체의 갯수
	 * @param color 색
	 */
	public Marker(int cap, int body, String color) {
		this.cap=cap;
		this.body=body;
		this.color=color;		
	} //Marker
	
	
	/**
	 * 마카펜 객체의 cap을 설정
	 * @param cap cap 수량
	 */
	public void setCap(int cap) {
		this.cap=cap;
	}//setCap
	
	/**
	 * 마카펜 객체의 body을 설정
	 * @param body body 수량
	 */
	public void setBody(int body) {
		this.body=body;
	}//setBody
	
	
	/**
	 * 마카펜 객체의 color을 설정
	 * @param color 색깔
	 */
	public void setColor(String color) {
		this.color=color;
	}//setColor

	/**
	 * 생성된 마카펜 객체의 cap을 얻는 일
	 * @return 마카펜 cap의 수
	 */
	public int getCap() {
		return cap;
	}//getCap

	/**
	 * 생성된 마카펜 객체의 body을 얻는 일
	 * @return 마카펜 body의 수
	 */
	public int getBody() {
		return body;
	}//getBody
	
	/**
	 * 생성된 마카펜 객체의 색을 얻는 일
	 * @return 마카펜 객체의 색
	 */
	public String getColor() {
		return color;
	}//getColor
	
	public String write(String message) {
		return color+"색인 마카펜으로 칠판에 \""+message+"\" 를 쓴다.";
	}
	

}//class
