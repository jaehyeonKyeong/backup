package day0403;

/**
 * 주민번호의 유효성 검증 사용
 * @author owner
 */
public class UseValidSsn {

	public static void main(String[] args) {
		String[] ssn= {"880101-1234567","880101-2234567","000101-3234567",
				"000101-4234567","880101-123456","8801011-234567","880101-5234567"};
		ValidSsn v_ssn=null;
		
		System.out.println("번호\t주민번호\t\t길이\t하이픈\t외국인여부\t생년월일\t\\t나이\t성별\t띠");
		for(int i=0; i<ssn.length; i++) {
			System.out.printf("%d\t%s\t",i+1,ssn[i]);
			v_ssn=new ValidSsn(ssn[i]);
			System.out.printf("%s\t%s\t%s\t",v_ssn.lengthCheck(),v_ssn.hyphenCheck(),v_ssn.foreigner());
			if(v_ssn.lengthCheck() && v_ssn.hyphenCheck()&&v_ssn.foreigner().equals("내국인")) {
				System.out.printf("%s\t%d\t%s\t%s",v_ssn.birth(),v_ssn.age(),v_ssn.gender(),v_ssn.zodiac());
			}
			System.out.println();
		}
	}

}
