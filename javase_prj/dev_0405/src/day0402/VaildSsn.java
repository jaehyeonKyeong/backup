package day0402;

public class VaildSsn {
	private String ssn;

	public VaildSsn(String ssn) {
		this.ssn = ssn;
	}

	// 14자리
	public boolean ssnLengthCheck() {
		return ssn.length() == 14;
	}

	// '-'
	public boolean hyphenCheck() {
		return ssn.charAt(6) == '-';

	}

	// 생년월일
	public String birth() {
		return (((ssn.charAt(7) == '1' || ssn.charAt(7) == '2') ? "19"
				: "20") + ssn.substring(0, 2) + "년 " + ssn.substring(2, 4) + "월 " + ssn.substring(4, 6) + "일");

	}

	// 나이
	public int age() {
		return 2018
				- (Integer.parseInt(((ssn.charAt(7) == '1' || ssn.charAt(7) == '2') ? "19" : "20") + ssn.substring(0, 2)))
				+ 1;

	}

	// 성별
	public String gender() {
		return ((ssn.charAt(7) == '1' || ssn.charAt(7) == '3') ? "남자" : "여자");

	}

	// 외국인
	public String foreigner() {
		return ((ssn.charAt(7) == '5' || ssn.charAt(7) == '6') ? "외국인" : "내국인");

	}

	// 띠
	public String zodiac() {
		int born = (Integer.parseInt(((ssn.charAt(7) == '1' || ssn.charAt(7) == '2') ? "19" : "20") + ssn.substring(0, 2)));
		String animal[] = { "양", "말", "뱀", "용", "토끼", "호랑이", "소", "쥐", "돼지", "개", "닭", "원숭이" };
		return animal[11 - (born % 12)];
	}

}
