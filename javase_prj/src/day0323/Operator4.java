package day0323;
/**
	���迬��
	>,<,>=,<=,==,!=
*/

class Operator4{
	public static void main(String[] args) {
		int temp1=23;
		int temp2=25;
		int temp3=23;
		System.out.println(temp1 + " == " +temp3+" = "+(temp1==temp3));//true
		System.out.println(temp1 + " == " +temp2+" = "+(temp1==temp2));//false
		System.out.println(temp1 + " != " +temp3+" = "+(temp1!=temp3));//false
		System.out.println(temp1 + " != " +temp2+" = "+(temp1!=temp2));//true

	}
}
