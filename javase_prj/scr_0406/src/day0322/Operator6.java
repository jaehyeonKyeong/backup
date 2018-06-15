package day0322;
/*
	삼항(조건) 연산자
	? : 
*/

class Operator6 {
	public static void main(String[] args) {
		int i=-23;
		System.out.println(i+"는 "+(i>=0? "양수":"음수"));
		
		//성년, 미성년 판정하는 삼항연산
		int age=29;
		int temp=0;
		System.out.println(age+"살은 "+(age>=20?"성년":"미성년")+"입니다");

		//삼항연산자는 반환하는 항의 데이터형이 달라도 된다
		System.out.println(age+"살은 "+(age>=20?"성년":temp)+"입니다");

		int absolute=-12;
		//위의 변수에 절대값을 구해서 반환하는 코드
		absolute=(absolute>=0? absolute : -absolute);
		System.out.println(absolute);

	}//main
}//class
