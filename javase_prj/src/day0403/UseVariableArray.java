package day0403;

/**
 * �����迭 : �ึ�� ���� ������ �ٸ� �迭
 * 
 * @author owner
 */
public class UseVariableArray {
	public UseVariableArray() {
		//���� ��������[][] �迭��=null;
		int[][] arr=null;
		//�⺻�� ���� : �౸�� ��ȣ�� ����Ҷ� ���� ������ �ٸ��� ����
		int[][] arr1= {{1,2},{3},{4,5,6,7},{8,9,10}};
		//���� ������ �������� �ʴ´�
		arr=new int[5][];
		//�ึ�� ���� ����
		arr[0]=new int[5];
		arr[1]=new int[2];
		arr[2]=new int[4];
		arr[3]=new int[] {1,2,3,4,5};
		arr[4]=new int[] {1,2};
		//�� �Ҵ� ���ȣ�� ����ȣ�� ����
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
