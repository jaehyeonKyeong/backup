package day0403;

/**
 *	��� ���� ������ ������ �迭�� ���.
 * @author owner
 */
public class UseArray2 {
	
	public UseArray2() {
		// 1. ����) 	��������[][] �迭��=null;
		// 				�������� �迭�� [][] = null;
		int [][] arr1 = null;
		int arr2[][]=null;
		// 2. ����)	�迭�� = new ��������[��][��];
		//������ ���� �ʱ�ȭ�ȴ�
		arr1=new int[3][4];
		arr2=new int[5][7];
		// 3. �� �Ҵ�)	�迭��[��][��]=��;
		arr1[0][0]=10;
		arr1[2][3]=100;
		// 4. �� ���)	�迭��[��][��]
		System.out.println(arr1[0][0]+"/"+arr1[1][0]);
		System.out.println("arr1 �迭�� �� : "+arr1.length+", �� : "+arr1[0].length);
		System.out.println("arr2 �迭�� �� : "+arr2.length+", �� : "+arr2[0].length);
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length;j++) {
				System.out.printf("arr1[%d][%d] = %d\t",i,j,arr1[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------");
		for(int[] temp : arr2) {
			for(int value : temp) {
				System.out.printf("%-4d",value);
			}
			System.out.println();
		}
		
	}//UseArray2
	
	public void usePrimitive() {
		//1.����) ��������[][] �迭�� ={{��,,,},{��,,,},,,,,};
		//1.����) ��������[][] �迭�� =new ��������[][] {{��,,,},{��,,,},,,,,};
		int[][] arr= {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		//2. ���Ҵ�)
		arr[1][1]=300;
	
		System.out.println("---------------------------------------------------------------------------");
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("arr[%d][%d]=%-6d",i,j,arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("��������");
	}
	

	public static void main(String[] args) {
//		UseArray2 ua = new UseArray2();
//		ua.usePrimitive();
		//��ü ���� �� method �ϳ��� ȣ�⸸ �ϴ� ���
		//new ������().method();
		new UseArray2().usePrimitive();
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
