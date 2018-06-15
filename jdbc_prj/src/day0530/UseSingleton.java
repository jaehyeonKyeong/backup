package day0530;

public class UseSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//생성자가 private이므로 외부에서 객체화 할수 없다.
		//singleton single=new singleton():
		//객체를 얻는 method 사용
		Singleton single=Singleton.getInstance();
		Singleton single1=Singleton.getInstance();
		System.out.println(single+" / "+single1);
		//객체를 여러번 얻어도 하나의 객체 사용

	}

}
