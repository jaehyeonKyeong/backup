package day0404;

public class OverrideSub extends OverrideSuper{
	
	//������ ���� �����ڷ� ���� ����
	//default->public, protected 
//	@Overridez
	public void test1(String msg) {
		System.out.println("�ڽ��� ���� test1 "+msg);
	}
	
	//protected -> public
//	@Override
	public void test(int i) {
		System.out.println("�ڽ��� ���� test "+ i);
	}
	
	//public -> public
//	@Override //�����Ϸ��� �������� �� Override�� ����� �Ǿ����� üũ
	public String myName() {
		return "���¹�";
	}

	public static void main(String[] args) {
		OverrideSub os = new OverrideSub();
		os.test(35);
		os.test1("ȭâ�� ������");
		System.out.println(os.myName());
		
		
		
		

	}

}
