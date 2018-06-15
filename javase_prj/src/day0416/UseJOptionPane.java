package day0416;

import javax.swing.JOptionPane;
/**
 *
 * @author owner
 */
public class UseJOptionPane {
	String name;
	public void inputDialog() {
		name=
		JOptionPane.showInputDialog(null,"사용자에게 입력받기\n당신의 이름은?");
		System.out.println("입력한 이름:"+name);
	}
	public void messageDialog() {
		JOptionPane.showMessageDialog(null, name+"님 안녕하셍ㅇ여?");
	}
	public void confirmDialog() {
		int selectButton=
				JOptionPane.showConfirmDialog(null, name+"잘생겼나요?");
		System.out.println(selectButton);
		String msg="";
		switch(selectButton) {
		case 0:msg="인정? 어인정 님두염";break;
		case 1:msg="노인정? 응 자기소개";break;
		case 2:msg="응답가치 없음";break;
			default:msg="하기싫음?";
		}
		JOptionPane.showMessageDialog(null, msg);
	}
	public static void main(String[] args) {
		UseJOptionPane ujp=new UseJOptionPane();
		ujp.inputDialog();
		ujp.messageDialog();
		ujp.confirmDialog();
		
	}//main

}//class
