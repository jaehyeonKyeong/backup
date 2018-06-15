package day0404;

import day0405.Fly;

/**
 * Person Ŭ������ �ڽ� Ŭ���� <br>
 * ����� ���� Ư¡(��,��,��,�̸�,�Դ���)�� Person���� ������ ����ϰ� <br>
 * �ڽŸ��� Ư¡(���� ���)�� ���� <br>
 * final Ŭ�����̹Ƿ� �ڽ� Ŭ������ ���� �� ����(��ӵ��� �ʴ� Ŭ����) <br>
 *  ���� �ִ� 10������ ����
 * @author owner
 */
public final class Clark extends Person implements Fly{
	public int power;
	
	public Clark() {
		power=10;
	}//Clark
	
	public String stoneType(String stone) {
		String result="";
		if(stone.equals("���̾Ƹ��")) {
			result="�����մϴ�.";
			power=10;
		} else if (stone.equals("ũ���䳪��Ʈ")) {
			result="���� ������. ~(_-_)~";
			power=0;
		} else {
			result="��г��� �Ѥ�;;";
			power=11;
		}//end else
		return result;
	}
	
	/* (non-Javadoc)
	 * �θ�Ŭ�������� �����ϴ� ����� ���� �ʾ� Override
	 * @see day0404.Person#eat(java.lang.String, int)
	 */
	@Override
	public String eat(String menu,int price) {
		return getName()+"�� ����������� "+menu+"�� ������ "+price+"$ ���� ��Խ��ϴ�.";
	}//eat(String,int)
	
	public String eat() {
		return getName()+"�� ������ ���� �Դ´�.";
	}//eat

	@Override
	public String[] language() {
		String[] lang= {"����","�ܰ��"};
		return lang;
	}
	
	@Override
	public String speed() {
		return getName()+"�� ������ ����.";
	}
	
	
	@Override	
	public String height() {
		return getName()+"�� ���� ����.";
	}
	
	

}//class
