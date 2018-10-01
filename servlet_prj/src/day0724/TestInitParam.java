package day0724;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInitParam extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("서블릿 호출");
		//특정 서블릿만 사용할 수 있는 값은 servletConfing로 받는다.
		//1. 값을 받기 위한 객체 얻기
		ServletConfig sc=getServletConfig();
		//2. 이름으로 값얻기
		String common_css=sc.getInitParameter("common_css");
		out.print("<link rel='stylesheet' type='text/css' href='");
		out.print(common_css);
		out.print("'/>");
		
		
		String name=sc.getInitParameter("name");
		String age=sc.getInitParameter("age");
		String addr=sc.getInitParameter("addr");
		
		
		out.println("<ul>");
		out.println("<li> 이름 :");
		out.println(name);
		out.println("</li>");
		
		out.println("<li> 나이:");
		out.println(age);
		out.println("</li>");
		
		out.println("<li> 주소:");
		out.println(addr);
		out.println("</li>");
		out.println("</ul>");
		out.println("<a href='test_context_param'>이동</a>");
	}

}
