package kr.co.sist.vo;

import lombok.Data;

@Data
public class CpEmpVO2 {
	private String ename;
	private int sal,comm;
	
	
	public CpEmpVO2(String ename, int sal, int comm) {
		super();
		this.ename = ename;
		this.sal = sal;
		this.comm = comm;
	}
	
	
	
}//class
