package day0330;

import day0404.HongGilDong;

/**
 * ����� �����Ͽ� ����ϴ� Ŭ����
 * @author owner
 */
public class UsePerson extends HongGilDong{

	/**
	 * Java Application : �ܵ����� ���� ������ ���α׷�
	 * @param args ���ڰ�
	 */
	public static void main(String[] args) {
		Person kyungjehyun=new HongGilDong();

		kyungjehyun.setName("������");
		System.out.println("��: "+kyungjehyun.getEye()+"\n��:"+kyungjehyun.getNose()+"\n��:"+kyungjehyun.getMouth()+"\n�̸�:"+kyungjehyun.getName());
		
		System.out.println(kyungjehyun.eat());
		System.out.println(kyungjehyun.eat("��ġ�",  7000));
		
		Person jinban= new HongGilDong();
		jinban.setName("����");
		System.out.println("��: "+jinban.getEye()+"\n��:"+jinban.getNose()+"\n��:"+jinban.getMouth()+"\n�̸�:"+jinban.getName());
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("����",  7000));

		
		
		

	}

}
