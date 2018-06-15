package myTest0404;

import day0330.Person;

public class InheritanceTest extends Person {
	
	public InheritanceTest (int eye,int nose,int mouse) {
		super( eye, nose, mouse);
	}
	public InheritanceTest () {
	}


	public static void main(String[] args) {
		InheritanceTest it1 = new InheritanceTest();
		InheritanceTest it2 = new InheritanceTest(3,2,3);
		
		it1.setName("»ç¶÷");
		System.out.println(it1.eat());
		System.out.println(it1.eat("»§",1500));
		
		it2.setName("±«¹°");
		System.out.println(it2.eat());
		System.out.println(it2.eat("¼±µÎ",1));
		
		
		
		

	}

}
