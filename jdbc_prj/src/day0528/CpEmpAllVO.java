package day0528;

import java.sql.Date;

public class CpEmpAllVO {
	private int empno, sal, comm;
	private String ename,hi2;
	private Date hi1;
	
	public CpEmpAllVO() {
	}

	public CpEmpAllVO(int empno, int sal, int comm, String ename, String hi2, Date hi1) {
		this.empno = empno;
		this.sal = sal;
		this.comm = comm;
		this.ename = ename;
		this.hi2 = hi2;
		this.hi1 = hi1;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getComm() {
		return comm;
	}

	public void setComm(int comm) {
		this.comm = comm;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getHi2() {
		return hi2;
	}

	public void setHi2(String hi2) {
		this.hi2 = hi2;
	}

	public Date getHi1() {
		return hi1;
	}

	public void setHi1(Date hi1) {
		this.hi1 = hi1;
	}
	
	
	
	
}