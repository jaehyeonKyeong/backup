package day0402;

public class VaildSsnRun {

	public static void main(String[] args) {
		String[] ssn = { "910101-1234567", "890101-2234567", "000101-3234567", "010101-4234567", "880101-123456",
				"8801011-234567", "880101-5234567" };
		for (int i = 0; i < ssn.length; i++) {
			VaildSsn vs = new VaildSsn(ssn[i]);
//			System.out.printf("주민번호길이\t하이픈\t외국인여부\t생년월일\t나이\t성별\t띠\t");
			System.out.printf("=======%s=======\n", ssn[i]);
			if (vs.ssnLengthCheck()) {
				if (vs.hyphenCheck()) {
					if (vs.foreigner().equals("내국인")) {
						System.out.printf("생년월일\t: %s\n", vs.birth());
						System.out.printf("나이\t: %s\n", vs.age());
						System.out.printf("성별\t: %s\n", vs.gender());
						System.out.printf("띠\t: %s\n", vs.zodiac());
					} else {
						System.out.println("외국인");
					}
				} else {
					System.out.println("'-'이 제자리에 없습니다");
				}
			} else {
				System.out.println("주민번호 길이가 잘못 되었습니다.");
			}
		}

	}

}
