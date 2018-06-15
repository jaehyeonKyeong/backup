package day0323;
class className {
	public static void main(String[] args) {
			//이름을 입력 받아 "지승민" 이라면 반장을 붙여 이름을 출력하고
			//지승민이 아니라면 이름만 출력
		if(args[0].equals("지승민")){
		System.out.print("반장 ");
		}
		System.out.print(args[0]+"님 안녕하세요?");
		if(args[0].equals("지승민")){
		System.out.print("~(^^~)(~^^)~");
		}
					//두번째 인자를 받아서 절대값으로 만들어 출력
		int num=Integer.parseInt(args[1]);
		System.out.print("입력값 : "+num);
		if(num<0){
			num=-num;		
		}
		System.out.print("절대값 : "+num);
	}//main
}//class
