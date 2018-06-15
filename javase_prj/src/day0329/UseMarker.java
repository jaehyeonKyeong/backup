package day0329;

/**
 *	¸¶Ä«Ææ Å¬·¡½º¸¦ °´Ã¼È­ÇÏ¿© »ç¿ëÇÏ´Â Å¬·¡½º
 * @author owner
 */
public class UseMarker {

	public static void main(String[] args) {
		
		Marker black = new Marker();
		
//		System.out.println("¶Ñ²± : "+black.getCap()+", ¸öÃ¼ : "+black.getBody()+", »ö : "+black.getColor());
		
		////////////////////////// 03-30-2018 ÄÚµå ¼öÁ¤ //////////////////////////
//		black.setCap(1);
//		black.setBody(1);
//		black.setColor("°ËÀº");
		System.out.println("¶Ñ²± : "+black.getCap()+", ¸öÃ¼ : "+black.getBody()+", »ö : "+black.getColor());
		System.out.println(black.write("Áö½Â¹ÎÀº Àß »ý°å´Ù."));
		
		////////////////////////// 03-30-2018 ÄÚµå ¼öÁ¤ //////////////////////////
		Marker red = new Marker(2,2,"»¡°­");
//		System.out.println("¶Ñ²± : "+red.getCap()+", ¸öÃ¼ : "+red.getBody()+", »ö : "+red.getColor());
//		red.setCap(2);
//		red.setBody(2);
//		red.setColor("»¡°­");
		System.out.println("¶Ñ²± : "+red.getCap()+", ¸öÃ¼ : "+red.getBody()+", »ö : "+red.getColor());
		System.out.println(red.write("»¡°£ ±Û¾¾"));
		

	}//main

}//class
