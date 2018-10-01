package day0724;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestContextParam extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//init-param 특정 서블릿에서만 사용되므로 정의 되지 않은 
		//서블리에서는 사용할 수 없다.
		
		//모든 서블릿에서는 사용할 수 있는 <context-param>사용
		//1. 값 얻는 객체 얻기
		ServletContext ctx=getServletContext();
		//2. 값 얻기
		String common_css=ctx.getInitParameter("common_css");
		out.print("<link rel='stylesheet' type='text/css' href='");
		out.print(common_css);
		out.print("'/>");
		
		
		String name=getServletConfig().getInitParameter("name");
		
		out.println("<ul>");
		out.println("<li> 이름 :");
		out.println(name);
		out.println("</li>");
	}

}
