package kr.co.sist.vo;

import lombok.Data;

@Data
public class CpEmpVO {
	private int empno, sal, comm;
	private String ename;
	
	
	public CpEmpVO(int empno, int sal, int comm, String ename) {
		super();
		this.empno = empno;
		this.sal = sal;
		this.comm = comm;
		this.ename = ename;
	}
	
	
	
}//class
