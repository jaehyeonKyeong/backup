package day0403;

/**
 * 행과 열로 구성된 이차원 배열
 * 
 * @author owner
 */
public class UseArray2 {

	public UseArray2() {
		// 1.선언 : 데이터형[][] 배열명=null;
		// 데이터형 배열명[][]=null;
		int[][] arr1 = null;
		int arr2[][] = null;

		// 2.생성 : 배열명=new 데이터형[행][열];
		// 모든 방의 값이 초기화 된다.

		arr1 = new int[3][4];
		arr2 = new int[5][7];

		// 3. 값할당 : 배열명[행][열]=값;
		arr1[0][0] = 10;
		arr1[2][3] = 100;
		// 4. 값사용 : 배열명[행][열]
		System.out.println(arr1[0][0] + "/" + arr1[1][0]);
		// 모든 방의 값 출력
		System.out.println("arr1 배열의 행" + arr1.length + ", 열" + arr1[0].length);
		System.out.println("arr2 배열의 행" + arr2.length + ", 열" + arr2[0].length);

		// System.out.println(arr1+"/"+arr2);

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.printf("arr1[%d][%d]=%d\t", i, j, arr1[i][j]);
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------");
		// 개선된 for
		for (int[] temp : arr2) { // 행
			for (int value : temp) {// 열
				System.out.printf("%-4d", value);
			}
			System.out.println();
		}
	}// UseArray2

	/**
	 * 2차원 배열의 기본형 형식 사용 
	 */
	public void usePrimitive() {
		//1.선언 : 데이터형[][] 배열명={{값...값}{..}{..}{..}};//행구분괄호
		// 		=데이터형 [][] 배열명=new 데이터형[][]{{..}{..}{..}{..}};
		int[][] arr= /*new int[][]*/{{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		//2.값할당
		arr[1][1]=300;
		for(int i=0;i<arr.length;i++) {//행에 대한 for
			for(int j=0;j<arr[i].length;j++) {//열에 대한 for
				System.out.printf("arr[%d][%d]=%-6d",i,j,arr[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// UseArray2 ua=new UseArray2();
		// ua.usePrimitive();
		// //객체 생성후 method를 하나 호출하는 경우
		// //new 생성자().method();
		new UseArray2().usePrimitive();
	}// main

}// class
