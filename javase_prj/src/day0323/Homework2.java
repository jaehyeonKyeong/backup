package day0323;

class Homework2 {
	public static void main(String[] args) {
		System.out.println("==============숙제2============");
		System.out.println();

		int arg0 = Integer.parseInt(args[0]);
		if (arg0 < 0) {
			arg0 = -arg0;
		}
		int arg1 = Integer.parseInt(args[1]);
		if (arg1 < 0) {
			arg1 = -arg1;
		}
		System.out.print("값1의 입력값:" + args[0] + " 절대값:" + arg0 + ",이고 값2의 입력값 : " + args[1] + ", 절대값 : " + arg1
				+ "이고, 두수의 &(and) 연산값 : " + (arg0 & arg1));
	}
}
