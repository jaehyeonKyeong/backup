package day0322;
class HomeWork0322{
	public static final int POCKET_MONEY = 10000;
	public static void main(String[] args) {
		
		System.out.println("================ 1 ================");
		int transportationExpense = 1250;
		int lunchExpense = 7000;
		System.out.println("하루의 용돈 "+POCKET_MONEY+"원 입니다");
		System.out.println("교통비는 편도 "+transportationExpense+"원 이고 왕복은 "+ transportationExpense*2+"원 입니다.");
		System.out.println("점심 값은 "+lunchExpense+"원 입니다. 남은 금액은 "+(POCKET_MONEY-2*transportationExpense-lunchExpense));

		System.out.println("================ 2 ================");
		double leftEye = 0.7;
		double rightEye = 0.8;
		System.out.println("왼눈 시력 "+leftEye+" 오른눈 시력 "+rightEye+" 양안은 "+(rightEye+leftEye)/2+"입니다.");

		System.out.println("================ 3 ================");
		char myName = 'L';
		System.out.println("내 이름의 이니셜 중 첫글자는 '"+myName+"'입니다.");
		

		System.out.println("================ 4 ================");
		System.out.println("Byte의 최소값 ("+ Byte.MIN_VALUE+"), 최대값 ("+ Byte.MAX_VALUE+")");
		System.out.println("Short의 최소값 ("+ Short.MIN_VALUE+"), 최대값 ("+ Short.MAX_VALUE+")");
		System.out.println("int의 최소값 ("+ Integer.MIN_VALUE+"), 최대값 ("+ Integer.MAX_VALUE+")");
		System.out.println("long의 최소값 ("+ Long.MIN_VALUE+"), 최대값 ("+ Long.MAX_VALUE+")");
		System.out.println("char의 최소값 ("+ (int)Character.MIN_VALUE+"), 최대값 ("+ (int)Character.MAX_VALUE+")");
		//System.out.println("char의 최소값 ("+ Character.MIN_CODE_POINT+"), 최대값 ("+ Character.MAX_CODE_POINT+")");
		System.out.println("float의 최소값 ("+ Float.MIN_VALUE+"), 최대값 ("+ Float.MAX_VALUE+")");
		System.out.println("double의 최소값 ("+ Double.MIN_VALUE+"), 최대값 ("+ Double.MAX_VALUE+")");
		//System.out.println("boolean의 최소값 ("+ Boolean.MIN_VALUE+"), 최대값 ("+ Boolean.MAX_VALUE+")");
		//System.out.println("boolean의 최소값 ("+ Boolean.FALSE+"), 최대값 ("+ Boolean.TRUE+")");
	
	}
}
