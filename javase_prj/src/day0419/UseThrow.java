package day0419;

public class UseThrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JiSeungMin sm=new JiSeungMin();
		try {
			String result=sm.walking();
			System.out.println(result);
		} catch (TabaccoException te) {
			
		System.err.println("간단한 메시지 : "+te.getMessage());
		System.err.println("예외발생 객체, 메시지 : "+te);
			te.printStackTrace();
		} // 사용자 정의 예외를 날림
	}

}
