package day0405;

public class AbstractSub extends AbstractSuper {

	@Override
	public void absMethod() {
		System.out.println("�ڽĿ��� override");
	}

	@Override
	public void absMethod1() {
		System.out.println("�ڽĿ��� �˾Ƽ� override");
		// super.absMethod1();//�θ��� method�� �߻�method�� ��� ȣ���� �� ����.
	}

	public static void main(String[] args) {
		AbstractSub as = new AbstractSub();
		as.absMethod();
		as.absMethod1();
		
		//is a ������ ��üȭ: �θ�Ŭ���� ��ü�� = new �ڽ�Ŭ���� ������();
		AbstractSuper as1=new AbstractSub();
		as1.absMethod();//�ڽ�Ŭ������ override�ߴٸ� ������� ��äȭ�� �ϴ��� �ڽ��� method�� ��!��!��!������ ȣ��ȴ�.
		

	}

}
