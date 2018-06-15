package day0410;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * 가변길이형(입력되는 데이터가 있으면 방의 갯수가 증가하고, 삭제되는 데이터가 있으면 방의 갯수가 감소한다)<br>
 * 중복값을 저장하며 순차적으로 값이 입력되고, 검색의 기능이 제공
 * 
 * @author owner
 */
public class UseList {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UseList() {
		// JDK1.4에서 사용할때(Generic이 없고, autoboxing,unboxing이 없다)
		// List list = new ArrayList();
		//
		// // 값 추가
		// // list.add(10); // 기본형 데이터형 입력 불가
		// list.add(new Integer(10));// Wrapper Class 사용;
		// list.add(new Double(12.22));
		// list.add("오늘은 화요일");
		//
		// // 값얻기
		// System.out.println(((Integer)list.get(0)).intValue()*4);

		// autoboxing
		// JDK1.5에서 부터는 기본형 데이터혀이 입력되면 WrapperClass로 자동생성되어 추가된다.
		List<Object> list = new ArrayList();
		// Generic이 사용되지 않으면 모든 값이 입력된다.
		list.add(4);// 기본형 데이터형이 추가되면 그에 대한 Wrapper class로 감싸져서 입력된다.(autoboxing)
		list.add(10);// -> list.add(new Integer(10));
		list.add(4.10);
		list.add("오늘은 화요일");

		for (int i = 0; i < list.size(); i++) {
//			int j= list.get(i);//unboxing
			System.out.println(list.get(i));// 값을 얻을때에는 원래의 형으로 바뀌어져 나오는 Unboxing이 된다.
		}

	}// constructor
	
	@SuppressWarnings("unchecked")
	public List<String> useArrayList() {
		//1.객체생성 :Generic 사용
		@SuppressWarnings("rawtypes")
		List<String> list=new ArrayList();
		//2.값 추가 : 추가 될때마다 방의 크기가 증가
		list.add("경제현");
		list.add("지승민");
		list.add("장현준");
		list.add("김대현");
		list.add("경제현");//중복값 허용
		
		//배열에 복사
		String[] arr=new String[list.size()];
		list.toArray(arr);
		
		//값 삭제
//		list.remove(1);//index로 삭제
//		list.remove("경제현");//입력값과 방의 내용과 같은 중 가장 앞에 있는 것을 삭제
		
		//모든 방의 값 삭제
		list.clear();
		
		//배열의 값은 살아있음.
		for(String name : arr) {
			System.out.println(name);
		}
		
		System.out.println(list+"/"+list.size());
		return list;
	}//useArrayList
	
	public List<String> useVector() {
		//생성
		List<String> list=new Vector<>();
		//값 할당
		list.add("이종민");
		list.add("지승민");
		list.add("지승민");
		list.add("장현준");
		list.add("김동희");//중복값 허용
		list.add("송재원");
		//중간에 값 넣기 : ArrayList나 Vector는 효율이 떨어진다.
		list.add(2,"강소예");
		//삭제 : 뒤지승민 삭제
//		list.remove(3);
		//배열로 목사
		String[] temp=new String[list.size()];

		list.toArray(temp);
		for(String name: temp)
			System.out.println(name);
//		System.out.println("벡터 : "+list+"/"+list.size());
		return list;
		
	}
	
	public List<String> useLinkedList() {
		List<String> list=new LinkedList<>();
		list.add("이종민");
		list.add("지승민");
		list.add("지승민");
		list.add("장현준");
		list.add("김동희");//중복값 허용
		list.add("송재원");
		//중간에 값 넣기 : LinkedList가 가장 좋음.
		list.add(2,"강소예");
		//삭제 : 뒤지승민 삭제
//		list.remove(3);
		//배열로 목사
		String[] temp=new String[list.size()];

		list.toArray(temp);
		for(String name: temp)
			System.out.println(name);
		return list;
		
	}

	public static void main(String[] args) {
		UseList ul=new UseList();
//		List<String> list=ul.useArrayList();
//		List<String> list=ul.useVector();
		List<String> list=ul.useLinkedList();
		System.out.println("-----------------------------------------");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
