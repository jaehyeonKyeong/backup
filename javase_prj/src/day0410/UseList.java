package day0410;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * ����������(�ԷµǴ� �����Ͱ� ������ ���� ������ �����ϰ�, �����Ǵ� �����Ͱ� ������ ���� ������ �����Ѵ�)<br>
 * �ߺ����� �����ϸ� ���������� ���� �Էµǰ�, �˻��� ����� ����
 * 
 * @author owner
 */
public class UseList {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UseList() {
		// JDK1.4���� ����Ҷ�(Generic�� ����, autoboxing,unboxing�� ����)
		// List list = new ArrayList();
		//
		// // �� �߰�
		// // list.add(10); // �⺻�� �������� �Է� �Ұ�
		// list.add(new Integer(10));// Wrapper Class ���;
		// list.add(new Double(12.22));
		// list.add("������ ȭ����");
		//
		// // �����
		// System.out.println(((Integer)list.get(0)).intValue()*4);

		// autoboxing
		// JDK1.5���� ���ʹ� �⺻�� ���������� �ԷµǸ� WrapperClass�� �ڵ������Ǿ� �߰��ȴ�.
		List<Object> list = new ArrayList();
		// Generic�� ������ ������ ��� ���� �Էµȴ�.
		list.add(4);// �⺻�� ���������� �߰��Ǹ� �׿� ���� Wrapper class�� �������� �Էµȴ�.(autoboxing)
		list.add(10);// -> list.add(new Integer(10));
		list.add(4.10);
		list.add("������ ȭ����");

		for (int i = 0; i < list.size(); i++) {
//			int j= list.get(i);//unboxing
			System.out.println(list.get(i));// ���� ���������� ������ ������ �ٲ���� ������ Unboxing�� �ȴ�.
		}

	}// constructor
	
	@SuppressWarnings("unchecked")
	public List<String> useArrayList() {
		//1.��ü���� :Generic ���
		@SuppressWarnings("rawtypes")
		List<String> list=new ArrayList();
		//2.�� �߰� : �߰� �ɶ����� ���� ũ�Ⱑ ����
		list.add("������");
		list.add("���¹�");
		list.add("������");
		list.add("�����");
		list.add("������");//�ߺ��� ���
		
		//�迭�� ����
		String[] arr=new String[list.size()];
		list.toArray(arr);
		
		//�� ����
//		list.remove(1);//index�� ����
//		list.remove("������");//�Է°��� ���� ����� ���� �� ���� �տ� �ִ� ���� ����
		
		//��� ���� �� ����
		list.clear();
		
		//�迭�� ���� �������.
		for(String name : arr) {
			System.out.println(name);
		}
		
		System.out.println(list+"/"+list.size());
		return list;
	}//useArrayList
	
	public List<String> useVector() {
		//����
		List<String> list=new Vector<>();
		//�� �Ҵ�
		list.add("������");
		list.add("���¹�");
		list.add("���¹�");
		list.add("������");
		list.add("�赿��");//�ߺ��� ���
		list.add("�����");
		//�߰��� �� �ֱ� : ArrayList�� Vector�� ȿ���� ��������.
		list.add(2,"���ҿ�");
		//���� : �����¹� ����
//		list.remove(3);
		//�迭�� ���
		String[] temp=new String[list.size()];

		list.toArray(temp);
		for(String name: temp)
			System.out.println(name);
//		System.out.println("���� : "+list+"/"+list.size());
		return list;
		
	}
	
	public List<String> useLinkedList() {
		List<String> list=new LinkedList<>();
		list.add("������");
		list.add("���¹�");
		list.add("���¹�");
		list.add("������");
		list.add("�赿��");//�ߺ��� ���
		list.add("�����");
		//�߰��� �� �ֱ� : LinkedList�� ���� ����.
		list.add(2,"���ҿ�");
		//���� : �����¹� ����
//		list.remove(3);
		//�迭�� ���
		String[] temp=new String[list.size()];

		list.toArray(temp);
		for(String name: temp)
			System.out.println(name);
		return list;
		
	}

	public static void main(String[] args) {
		UseList ul=new UseList();
//		List<String> list=ul.useArrayList();
//		List<String> list=ul.useVector();
		List<String> list=ul.useLinkedList();
		System.out.println("-----------------------------------------");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
