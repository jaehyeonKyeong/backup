package day0322;
/*
	��������
		�Ϲݳ�
			&& , ||
		��Ʈ��
			& , | , ^ ,~ 
*/

class Operator5 {
	public static void main(String[] args) {
		int score=100;
		//������ ������ 0~100 ������ ���� true ���
		System.out.println(score > -1 && score <101 );
		boolean b1=true, b2=true, b3=false, b4=false;
		System.out.println("------------------------------------");
		// && : ������ �����̸� ������ ������� �ʰ� ������ ��������
		System.out.println(b1+"&&"+b2+" = "+(b1&&b2));
		System.out.println(b1+"&&"+b3+" = "+(b1&&b3));
		System.out.println(b3+"&&"+b1+" = "+(b3&&b1));
		System.out.println(b3+"&&"+b4+" = "+(b3&&b4));
		System.out.println("------------------------------------");
		// || : ������ ���̸� ������ ������� �ʰ� ���� ��������
		System.out.println(b1+"||"+b2+" = "+(b1||b2));
		System.out.println(b1+"||"+b3+" = "+(b1||b3));
		System.out.println(b3+"||"+b1+" = "+(b3||b1));
		System.out.println(b3+"||"+b4+" = "+(b3||b4));
		
		int i=38; // 0010 0110 
		int j=13; // 0000 1101
		System.out.println(i+"&"+j+" = "+(i&j)); //AND	0000 0100 = 4
		System.out.println(i+"|"+j+" = "+(i|j)); //OR		0010 1111 = 47
		System.out.println(i+"^"+j+" = "+(i^j)); //XOR	0010 1011 = 43
		
		//AND�� ������ �����̸� ������ ������� �ʴ´�
		b1=true; //����
		b2=true; //����
		b3=true; //��ü����
		//b3=(b1=4>3)&&(b2=5<6); //��ü true
		//b3=(b1=4>3)&&(b2=5>6); //���� T ,���� F, ���� F
		//b3=(b1=4<3)&&(b2=5<6); //���� F, ���� T, ���� F
		b3=(b1=4<3)&&(b2=5>6); //���� F, ���� F, ���� F  ������ ������ �� ������ ������� �ʾ� b2���� �ʱⰪ true�� �״�� ������ �ִ�
		System.out.println("���� : "+b1+", ���� : "+b2+", ���� : "+b3);

		b1=true; //����
		b2=true; //����
		b3=true; //��ü����
		//b3=(b1=4>3)||(b2=5<6); //��ü true					������ ���� �� ������ ������� �ʾ� b2���� �ʱⰪ true�� �״�� ������ �ִ�
		b3=(b1=4>3)||(b2=5>6); //���� T ,���� F, ���� T	������ ���� �� ������ ������� �ʾ� b2���� �ʱⰪ true�� �״�� ������ �ִ�
		//b3=(b1=4<3)||(b2=5<6); //���� F, ���� T, ���� T
		//b3=(b1=4<3)||(b2=5>6); //���� F, ���� F, ���� F 
		System.out.println("���� : "+b1+", ���� : "+b2+", ���� : "+b3);


	}//main
}//class
