package day0322;
/*
	대입 연산자
	=(순수대입)
	+=, -=, *=, /=, %=(산술대입)
	<<=, >>=, >>>= (쉬프트 대입)
	&=, |=, ^=(비트논리 대입)
*/
class Operator7 {
	public static void main(String[] args) throws Exception {
		int i=3;
		//산술대입
		i+=4; //i=i+4;
		i-=2; //i=i-2;
		i*=2; //i=i*2;
		i/=3; //i=i/3;
		i%=2; //i=i%2;
		System.out.println(i);

//		int keycode = System.in.read();
	}//main
}//class
