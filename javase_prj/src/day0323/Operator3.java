package day0323;
/**
	shift ������
	<< : �� ����Ʈ(��Ʈ�� �������� �а� �о ��ĭ�� �׻� 0���� ä���)
	>> : �� ����Ʈ(��Ʈ�� ���������� �а� �о ��ĭ�� �ֻ��� ��ȣ��Ʈ�� ���� ����� 0�� ������ 1�� ä���.)
	>>> : ����ε� �� ����Ʈ(��Ʈ�� ���������� �а� ��Ʈ�� �׻� 0���� ä���)
*/
class Operator3{
	public static void main(String[] args) {
		int temp1=24;
		int temp2=25;
		int temp3=43;
		System.out.println(temp1+"<<3 = "+(temp1<<3)); // 192
		System.out.println(temp2+">>2 = "+(temp2>>2)); // 6
		System.out.println(temp3+">>>3 = "+(temp3>>>3)); //5

		temp1=1;
		System.out.println(temp1+"<<31="+(temp1<<31)); //java�� ���  <<�� ��Ʈ���� �Ѿ�� �ٽ� �ڷοͼ� ä������
		System.out.println(temp1+"<<32="+(temp1<<32));
		System.out.println(temp1+"<<33="+(temp1<<33));

		temp1=-1;
		System.out.println(temp1+">>100="+(temp1>>100));
		System.out.println(temp1+">>>1="+(temp1>>>1));
	}//main
}//class
