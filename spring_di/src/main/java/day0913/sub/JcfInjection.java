package day0913.sub;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Getter;

@Getter
public class JcfInjection {
	
	private List<String> list;
	private Set<String> set;
	private Map<String, String> map;
	private List<DataVO> dataList;
	
	public JcfInjection(List<String> list) {
		this.list = list;
	}
	
	public JcfInjection(Set<String> set) {
		this.set = set;
	}
	
	public JcfInjection(Map<String, String> map) {
		this.map = map;
	}

	public JcfInjection(List<DataVO> dataList,int i) {
		this.dataList = dataList;
	}
	
	
	

}
