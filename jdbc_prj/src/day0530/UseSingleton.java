package day0530;

public class UseSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����ڰ� private�̹Ƿ� �ܺο��� ��üȭ �Ҽ� ����.
		//singleton single=new singleton():
		//��ü�� ��� method ���
		Singleton single=Singleton.getInstance();
		Singleton single1=Singleton.getInstance();
		System.out.println(single+" / "+single1);
		//��ü�� ������ �� �ϳ��� ��ü ���

	}

}
