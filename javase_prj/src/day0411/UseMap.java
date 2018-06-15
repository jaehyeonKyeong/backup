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
 * Ű�� ������ �̷���� �������� Map ���
 * 
 * @author owner
 */
public class UseMap {

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public UseMap() {
		this(0);
		
		// JDK1.4������ Generic�� ���� ������ ��� ��ü�� Ű�� ������ ���� �� �־���.
		// �Է��Ҷ��� ��������� ����Ͽ� ����� �� ������ �߻��� �� �ִ�.
		Map map = new HashMap(100);
		// �� �Է� : Ű�� �ߺ��� �� ���� ���� �ߺ� ����
		map.put("Java", "�Ϻ��� OOP���");
		map.put("Oracle", "��뷮 �����ͺ��̽�");
		map.put("JSP", "�ڹ� �� ������� ���� SSS(Server Side Script)");
		map.put("Java", "�Ϻ��� OOP���, memory������ �����ڰ� ���� �ʽ��ϴ�.");
		map.put(1, "�Ϻ��� OOP���, memory������ �����ڰ� ���� �ʽ��ϴ�.");

		System.out.println("map�� ũ�� : " + map.size());
		System.out.println(map);

		// ��� Ű ���
		Set set = map.keySet();
		System.out.println("���Ű : " + set);

		// �� ����
		map.remove("Oracle");
		map.remove(1);
		System.out.println(map);

		// Ű�� �����ϴ���
		System.out.println(map.containsKey("Java"));

		// Ű�� ���� �� ���
		System.out.println(map.get("Java"));
		System.out.println(map.get("java"));

		Iterator ita = set.iterator();

		// map�� ������ �ִ� ��� Ű�� �����ͼ� ��� ���� ������
		while (ita.hasNext()) {
			System.out.println(map.get(ita.next()));
		} // while
		

	}// constructor
	
	
	private Map<Integer, StudentVO> map;
	
	
	public UseMap(int i) {
		List<StudentVO> list = new ArrayList<StudentVO>();
		list.add(new StudentVO(1, "���¹�", 28, 87, "��õ�� ��籸"));
		list.add(new StudentVO(20, "������", 27, 91, "������ �Ǽ���"));
		list.add(new StudentVO(3, "������", 27, 73, "���ν� ������"));
		list.add(new StudentVO(14, "������", 25, 99, "��⵵ �Ǽ���"));
		list.add(new StudentVO(5, "�����", 25, 85, "������ ���ѻ꼺"));
		
		
		map=new HashMap<Integer,StudentVO>();
		//list�� �߰��� �����͸� ����Ͽ� map�� �߰�
		for(StudentVO temp: list) {
			map.put(temp.getNum(), temp);
		}
	}//constructor overloading

	/**
	 * �����ϸ� 11���� ���� �ڵ� ������.
	 */
	public void useHashtable() {
		Map<String, String> bloodMap=new Hashtable<String, String>();
		bloodMap.put("A", 	"�����ϴ�, ģ���ϴ�, ����ɱ��(^o^)b");
		bloodMap.put("B", "�����ϴ� (/^^)/");
		bloodMap.put("AB", "������ (@,.@)");
		bloodMap.put("O", "�����δ� ~(^^~)(~^^)~");
		bloodMap.put("A", "�ҽ��ϴ�(��^_^��)");
		
		String key="a";
		key=key.toUpperCase();//�Էµ� �������� �ҹ����� �� �� �ֱ� ������ �빮�ڷ� ����
		if(bloodMap.containsKey(key)) {
			String value=bloodMap.get(key);
			System.out.println(key+"���� Ư¡��"+value);
		}else {
			System.out.println(key+"���� �������� �������� �ʽ��ϴ�.");
		}
		
		
	}//useHastable

	/**
	 * �����ϸ� 16���� ���� �ڵ� ������.
	 */
	public void useHashMap() {
		Map<String, String> map=new HashMap<String,String>();
		map.put("����ʰ�", "����� ���� ���ֺҰ�");
		map.put("��������", "�⼼�� ���� �� ����");
		map.put("�°�����", "������ ���ʷ� ���ο� ���� ����");
		map.put("�ְ�ߵ�", "������ ���ϰ� �㿡�� �����Ѵ�");
		map.put("����ġ��", "�Լ��� ������ ¡�׷�����");
		map.put("û����", "�ϰ�....����...!");
		map.put("�׸����", "ģ�ؿ�");
		
		String key="û����";
		String value=map.get(key);
		
		if(value!=null) {
			System.out.println(key+" : "+value);
		}else {
			System.out.println(key+"�� ���� ���� �غ� ���� �ʾҽ��ϴ�");
		}//if
	}//useHasMap
	
	/**
	 * 	�л��� ������ ã�Ƽ� �л� �����͸� ��ȯ�ϴ� ��.
	 * @param num �л���ȣ
	 * @return �л��� ����
	 */
	public StudentVO stuInfo(int num){
		StudentVO sv=null;
		//�����͸� ȣ���Ҷ����� �������� �ʱ� ���� �ڵ带 �����ڷ� �̵�
		
		
		
		//�Էµ� ��ȣ�� ������ Map���� ��ȸ
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
		System.out.println("---------- ��ü�� value�� �������� ---------");
		int num=20;
		//ȣ���Ҷ����� �����͸� �����ϰ� Map�� ���� ���� �� ��ȸ
		StudentVO sv=um.stuInfo(num); 
		if(sv==null) {
			System.out.println(num+"���� �л� ������ �������� �ʽ��ϴ�");
		}else {
			System.out.println(num+"�� �л��� ����");
			System.out.println("�̸� :"+sv.getName());
			System.out.println("���� :"+sv.getAge());
			System.out.println("�ּ� :"+sv.getAddr());
			System.out.println("�ڹ����� :"+sv.getJavaScore());
		}
	}

}
