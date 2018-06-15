package day0411;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.GapContent;

@SuppressWarnings("unused")
public class Homework2 {
	
	Map<Integer, String[]> groupMap=new HashMap<Integer, String[]>();
	String[] groupCap= null;
	public Homework2() {
		
		//조원
		groupMap.put(1, new String[] {"이형식","박지영","이진영","신종성","배수진"} );
		groupMap.put(2, new String[] {"김우현","이종민","강지형","최주오","정다은"} );
		groupMap.put(3, new String[] {"송재원","강소예","경제현","이동근","장현준"} );
		groupMap.put(4, new String[] {"김대현","이상훈","김동희","오경림","지승민"} );
		
		//조장
		groupCap= new String[]{"이형식","이종민","송재원","지승민"};
		
		}//constructor

	public String[] member(int groupNum) {
		String[] groupMember=groupMap.get(groupNum);
		return groupMember;		
	}
	public static void main(String[] args) {
		Homework2 work=new Homework2();
		String[] member=work.member(3);
		
		for(String name : member) {
			for(String capName:work.groupCap) {
				if(name.equals(capName)) {
					System.out.print("조장");
				}
			}
			System.out.println("\t"+name);
		}
		
	}
}
