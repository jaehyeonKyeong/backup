package day0322;
class Homework{
	public static final int MONEY=10000;
	public static void main(String[] args){
		////숙제1 
		int transExpen=1250;
		int lunchExpen=7000;

		System.out.println("===============숙제1=============== ");
		System.out.println();
		System.out.println("하루 용돈 "+MONEY+"원 입니다.");
		System.out.println("교통비는 편도 "+transExpen+"원이고, 왕복 "+(transExpen*2)+"원 입니다.");
		System.out.println("점심비용은 "+lunchExpen+"원입니다. 남은돈은 "+(MONEY-transExpen*2-lunchExpen)+"원 입니다."); 
		
		////숙제2
		double leftEye=1.0;
		double rightEye=1.2;
		System.out.println();
		System.out.println("===============숙제2=============== ");
		System.out.println();
		System.out.println("왼눈 시력은 "+leftEye+"이고, 오른눈 시력은 "+rightEye+"이고, 양안 시력은 "+(double)((leftEye+rightEye)/2)+"입니다.");
		
		////숙제3
		char initial='K';
		System.out.println();
		System.out.println("===============숙제3=============== ");
		System.out.println();
		System.out.println("제 이름의 이니셜중 첫글자는 "+initial+"입니다.");
	
		////숙제4
		System.out.println();
		System.out.println("===============숙제4=============== ");
		System.out.println();
		System.out.println("byte의 최소값은 "+Byte.MIN_VALUE+"이고, 최대값은 "+Byte.MAX_VALUE+"입니다.");
		System.out.println("short의 최소값은 "+Short.MIN_VALUE+"이고, 최대값은 "+Short.MAX_VALUE+"입니다.");
		System.out.println("int의 최소값은 "+Integer.MIN_VALUE+"이고, 최대값은 "+Integer.MAX_VALUE+"입니다.");
		System.out.println("long의 최소값은 "+Long.MIN_VALUE+"이고, 최대값은 "+Long.MAX_VALUE+"입니다.");
		System.out.println("char의 최소값은 "+(int)(Character.MIN_VALUE)+"이고, 최대값은 "+(int)(Character.MAX_VALUE)+"입니다.");
		System.out.println("float의 최소값은 "+Float.MIN_VALUE+"이고, 최대값은 "+Float.MAX_VALUE+"입니다.");
		System.out.println("double의 최소값은 "+Double.MIN_VALUE+"이고, 최대값은 "+Double.MAX_VALUE+"입니다.");
		System.out.println("boolean의 최소값 최대값은 없습니다.");


	}
}
