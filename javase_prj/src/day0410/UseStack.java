package day0410;

import java.util.Stack;

/**
 * Stack : LIFO(Last Input First Output)
 * @author owner
 */
public class UseStack {
	
	public UseStack() {
		//1.����
		Stack<String> stk=new Stack<>();
		
		//2.���Ҵ� push();
//		stk.add("aaaa");// �θ��� �߰������ ����� �� ������, ������� �ʴ´�. (LIFO�� ����� ����ϱ� ���ؼ�)
		stk.push("�Դϴ�");
		stk.push("ȭ����");
		stk.push("������");
		
//		System.out.println(stk.size());
		
		System.out.println(stk.empty());//������� true ������ false
		while(!stk.empty()){
			System.out.println(stk.pop());
		}

			
	}//Constructor
	
	public static void main(String[] args) {
		new UseStack();
	}//main

}//class
