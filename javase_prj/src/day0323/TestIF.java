package day0323;
/**
	���� if ��� : ���ǿ� ���� ��쿡�� �ڵ带 �����ؾ� �Ҷ�
	if(���ǽ�){
		���ǿ� ������ ������ �����... ;
	}//end if
*/

class TestIF{
	public static void main(String[] args) {
		//�̸��� �Է¹޾� "���¹�" �̶�� "����"�� �ٿ� �̸��� ����ϰ�
		// ���¹��� �ƴ϶�� �̸��� ���
		if(args[0].equals("���¹�")){
			System.out.print("���� ");
		}//end if
		System.out.println(args[0] + "�� �ȳ��ϼ���?");

		//�ι�° ���ڸ� �޾Ƽ� ���밪���� ����� ���
		int num=Integer.parseInt(args[1]);
		System.out.println("�Է°� : " +num);
		if(num<0){
			num= -num;
		}
		System.out.println("���밪 : "+num);
	}// main
}// class