package day0828;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get����� ��û�� �ִٸ� doPost�� ���� ó���Ѵ�
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request : ��ûó����ü, scope��ü
		request.setAttribute("method", request.getMethod());
		
		RequestDispatcher rd=request.getRequestDispatcher("day0828/index.jsp");
		rd.forward(request, response);
	}

}
