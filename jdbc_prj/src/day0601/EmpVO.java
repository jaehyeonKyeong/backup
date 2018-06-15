package day0601;

public class EmpVO {
	private int empno,sal,comm;
	private String ename,hiredate;
	
	public EmpVO() {
		
	}
	
	public EmpVO(int empno, int sal, int comm, String ename, String hiredate) {
		this.empno = empno;
		this.sal = sal;
		this.comm = comm;
		this.ename = ename;
		this.hiredate = hiredate;
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
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	
	
}
