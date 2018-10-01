package day0709;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//HttpServlet�� ��� �޴´� : �ۼ��� Ŭ������ �����񽺰� �Ǿ�� �ϹǷ�
@SuppressWarnings("serial")
public class Hello extends HttpServlet {
	//2.��û����� ó���Ҽ� �մ� method Override�Ѵ�:Servlet�� ���� ȣ���ϸ� get���
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3.������ ���� : �����ڿ��� ������ ���� ����(MIME-Type)
		response.setContentType("text/html;charset=UTF-8");
		//4.������������ ������ ������ �����ڿ��� ����ϱ� ���� ���Stream���
		PrintWriter out=response.getWriter();
		//5.��� ������ �����Ͽ� ���
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>�ȳ� servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<strong>Hello Servlet!!!!</strong><br>");
		String name="�۷���";
		out.print("�� �̸���<b>");
		out.print(name);
		out.println(request+"<br>");
		out.println(response+"<br>");
		out.println("</b>�Դϴ�.<br>������ 2018-07-09 �Դϴ�.");
		out.println("</body>");
		out.println("</html>");
	}

}
