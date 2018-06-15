package day0404;

public class LeeHyungSik extends Person {
	
	private int total;
	private int win;
	private int lose;
	private String result;
	private String address;
	
	public LeeHyungSik() {
		total=125;
		win=50;
		lose=34;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getAddress() {
		return address;
	}
	
	
	public void print() {
		System.out.println(getName()+"의 주소 : "+address);
		
	}
	
	public String rockPaperScissors(String myChoice) {
		
		String yourChoice = selectChoice();
		total++;
		switch (compare(myChoice,yourChoice)) {
		case 1:
			win++;
			result="승리";
			break;
		case -1:
			lose++;
			result="패배";
			break;
		default :
			result="비김";
			break;
		}
		return "나 : "+myChoice+" vs 상대편 : "+yourChoice+"  "+result+"!!!\t총 "+total+"번 중 "+win+"번 승리, "+lose+"번 패배, "+(total-win-lose)+"번 비김";
	}
	
	public String selectChoice() {
		
		int randomNumber = (int)(Math.random()*3+1);
		switch(randomNumber) {
		case 1 : 
			return "가위";
		case 2 :
			return "바위";
		default :
			return "보";
		}
	}
	
	public int compare(String myChoice, String yourChoice) {
		if(myChoice.equals(yourChoice)) {
			return 0;
		} else if(myChoice.equals("가위")){
			return yourChoice.equals("바위")?-1:1;
		}else if(myChoice.equals("바위")){
			return yourChoice.equals("보")?-1:1;
		} else {
			return yourChoice.equals("가위")?-1:1;
		}
	}
	//Override
	public String eat(String food, int price) {
		return getName()+"이 야시장에서 "+price+"원인 " +food+"을(를) 사먹습니다.";
	}
	
	public String eat() {
		return getName()+"이 양재동 집에서  김치도 없이 라면을 먹습니다.";
	}

	@Override
	public String[] language() {
		return "한국어,영어".split(",");
	}


}
