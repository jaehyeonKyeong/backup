package day0412;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ����ڰ� ������ �������� �� ������ ó�� �� �ڵ� ���� : Event Handling(�̺�Ʈ ó��) �̺�Ʈ ó�� - ��ϵ�(add)�� ��
 * ������Ʈ�� ó��
 * 
 * @author owner
 */
// �̺�Ʈ ó�� Ŭ���� �ۼ���
// 1.ó���� �̺�Ʈ�� �����ϴ� �������̽��� �����Ѵ�.
public class EventTest implements ActionListener {
	// ����ڰ� ������ ���ϸ� JVM�� ������ �����Ͽ� addXXXListener()�� �Ű������� �Էµ� ��ü�� �߻�method�� ȣ���Ͽ�
	// �̺�Ʈ�� ó���Ѵ�.
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("����ڰ� ��ư�� Ŭ������..");
	}// actionPerformed

}// class
