package myTest0405;

public class TestInstacneof {
	
	public static void method1(Parents parent) {
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1 - Child ��ȯ ����");
		} else {
			System.out.println("method1 - Child ��ȯ���� ����");
		}
	}
	
	public static void method2(Parents parent) {
		Child child = (Child) parent;
		System.out.println("method2 - Child ��ȯ ����");
	}

	public static void main(String[] args) {
		Parents parentA = new Child();
		method1(parentA);
		method2(parentA);
		
		Parents parentB = new Parents();
		method1(parentB);
//		method2(parentB); //���� �߻�	
		
		
		
		// TODO Auto-generated method stub

	}

}
