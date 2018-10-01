package data;

public class Test {
	
	public Test() {
		String[] names = {"¼Û¾²","±è¿ìÇö","ÀÌÁ¾¹Î"};
		for(int i=0;i<names.length;i++) {
			System.out.print("name:"+names[i]);
			if(i!=names.length-1) {
				System.out.print(",");
			}
		}//end for
	}//Test

	public static void main(String[] args) {
		Test t = new Test();
	}//main
}//class
