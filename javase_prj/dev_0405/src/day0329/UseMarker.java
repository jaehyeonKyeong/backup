package day0329;

/**
 *	��ī�� Ŭ������ ��üȭ�Ͽ� ����ϴ� Ŭ����
 * @author owner
 */
public class UseMarker {

	public static void main(String[] args) {
		
		Marker black = new Marker();
		
//		System.out.println("�Ѳ� : "+black.getCap()+", ��ü : "+black.getBody()+", �� : "+black.getColor());
		
		////////////////////////// 03-30-2018 �ڵ� ���� //////////////////////////
//		black.setCap(1);
//		black.setBody(1);
//		black.setColor("����");
		System.out.println("�Ѳ� : "+black.getCap()+", ��ü : "+black.getBody()+", �� : "+black.getColor());
		System.out.println(black.write("���¹��� �� �����."));
		
		////////////////////////// 03-30-2018 �ڵ� ���� //////////////////////////
		Marker red = new Marker(2,2,"����");
//		System.out.println("�Ѳ� : "+red.getCap()+", ��ü : "+red.getBody()+", �� : "+red.getColor());
//		red.setCap(2);
//		red.setBody(2);
//		red.setColor("����");
		System.out.println("�Ѳ� : "+red.getCap()+", ��ü : "+red.getBody()+", �� : "+red.getColor());
		System.out.println(red.write("���� �۾�"));
		

	}//main

}//class
