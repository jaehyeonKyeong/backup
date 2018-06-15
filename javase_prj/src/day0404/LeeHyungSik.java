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
		System.out.println(getName()+"�� �ּ� : "+address);
		
	}
	
	public String rockPaperScissors(String myChoice) {
		
		String yourChoice = selectChoice();
		total++;
		switch (compare(myChoice,yourChoice)) {
		case 1:
			win++;
			result="�¸�";
			break;
		case -1:
			lose++;
			result="�й�";
			break;
		default :
			result="���";
			break;
		}
		return "�� : "+myChoice+" vs ����� : "+yourChoice+"  "+result+"!!!\t�� "+total+"�� �� "+win+"�� �¸�, "+lose+"�� �й�, "+(total-win-lose)+"�� ���";
	}
	
	public String selectChoice() {
		
		int randomNumber = (int)(Math.random()*3+1);
		switch(randomNumber) {
		case 1 : 
			return "����";
		case 2 :
			return "����";
		default :
			return "��";
		}
	}
	
	public int compare(String myChoice, String yourChoice) {
		if(myChoice.equals(yourChoice)) {
			return 0;
		} else if(myChoice.equals("����")){
			return yourChoice.equals("����")?-1:1;
		}else if(myChoice.equals("����")){
			return yourChoice.equals("��")?-1:1;
		} else {
			return yourChoice.equals("����")?-1:1;
		}
	}
	//Override
	public String eat(String food, int price) {
		return getName()+"�� �߽��忡�� "+price+"���� " +food+"��(��) ��Խ��ϴ�.";
	}
	
	public String eat() {
		return getName()+"�� ���絿 ������  ��ġ�� ���� ����� �Խ��ϴ�.";
	}

	@Override
	public String[] language() {
		return "�ѱ���,����".split(",");
	}


}
