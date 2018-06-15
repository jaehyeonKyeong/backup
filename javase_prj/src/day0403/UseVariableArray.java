package day0403;

/**
 * 가변배열 : 행마다 열의 갯수가 다른 배열
 * 
 * @author owner
 */
public class UseVariableArray {
	public UseVariableArray() {
		//선언 데이터형[][] 배열명=null;
		int[][] arr=null;
		//기본형 형식 : 행구분 괄호를 사용할때 열의 갯수를 다르게 설정
		int[][] arr1= {{1,2},{3},{4,5,6,7},{8,9,10}};
		//열의 갯수를 설정하지 않는다
		arr=new int[5][];
		//행마다 열을 생성
		arr[0]=new int[5];
		arr[1]=new int[2];
		arr[2]=new int[4];
		arr[3]=new int[] {1,2,3,4,5};
		arr[4]=new int[] {1,2};
		//값 할당 행번호와 열번호에 주의
		arr[0][0]=20;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length;j++) {
				System.out.printf("%-5d",arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for(int[] temp :arr1) {
			for(int val : temp) {
				System.out.printf("%-4d",val);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new UseVariableArray();
	}

}
