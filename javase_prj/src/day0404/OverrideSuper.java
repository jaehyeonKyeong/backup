package day0404;

/**
 *	Override ����
 * @author owner
 */
public class OverrideSuper {
	//method�� ���� �����ڿ� final�� �ִٸ�  Override�� ���� �ʴ´�
	protected /*final*/ void test (int i) { 
		System.out.println("�θ��� test method  "+i);
	}//test
	
	void test1(String str) {
		System.out.println("�θ��� test1 method  "+str);
	}//test
	
	public String myName() {
		return "������";
	}
	
	
	
}//class