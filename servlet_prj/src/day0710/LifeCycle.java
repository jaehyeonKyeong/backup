package day0710;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycle
 */
public class LifeCycle extends HttpServlet {
    //생명주기 method
	public void init() {
		System.out.println("--------------------init:최초접속자에 의해 한번 호출된다.");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------------doGet,doPost,service 모든 접속자에 의해 여러번 출력된다");
		// 3.응답방식의 설정(MIME-Type 설정)
				response.setContentType("text/html;charset=UTF-8");
				// 4.출력스트림 얻기
				PrintWriter out = response.getWriter();
				// 5.응답내용 생성
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset='UTF-8'>");
				out.println("<title>생명주기</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<span style='color:#ff0000;font-weight:bold;font-size:25px;'>서블릿의 생명주기 </span><br>");
				out.println("<a href='day0710/call_servlet.html'>뒤로가기</a>");
				out.println("</body>");
				out.println("</html>");
	}
	public void destroy() {
		System.out.println("Container(WAS)가 종료될때 마지막으로 호출");
	}
    
}
