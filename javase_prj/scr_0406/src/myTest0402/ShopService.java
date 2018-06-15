package myTest0402;

public class ShopService {
	
	public String line="";
	private static ShopService singleton1 = new ShopService();
	
	private ShopService() {
		
	}
	
	static ShopService getInstnace() {
		return singleton1;
	}
	
	public void pt(int repeat) {
		for(int i=0;i<repeat;i++) {
			System.out.print(line);
		}
		System.out.println();
	}
	
	
	
	
}
