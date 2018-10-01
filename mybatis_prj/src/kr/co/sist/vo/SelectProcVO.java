package kr.co.sist.vo;

import java.util.List;

import kr.co.sist.domain.Emp;

public class SelectProcVO {    
	private int deptno;// ��ȸ�� �μ� ��ȣ 
	private List<Emp> emp; // ��ȸ�� ����� ������ List
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
