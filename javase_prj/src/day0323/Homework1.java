package day0323;
class Homework1{
	public static void main(String[] args){
		
		System.out.println("============���� 1=============");
		int price = Integer.parseInt(args[3]);
		System.out.println();
		if(args[1].equals("Ư��")){
			System.out.println(args[0]+"�� "+args[1]+"������� "+args[2]+" ��ǰ�� ���� " +price+"������ ���ι޾� ����ݾ� "+(int)(price*0.7)+"���Դϴ�.");
		}
		if(args[1].equals("�Ϲ�")){
			System.out.println(args[0]+"�� "+args[1]+"������� "+args[2]+" ��ǰ�� ���� " +price+"������ ���ι޾� ����ݾ� "+(int)(price*0.9)+"���Դϴ�.");
		}


	}
}
