package day0402;

public class VaildSsnRun {

	public static void main(String[] args) {
		String[] ssn = { "910101-1234567", "890101-2234567", "000101-3234567", "010101-4234567", "880101-123456",
				"8801011-234567", "880101-5234567" };
		for (int i = 0; i < ssn.length; i++) {
			VaildSsn vs = new VaildSsn(ssn[i]);
//			System.out.printf("�ֹι�ȣ����\t������\t�ܱ��ο���\t�������\t����\t����\t��\t");
			System.out.printf("=======%s=======\n", ssn[i]);
			if (vs.ssnLengthCheck()) {
				if (vs.hyphenCheck()) {
					if (vs.foreigner().equals("������")) {
						System.out.printf("�������\t: %s\n", vs.birth());
						System.out.printf("����\t: %s\n", vs.age());
						System.out.printf("����\t: %s\n", vs.gender());
						System.out.printf("��\t: %s\n", vs.zodiac());
					} else {
						System.out.println("�ܱ���");
					}
				} else {
					System.out.println("'-'�� ���ڸ��� �����ϴ�");
				}
			} else {
				System.out.println("�ֹι�ȣ ���̰� �߸� �Ǿ����ϴ�.");
			}
		}

	}

}
