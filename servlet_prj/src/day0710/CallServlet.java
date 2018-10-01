package day0710;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1.HttpServlet 상속 
@SuppressWarnings("serial")
public class CallServlet extends HttpServlet {
	// 2.요청방식을 처리하는 method Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 3.응답방식의 설정(MIME-Type 설정)
		response.setContentType("text/html;charset=UTF-8");
		// 4.출력스트림 얻기
		PrintWriter out = response.getWriter();
		// 5.응답내용 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>GET방식의 요청</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<strong>GET방식의 요청 </strong><br>");
		out.println("<a href='javascript:history.back()'>뒤로가기</a>");
		out.println("</body>");
		out.println("</html>");
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 3.응답방식의 설정(MIME-Type 설정)
		response.setContentType("text/html;charset=UTF-8");
		// 4.출력스트림 얻기
		PrintWriter out = response.getWriter();
		// 5.응답내용 생성
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>POST방식의 요청</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<span style='color:#ff0000;font-weight:bold;font-size:25px;'>POST방식의 요청 </span><br>");
		out.println("<a href='day0710/call_servlet.html'>뒤로가기</a>");
		out.println("</body>");
		out.println("</html>");

	}// doPost

}
