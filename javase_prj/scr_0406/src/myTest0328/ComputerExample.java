package myTest0328;

public class ComputerExample {
	static float num=1.3F;

	public static void main(String[] args) {
		
		Computer myCom= new Computer();
		
		
		int[] value1= {1,2,5};
		int result1=myCom.sum1(value1);
		System.out.println("result1 : "+result1);
		
		int result2= myCom.sum1(new int[] {2,3,4});
		System.out.println("result2 : "+result2);
		
		int result3= myCom.sum2(3,4,5);
		System.out.println("result3 : "+result3);
		
		int result5= myCom.sum2(value1);
		System.out.println("result5 : "+result5);
		
		int result6= myCom.sum2(new int[] {2,3,4});
		System.out.println("result6 : "+result6);
		
		//static ������ ��ü�� �̿��� ������ ������� �ʴ´�
//		System.out.println(myCom.num);
		
		System.out.println(Computer.num); //static�� ��ü���� ���� ȣ�� ����
		System.out.println(myCom.num2);
//		System.out.println(Computer.num2); static�� �ƴ� instance������ ��ü ���� �ҷ��� �� ����
		System.out.println(num);
		
//		int result4= myCom.sum1(3,4,5);
		
		
		

	}

}
