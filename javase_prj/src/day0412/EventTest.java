package day0412;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 사용자가 동작을 취했을때 그 동작을 처리 할 코드 정의 : Event Handling(이벤트 처리) 이벤트 처리 - 등록된(add)가 된
 * 컴포넌트만 처리
 * 
 * @author owner
 */
// 이벤트 처리 클래스 작성법
// 1.처리할 이벤트를 감지하는 인터페이스를 구현한다.
public class EventTest implements ActionListener {
	// 사용자가 동작을 취하면 JVM이 동작을 감지하여 addXXXListener()에 매개변수로 입력된 객체의 추상method를 호출하여
	// 이벤트를 처리한다.
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("사용자가 버튼을 클릭했음..");
	}// actionPerformed

}// class
