package day0710;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//1.HttpServlet ��� 
@SuppressWarnings("serial")
public class CallServlet extends HttpServlet {
	// 2.��û����� ó���ϴ� method Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 3.�������� ����(MIME-Type ����)
		response.setContentType("text/html;charset=UTF-8");
		// 4.��½�Ʈ�� ���
		PrintWriter out = response.getWriter();
		// 5.���䳻�� ����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>GET����� ��û</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<strong>GET����� ��û </strong><br>");
		out.println("<a href='javascript:history.back()'>�ڷΰ���</a>");
		out.println("</body>");
		out.println("</html>");
	}// doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 3.�������� ����(MIME-Type ����)
		response.setContentType("text/html;charset=UTF-8");
		// 4.��½�Ʈ�� ���
		PrintWriter out = response.getWriter();
		// 5.���䳻�� ����
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>POST����� ��û</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<span style='color:#ff0000;font-weight:bold;font-size:25px;'>POST����� ��û </span><br>");
		out.println("<a href='day0710/call_servlet.html'>�ڷΰ���</a>");
		out.println("</body>");
		out.println("</html>");

	}// doPost

}
