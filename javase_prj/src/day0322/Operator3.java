package day0322;
/*
����Ʈ ������
	<< : ��Ʈ�� �������� �а� �о ��ĭ�� �׻� 0���� ä��
	>> : ��Ʈ�� ���������� �а� �о ��ĭ�� �ֻ��� ��ȣ��Ʈ�� ���� ����� 0 ������ 1�� ä��\
	>>> : ��Ʈ�� ���������� �а� �о ��ĭ�� �׻� 0���� ä��
*/
class Operator3 {
	public static void main(String[] args) {
		int temp1 = 24;
		int temp2 = 25;
		int temp3 = 43;
		System.out.println(temp1+"<<3="+(temp1<<3)); // 192
		System.out.println(temp2+">>2="+(temp2>>2)); // 6
		System.out.println(temp3+">>>3="+(temp3>>>3)); // 5

		temp1 = 1;
		System.out.println(temp1+"<<31="+(temp1<<31)); //
		System.out.println(temp1+"<<32="+(temp1<<32)); // �ڹٿ��� <<�� ��Ʈ���� �Ѿ�� �ٽ� �ڷοͼ� ä������

		temp1 = -1;
		System.out.println(temp1+"<<100="+(temp1>>100)); //
		System.out.println(temp1+">>>1="+(temp1>>>1)); //


		/*
		float test = 0.1F;
		double temp = test;
		System.out.println(temp);
		*/
		}//main
}//class
