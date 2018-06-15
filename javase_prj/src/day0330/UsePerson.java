package day0330;

import day0404.HongGilDong;

/**
 * 사람을 생성하여 사용하는 클레스
 * @author owner
 */
public class UsePerson extends HongGilDong{

	/**
	 * Java Application : 단독으로 실행 가능한 프로그램
	 * @param args 인자값
	 */
	public static void main(String[] args) {
		Person kyungjehyun=new HongGilDong();

		kyungjehyun.setName("경제현");
		System.out.println("눈: "+kyungjehyun.getEye()+"\n코:"+kyungjehyun.getNose()+"\n입:"+kyungjehyun.getMouth()+"\n이름:"+kyungjehyun.getName());
		
		System.out.println(kyungjehyun.eat());
		System.out.println(kyungjehyun.eat("김치찌개",  7000));
		
		Person jinban= new HongGilDong();
		jinban.setName("진반");
		System.out.println("눈: "+jinban.getEye()+"\n코:"+jinban.getNose()+"\n입:"+jinban.getMouth()+"\n이름:"+jinban.getName());
		System.out.println(jinban.eat());
		System.out.println(jinban.eat("선두",  7000));

		
		
		

	}

}
