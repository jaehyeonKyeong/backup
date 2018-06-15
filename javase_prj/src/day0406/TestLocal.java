package day0406;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * method���� class�� �����ϴ� localŬ����<br>
 * method �������� ���Ǵ� class <br>
 * compile �Ǹ� : �ٱ�Ŭ������$1����Ŭ������.class
 * 
 * @author owner
 */
@SuppressWarnings("unused")
public class TestLocal {
	int i;
	
	public TestLocal() {
		System.out.println("������");
	}
	
	public void test(int param_i, final int param_j) {
		int loc_i=0;
		final int loc_j=0;
		////////////////// ����Ŭ���� //////////////////////
		class LocalInner{
			@SuppressWarnings("unused")
			int ii;
			public LocalInner() {
				System.out.println("����Ŭ���� ������");
			}//����Ŭ������ ������
			public void locMethod() {
				System.out.println("����Ŭ������ method");
				//final�� �پ��ִ� ������ ��밡�� : JDK 1.8���ʹ� final�� �پ����� �ʾƵ� ��밡��(�� �Ҵ� �Ұ�)
				System.out.println("method�� �������� loc_i ="+loc_i+",loc_j="+loc_j);
				System.out.println("Param_i="+param_i+", param_j="+param_j);
			}
		}//class
		////////////////////////////////////////////////
		System.out.println("���� "+loc_i+", "+loc_j);
		System.out.println("�Ű� ���� "+param_i+", "+param_j);
		LocalInner li=new LocalInner();
		li.locMethod();
	}//test
	
	public static void main(String[] args) {
		TestLocal tl=new TestLocal();
		tl.test(100, 200);

	}//main

}//class
