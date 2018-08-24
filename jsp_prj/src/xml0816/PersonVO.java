package xml0816;

public class PersonVO {
	private String name,addr;
	private int birthYear;
	
	public PersonVO() {
		
	}
	public PersonVO(String name, String addr, int birthYear) {
		super();
		this.name = name;
		this.addr = addr;
		this.birthYear = birthYear;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
}
