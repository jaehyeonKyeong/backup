package day0329;

/**
 * ��ī Ŭ������ �̿��Ͽ� ��ī�� ����ϴ� Ŭ����
 * @author owner
 */
public class UseMaker {

	public static void main(String[] args) {
		//1 ��ü����
		Marker black=new Marker();
		///////////////////////03-30-2018 �ڵ� ����/////////////////////////
	
		System.out.println("�Ѳ�: "+black.getCap()+", ��ü: "+black.getBody()+", ��: "+black.getColor());
		String msg=black.write("jhjk");
		System.out.println(msg);
		
		Marker red=new Marker(2,2,"red");
	
		msg = red.write("red pen");
		System.out.println("�Ѳ�: "+red.getCap()+", ��ü: "+red.getBody()+", ��: "+red.getColor());
		System.out.println(msg);

	}

}
