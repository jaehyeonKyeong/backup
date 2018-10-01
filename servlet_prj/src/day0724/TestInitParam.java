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
		out.println("���� ȣ��");
		//Ư�� ������ ����� �� �ִ� ���� servletConfing�� �޴´�.
		//1. ���� �ޱ� ���� ��ü ���
		ServletConfig sc=getServletConfig();
		//2. �̸����� �����
		String common_css=sc.getInitParameter("common_css");
		out.print("<link rel='stylesheet' type='text/css' href='");
		out.print(common_css);
		out.print("'/>");
		
		
		String name=sc.getInitParameter("name");
		String age=sc.getInitParameter("age");
		String addr=sc.getInitParameter("addr");
		
		
		out.println("<ul>");
		out.println("<li> �̸� :");
		out.println(name);
		out.println("</li>");
		
		out.println("<li> ����:");
		out.println(age);
		out.println("</li>");
		
		out.println("<li> �ּ�:");
		out.println(addr);
		out.println("</li>");
		out.println("</ul>");
		out.println("<a href='test_context_param'>�̵�</a>");
	}

}
