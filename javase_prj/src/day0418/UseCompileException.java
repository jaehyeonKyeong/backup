package day0418;

import javax.swing.JOptionPane;

/**
 * compileException 개발자가 반드시 예외처리 코드를 정의하여 처리하는 예외
 * @author owner
 */
public class UseCompileException {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//for Name method가 Compile Exception을 날린다.
			Class cls=Class.forName("java.lang.String"); //리플렉트 클래스
			System.out.println(cls);
			Class cls1=Class.forName("day0418.UseRuntimeException"); //리플렉트 클래스
			System.out.println(cls1);
			
			UseCompileException uce=new UseCompileException();
			UseCompileException uce1=(UseCompileException) uce.clone();
			System.out.println("객체 복제 성공");
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "클래스명을 확인해주세요");
			e.printStackTrace();
		} catch (CloneNotSupportedException cnse) {
			JOptionPane.showMessageDialog(null, "복제되는 객체가 아니에요");
			cnse.printStackTrace();
		} 
	}

}
