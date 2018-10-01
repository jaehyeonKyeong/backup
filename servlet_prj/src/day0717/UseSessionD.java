package day0717;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class UseSessionD extends HttpServlet {// session�� ���� ������ ��ȿȭ �� servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ���ǰ� ����
		// 1.���Ǿ��
		HttpSession session = request.getSession();
		// 2.���� �� ���� (�������� ������ ��ȿȭ�Ѱ��� �ƴϹǷ� �� ��� �ڵ带 ����� �� ����.)
		session.removeAttribute("name");
		session.removeAttribute("loginTime");
		// out.println(session.getAttribute("name"));
		// out.println(session.getAttribute("loginTime"));
		// 3.���� ��ȿȭ
		session.invalidate();
		// ������ ��ȿȭ �Ǹ� �� ��ü�� ���� �� ����
		// out.println(session.getAttribute("name")); //error
		out.println("<script type='text/javascript'>");
		out.println("location.replace('day0717/use_session_a.html')");
		out.println("</script>");
		
	}

}
