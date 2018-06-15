package day0323;
/*
	대입 연산자
	=(순수대입)
	+=, -=, *=, /=, %=(산술대입)
	<<=, >>=, >>>= (쉬프트 대입)
	&=, |=, ^=(비트논리 대입)
*/
class Operator7 {
	public static void main(String[] args) throws Exception { //throws Exception
		int i=3;
		//산술대입
		i+=4; //i=i+4;
		i-=2; //i=i-2;
		i*=2; //i=i*2;
		i/=3; //i=i/3;
		//쉬프트
		i<<=4;
		i>>=1;
		i>>>=1;

		//비트논리 대입
		i=4;
		i&=12; //i=i&12; //	0000 0100 &	0000 1100 = 0000 0100
		i|=6; //i=i|6; //			0000 0100 |		0000 0110 = 0000 0110
		i^=9; //i=i^9;			0000 0110 ^	0000 1001 = 0000 1111
		System.out.println(i);

		int keycode = System.in.read();
		System.out.println(keycode==48?"0":"X");

	}//main
}//class 
