package kr.co.sist.vo;

import java.util.List;

import kr.co.sist.domain.Emp;

public class SelectProcVO {    
	private int deptno;// 조회할 부서 번호 
	private List<Emp> emp; // 조회할 결과를 저장할 List
	public SelectProcVO() {
	}
	public SelectProcVO(int deptno, List<Emp> emp) {
		this.deptno = deptno;
		this.emp = emp;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public List<Emp> getEmp() {
		return emp;
	}
	public void setEmp(List<Emp> emp) {
		this.emp = emp;
	}
	
}
