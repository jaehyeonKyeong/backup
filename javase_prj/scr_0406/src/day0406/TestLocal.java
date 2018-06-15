package day0406;

/**
 *	method �� Ŭ������ �����ϴ� Local class <br>
 *	method�������� ���Ǵ� Ŭ����<br>
 *	compile �Ǹ� "�ٱ�Ŭ������$1����Ŭ������.class"
 * @author owner
 */
public class TestLocal {
	int i;
	public TestLocal() {
		System.out.println("�ٱ�Ŭ������ ������");
	}//TestLocal
	public void test(int param_i, final int param_j) {
		int loc_i=0;
		final int loc_j=10;
		
		
		//////////////////////////////////����Ŭ���� ����///////////////////////////////////////////
		class LocalInner{
			int ii;
			public LocalInner() {
				System.out.println("����Ŭ������ ������");
			}//LocalInner
			public void locMethod() {
				System.out.println("����Ŭ������ method, "+ii);
				//final�� �پ��ִ� ������ ��밡�� : JDK1.8���ʹ� final�� �پ����� �ʾƵ� ��밡��(�� �Ҵ�Ұ�)
//				loc_i=300;
				System.out.println("method�� ��������loc_i="+loc_i+", loc_j="+loc_j );
				System.out.println("method�� �Ű����� param_i="+param_i+", param_j="+param_j);
				
			}//locMethod
			
			
			
		}//class
		//////////////////////////////////����Ŭ���� �� ///////////////////////////////////////////
		System.out.println("���� "+loc_i+","+loc_j);
		System.out.println("�Ű����� "+param_i+","+param_j);
		//////����Ŭ���� ��üȭ
		LocalInner li = new LocalInner();
		li.ii=100;
		li.locMethod();
		
		
	}//test
	public static void main(String[] args) {
		TestLocal tl = new TestLocal();
		tl.test(100, 200);
		
	}

}
