package myTest0402;

public class ShopServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShopService ss1=ShopService.getInstnace();
		ShopService ss2=ShopService.getInstnace();
		ss1.line="#";
		ss1.pt(5);
		ss2.line="*";
		ss2.pt(10);
		ss1.pt(5);
		

	}

}
