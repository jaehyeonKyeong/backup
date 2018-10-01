package day0913.sub;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseJcfInjection {

	public static void main(String[] args) {
		//Spring Context생성
		ApplicationContext ac=new ClassPathXmlApplicationContext("day0913/sub/applicationContext2.xml");
		//2.Bean얻기 : class명으로만은 얻을 수 없고, class명과 id명을 같이 넣어 객체를 찾는다.
		JcfInjection ji_list=ac.getBean("ji_list",JcfInjection.class);
		List<String> list=ji_list.getList();
		System.out.println("------리스트로 값얻기-----");
		//ji_list객체에 리스트만 의존성 주입 되었기 때문에 set과 map은 null을 가진다.
		System.out.println("ji_list set : "+ji_list.getSet()+"\nji_list map : "+ji_list.getMap());
		for(String name:list) {
			System.out.println(name);
		}
		System.out.println("_______________________________");
		JcfInjection ji_set=ac.getBean("ji_set",JcfInjection.class);
		System.out.println("list"+ji_set.getList()+"\nset:"+ji_set.getSet()+"\nmap:"+ji_set.getMap());
		System.out.println("_______________________________");
		JcfInjection ji_map=ac.getBean("ji_map",JcfInjection.class);
		System.out.println("list"+ji_map.getList()+"\nset:"+ji_map.getSet()+"\nmap:"+ji_map.getMap());
		System.out.println("_______________________________");
		JcfInjection ji_datalist=ac.getBean("ji_data",JcfInjection.class);
		System.out.println(ji_datalist.getDataList());
	}

}
