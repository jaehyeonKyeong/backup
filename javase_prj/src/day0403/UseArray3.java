package day0403;

/**
 * 삼차원 배열의 사용<br>
 * 면,행,열로 구성된 배열
 * @author owner
 */
public class UseArray3 {
	public UseArray3() {
		//선언
		int[][][] arr1=null;
		int arr2[][][]=null;
		
		//생성
		arr1=new int[2][3][4];
		arr2=new int[4][2][5];
		System.out.printf("arr1 면%d 행%d 열%d\n",arr1.length,arr1[0].length,arr1[0][0].length);
		System.out.printf("arr2 면%d 행%d 열%d\n",arr2.length,arr2[0].length,arr2[0][0].length);
		
		//값할당 배열명[면][행][열]=값;
		arr1[0][0][0]=10;
		arr1[1][1][1]=20;
		
		//값사용
		System.out.println(arr1[0][0][0]+"/"+arr1[0][0][1]);
		
		//모든 방의 값 출력
		for(int i=0;i<arr1.length;i++) {//면
			System.out.println(i+"면 시작");
			for(int j=0;j<arr1[i].length;j++) {
				for(int k=0;k<arr1[i][j].length;k++) {
					System.out.printf("%-3d",arr1[i][j][k]);
				}
				System.out.println();
			}

		}
	}
	public void usePrimitive() {
		//선언 ) 데이터형 [][][] 배열명={{{값,값,값},{값,값,값},{값,값,값}},{{값,값,값},{값,값,값},{값,값,값}}}
		int[][][] arr=new int[][][] {{{1,2,3}/*행구분*/,{4,5,6}}/*면구분*/,{{7,8,9}/*행구분*/,{10,11,12}}/*면구분*/};
		System.out.printf("arr배열은 [%d면][%d행][%d열]입니다\n",arr.length,arr[0].length,arr[0][0].length);
		
		//개선된 for
		//한 면은 이차원 배열로 일어져있음
		for(int[][] arr2:arr) {
			System.out.println("면시작");
			for(int[] arr1 : arr2) {// 이차원 배열은 1차원 배열로 이루어져 있음
				for(int val:arr1) {
					System.out.printf("%-4d",val);
				}
				System.out.println();
			}
		}
	}
	public static void main(String[] args) {
		new UseArray3().usePrimitive();
	}

}
