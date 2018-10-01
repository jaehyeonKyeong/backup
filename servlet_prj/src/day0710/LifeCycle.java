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
    //�����ֱ� method
	public void init() {
		System.out.println("--------------------init:���������ڿ� ���� �ѹ� ȣ��ȴ�.");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------------doGet,doPost,service ��� �����ڿ� ���� ������ ��µȴ�");
		// 3.�������� ����(MIME-Type ����)
				response.setContentType("text/html;charset=UTF-8");
				// 4.��½�Ʈ�� ���
				PrintWriter out = response.getWriter();
				// 5.���䳻�� ����
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset='UTF-8'>");
				out.println("<title>�����ֱ�</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<span style='color:#ff0000;font-weight:bold;font-size:25px;'>������ �����ֱ� </span><br>");
				out.println("<a href='day0710/call_servlet.html'>�ڷΰ���</a>");
				out.println("</body>");
				out.println("</html>");
	}
	public void destroy() {
		System.out.println("Container(WAS)�� ����ɶ� ���������� ȣ��");
	}
    
}
