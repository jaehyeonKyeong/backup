package day0329;

public class Ramen {
	
	private String ramenName;
	private int ramenNumber;
	private int time;
	private boolean addMore;
	private boolean eatFresh;
	
//	생성자 추가, 끓여 먹는 기능과 뿌셔먹는 기능 추가 (return String)
	
	//끓여 먹는 생성자
	public Ramen() {
		ramenName="아무거나";
		ramenNumber=1;
		time =5;
		addMore = false;
		eatFresh= false;
	}
	
	/*
	public Ramen(String ramenName, int ramenNumber, int time, boolean addMore) {
		ramenName="아무거나";
		ramenNumber=1;
		time =5;
		addMore = false;
		howToEat="끓여";
	}
	
	public Ramen(String ramenName, int ramenNumber, boolean soup) {
		ramenName="아무거나";
		ramenNumber=1;
		soup=true;
		howToEat="부셔";
	
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
		return ramenName+" 라면 "+ ramenNumber+"개를 "+((addMore)?"파를 넣어서 ":"파를 넣지 않고 ")+time+((eatFresh)?"조각으로 ":"분 동안 ")+((eatFresh)?"부셔":"끓여")+"서 맛있게 먹습니다.";
	}
	

}
