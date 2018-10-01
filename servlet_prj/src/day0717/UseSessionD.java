package day0717;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class UseSessionD extends HttpServlet {// session의 값을 지운후 무효화 할 servlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 세션값 삭제
		// 1.세션얻기
		HttpSession session = request.getSession();
		// 2.세션 값 삭제 (값삭제는 세션을 무효화한것이 아니므로 값 얻는 코드를 사용할 수 있음.)
		session.removeAttribute("name");
		session.removeAttribute("loginTime");
		// out.println(session.getAttribute("name"));
		// out.println(session.getAttribute("loginTime"));
		// 3.세션 무효화
		session.invalidate();
		// 세션이 무효화 되면 값 자체를 얻을 수 없음
		// out.println(session.getAttribute("name")); //error
		out.println("<script type='text/javascript'>");
		out.println("location.replace('day0717/use_session_a.html')");
		out.println("</script>");
		
	}

}
