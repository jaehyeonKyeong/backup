package day0403;

/**
 * ������ �迭�� ���<br>
 * ��,��,���� ������ �迭
 * @author owner
 */
public class UseArray3 {
	public UseArray3() {
		//����
		int[][][] arr1=null;
		int arr2[][][]=null;
		
		//����
		arr1=new int[2][3][4];
		arr2=new int[4][2][5];
		System.out.printf("arr1 ��%d ��%d ��%d\n",arr1.length,arr1[0].length,arr1[0][0].length);
		System.out.printf("arr2 ��%d ��%d ��%d\n",arr2.length,arr2[0].length,arr2[0][0].length);
		
		//���Ҵ� �迭��[��][��][��]=��;
		arr1[0][0][0]=10;
		arr1[1][1][1]=20;
		
		//�����
		System.out.println(arr1[0][0][0]+"/"+arr1[0][0][1]);
		
		//��� ���� �� ���
		for(int i=0;i<arr1.length;i++) {//��
			System.out.println(i+"�� ����");
			for(int j=0;j<arr1[i].length;j++) {
				for(int k=0;k<arr1[i][j].length;k++) {
					System.out.printf("%-3d",arr1[i][j][k]);
				}
				System.out.println();
			}

		}
	}
	public void usePrimitive() {
		//���� ) �������� [][][] �迭��={{{��,��,��},{��,��,��},{��,��,��}},{{��,��,��},{��,��,��},{��,��,��}}}
		int[][][] arr=new int[][][] {{{1,2,3}/*�౸��*/,{4,5,6}}/*�鱸��*/,{{7,8,9}/*�౸��*/,{10,11,12}}/*�鱸��*/};
		System.out.printf("arr�迭�� [%d��][%d��][%d��]�Դϴ�\n",arr.length,arr[0].length,arr[0][0].length);
		
		//������ for
		//�� ���� ������ �迭�� �Ͼ�������
		for(int[][] arr2:arr) {
			System.out.println("�����");
			for(int[] arr1 : arr2) {// ������ �迭�� 1���� �迭�� �̷���� ����
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
