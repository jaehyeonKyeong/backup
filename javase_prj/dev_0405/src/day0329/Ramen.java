package day0329;

public class Ramen {
	
	private String ramenName;
	private int ramenNumber;
	private int time;
	private boolean addMore;
	private boolean eatFresh;
	
//	������ �߰�, ���� �Դ� ��ɰ� �ѼŸԴ� ��� �߰� (return String)
	
	//���� �Դ� ������
	public Ramen() {
		ramenName="�ƹ��ų�";
		ramenNumber=1;
		time =5;
		addMore = false;
		eatFresh= false;
	}
	
	/*
	public Ramen(String ramenName, int ramenNumber, int time, boolean addMore) {
		ramenName="�ƹ��ų�";
		ramenNumber=1;
		time =5;
		addMore = false;
		howToEat="����";
	}
	
	public Ramen(String ramenName, int ramenNumber, boolean soup) {
		ramenName="�ƹ��ų�";
		ramenNumber=1;
		soup=true;
		howToEat="�μ�";
	
	}
*/
	
	// get
	public String getRamenName() {
		return ramenName;
			}
	
	public int getRamenNumber() {
		return ramenNumber;
		}

	public int getTime() {
		return time;
		}

	public boolean isAddMore() {
		return addMore;
		}
	
	public boolean isEatFresh() {
		return eatFresh;		
	}
	
	//set
	public void setRamenName(String ramenName) {
		this.ramenName=ramenName;
			}
	
	public void setRamenNumber(int ramenNumber) {
		this.ramenNumber=ramenNumber;
		}

	public void setTime(int time) {
		this.time=time;
		}

	public void setAddMore(boolean addMore) {
		this.addMore=addMore;
		}
	
	public void setEatFresh(boolean eatFresh) {
		this.eatFresh=eatFresh;
	}
	
	public String eat() {
		return ramenName+" ��� "+ ramenNumber+"���� "+((addMore)?"�ĸ� �־ ":"�ĸ� ���� �ʰ� ")+time+((eatFresh)?"�������� ":"�� ���� ")+((eatFresh)?"�μ�":"����")+"�� ���ְ� �Խ��ϴ�.";
	}
	

}
