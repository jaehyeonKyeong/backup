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
		JOptionPane.showInputDialog(null,"����ڿ��� �Է¹ޱ�\n����� �̸���?");
		System.out.println("�Է��� �̸�:"+name);
	}
	public void messageDialog() {
		JOptionPane.showMessageDialog(null, name+"�� �ȳ��ϼĤ���?");
	}
	public void confirmDialog() {
		int selectButton=
				JOptionPane.showConfirmDialog(null, name+"�߻��峪��?");
		System.out.println(selectButton);
		String msg="";
		switch(selectButton) {
		case 0:msg="����? ������ �Եο�";break;
		case 1:msg="������? �� �ڱ�Ұ�";break;
		case 2:msg="���䰡ġ ����";break;
			default:msg="�ϱ����?";
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
