package day0323;
class Operator1 {
	public static void main(String[] args) {
		int i = 10;
		int j = 15;
		System.out.println("-i ="+-i);
		System.out.println("-j ="+-j);
		// ++ : 증가연산 (대상체의 값을 1씩 증가)
		// -- : 감소연산 (대상체의 값을 1씩 감소)
		i = 23;
		j = 23;
		// 전위 : 대상체 앞에 연산자를 사용
		++i; //23 -> 24
		--j; // 23 -> 22
		System.out.println("전위연산 후 i : "+i+", j : "+-j);
		//후위 : 대상체 뒤에 연산자를 사용
		i++; //24 -> 25
		j--; // 22 -> 21
		System.out.println("후위연산 후 i : "+i+", j : "+-j);

		//대입 연산자와 함께 사용하면 전위와 후위가 다른 값을 사용
		//전위 : 내것 먼저
		int temp = 0;
		temp = ++i;
		System.out.println("전위 후 temp : "+temp+", i : "+i);
		temp = 0;
		//후위 : 남의 것 먼저
		temp = i++;
		System.out.println("후위 후 temp : "+temp+", i : "+i);

	}
}
