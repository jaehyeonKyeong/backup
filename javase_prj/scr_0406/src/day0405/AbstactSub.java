package day0405;

public class AbstactSub extends AbstractSuper{
	
	@Override
	public void absMethod() {
		System.out.println("�ڽĿ��� Override");
	}
	
	@Override
	public void absMethod1() {
		System.out.println("�ڽĿ��� �˾Ƽ� Override");
		//�߻�method Override
//		super.absMethod1(); //�θ��� method�� �߻� method�� ��� super�� ȣ���� �� ����
	}//absmethod1
	
	public static void main(String[] args) {
//		AbstractSuper as = new AbstractSuper(); //�߻�Ŭ������ ���� ��üȭ�� �� ����
		AbstactSub as = new AbstactSub();
		as.absMethod();
		as.absMethod1();
		System.out.println("-------------------------------------------");
		
		//is a ������ ��üȭ : �θ�Ŭ���� ��ü�� = new �ڽ�Ŭ����������();
		AbstractSuper as1 = new AbstactSub();
		as1.absMethod(); // �ڽ�Ŭ������ Override �ߴٸ� � ������ ��üȭ�� �ϴ��� �ڽ��� method�� ��!��!��! ������ ȣ��ȴ�
		as1.absMethod1();
		
		
	}//main
}//class
