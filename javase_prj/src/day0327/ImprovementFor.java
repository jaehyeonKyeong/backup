package day0327;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ������ for : �迭, Collection(List,Set)�� ��� ���� ���� ���������� ����ϱ� ���� ��ȵ� for<br>
 * JDK 1.5+ ��밡��.<br>
 * ����) for(�������� ������ : �迭�� or Collection��){<br>
 * ������;<br>
 * }<br>
 * 
 * @author owner
 */
public class ImprovementFor {

	public static void main(String[] args) {
		// main method�� ��� arguments ���
		for (String value : args) {
			System.out.println("�Է� �� : " + value);
		} // end for
		
		//�迭�� ��� ���� ���� ��°���
		int[] arr = { 2018, 3, 27, 3, 20 };
		for (int value : arr) {
			System.out.println(value);
		} // end for

		//����Ʈ�� ��� ���� ���� ��°���
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(100);
		list.add(1000);
		list.add(10000);

		for (int value : list) {
			System.out.println("list�� �� : " + value);
		} // end for

		//set�� ��� ���� ���� ���
		Set<Integer> set= new HashSet<>();
		set.add(1);
		set.add(10);
		set.add(100);
		set.add(1000);
		set.add(10000);
		
		for(int value:set) {
			System.out.println("set : "+value); //set�� ���� ���������� ������ ����.
		}
		
		
	}// main

}// class
