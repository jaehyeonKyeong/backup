package day0322;
class CheckNaN {
	public static void main(String[] args) {
		double x=5.0;
		double y=0.0;

		double z=x%y;
		if(y==0.0){
		System.out.println("0.0���� ���� �� �����ϴ� ");
		}else{
		double result=z+10;
		System.out.println("��� : "+result);
		}


	}
}
