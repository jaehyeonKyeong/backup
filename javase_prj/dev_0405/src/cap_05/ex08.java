package cap_05;

public class ex08 {

	public static void main(String[] args) {
		int[][] array= {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		int sum=0;
		double avg=0.0;
		int counter=0;
		for(int[] row:array) {
			for(int num:row) {
				sum+=num;
				counter++;
			}//end inner for
		}//end outer for
		avg=(double)sum/counter;
		
		
		System.out.println("sum: "+sum);
		System.out.println("avg: "+avg);

	}//main

}//class
