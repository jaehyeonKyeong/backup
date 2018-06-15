package day0411;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.GapContent;

@SuppressWarnings("unused")
public class Homework2 {
	
	Map<Integer, String[]> groupMap=new HashMap<Integer, String[]>();
	String[] groupCap= null;
	public Homework2() {
		
		//����
		groupMap.put(1, new String[] {"������","������","������","������","�����"} );
		groupMap.put(2, new String[] {"�����","������","������","���ֿ�","������"} );
		groupMap.put(3, new String[] {"�����","���ҿ�","������","�̵���","������"} );
		groupMap.put(4, new String[] {"�����","�̻���","�赿��","���渲","���¹�"} );
		
		//����
		groupCap= new String[]{"������","������","�����","���¹�"};
		
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
					System.out.print("����");
				}
			}
			System.out.println("\t"+name);
		}
		
	}
}
