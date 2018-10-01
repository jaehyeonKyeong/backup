package kr.co.sist.vo;

public class DynamicSetVO {

	private int empno, sal, comm;
	private String ename;
	public DynamicSetVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DynamicSetVO(int empno, int sal, int comm, String ename) {
		super();
		this.empno = empno;
		this.sal = sal;
		this.comm = comm;
		this.ename = ename;
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
	
	
}
