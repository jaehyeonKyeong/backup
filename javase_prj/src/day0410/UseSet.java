package day0410;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *	데이터가 순차적으로 입력되지 않고, 중복값을 저장하지 않으며, 검색의 기능이 없는 Set
 * @author owner
 */
public class UseSet {

	public UseSet() {
		//1.선언+생성)
		Set<String> set=new HashSet<String>();
		//2.값할당)
		set.add("지승민");
		set.add("이상훈");
		set.add("신종성");
		set.add("김우현");
		set.add("신종성");//중복값 저장 불가
		set.add("장현준");
		set.add("송재원");//입력되는 데이터의 순서가 없음
		
		//배열로 보내기
		String[] temp=new String[set.size()];
		set.toArray(temp);
		
		System.out.println(set+" 크기 "+set.size());
		
		//값삭제
//		set.remove("지승민");
		set.clear();
		
		//값얻기
		Iterator<String> ita =set.iterator();
		while(ita.hasNext()) { //요소가 존재하는지?
			System.out.println(ita.next());//값을 얻고 포이터 이동
		}
		
	}//Constructor
	public static void main(String[] args) {
		new UseSet();
	}//main
}//class
