package day0905;

public class DeptDomain {
	private int deptno;
	private String dname, loc;
	
/*	public DeptDomain() {
		System.out.println("기본생성");
	}
	
	public DeptDomain(int deptno, String dname, String loc) {
		System.out.println("인자있는");
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}*/



	public int getDeptno() {
//		System.out.println("값 출력" + deptno);
		return deptno;
	}

	public void setDeptno(int deptno) {
//		System.out.println("값 입력" + deptno);
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
