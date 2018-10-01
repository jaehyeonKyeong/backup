package day0712;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ForwardA extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ ó�� ����(������ ���� �ʴ´�)
		String[] names= {"�۷���","������","������","����","Ż�״�"};
		String[] addrs= {"������ ����","������ ��ž��","����� ������ ���ǵ�","����� ��û��","������ ��â��"};
		
		System.out.println("��û�̸� :"+request.getParameter("name"));
		System.out.println("��û���� :"+request.getParameter("age"));
		//1.�̵��� ������ ����
		RequestDispatcher rd=request.getRequestDispatcher("forward_b");
		//2.ȭ�鿡�� ������ �����͸� ��û��ü�� �Ӽ����� ����
		request.setAttribute("names", names);
		request.setAttribute("addrs", addrs);
		//3.�̵�
		rd.forward(request, response);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("adfsdfdsafasdfsadfasdfsadf");
		
	}

}
