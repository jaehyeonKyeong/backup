package day0322;
/*
	������ ���ó�� ����ϱ�
*/
class TestConstant{
	public static final int MAX_VALUE = 100;
	public static final int MIN_VALUE = 0;
	public static void main(String[] args) {
		//�����
		System.out.println(MAX_VALUE+"/"+MIN_VALUE);
		int myScore = 85;
		//Constant�� ���� ������ �� ����
		//TestConstant.MAX_VALUE = 50; //error
		//Ŭ������.�����
		System.out.println("ȹ������ : "+myScore+"���� : "+TestConstant.MAX_VALUE+", �������� �� : "+(TestConstant.MAX_VALUE-myScore)+"��");
			
	}//main
}//class