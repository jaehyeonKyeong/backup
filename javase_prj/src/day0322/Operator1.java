package day0322;
/**
	���׿����� : ���꿡 �ʿ��� ���� �ϳ��� ������
	~,!,+,-,++,--
*/
class Operator1{
	public static void main(String[] args){
		//~(tilde): 1�� ���� ����
		int i=22;
		int j=-22;
		System.out.println("~"+i+"="+~i);//��ȣ���� 1����
		System.out.println("~"+j+"="+~j);//��ȣ���� 1����
		//!(not) : true<->false
		boolean b= true;
		boolean c= false;
		System.out.println("!"+b+"="+!b);
		System.out.println("!"+c+"="+!c);
		System.out.println("!(3>22)="+!(3>22));
		//+ :������ ����
		System.out.println("+"+i+"="+ +i);
		System.out.println("+"+j+"="+ +j);
		//- :2�� ��������
		System.out.println("-"+i+"="+ -i); // ���� �״�ΰ� ��ȣ�� �ٲ�
		System.out.println("-"+j+"="+ -j);

		//0323 �߰�
		//++ : ��������(���ü�� ���� 1�� ����)
		//-- : ���ҿ���(���ü�� ���� 1�� ����)

		i=23;
		j=23;
		
		//���� : ���ü �տ� ������ ���
		++i; // 23->24
		--j; //23->22
		System.out.println("���� ������ i : "+i+", j: "+j);
		//���� : ���ü �ڿ� ������ ���
		i++;//24->25
		j--;//22->21
		System.out.println("���� ������ i : "+i+", j: "+j);
		//���Կ����ڿ� �Բ� ����ϸ� ������ ������ �ٸ� ���� �����Ѵ�.
		//���� : ���͸���
		int temp=0;
		temp=++i;
		System.out.println("���� �� temp: "+temp+", i :"+i);
		temp=0;
		//���� : ���͸���
		temp=i++;
		System.out.println("���� �� temp: "+temp+", i :"+i);


	}
}