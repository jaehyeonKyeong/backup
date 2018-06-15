package day0329;

/**
 * 마카 클래스를 이용하여 마카를 사용하는 클래스
 * @author owner
 */
public class UseMaker {

	public static void main(String[] args) {
		//1 객체생성
		Marker black=new Marker();
		///////////////////////03-30-2018 코드 수정/////////////////////////
	
		System.out.println("뚜껑: "+black.getCap()+", 몸체: "+black.getBody()+", 색: "+black.getColor());
		String msg=black.write("jhjk");
		System.out.println(msg);
		
		Marker red=new Marker(2,2,"red");
	
		msg = red.write("red pen");
		System.out.println("뚜껑: "+red.getCap()+", 몸체: "+red.getBody()+", 색: "+red.getColor());
		System.out.println(msg);

	}

}
