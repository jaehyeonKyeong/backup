package day0709;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet을 상속 받는다 : 작성한 클래스가 웹서비스가 되어야 하므로
@SuppressWarnings("serial")
public class Hello extends HttpServlet {
	//2.요청방식을 처리할수 잇는 method Override한다:Servlet을 직접 호출하면 get방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3.응답방식 설정 : 접속자에게 응답할 형식 결정(MIME-Type)
		response.setContentType("text/html;charset=UTF-8");
		//4.응답형식으로 설정된 내용을 접속자에게 출력하기 위해 출력Stream얻기
		PrintWriter out=response.getWriter();
		//5.출력 내용을 생성하여 출력
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>안녕 servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<strong>Hello Servlet!!!!</strong><br>");
		String name="송램지";
		out.print("내 이름은<b>");
		out.print(name);
		out.println(request+"<br>");
		out.println(response+"<br>");
		out.println("</b>입니다.<br>오늘은 2018-07-09 입니다.");
		out.println("</body>");
		out.println("</html>");
	}

}
