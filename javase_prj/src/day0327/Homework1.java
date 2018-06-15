package day0327;

public class Homework1 {
	public static void main(String[] args) {
		// 槛力1
		// 0 1 0 2 0 3 0 4
		// 1 2 1 3 1 4
		// 2 3 2 4
		// 3 4
		System.out.println("============槛力1==========");
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 5; j++) {
				System.out.print(i + " " + j + " ");
			} // end for
			System.out.println();
		} // end for
		System.out.println("============槛力2==========");
		// 槛力2
		// 0 0
		// 1 0 1 1
		// 2 0 2 1 2 2
		// 3 0 3 1 3 2 3 3
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i + " " + j + " ");
			} // end for
			System.out.println();
		} // end for
	}//main
}//class
