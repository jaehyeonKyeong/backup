package day0403;

/**
 *	�����迭
 * @author owner
 */
public class UseVariableArray {
	
	
	public UseVariableArray() {
		//1.���� : ��������[][] �迭��=null;
		int[][] arr=null;
		//�⺻�� ���� : �౸�� ��ȣ�� ����� �� ���� ������ �ٸ��� ����
		int[][] arr1= {{1,2},{3},{4,5,6,7},{8,9,10}};
		//���� ������ �������� �ʴ´�
		//2. ���� : �迭�� = new ��������[��][];��
		arr=new int[5][];
		//3. �ึ�� ���� ���� : �迭��[��] = new ��������[��];
		arr[0]=new int[5];
		arr[1]=new int[2];
		arr[2]=new int[4];
		arr[3]=new int[] {1,2,3,4,5};
		arr[4]=new int[] {1,2};
		
//		for(int i=0;i<arr.length;i++) {
//			System.out.println(i+"��"+arr[i].length);
//		}
		
		//3. �� �Ҵ�) : ���ȣ�� ����ȣ�� ����
		arr[0][0]=20;
		//������ ���� ���
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("arr[%d][%d]:%d\t",i,j,arr[i][j]);
			}
			System.out.println();
			
		}
		
		//����for
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
