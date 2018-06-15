package day0323;
class Homework3 
{
	public static void main(String[] args) 
	{
		System.out.println("===============숙제3=============");
		System.out.println();
		int maximum= Integer.MAX_VALUE;
		System.out.print("정수의 최고값은" +maximum+"이고, 하위 2byte값은 ");
		maximum>>=15;
		System.out.print(maximum+"입니다.");

	}
}
