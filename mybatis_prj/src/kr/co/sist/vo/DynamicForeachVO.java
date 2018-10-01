package kr.co.sist.vo;

import java.util.List;

public class DynamicForeachVO {
	
	private List<Integer> deptnoList;
	
	public DynamicForeachVO(List<Integer> deptnoList) {
		this.deptnoList = deptnoList;
	}
	
	public DynamicForeachVO() {
	}

	public List<Integer> getDeptnoList() {
		return deptnoList;
	}

	public void setDeptnoList(List<Integer> deptnoList) {
		this.deptnoList = deptnoList;
	}

	
	

}
