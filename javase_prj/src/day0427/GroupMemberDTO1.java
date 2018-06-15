package day0427;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class GroupMemberDTO1 implements Serializable {
	private List<String> list;

	public GroupMemberDTO1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupMemberDTO1(List<String> list) {
		super();
		this.list = list;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
}
