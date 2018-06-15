package day0528;

public class CpEmpVOUpdate {

	private int empno,sal;
	private String ename;
	public CpEmpVOUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CpEmpVOUpdate(int empno, int sal, String ename) {
		super();
		this.empno = empno;
		this.sal = sal;
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
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	

	
}
