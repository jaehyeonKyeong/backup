package day0419;

import java.util.Random;

public class JiSeungMin {
	
	public String walking() throws TabaccoException {
		String[] stuArr= {"�ʵ�","�ߵ�","���"};
		String stu=stuArr[new Random().nextInt(stuArr.length)];
		if(stu.equals("�ʵ�")) {
			//������ �߻��� ���ܴ� �ݵ�� try~catch�Ǵ� throws(����)�� �ؾ��Ѵ�.
			throw new TabaccoException("ó..ó���� �ݿ���..");
		}
		return stu+"�� ���� �𸣴� ô ��������.('' )( '') ";
	}

}
