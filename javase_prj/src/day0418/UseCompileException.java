package day0418;

import javax.swing.JOptionPane;

/**
 * compileException �����ڰ� �ݵ�� ����ó�� �ڵ带 �����Ͽ� ó���ϴ� ����
 * @author owner
 */
public class UseCompileException {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//for Name method�� Compile Exception�� ������.
			Class cls=Class.forName("java.lang.String"); //���÷�Ʈ Ŭ����
			System.out.println(cls);
			Class cls1=Class.forName("day0418.UseRuntimeException"); //���÷�Ʈ Ŭ����
			System.out.println(cls1);
			
			UseCompileException uce=new UseCompileException();
			UseCompileException uce1=(UseCompileException) uce.clone();
			System.out.println("��ü ���� ����");
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Ŭ�������� Ȯ�����ּ���");
			e.printStackTrace();
		} catch (CloneNotSupportedException cnse) {
			JOptionPane.showMessageDialog(null, "�����Ǵ� ��ü�� �ƴϿ���");
			cnse.printStackTrace();
		} 
	}

}
