package day0403;

/**
 * 주민번호를 가지고 유효성 검증, 계산하는 일
 * @author owner
 */
public class ValidSsn {
	
	private String ssn;
	public static final int SSN_LENGTH=14;
	public static final int HYPHEN=6;
	private int birthYear;//태어난 해 저장
	/**
	 * 주민번호를 입력받는 생성자
	 * @param ssn
	 */
	public ValidSsn(String ssn) {
		this.ssn=ssn;
	}//ValidSsn
	
	/**
	 * 주민번호의 길이를 확인하여 14자라면 true 그렇지 않으면 false
	 * @return
	 */
	public boolean lengthCheck() {
		return ssn.length()==SSN_LENGTH;
	}
	
	/**
	 * 주민번호의 6째자리가 -인지 확인
	 * @return
	 */
	public boolean hyphenCheck() {
		return ssn.indexOf('-')==HYPHEN;
	}
	//880101-1234567
	/**
	 * 주민번호의 7번째 자리를 얻는 일
	 * @return 7번째 자리
	 */
	private int flagNumber() {
		return ssn.charAt(7)-'0';//'0'-48,'1'-49,'2'-50...
	}
	/**
	 * 주민번호의 생년월일을 구하기<br>
	 * 예)880101-1234567이 입력된다면
	 * 1988년01월01일 형식으로 반환
	 * @return
	 */
	public String birth() {
		String resultData;
		int flagNum=flagNumber();
		String tempYear="19";
		if(flagNum>2&&flagNum<5) {
			tempYear="20";
		}
		birthYear=Integer.parseInt(tempYear+ssn.substring(0,2));
		resultData=birthYear+"년 "+ssn.substring(2,4)+"월 "+ssn.substring(4,6)+"일";
		return resultData;
	}
	
	public int age() {
		return 2018-birthYear+1;
	}
	
	public String gender() {
		return flagNumber()%2==0?"여자":"남자";
	}
	
	public String foreigner() {
		return flagNumber()==5||flagNumber()==6?"외국인":"내국인";
	}
	
	public String zodiac() {
		String[] zodiac= {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
		return zodiac[birthYear%12];
	}
	
}
