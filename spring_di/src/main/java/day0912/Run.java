package day0912;

import java.util.List;

public class Run {
	
	public static void main(String[] args) {
		Assembly as=new Assembly();
		Service s=as.getBean();
		s.addMember("강소예");
		List<String> list=s.searchMember(3);
		for(String name:list) {
			System.out.println(name);
		}
		
	}
}
