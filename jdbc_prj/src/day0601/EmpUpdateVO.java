package day0601;

public class EmpUpdateVO {
	private int empno,sal;

	public EmpUpdateVO() {
	}

	public EmpUpdateVO(int empno, int sal) {
		this.empno = empno;
		this.sal = sal;
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
	
	
}
