package day0419;

public class UseThrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JiSeungMin sm=new JiSeungMin();
		try {
			String result=sm.walking();
			System.out.println(result);
		} catch (TabaccoException te) {
			
		System.err.println("������ �޽��� : "+te.getMessage());
		System.err.println("���ܹ߻� ��ü, �޽��� : "+te);
			te.printStackTrace();
		} // ����� ���� ���ܸ� ����
	}

}
