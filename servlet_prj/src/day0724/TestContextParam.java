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
		
		//init-param Ư�� ���������� ���ǹǷ� ���� ���� ���� 
		//���������� ����� �� ����.
		
		//��� ���������� ����� �� �ִ� <context-param>���
		//1. �� ��� ��ü ���
		ServletContext ctx=getServletContext();
		//2. �� ���
		String common_css=ctx.getInitParameter("common_css");
		out.print("<link rel='stylesheet' type='text/css' href='");
		out.print(common_css);
		out.print("'/>");
		
		
		String name=getServletConfig().getInitParameter("name");
		
		out.println("<ul>");
		out.println("<li> �̸� :");
		out.println(name);
		out.println("</li>");
	}

}
