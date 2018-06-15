package day0411;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import day0410.StudentVO;

/**
 * 키와 값으로 이루어진 데이터형 Map 사용
 * 
 * @author owner
 */
public class UseMap {

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public UseMap() {
		this(0);
		
		// JDK1.4에서는 Generic이 없기 때문에 모든 객체가 키와 값으로 사용될 수 있었음.
		// 입력할때는 상관없으나 출력하여 사용할 때 문제가 발생할 수 있다.
		Map map = new HashMap(100);
		// 값 입력 : 키는 중복될 수 없고 값은 중복 가능
		map.put("Java", "완벽한 OOP언어");
		map.put("Oracle", "대용량 데이터베이스");
		map.put("JSP", "자바 언어를 기반으로 만든 SSS(Server Side Script)");
		map.put("Java", "완벽한 OOP언어, memory관리를 개발자가 하지 않습니다.");
		map.put(1, "완벽한 OOP언어, memory관리를 개발자가 하지 않습니다.");

		System.out.println("map의 크기 : " + map.size());
		System.out.println(map);

		// 모든 키 얻기
		Set set = map.keySet();
		System.out.println("모든키 : " + set);

		// 값 삭제
		map.remove("Oracle");
		map.remove(1);
		System.out.println(map);

		// 키가 존재하는지
		System.out.println(map.containsKey("Java"));

		// 키에 따른 값 얻기
		System.out.println(map.get("Java"));
		System.out.println(map.get("java"));

		Iterator ita = set.iterator();

		// map이 가지고 있는 모든 키를 가져와서 모든 값을 꺼낼때
		while (ita.hasNext()) {
			System.out.println(map.get(ita.next()));
		} // while
		

	}// constructor
	
	
	private Map<Integer, StudentVO> map;
	
	
	public UseMap(int i) {
		List<StudentVO> list = new ArrayList<StudentVO>();
		list.add(new StudentVO(1, "지승민", 28, 87, "인천시 계양구"));
		list.add(new StudentVO(20, "장현준", 27, 91, "수원시 권선구"));
		list.add(new StudentVO(3, "신종성", 27, 73, "용인시 수지구"));
		list.add(new StudentVO(14, "경제현", 25, 99, "경기도 권선구"));
		list.add(new StudentVO(5, "송재원", 25, 85, "성남시 남한산성"));
		
		
		map=new HashMap<Integer,StudentVO>();
		//list에 추가된 데이터를 사용하여 map에 추가
		for(StudentVO temp: list) {
			map.put(temp.getNum(), temp);
		}
	}//constructor overloading

	/**
	 * 생성하면 11개의 행이 자동 생성됨.
	 */
	public void useHashtable() {
		Map<String, String> bloodMap=new Hashtable<String, String>();
		bloodMap.put("A", 	"세심하다, 친절하다, 배려심깁다(^o^)b");
		bloodMap.put("B", "터프하다 (/^^)/");
		bloodMap.put("AB", "싸이코 (@,.@)");
		bloodMap.put("O", "우유부단 ~(^^~)(~^^)~");
		bloodMap.put("A", "소심하다(☞^_^☜)");
		
		String key="a";
		key=key.toUpperCase();//입력된 혈액형이 소문자일 수 도 있기 때문에 대문자로 변경
		if(bloodMap.containsKey(key)) {
			String value=bloodMap.get(key);
			System.out.println(key+"형의 특징은"+value);
		}else {
			System.out.println(key+"형의 혈액형은 존재하지 않습니다.");
		}
		
		
	}//useHastable

	/**
	 * 생성하면 16개의 행이 자동 생성됨.
	 */
	public void useHashMap() {
		Map<String, String> map=new HashMap<String,String>();
		map.put("사면초가", "사방이 막혀 도주불가");
		map.put("파죽지세", "기세를 막을 수 없다");
		map.put("온고지신", "옛것을 기초로 새로운 것을 배우다");
		map.put("주경야독", "낮에는 일하고 밤에는 공부한다");
		map.put("순망치한", "입술이 없으면 징그러워요");
		map.put("청출어람", "니가....나를...!");
		map.put("죽마고우", "친해요");
		
		String key="청출어람";
		String value=map.get(key);
		
		if(value!=null) {
			System.out.println(key+" : "+value);
		}else {
			System.out.println(key+"의 뜻은 아직 준비 되지 않았습니다");
		}//if
	}//useHasMap
	
	/**
	 * 	학생의 정보를 찾아서 학생 데이터를 반환하는 일.
	 * @param num 학생번호
	 * @return 학생의 정보
	 */
	public StudentVO stuInfo(int num){
		StudentVO sv=null;
		//데이터를 호출할때마다 생성하지 않기 위해 코드를 생성자로 이동
		
		
		
		//입력된 번호를 가지고 Map에서 조회
		sv=map.get(num);
		
		return sv;
	}
	 

	public static void main(String[] args) {
		UseMap um=new UseMap();
		System.out.println("---------- Hashtable ---------\n");
		um.useHashtable();
		System.out.println();
		System.out.println("---------- HashMap ---------\n");
		um.useHashMap();
		System.out.println();
		System.out.println("---------- 객체를 value로 가졌을때 ---------");
		int num=20;
		//호출할때마다 데이터를 생성하고 Map에 값을 넣은 후 조회
		StudentVO sv=um.stuInfo(num); 
		if(sv==null) {
			System.out.println(num+"번의 학생 정보는 존재하지 않습니다");
		}else {
			System.out.println(num+"번 학생의 정보");
			System.out.println("이름 :"+sv.getName());
			System.out.println("나이 :"+sv.getAge());
			System.out.println("주소 :"+sv.getAddr());
			System.out.println("자바점수 :"+sv.getJavaScore());
		}
	}

}
