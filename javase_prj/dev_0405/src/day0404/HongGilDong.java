package day0404;

/**
 * Person Ŭ������ �ڽ� Ŭ���� <br>
 * ����� ���� Ư¡(��,��,��,�̸�,�Դ���)�� Person���� ������ ����ϰ� <br>
 * �ڽŸ��� Ư¡(�ο�����)�� ���� <br>
 * �ο� ������ ���� 10
 * 
 * @author owner
 */
public class HongGilDong extends Person {

	private int level;

	/**
	 * �⺻������ : �����Ǹ� �ο�ɷ��� 7�� ����
	 */
	public HongGilDong() {
		level = 7;
	}// HongGilDong
	
	
	/**
	 * ���� ȫ�浿�� �ο� �ɷ�ġ
	 * @return �ɷ�
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param your_level
	 * @return �ο��� ���
	 */
	public String fight(int your_level) {
		String result = "";
		if (level > your_level) {
			result = "�̰���.s('.^)v;";
			level++;
			if (level > 10) {
				level = 10;
			}
		} else if (level < your_level) {
			result = "����. Orz";
			level--;
			if (level < 0) {
				level = 0;
			}
		} else {
			result = "�����";
		}
		return result;
	} // fight
	
	/* (non-Javadoc)
	 * 	�θ�Ŭ�������� �����ϴ� ����� ���� �ʾ� Override
	 * @see day0404.Person#eat(java.lang.String, int)
	 */
	@Override
	public String eat() {
		return getName()+"�� ������ ���� �Խ��ϴ�.";
	}
	
	@Override
	public String eat(String menu,int price) {
		return getName()+"�� �ָ����� "+menu+"�� ������ "+price+"�� ���� ��Խ��ϴ�.";
	}
	
	public String[] language() {
		return "�ѱ���,�߱���,��ȭ".split(",");
	}//language
	
}//class
