package day0404;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *	JDK1.5���� �����Ǵ� Annotation�� ���
 * @author owner
 */
public class UseAnnotation {
	@Override
	public String toString() {
        return "�������� ����Ե� �����ϴ� �ڹ� ������?";
//        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }//toString
	
	@Deprecated
	public void printName() {
		System.out.println("������");
	}

	@SuppressWarnings({"unused","rawtypes"}) //���� �Ӽ��� ��Ƽ� ���
	public void test() {
//	@SuppressWarnings("unused")
		String str="����𷡸��ڰ��ڰ�";
//		@SuppressWarnings("rawtypes")
		List list = new ArrayList();
	}

	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		//��ü�� ����ϸ� ��� method �ȿ��� �ش� ��ü�� toString()�� ȣ���Ͽ� �ּҸ� ����Ѵ�.
		
		System.out.println(ua+"\n"+ua.toString());
		String str = new String("���� ������ ���� ������ �ʾƼ� ��糯�� ������.");
		System.out.println(str+"\n"+str.toString());
		System.out.println("------------------------------------------------");
		ua.printName();
		
		Date date = new Date();
		System.out.println(date);
		
//		System.out.println(date.getYear()+1900); //�� ���� �����̹Ƿ� ������� ����� ��� 
		
		
		
		
	}//main

}//class
