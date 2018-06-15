package myTest0329;

/**
 *	Singleton
 * @author owner
 */
public class Singleton {
	
	private static Singleton st = new Singleton();
	
	private Singleton() {
		
	}
	
	static Singleton getInstance() {
		return st;
	}
	
	void printStar(int cnt) {
		for(int i=0;i<cnt;i++) {
			System.out.print("¡Ú");
		}
		System.out.println();
	}
}
