package day0323;

class Homework2 {
	public static void main(String[] args) {
		System.out.println("==============����2============");
		System.out.println();

		int arg0 = Integer.parseInt(args[0]);
		if (arg0 < 0) {
			arg0 = -arg0;
		}
		int arg1 = Integer.parseInt(args[1]);
		if (arg1 < 0) {
			arg1 = -arg1;
		}
		System.out.print("��1�� �Է°�:" + args[0] + " ���밪:" + arg0 + ",�̰� ��2�� �Է°� : " + args[1] + ", ���밪 : " + arg1
				+ "�̰�, �μ��� &(and) ���갪 : " + (arg0 & arg1));
	}
}