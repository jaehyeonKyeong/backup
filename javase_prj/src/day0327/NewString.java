package day0327;

public class NewString {

	public static void main(String[] args) {
		
		
		String word=null;
		System.out.println("null�Է�");
		word= new String("�Է�1");
		System.out.println(word);
		String words[]=null;
		words= new String[]{"�Է�1","�Է�2"};
		System.out.println(words[0]+words[1]);
		System.out.println(add(new int[] {1,2,3,4,5,6,}));
//		int arr[] = new int[5];
//		arr = new int[6];
	}//main
	
		public static int add(int score[]) {
		int sum=0;
		for(int i=0;i<6;i++) {
			sum+=score[i];
		}//for
		return sum;
	}//add

}//end class
