package day0327;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 개선된 for : 배열, Collection(List,Set)의 모든 방의 값을 순차적으로 출력하기 위해 고안된 for<br>
 * JDK 1.5+ 사용가능.<br>
 * 문법) for(데이터형 변수명 : 배열명 or Collection명){<br>
 * 변수명;<br>
 * }<br>
 * 
 * @author owner
 */
public class ImprovementFor {

	public static void main(String[] args) {
		// main method의 모든 arguments 출력
		for (String value : args) {
			System.out.println("입력 값 : " + value);
		} // end for
		
		//배열의 모든 방의 값을 출력가능
		int[] arr = { 2018, 3, 27, 3, 20 };
		for (int value : arr) {
			System.out.println(value);
		} // end for

		//리스트의 모든 방의 값을 출력가능
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(100);
		list.add(1000);
		list.add(10000);

		for (int value : list) {
			System.out.println("list의 값 : " + value);
		} // end for

		//set의 모든 방의 값을 출력
		Set<Integer> set= new HashSet<>();
		set.add(1);
		set.add(10);
		set.add(100);
		set.add(1000);
		set.add(10000);
		
		for(int value:set) {
			System.out.println("set : "+value); //set의 값은 순차적으로 나오지 않음.
		}
		
		
	}// main

}// class
