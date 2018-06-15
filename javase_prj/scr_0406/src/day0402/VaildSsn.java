package day0402;

public class VaildSsn {
	private String ssn;

	public VaildSsn(String ssn) {
		this.ssn = ssn;
	}

	// 14�ڸ�
	public boolean ssnLengthCheck() {
		return ssn.length() == 14;
	}

	// '-'
	public boolean hyphenCheck() {
		return ssn.charAt(6) == '-';

	}

	// �������
	public String birth() {
		return (((ssn.charAt(7) == '1' || ssn.charAt(7) == '2') ? "19"
				: "20") + ssn.substring(0, 2) + "�� " + ssn.substring(2, 4) + "�� " + ssn.substring(4, 6) + "��");

	}

	// ����
	public int age() {
		return 2018
				- (Integer.parseInt(((ssn.charAt(7) == '1' || ssn.charAt(7) == '2') ? "19" : "20") + ssn.substring(0, 2)))
				+ 1;

	}

	// ����
	public String gender() {
		return ((ssn.charAt(7) == '1' || ssn.charAt(7) == '3') ? "����" : "����");

	}

	// �ܱ���
	public String foreigner() {
		return ((ssn.charAt(7) == '5' || ssn.charAt(7) == '6') ? "�ܱ���" : "������");

	}

	// ��
	public String zodiac() {
		int born = (Integer.parseInt(((ssn.charAt(7) == '1' || ssn.charAt(7) == '2') ? "19" : "20") + ssn.substring(0, 2)));
		String animal[] = { "��", "��", "��", "��", "�䳢", "ȣ����", "��", "��", "����", "��", "��", "������" };
		return animal[11 - (born % 12)];
	}

}
