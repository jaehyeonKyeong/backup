package kr.co.sist.vo;

public class EmpInsertVO {
	private String ename, resultMsg;
	private int empno,sal,comm;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
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
	public EmpInsertVO(String ename, String resultMsg, int empno, int sal, int comm) {
		super();
		this.ename = ename;
		this.resultMsg = resultMsg;
		this.empno = empno;
		this.sal = sal;
		this.comm = comm;
	}
	public EmpInsertVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
