package day0322;
/**
	단항연산자 : 연산에 필요한 항이 하나인 연산자
	~,!,+,-,++,--
*/
class Operator1{
	public static void main(String[] args){
		//~(tilde): 1의 보수 연산
		int i=22;
		int j=-22;
		System.out.println("~"+i+"="+~i);//부호변경 1증가
		System.out.println("~"+j+"="+~j);//부호변경 1감소
		//!(not) : true<->false
		boolean b= true;
		boolean c= false;
		System.out.println("!"+b+"="+!b);
		System.out.println("!"+c+"="+!c);
		System.out.println("!(3>22)="+!(3>22));
		//+ :형식적 제공
		System.out.println("+"+i+"="+ +i);
		System.out.println("+"+j+"="+ +j);
		//- :2의 보수연산
		System.out.println("-"+i+"="+ -i); // 값은 그대로고 부호만 바뀜
		System.out.println("-"+j+"="+ -j);

		//0323 추가
		//++ : 증가연산(대상체의 값을 1씩 증가)
		//-- : 감소연산(대상체의 값을 1씩 감소)

		i=23;
		j=23;
		
		//전위 : 대상체 앞에 연산자 사용
		++i; // 23->24
		--j; //23->22
		System.out.println("전위 연산후 i : "+i+", j: "+j);
		//후위 : 대상체 뒤에 연산자 사용
		i++;//24->25
		j--;//22->21
		System.out.println("후위 연산후 i : "+i+", j: "+j);
		//대입연산자와 함께 사용하면 전위와 후위가 다른 값을 대입한다.
		//전위 : 내것먼저
		int temp=0;
		temp=++i;
		System.out.println("전위 후 temp: "+temp+", i :"+i);
		temp=0;
		//후위 : 남것먼저
		temp=i++;
		System.out.println("후위 후 temp: "+temp+", i :"+i);


	}
}
