package day0323;
class className {
	public static void main(String[] args) {
			//�̸��� �Է� �޾� "���¹�" �̶�� ������ �ٿ� �̸��� ����ϰ�
			//���¹��� �ƴ϶�� �̸��� ���
		if(args[0].equals("���¹�")){
		System.out.print("���� ");
		}
		System.out.print(args[0]+"�� �ȳ��ϼ���?");
		if(args[0].equals("���¹�")){
		System.out.print("~(^^~)(~^^)~");
		}
					//�ι�° ���ڸ� �޾Ƽ� ���밪���� ����� ���
		int num=Integer.parseInt(args[1]);
		System.out.print("�Է°� : "+num);
		if(num<0){
			num=-num;		
		}
		System.out.print("���밪 : "+num);
	}//main
}//class
