package day0403;

/**
 *	가변배열
 * @author owner
 */
public class UseVariableArray {
	
	
	public UseVariableArray() {
		//1.선언 : 데이터형[][] 배열명=null;
		int[][] arr=null;
		//기본형 형식 : 행구분 괄호를 사용할 때 열의 갯수를 다르게 설정
		int[][] arr1= {{1,2},{3},{4,5,6,7},{8,9,10}};
		//열의 갯수를 설정하지 않는다
		//2. 생성 : 배열명 = new 데이터형[행][];ㅣ
		arr=new int[5][];
		//3. 행마다 열을 생성 : 배열명[행] = new 데이터형[열];
		arr[0]=new int[5];
		arr[1]=new int[2];
		arr[2]=new int[4];
		arr[3]=new int[] {1,2,3,4,5};
		arr[4]=new int[] {1,2};
		
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(i+"행"+arr[i].length);
//		}
		
		//3. 값 할당) : 행번호와 열번호에 주의
		arr[0][0]=20;
		//모든방의 값을 출력
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("arr[%d][%d]:%d\t",i,j,arr[i][j]);
			}
			System.out.println();
			
		}
		
		//개선for
		for(int[] temp:arr) {
			for(int i : temp) {
				System.out.printf("%-4d",i);
			}
			System.out.println();
			
		}
		
		for(int[] temp:arr1) {
			for(int i : temp) {
				System.out.printf("%-4d",i);
			}
			System.out.println();
			
		}
		
		
	}
	public static void main(String[] args) {
		new UseVariableArray();
		
		
		
		
		
		
		

	}

}
