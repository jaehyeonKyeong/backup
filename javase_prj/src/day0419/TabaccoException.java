package day0419;

/**
 * ����� ���� ����ó�� Ŭ����<br>
 * �����ϴ� Ŭ������ ���ܸ� ó���� �� �ֵ��� Exception, RuntimeException�� ��� �޴´�.<br>
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class TabaccoException extends Exception {

	public TabaccoException() {
		this("���� �ǰ��� �طӽ��ϴ�.");

	}// constructor

	public TabaccoException(String msg) {
		super(msg);// �θ� class�� �����ڿ� ���޵� message�� getMessage(),�Ǵ� ����ó�� ��ü�� ����ϰų� printStackTrace()��
					// ȣ���Ҷ� ��µȴ�.
	}// constructor

}// class
