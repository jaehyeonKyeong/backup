package day0913;

public class UseTestVO {
	
	public static void main(String[] args) {
		TestVO tv = new TestVO();
		tv.setName("송재원");
		tv.setAddr("경기도 성남시 수정구 태평동");
		tv.setAge(25);
		
		System.out.println(tv);
		System.out.println(tv.getAddr());
	}
}
