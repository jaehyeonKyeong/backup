package day0322;
/*
쉬프트 연산자
	<< : 비트를 왼쪽으로 밀고 밀어서 빈칸을 항상 0으로 채움
	>> : 비트를 오른쪽으로 밀고 밀어서 빈칸을 최상위 부호비트에 따라 양수면 0 음수면 1을 채움\
	>>> : 비트를 오른쪽으로 밀고 밀어서 빈칸을 항상 0으로 채움
*/
class Operator3 {
	public static void main(String[] args) {
		int temp1 = 24;
		int temp2 = 25;
		int temp3 = 43;
		System.out.println(temp1+"<<3="+(temp1<<3)); // 192
		System.out.println(temp2+">>2="+(temp2>>2)); // 6
		System.out.println(temp3+">>>3="+(temp3>>>3)); // 5

		temp1 = 1;
		System.out.println(temp1+"<<31="+(temp1<<31)); //
		System.out.println(temp1+"<<32="+(temp1<<32)); // 자바에서 <<는 비트수를 넘어가면 다시 뒤로와서 채워진다

		temp1 = -1;
		System.out.println(temp1+"<<100="+(temp1>>100)); //
		System.out.println(temp1+">>>1="+(temp1>>>1)); //


		/*
		float test = 0.1F;
		double temp = test;
		System.out.println(temp);
		*/
		}//main
}//class
