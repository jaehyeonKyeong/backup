package day0403;

/**
 * �ֹι�ȣ�� ������ ��ȿ�� ����, ����ϴ� ��
 * @author owner
 */
public class ValidSsn {
	
	private String ssn;
	public static final int SSN_LENGTH=14;
	public static final int HYPHEN=6;
	private int birthYear;//�¾ �� ����
	/**
	 * �ֹι�ȣ�� �Է¹޴� ������
	 * @param ssn
	 */
	public ValidSsn(String ssn) {
		this.ssn=ssn;
	}//ValidSsn
	
	/**
	 * �ֹι�ȣ�� ���̸� Ȯ���Ͽ� 14�ڶ�� true �׷��� ������ false
	 * @return
	 */
	public boolean lengthCheck() {
		return ssn.length()==SSN_LENGTH;
	}
	
	/**
	 * �ֹι�ȣ�� 6°�ڸ��� -���� Ȯ��
	 * @return
	 */
	public boolean hyphenCheck() {
		return ssn.indexOf('-')==HYPHEN;
	}
	//880101-1234567
	/**
	 * �ֹι�ȣ�� 7��° �ڸ��� ��� ��
	 * @return 7��° �ڸ�
	 */
	private int flagNumber() {
		return ssn.charAt(7)-'0';//'0'-48,'1'-49,'2'-50...
	}
	/**
	 * �ֹι�ȣ�� ��������� ���ϱ�<br>
	 * ��)880101-1234567�� �Էµȴٸ�
	 * 1988��01��01�� �������� ��ȯ
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
		resultData=birthYear+"�� "+ssn.substring(2,4)+"�� "+ssn.substring(4,6)+"��";
		return resultData;
	}
	
	public int age() {
		return 2018-birthYear+1;
	}
	
	public String gender() {
		return flagNumber()%2==0?"����":"����";
	}
	
	public String foreigner() {
		return flagNumber()==5||flagNumber()==6?"�ܱ���":"������";
	}
	
	public String zodiac() {
		String[] zodiac= {"������","��","��","����","��","��","ȣ����","�䳢","��","��","��","��"};
		return zodiac[birthYear%12];
	}
	
}
