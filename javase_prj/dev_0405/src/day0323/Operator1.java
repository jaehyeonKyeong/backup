package day0323;
class Operator1 {
	public static void main(String[] args) {
		int i = 10;
		int j = 15;
		System.out.println("-i ="+-i);
		System.out.println("-j ="+-j);
		// ++ : �������� (���ü�� ���� 1�� ����)
		// -- : ���ҿ��� (���ü�� ���� 1�� ����)
		i = 23;
		j = 23;
		// ���� : ���ü �տ� �����ڸ� ���
		++i; //23 -> 24
		--j; // 23 -> 22
		System.out.println("�������� �� i : "+i+", j : "+-j);
		//���� : ���ü �ڿ� �����ڸ� ���
		i++; //24 -> 25
		j--; // 22 -> 21
		System.out.println("�������� �� i : "+i+", j : "+-j);

		//���� �����ڿ� �Բ� ����ϸ� ������ ������ �ٸ� ���� ���
		//���� : ���� ����
		int temp = 0;
		temp = ++i;
		System.out.println("���� �� temp : "+temp+", i : "+i);
		temp = 0;
		//���� : ���� �� ����
		temp = i++;
		System.out.println("���� �� temp : "+temp+", i : "+i);

	}
}
