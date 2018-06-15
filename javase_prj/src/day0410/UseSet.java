package day0410;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *	�����Ͱ� ���������� �Էµ��� �ʰ�, �ߺ����� �������� ������, �˻��� ����� ���� Set
 * @author owner
 */
public class UseSet {

	public UseSet() {
		//1.����+����)
		Set<String> set=new HashSet<String>();
		//2.���Ҵ�)
		set.add("���¹�");
		set.add("�̻���");
		set.add("������");
		set.add("�����");
		set.add("������");//�ߺ��� ���� �Ұ�
		set.add("������");
		set.add("�����");//�ԷµǴ� �������� ������ ����
		
		//�迭�� ������
		String[] temp=new String[set.size()];
		set.toArray(temp);
		
		System.out.println(set+" ũ�� "+set.size());
		
		//������
//		set.remove("���¹�");
		set.clear();
		
		//�����
		Iterator<String> ita =set.iterator();
		while(ita.hasNext()) { //��Ұ� �����ϴ���?
			System.out.println(ita.next());//���� ��� ������ �̵�
		}
		
	}//Constructor
	public static void main(String[] args) {
		new UseSet();
	}//main
}//class
