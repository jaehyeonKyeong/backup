package day0718;

public class EmpVO {
	private int empno,sal;
	private String ename,job,hiredate;
	public EmpVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpVO(int empno, int sal, String ename, String job, String hiredate) {
		super();
		this.empno = empno;
		this.sal = sal;
		this.ename = ename;
		this.job = job;
		this.hiredate = hiredate;
	}
	public int getEmpno() {
		return empno;
	}
	public int getSal() {
		return sal;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public String getHiredate() {
		return hiredate;
	}
	
}
