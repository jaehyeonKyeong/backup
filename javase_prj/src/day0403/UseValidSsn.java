package day0403;

/**
 * �ֹι�ȣ�� ��ȿ�� ���� ���
 * @author owner
 */
public class UseValidSsn {

	public static void main(String[] args) {
		String[] ssn= {"880101-1234567","880101-2234567","000101-3234567",
				"000101-4234567","880101-123456","8801011-234567","880101-5234567"};
		ValidSsn v_ssn=null;
		
		System.out.println("��ȣ\t�ֹι�ȣ\t\t����\t������\t�ܱ��ο���\t�������\t\\t����\t����\t��");
		for(int i=0; i<ssn.length; i++) {
			System.out.printf("%d\t%s\t",i+1,ssn[i]);
			v_ssn=new ValidSsn(ssn[i]);
			System.out.printf("%s\t%s\t%s\t",v_ssn.lengthCheck(),v_ssn.hyphenCheck(),v_ssn.foreigner());
			if(v_ssn.lengthCheck() && v_ssn.hyphenCheck()&&v_ssn.foreigner().equals("������")) {
				System.out.printf("%s\t%d\t%s\t%s",v_ssn.birth(),v_ssn.age(),v_ssn.gender(),v_ssn.zodiac());
			}
			System.out.println();
		}
	}

}
