package day0410;

import java.util.Stack;

/**
 * Stack : LIFO(Last Input First Output)
 * @author owner
 */
public class UseStack {
	
	public UseStack() {
		//1.생성
		Stack<String> stk=new Stack<>();
		
		//2.값할당 push();
//		stk.add("aaaa");// 부모의 추가기능을 사용할 수 있지만, 사용하지 않는다. (LIFO의 기능을 사용하기 위해서)
		stk.push("입니다");
		stk.push("화요일");
		stk.push("오늘은");
		
//		System.out.println(stk.size());
		
		System.out.println(stk.empty());//비었을때 true 있을때 false
		while(!stk.empty()){
			System.out.println(stk.pop());
		}

			
	}//Constructor
	
	public static void main(String[] args) {
		new UseStack();
	}//main

}//class
