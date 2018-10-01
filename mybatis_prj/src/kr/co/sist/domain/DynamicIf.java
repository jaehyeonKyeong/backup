package kr.co.sist.domain;

public class DynamicIf {
	private int empno, sal, deptno;
	private String ename, hiredate;
	
	public DynamicIf() {
		
	}

	public DynamicIf(int empno, int sal, int deptno, String ename, String hiredate) {
		super();
		this.empno = empno;
		this.sal = sal;
		this.deptno = deptno;
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

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
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

	@Override
	public String toString() {
		return "DynamicIf [empno=" + empno + ", sal=" + sal + ", deptno=" + deptno + ", ename=" + ename + ", hiredate="
				+ hiredate + "]";
	}
	
}
